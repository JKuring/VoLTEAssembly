package com.eastcom.volte.data.cxtype.sh;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class ShSerializer extends Serializer<Sh> {

    public void write(Kryo kryo, Output output, Sh sh) {
        output.writeInt(sh.getInterface(), true);
        output.writeString(sh.getXdr_id());
        output.writeLong(sh.getStart_time(), true);
        output.writeLong(sh.getEnd_time(), true);
        output.writeString(sh.getDest_ne_ip());
    }

    public Sh read(Kryo kryo, Input input, Class<Sh> type) {
        Sh sh = new Sh();
        sh.setInterface(input.readInt(true));
        sh.setXdr_id(input.readString());
        sh.setStart_time(input.readLong(true));
        sh.setEnd_time(input.readLong(true));
        sh.setDest_ne_ip(input.readString());
        return sh;
    }
}
