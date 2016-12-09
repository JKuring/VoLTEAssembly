package common.utilities;

import com.eastcom.volte.storm.common.utilities.HexToDec;
import org.junit.Test;

/**
 * Created by linghang.kong on 2016/8/24.
 */
public class HexToDecTest {
    @Test
    public void hexToDec() throws Exception {
        char[] chars = "960".toCharArray();
        System.out.println(HexToDec.hexToDec(chars));
    }

}