package com.eastcom.volte.data.gmtype.mi;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/15.
 */
public class MiSerializer extends Serializer<Mi> {
    public void write(Kryo kryo, Output output, Mi mi) {
//        output.writeInt(mi.getLength(),true);
//        output.writeString(mi.getCity());
        output.writeInt(mi.getInterface(), true);
        output.writeString(mi.getXdr_id());
//        output.writeInt(mi.getRat(),true);
//        output.writeString(mi.getImsi());
//        output.writeString(mi.getImei());
//        output.writeString(mi.getMsisdn());
//        output.writeString(mi.getProcedure_type());
        output.writeLong(mi.getStart_time(), true);
//        output.writeLong(mi.getEnd_time(),true);
//        output.writeString(mi.getService_type());
//        output.writeInt(mi.getProcedure_status(),true);
//        output.writeString(mi.getCalling_number());
//        output.writeString(mi.getCalled_number());
//        output.writeString(mi.getCalling_party_url());
//        output.writeString(mi.getRequest_url());
//        output.writeString(mi.getUser_ip());
//        output.writeString(mi.getCallid());
//        output.writeString(mi.getSource_ne_ip());
//        output.writeString(mi.getSource_ne_port());
        output.writeString(mi.getDest_ne_ip());
//        output.writeString(mi.getDest_ne_port());
//        output.writeInt(mi.getCall_side(),true);
        output.writeInt(mi.getAlerting_time(), true);
    }

    public Mi read(Kryo kryo, Input input, Class<Mi> type) {
        Mi mi = new Mi();
        mi.setInterface(input.readInt(true));
        mi.setXdr_id(input.readString());
        mi.setStart_time(input.readLong(true));
        mi.setDest_ne_ip(input.readString());
        mi.setAlerting_time(input.readInt(true));
        return mi;
    }
}
