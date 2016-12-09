package com.eastcom.volte.data.cxtype.dx;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/16.
 */
public class DxSerializer extends Serializer<Dx> {

    public void write(Kryo kryo, Output output, Dx dx) {
        output.writeInt(dx.getInterface(), true);
        output.writeString(dx.getXdr_id());
        output.writeLong(dx.getStart_time(), true);
        output.writeLong(dx.getEnd_time(), true);
        output.writeString(dx.getDest_ne_ip());
    }

    public Dx read(Kryo kryo, Input input, Class<Dx> type) {
        Dx dx = new Dx();
        dx.setInterface(input.readInt(true));
        dx.setXdr_id(input.readString());
        dx.setStart_time(input.readLong(true));
        dx.setEnd_time(input.readLong(true));
        dx.setDest_ne_ip(input.readString());
        return dx;
    }
}
