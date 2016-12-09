package com.eastcom.volte.storm.common.reader;

import com.google.common.base.Charsets;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by linghang.kong on 2016/8/15.
 */
public class FTPReader implements Readable {

    private static Logger logger = LoggerFactory.getLogger(FTPReader.class);

    private final int connectTimeout = 30000;
    private final int dataTimeout = 120000;
    private final int retryTimes = 3;
    private final int bufferSize = 1048576;
    private FTPClient ftpClient;

    public FTPReader() {
        this.ftpClient = new FTPClient();
        this.ftpClient.setConnectTimeout(this.connectTimeout);
        this.ftpClient.setDataTimeout(this.dataTimeout);
    }

    private FTPClient connect(URL url) throws IOException {
        String host = url.getHost();
        int port = url.getPort();
        String[] userAndPassword = url.getUserInfo().split(":");
        String user = userAndPassword[0];
        String password = userAndPassword[1];
        // 如果port为-1，即为指定，用默认port 21
        port = (port == -1) ? FTP.DEFAULT_PORT : port;
        return connect(host, port, user, password);
    }

    private FTPClient connect(String host, int port, String user, String password) throws IOException {
        try {

            ftpClient.connect(host, port);
            if (!ftpClient.login(user, password)) {
                logger.warn("User {} can't login FTP server.", user);
                throw new IOException("login failure");
            }
            ftpClient.setFileTransferMode(FTP.BLOCK_TRANSFER_MODE);
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.setBufferSize(this.bufferSize);
            return ftpClient;
        } catch (IOException e) {
            logger.error("connect failure: {}. host: {}, port: {}, user: {}, password: {}.", e.getMessage(), host, port, user, password);
            close();
            throw e;
        }
    }

    public BufferedReader read(String fileUri) throws IOException {
        int retryTimes = this.retryTimes;
        try {
            URL url = new URL(fileUri);
            BufferedReader bufferedReader;
            FTPClient ftpClient = this.connect(url);
            InputStream inputStream = ftpClient.retrieveFileStream(url.getPath());
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8));
            return bufferedReader;
        } catch (IOException e) {
            logger.warn("{}, retry to read {}...", e.getMessage(), fileUri);
            retryTimes--;
            if (retryTimes >= 0) {
                this.read(fileUri);
            }
        }
        return null;
    }

    public void close() throws IOException {
        if (this.ftpClient == null) throw new IOException("FTP client is null.");
        // 是否有未完成任务
        boolean cmdCompleted = ftpClient.completePendingCommand();
        // close all
        this.ftpClient.logout();
        this.ftpClient.disconnect();
        if (!cmdCompleted)
            logger.warn("failed transfer. ReplyCode-{}", ftpClient.getReplyCode());
    }
}

