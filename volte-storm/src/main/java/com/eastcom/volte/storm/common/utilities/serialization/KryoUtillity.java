package com.eastcom.volte.storm.common.utilities.serialization;

import com.eastcom.volte.data.cxtype.cx.Cx;
import com.eastcom.volte.data.cxtype.cx.CxSerializer;
import com.eastcom.volte.data.cxtype.dh.Dh;
import com.eastcom.volte.data.cxtype.dh.DhSerializer;
import com.eastcom.volte.data.cxtype.dx.Dx;
import com.eastcom.volte.data.cxtype.dx.DxSerializer;
import com.eastcom.volte.data.cxtype.sh.Sh;
import com.eastcom.volte.data.cxtype.sh.ShSerializer;
import com.eastcom.volte.data.cxtype.zh.Zh;
import com.eastcom.volte.data.cxtype.zh.ZhSerializer;
import com.eastcom.volte.data.gmtype.gm.Gm;
import com.eastcom.volte.data.gmtype.gm.GmSerializer;
import com.eastcom.volte.data.gmtype.isc.ISC;
import com.eastcom.volte.data.gmtype.isc.ISCSerializer;
import com.eastcom.volte.data.gmtype.mg.Mg;
import com.eastcom.volte.data.gmtype.mg.MgSerializer;
import com.eastcom.volte.data.gmtype.mi.Mi;
import com.eastcom.volte.data.gmtype.mi.MiSerializer;
import com.eastcom.volte.data.gmtype.mj.Mj;
import com.eastcom.volte.data.gmtype.mj.MjSerializer;
import com.eastcom.volte.data.gmtype.mw.Mw;
import com.eastcom.volte.data.gmtype.mw.MwSerializer;
import com.eastcom.volte.data.gxtype.rx.Rx;
import com.eastcom.volte.data.gxtype.rx.RxSerializer;
import com.eastcom.volte.data.nc.Nc;
import com.eastcom.volte.data.nc.NcSerializer;
import com.eastcom.volte.data.xdr.MergedXDR;
import com.eastcom.volte.data.xdr.MergedXDRSerializer;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/22.
 */
public class KryoUtillity {

    /**
     * 获取已注册序列化类的Kryo handle
     *
     * @return
     */
    public static Kryo getKryo() {
        Kryo kryo = new Kryo();

        kryo.register(Gm.class, new GmSerializer(), 0);
        kryo.register(Mw.class, new MwSerializer(), 1);
        kryo.register(Mg.class, new MgSerializer(), 2);
        kryo.register(Mi.class, new MiSerializer(), 3);
        kryo.register(Mj.class, new MjSerializer(), 4);
        kryo.register(ISC.class, new ISCSerializer(), 5);
        //Sv
        kryo.register(Cx.class, new CxSerializer(), 6);
        kryo.register(Dx.class, new DxSerializer(), 7);
        kryo.register(Sh.class, new ShSerializer(), 8);
        kryo.register(Dh.class, new DhSerializer(), 9);
        kryo.register(Zh.class, new ZhSerializer(), 10);
        //Gx
        kryo.register(Rx.class, new RxSerializer(), 11);

        kryo.register(Nc.class, new NcSerializer(), 12);
        kryo.register(MergedXDR.class, new MergedXDRSerializer(), 13);
        return kryo;
    }

    /**
     * 序列化输出格式
     *
     * @param kryo   Kryo handle
     * @param object Object
     * @return byte array
     */
    public static byte[] serialize(Kryo kryo, Object object) {
        Output output = new Output(1000, Integer.MAX_VALUE);
        kryo.writeClassAndObject(output, object);
        output.close();
        return output.toBytes();
    }

    /**
     * 反序列化输入格式
     *
     * @param kryo Kryo handle
     * @param data data
     * @param <T>  Object type
     * @return Object
     */
    public static <T> T deserialize(Kryo kryo, byte[] data) {
        return (T) kryo.readClassAndObject(new Input(data));
    }
}
