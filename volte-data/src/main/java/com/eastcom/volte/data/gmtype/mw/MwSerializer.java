package com.eastcom.volte.data.gmtype.mw;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/15.
 */
public class MwSerializer extends Serializer<Mw> {
    public void write(Kryo kryo, Output output, Mw mw) {
//        output.writeInt(mw.getLength(),true);
//        output.writeString(mw.getCity());
        output.writeInt(mw.getInterface(), true);
        output.writeString(mw.getXdr_id());
//        output.writeInt(mw.getRat(),true);
//        output.writeString(mw.getImsi());
//        output.writeString(mw.getImei());
//        output.writeString(mw.getMsisdn());
//        output.writeString(mw.getProcedure_type());
        output.writeLong(mw.getStart_time(), true);
//        output.writeLong(mw.getEnd_time(),true);
//        output.writeString(mw.getService_type());
//        output.writeInt(mw.getProcedure_status(),true);
//        output.writeString(mw.getCalling_number());
//        output.writeString(mw.getCalled_number());
//        output.writeString(mw.getCalling_party_url());
//        output.writeString(mw.getRequest_url());
//        output.writeString(mw.getUser_ip());
//        output.writeString(mw.getCallid());
//        output.writeString(mw.getSource_ne_ip());
//        output.writeString(mw.getSource_ne_port());
        output.writeString(mw.getDest_ne_ip());
//        output.writeString(mw.getDest_ne_port());
//        output.writeInt(mw.getCall_side(),true);
        output.writeInt(mw.getAlerting_time(), true);
    }

    public Mw read(Kryo kryo, Input input, Class<Mw> type) {
        Mw mw = new Mw();
        mw.setInterface(input.readInt(true));
        mw.setXdr_id(input.readString());
        mw.setStart_time(input.readLong(true));
        mw.setDest_ne_ip(input.readString());
        mw.setAlerting_time(input.readInt(true));
        return mw;
    }
}
