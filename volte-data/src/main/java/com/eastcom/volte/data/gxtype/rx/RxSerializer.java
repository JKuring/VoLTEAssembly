package com.eastcom.volte.data.gxtype.rx;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/11/11.
 */
public class RxSerializer extends Serializer<Rx> {
    @Override
    public void write(Kryo kryo, Output output, Rx rx) {
        output.writeInt(rx.getInterface(), true);
        output.writeString(rx.getXdr_id());
        output.writeString(rx.getDest_ne_ip());
    }

    @Override
    public Rx read(Kryo kryo, Input input, Class<Rx> type) {
        Rx rx = new Rx();
        rx.setInterface(input.readInt(true));
        rx.setXdr_id(input.readString());
        rx.setDest_ne_ip(input.readString());
        return rx;
    }
}
