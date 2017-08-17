package com.eastcom.volte.data;

import com.eastcom.volte.data.cxtype.cx.CxParser;
import com.eastcom.volte.data.cxtype.dh.DhParser;
import com.eastcom.volte.data.cxtype.dx.DxParser;
import com.eastcom.volte.data.cxtype.sh.ShParser;
import com.eastcom.volte.data.cxtype.zh.ZhParser;
import com.eastcom.volte.data.gmtype.gm.GmParser;
import com.eastcom.volte.data.gmtype.isc.ISCParser;
import com.eastcom.volte.data.gmtype.mg.MgParser;
import com.eastcom.volte.data.gmtype.mi.MiParser;
import com.eastcom.volte.data.gmtype.mj.MjParser;
import com.eastcom.volte.data.gmtype.mw.MwParser;
import com.eastcom.volte.data.gxtype.rx.RxParser;
import com.eastcom.volte.data.nc.NcParser;
import com.eastcom.volte.data.xdr.MergedXDRParser;
import com.google.common.base.Splitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public abstract class DataParser<T> {

    public static final String GM = "Gm";
    public static final String ISC = "ISC";
    public static final String MG = "Mg";
    public static final String MI = "Mi";
    public static final String MJ = "Mj";
    public static final String MW = "Mw";

    //public static final String SV = "Sv";

    public static final String CX = "Cx";
    public static final String DH = "Dh";
    public static final String DX = "Dx";
    public static final String SH = "Sh";
    public static final String ZH = "Zh";

    //public static final String GX = "Gx";
    public static final String RX = "Rx";

    public static final String NC = "nc_bicc";

    public static final String MERGED_XDR = "Bigxdr";

    public static final List<String> INTERFACES = Arrays.asList(GM, ISC, MG, MI, MJ, MW, CX, DH, DX, SH, ZH, RX, NC, MERGED_XDR);
    private static Logger logger = LoggerFactory.getLogger(DataParser.class);
    private Splitter splitter = Splitter.on('|').trimResults();

    public static DataParser getParser(String type) {
        switch (type) {
            case GM:
                return new GmParser();
            case ISC:
                return new ISCParser();
            case MG:
                return new MgParser();
            case MI:
                return new MiParser();
            case MJ:
                return new MjParser();
            case MW:
                return new MwParser();
            //case SV:
            case CX:
                return new CxParser();
            case DH:
                return new DhParser();
            case DX:
                return new DxParser();
            case SH:
                return new ShParser();
            case ZH:
                return new ZhParser();
            //case GX:
            case RX:
                return new RxParser();
            case NC:
                return new NcParser();
            case MERGED_XDR:
                return new MergedXDRParser();
            default:
                return null;
        }
    }

    public List<String> split(String data) {
        List<String> dataList = this.splitter.splitToList(data);
        logger.debug("data: {}, size: {}", data, data.length());
        return dataList;
    }

    public abstract T parse(List<String> dataList) throws Exception;

}
