package com.eastcom.volte.data.gmtype.mg;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/15.
 */
public class MgSerializer extends Serializer<Mg> {
    public void write(Kryo kryo, Output output, Mg mg) {
//        output.writeInt(mg.getLength(),true);
//        output.writeString(mg.getCity());
        output.writeInt(mg.getInterface(), true);
        output.writeString(mg.getXdr_id());
//        output.writeInt(mg.getRat(),true);
//        output.writeString(mg.getImsi());
//        output.writeString(mg.getImei());
//        output.writeString(mg.getMsisdn());
//        output.writeString(mg.getProcedure_type());
        output.writeLong(mg.getStart_time(), true);
//        output.writeLong(mg.getEnd_time(),true);
//        output.writeString(mg.getService_type());
//        output.writeInt(mg.getProcedure_status(),true);
//        output.writeString(mg.getCalling_number());
//        output.writeString(mg.getCalled_number());
//        output.writeString(mg.getCalling_party_url());
//        output.writeString(mg.getRequest_url());
//        output.writeString(mg.getUser_ip());
//        output.writeString(mg.getCallid());
//        output.writeString(mg.getSource_ne_ip());
//        output.writeString(mg.getSource_ne_port());
        output.writeString(mg.getDest_ne_ip());
//        output.writeString(mg.getDest_ne_port());
//        output.writeInt(mg.getCall_side(),true);
        output.writeInt(mg.getAlerting_time(), true);
    }

    public Mg read(Kryo kryo, Input input, Class<Mg> type) {
        Mg mg = new Mg();
        mg.setInterface(input.readInt(true));
        mg.setXdr_id(input.readString());
        mg.setStart_time(input.readLong(true));
        mg.setDest_ne_ip(input.readString());
        mg.setAlerting_time(input.readInt(true));
        return mg;
    }
}
