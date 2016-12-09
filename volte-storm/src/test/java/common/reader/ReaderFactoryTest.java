package common.reader;

import com.eastcom.volte.storm.common.reader.Readable;
import com.eastcom.volte.storm.common.reader.ReaderFactory;
import common.JUnit4ClassRunner;
import org.junit.Test;

import java.io.BufferedReader;

/**
 * Created by linghang.kong on 2016/8/19.
 */
public class ReaderFactoryTest {
    @Test
    public void getReader() throws Exception {
        JUnit4ClassRunner.initLog4j();
        Readable readable = ReaderFactory.getReader(Readable.FTP_READER);
        BufferedReader bufferedReader = readable.read("ftp://ipms:IPms!23$@10.11.40.159/xdr/lte/lte_sgs/20160819/11/210_f525_LTE_SGS_201608191100_03.CSV");
        if (bufferedReader.ready()) {
            String data = bufferedReader.readLine();
            while (data != null) {
                System.out.println(data);
                data = bufferedReader.readLine();
            }
        }
    }

}