package com.eastcom.volte.data.cxtype.zh;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class ZhSerializer extends Serializer<Zh> {

    public void write(Kryo kryo, Output output, Zh zh) {
        output.writeInt(zh.getInterface(), true);
        output.writeString(zh.getXdr_id());
        output.writeLong(zh.getStart_time(), true);
        output.writeLong(zh.getEnd_time(), true);
        output.writeString(zh.getDest_ne_ip());
    }

    public Zh read(Kryo kryo, Input input, Class<Zh> type) {
        Zh zh = new Zh();
        zh.setInterface(input.readInt(true));
        zh.setXdr_id(input.readString());
        zh.setStart_time(input.readLong(true));
        zh.setEnd_time(input.readLong(true));
        zh.setDest_ne_ip(input.readString());
        return zh;
    }
}
