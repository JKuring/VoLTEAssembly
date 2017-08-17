package com.eastcom.volte.storm.common.kafka;

public class ConfigKey {

    // public
    // spout
    public static final String PROJECT_SPOUT_TYPE = "project.spout.type";

    public static final String PROJECT_NETWORK_ELEMENT_TABLE_NAME = "project.network_element.table.name";


    // ftp add mq
    public static final String PROJECT_SPOUT_FTP_READER_THREADS = "project.spout.ftp.reader.threads";
    //    public static final String PROJECT_SPOUT_FILE_TOPICS = "project.spout.topics";
    public static final String PROJECT_MQ_BROKER_URL = "project.mq.broker.url";
    public static final String PROJECT_MQ_QUEUE_NAME = "project.mq.queue.name";

    // kafka
    public static final String PROJECT_SPOUT_KAFKA_READER_THREADS = "project.spout.kafka.reader.threads";
    public static final String KAFKA_GROUP_ID = "kafka.group.id";
    public static final String KAFKA_TOPIC_NAMES = "kafka.topic.names";
    public static final String KAFKA_BOOTSTRAP_SERVERS = "kafka.bootstrap.servers";
    public static final String KAFKA_KEY_DESERIALIZER = "kafka.key.deserializer";
    public static final String KAFKA_VALUE_DESERIALIZER = "kafka.value.deserializer";
    public static final String KAFKA_AUTO_OFFSET_RESET = "kafka.auto.offset.reset";

    public static final String PROJECT_BOLT_KAFKA_WRITER_THREADS = "project.bolt.kafka.writer.threads";
    public static final String PROJECT_BOLT_KAFKA_WRITER_TOPIC = "project.bolt.kafka.writer.topic";
    public static final String KAFKA_ACKS = "kafka.acks";
    public static final String KAFKA_RETRIES = "kafka.retries";
    public static final String KAFKA_BATCH_SIZE = "kafka.batch.size";
    public static final String KAFKA_LINGER_MS = "kafka.linger.ms";
    public static final String KAFKA_BUFFER_MEMORY = "kafka.buffer.memory";
    public static final String KAFKA_KEY_SERIALIZER = "kafka.key.serializer";
    public static final String KAFKA_VALUE_SERIALIZER = "kafka.value.serializer";


//    public static final String FILE_QUEUE_NAME = "file.queue.name";
//    public static final String FILE_TOPIC_NAMES = "file.topic.names";
//    public static final String FILE_READ_THREAD = "file.read.thread";

//    // ftp pool
//    public static final String FTP_POOL_ENABLE = "ftp.pool.enable";
//    public static final String FTP_POOL_MAX_TOTAL = "ftp.pool.maxTotal";
//    public static final String FTP_POOL_MAX_IDLE = "ftp.pool.maxIdle";
//
//    public static final String FTP_READ_RETRY = "ftp.read.retry";

    // the class parse csv object.
//    public static final String CSVPARSER_SELECTOR_CLASS = "csvparser.selector.class";

    //hdfs
    public static final String HDFS_URL = "hdfs.url";
    public static final String HDFS_PATH = "hdfs.path";
    public static final String HDFS_BATCH = "hdfs.batch";
    public static final String HDFS_CREATEDIR_INTERVAL = "hdfs.createDir.interval";
    public static final String HDFS_FILE_CONTENT_SPLIT = "hdfs.file.content.split";
    public static final String HDFS_FILE_NAME_PREFIX = "hdfs.file.name.prefix";

    //jedis
    public static final String JEDIS_MINDLE = "jedis.minIdle";
    public static final String JEDIS_PASSWORD = "jedis.password";
    public static final String JEDIS_ADDRESSES = "jedis.addresses";

}
