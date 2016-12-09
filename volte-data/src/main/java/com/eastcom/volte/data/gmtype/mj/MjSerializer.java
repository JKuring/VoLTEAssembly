package com.eastcom.volte.data.gmtype.mj;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/15.
 */
public class MjSerializer extends Serializer<Mj> {
    public void write(Kryo kryo, Output output, Mj mj) {
//        output.writeInt(mj.getLength(),true);
//        output.writeString(mj.getCity());
        output.writeInt(mj.getInterface(), true);
        output.writeString(mj.getXdr_id());
//        output.writeInt(mj.getRat(),true);
//        output.writeString(mj.getImsi());
//        output.writeString(mj.getImei());
//        output.writeString(mj.getMsisdn());
//        output.writeString(mj.getProcedure_type());
        output.writeLong(mj.getStart_time(), true);
//        output.writeLong(mj.getEnd_time(),true);
//        output.writeString(mj.getService_type());
//        output.writeInt(mj.getProcedure_status(),true);
//        output.writeString(mj.getCalling_number());
//        output.writeString(mj.getCalled_number());
//        output.writeString(mj.getCalling_party_url());
//        output.writeString(mj.getRequest_url());
//        output.writeString(mj.getUser_ip());
//        output.writeString(mj.getCallid());
//        output.writeString(mj.getSource_ne_ip());
//        output.writeString(mj.getSource_ne_port());
        output.writeString(mj.getDest_ne_ip());
//        output.writeString(mj.getDest_ne_port());
//        output.writeInt(mj.getCall_side(),true);
        output.writeInt(mj.getAlerting_time(), true);
    }

    public Mj read(Kryo kryo, Input input, Class<Mj> type) {
        Mj mj = new Mj();
        mj.setInterface(input.readInt(true));
        mj.setXdr_id(input.readString());
        mj.setStart_time(input.readLong(true));
        mj.setDest_ne_ip(input.readString());
        mj.setAlerting_time(input.readInt(true));
        return mj;
    }
}
