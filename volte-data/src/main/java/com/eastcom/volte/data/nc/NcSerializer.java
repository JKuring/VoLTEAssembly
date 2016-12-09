package com.eastcom.volte.data.nc;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/30.
 */
public class NcSerializer extends Serializer<Nc> {
    @Override
    public void write(Kryo kryo, Output output, Nc nc) {
        output.writeLong(nc.getStart_time());
        output.writeLong(nc.getAcmoffset());
        output.writeString(nc.getXdr_id());
    }

    @Override
    public Nc read(Kryo kryo, Input input, Class<Nc> type) {
        Nc nc = new Nc();
        nc.setStart_time(input.readLong(true));
        nc.setAcmoffset(input.readLong(true));
        nc.setXdr_id(input.readString());
        return nc;
    }
}
