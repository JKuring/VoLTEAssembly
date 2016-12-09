package mytest;

import com.eastcom.volte.data.DataParser;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * Created by linghang.kong on 2016/9/6.
 */
public class test {
    public static void main(String[] args) throws IOException {
        test t = new test();

        FileReader fileInputStream = new FileReader("C:\\Users\\linghang.kong\\Desktop\\新建文本文档 (5).txt");
        LineNumberReader lineNumberReader = new LineNumberReader(fileInputStream);
        String s;
        while ((s = lineNumberReader.readLine()) != null) {
            System.out.println(s);
            System.out.println(t.getDataType(s));
        }
    }

    public String getDataType(String message) {
        for (String type : DataParser.INTERFACES
                ) {
            if (message.contains(type)) {
                return type;
            }
        }
        return null;
    }
}
