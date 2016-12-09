package com.eastcom.volte.data.cxtype.cx;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class CxSerializer extends Serializer<Cx> {

    public void write(Kryo kryo, Output output, Cx cx) {
        output.writeInt(cx.getInterface(), true);
        output.writeString(cx.getXdr_id());
        output.writeLong(cx.getStart_time(), true);
        output.writeLong(cx.getEnd_time(), true);
        output.writeString(cx.getDest_ne_ip());
    }

    public Cx read(Kryo kryo, Input input, Class<Cx> type) {
        Cx cx = new Cx();
        cx.setInterface(input.readInt(true));
        cx.setXdr_id(input.readString());
        cx.setStart_time(input.readLong(true));
        cx.setEnd_time(input.readLong(true));
        cx.setDest_ne_ip(input.readString());
        return cx;
    }
}
