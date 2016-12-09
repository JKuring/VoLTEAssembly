package com.eastcom.volte.data.cxtype.dh;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class DhSerializer extends Serializer<Dh> {

    public void write(Kryo kryo, Output output, Dh dh) {
        output.writeInt(dh.getInterface(), true);
        output.writeString(dh.getXdr_id());
        output.writeLong(dh.getStart_time(), true);
        output.writeLong(dh.getEnd_time(), true);
        output.writeString(dh.getDest_ne_ip());
    }

    public Dh read(Kryo kryo, Input input, Class<Dh> type) {
        Dh dh = new Dh();
        dh.setInterface(input.readInt(true));
        dh.setXdr_id(input.readString());
        dh.setStart_time(input.readLong(true));
        dh.setEnd_time(input.readLong(true));
        dh.setDest_ne_ip(input.readString());
        return dh;
    }
}
