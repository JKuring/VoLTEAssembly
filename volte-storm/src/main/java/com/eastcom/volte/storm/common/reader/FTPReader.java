package com.eastcom.volte.storm.common.reader;

import com.google.common.base.Charsets;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.SocketException;
import java.net.URI;

public class FTPReader implements Readable {

    private static Logger logger = LoggerFactory.getLogger(FTPReader.class);

    public static FTPClient connect(URI uri) throws SocketException, IOException {
        String host = uri.getHost();
        String userAndPassword = uri.getUserInfo();
        String[] userPasswdInfo = userAndPassword.split(":");
        String username = userPasswdInfo[0];
        String password = userPasswdInfo[1];
        int port = uri.getPort();
        port = (port == -1) ? FTP.DEFAULT_PORT : port;

        return FTPReader.connect(host, port, username, password);
    }

    public static FTPClient connect(String host, int port, String username, String password)
            throws SocketException, IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(10000);
        ftpClient.setDataTimeout(60000);
        try {
            ftpClient.connect(host, port);
        } catch (Exception e) {
            logger.error("Ftp connect failed. host:{}.", host);
            throw e;
        }
        int reply = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftpClient.disconnect();
            logger.error("Ftp connect failed. host:{}, reply:{}.", host, reply);
            throw new RuntimeException("Ftp connect failed.");
        }
        if (ftpClient.login(username, password) == false) {
            ftpClient.disconnect();
            logger.error("Ftp login failed. host:{}, username:{}, password:{}.", host, username, password);
            throw new RuntimeException("Ftp login failed.");
        }
        ftpClient.setFileTransferMode(FTP.BLOCK_TRANSFER_MODE);
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.setBufferSize(1048576);
        return ftpClient;
    }

    public static void close(FTPClient ftpClient) throws IOException {
        boolean cmdCompleted = ftpClient.completePendingCommand();
        ftpClient.logout();
        ftpClient.disconnect();
        if (!cmdCompleted) {
            logger.error("Could not complete transfer, Reply Code - " + ftpClient.getReplyCode());
        }
    }

    //    @Override
    public BufferedReader read(String fileUri) {
        int retry = 3;
        while (retry-- > 0) {
            try {
                URI uri = URI.create(fileUri);
                FTPClient ftpClient = connect(uri);
                InputStream input = ftpClient.retrieveFileStream(uri.getPath());
                FtpBufferedReader reader = new FtpBufferedReader(new InputStreamReader(input, Charsets.UTF_8),
                        ftpClient);
                return reader;
            } catch (Exception e) {
                if (retry > 0) {
                    logger.warn("{}, will retry ({}) times ...", e.getMessage(), retry);
                } else {

                }
            }
        }
        return null;
    }

    public static class FtpBufferedReader extends BufferedReader {

        private FTPClient ftpClient;

        public FtpBufferedReader(Reader in, FTPClient ftpClient) {
            super(in);
            this.ftpClient = ftpClient;
        }

        @Override
        public void close() throws IOException {
            super.close();
            FTPReader.close(ftpClient);
        }
    }

}
