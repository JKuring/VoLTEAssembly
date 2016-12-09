package common;

import org.apache.log4j.PropertyConfigurator;

/**
 * Created by linghang.kong on 2016/8/15.
 */
public class JUnit4ClassRunner {

    public static void initLog4j() {
        try {
            PropertyConfigurator.configure("E:\\百度云同步盘\\东信软件EastCom\\workspace\\VoLTEAssembly\\volte-storm\\src\\test\\java\\common\\mq\\conf\\log4j.properties");
            System.out.println("Successful load properties.");
        } catch (Exception ex) {
            System.err.println("Cannot Initialize log4j");
        }
    }
}
