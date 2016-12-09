package com.eastcom.volte.data.gmtype.gm;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/15.
 */
public class GmSerializer extends Serializer<Gm> {
    public void write(Kryo kryo, Output output, Gm gm) {
//        output.writeInt(gm.getLength(),true);
//        output.writeString(gm.getCity());
        output.writeInt(gm.getInterface(), true);
        output.writeString(gm.getXdr_id());
//        output.writeInt(gm.getRat(),true);
//        output.writeString(gm.getImsi());
//        output.writeString(gm.getImei());
//        output.writeString(gm.getMsisdn());
//        output.writeString(gm.getProcedure_type());
        output.writeLong(gm.getStart_time(), true);
//        output.writeLong(gm.getEnd_time(),true);
//        output.writeString(gm.getService_type());
//        output.writeInt(gm.getProcedure_status(),true);
//        output.writeString(gm.getCalling_number());
//        output.writeString(gm.getCalled_number());
//        output.writeString(gm.getCalling_party_url());
//        output.writeString(gm.getRequest_url());
//        output.writeString(gm.getUser_ip());
//        output.writeString(gm.getCallid());
//        output.writeString(gm.getSource_ne_ip());
//        output.writeString(gm.getSource_ne_port());
        output.writeString(gm.getDest_ne_ip());
//        output.writeString(gm.getDest_ne_port());
//        output.writeInt(gm.getCall_side(),true);
        output.writeInt(gm.getAlerting_time(), true);
    }

    public Gm read(Kryo kryo, Input input, Class<Gm> type) {
        Gm gm = new Gm();
        gm.setInterface(input.readInt(true));
        gm.setXdr_id(input.readString());
        gm.setStart_time(input.readLong(true));
        gm.setDest_ne_ip(input.readString());
        gm.setAlerting_time(input.readInt(true));
        return gm;
    }
}
