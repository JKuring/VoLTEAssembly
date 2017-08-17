package com.eastcom.volte.storm.storm.base;


import com.eastcom.volte.storm.common.kafka.ConfigKey;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.client.HdfsDataOutputStream;
import org.apache.storm.hdfs.bolt.AbstractHdfsBolt;
import org.apache.storm.hdfs.bolt.format.DefaultFileNameFormat;
import org.apache.storm.hdfs.bolt.format.DelimitedRecordFormat;
import org.apache.storm.hdfs.bolt.format.FileNameFormat;
import org.apache.storm.hdfs.bolt.format.RecordFormat;
import org.apache.storm.hdfs.bolt.rotation.FileRotationPolicy;
import org.apache.storm.hdfs.bolt.rotation.TimedRotationPolicy;
import org.apache.storm.hdfs.bolt.sync.CountSyncPolicy;
import org.apache.storm.hdfs.bolt.sync.SyncPolicy;
import org.apache.storm.hdfs.common.rotation.RotationAction;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Map;

import static org.apache.commons.collections4.MapUtils.getIntValue;
import static org.apache.commons.collections4.MapUtils.getString;

/**
 * Created by linghang.kong on 2016/5/17.
 */
public class OutputDataBolt extends AbstractHdfsBolt {

    private static final Logger LOG = LoggerFactory.getLogger(OutputDataBolt.class);

    private transient FSDataOutputStream out;
    private RecordFormat format;

    public OutputDataBolt withFsUrl(String fsUrl) {
        this.fsUrl = fsUrl;
        return this;
    }

    public OutputDataBolt withConfigKey(String configKey) {
        this.configKey = configKey;
        return this;
    }

    public OutputDataBolt withFileNameFormat(FileNameFormat fileNameFormat) {
        this.fileNameFormat = fileNameFormat;
        return this;
    }

    public OutputDataBolt withRecordFormat(RecordFormat format) {
        this.format = format;
        return this;
    }

    public OutputDataBolt withSyncPolicy(SyncPolicy syncPolicy) {
        this.syncPolicy = syncPolicy;
        return this;
    }

    public OutputDataBolt withRotationPolicy(FileRotationPolicy rotationPolicy) {
        this.rotationPolicy = rotationPolicy;
        return this;
    }

    public OutputDataBolt addRotationAction(RotationAction action) {
        this.rotationActions.add(action);
        return this;
    }

    public OutputDataBolt withTickTupleIntervalSeconds(int interval) {
        this.tickTupleInterval = interval;
        return this;
    }

    public OutputDataBolt withRetryCount(int fileRetryCount) {
        this.fileRetryCount = fileRetryCount;
        return this;
    }

    @Override
    public void doPrepare(Map conf, TopologyContext topologyContext, OutputCollector collector) throws IOException {

        // use "|" instead of "," for field delimiter
        RecordFormat format = new DelimitedRecordFormat().withFieldDelimiter(getString(conf, ConfigKey.HDFS_FILE_CONTENT_SPLIT));
        // sync the filesystem after every 1k tuples
        SyncPolicy syncPolicy = new CountSyncPolicy(getIntValue(conf, ConfigKey.HDFS_BATCH));
        // rotate files， 5 minutes
        FileRotationPolicy rotationPolicy = new TimedRotationPolicy(getIntValue(conf, ConfigKey.HDFS_CREATEDIR_INTERVAL), TimedRotationPolicy.TimeUnit.MINUTES);
        FileNameFormat fileNameFormat = new DefaultFileNameFormat().withPath(getString(conf, ConfigKey.HDFS_PATH)).withPrefix(getString(conf, ConfigKey.HDFS_FILE_NAME_PREFIX))
                .withExtension(".csv");
        this.withFsUrl(getString(conf, ConfigKey.HDFS_URL)).withFileNameFormat(fileNameFormat).withRecordFormat(format)
                .withRotationPolicy(rotationPolicy).withSyncPolicy(syncPolicy);


        LOG.info("Preparing HDFS Bolt...");
        this.fs = FileSystem.get(URI.create(this.fsUrl), hdfsConfig);
    }

    @Override
    protected void syncTuples() throws IOException {
        LOG.debug("Attempting to sync all data to filesystem");
        if (this.out instanceof HdfsDataOutputStream) {
            ((HdfsDataOutputStream) this.out).hsync(EnumSet.of(HdfsDataOutputStream.SyncFlag.UPDATE_LENGTH));
        } else {
            this.out.hsync();
        }
    }

    @Override
    protected void writeTuple(Tuple tuple) throws IOException {
        byte[] bytes = this.format.format(tuple);
        out.write(bytes);
        this.offset += bytes.length;
    }

    @Override
    protected void closeOutputFile() throws IOException {
        this.out.close();
    }

    @Override
    protected Path createOutputFile() throws IOException {
        Path path = new Path(this.fileNameFormat.getPath() + extractPathFromTime(System.currentTimeMillis()), this.fileNameFormat.getName(this.rotation, System.currentTimeMillis()));
        this.out = this.fs.create(path);
        return path;
    }

    private String extractPathFromTime(Long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String sd = sdf.format(new Date(timestamp));

        String[] data = sd.split(" ");

        String[] date = data[0].split("-");
        String tmp = "";
        for (int i = 0; i < date.length; i++) {
            tmp += date[i];
        }

        String[] time = data[1].split(":");
        String hour = time[0];
        String minute;
        int mm = Integer.parseInt(time[1]);
        mm = mm - mm % 5;
        if (mm < 10) {
            minute = "0" + mm;
        } else
            minute = String.valueOf(mm);
        return tmp + "/" + hour + "/" + minute + "/";
    }
}
