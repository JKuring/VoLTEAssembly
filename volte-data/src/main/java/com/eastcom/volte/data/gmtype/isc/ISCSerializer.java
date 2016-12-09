package com.eastcom.volte.data.gmtype.isc;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created by linghang.kong on 2016/8/15.
 */
public class ISCSerializer extends Serializer<ISC> {
    public void write(Kryo kryo, Output output, ISC isc) {
//        output.writeInt(isc.getLength(),true);
//        output.writeString(isc.getCity());
        output.writeInt(isc.getInterface(), true);
        output.writeString(isc.getXdr_id());
//        output.writeInt(isc.getRat(),true);
//        output.writeString(isc.getImsi());
//        output.writeString(isc.getImei());
//        output.writeString(isc.getMsisdn());
//        output.writeString(isc.getProcedure_type());
        output.writeLong(isc.getStart_time(), true);
//        output.writeLong(isc.getEnd_time(),true);
//        output.writeString(isc.getService_type());
//        output.writeInt(isc.getProcedure_status(),true);
//        output.writeString(isc.getCalling_number());
//        output.writeString(isc.getCalled_number());
//        output.writeString(isc.getCalling_party_url());
//        output.writeString(isc.getRequest_url());
//        output.writeString(isc.getUser_ip());
//        output.writeString(isc.getCallid());
//        output.writeString(isc.getSource_ne_ip());
//        output.writeString(isc.getSource_ne_port());
        output.writeString(isc.getDest_ne_ip());
//        output.writeString(isc.getDest_ne_port());
//        output.writeInt(isc.getCall_side(),true);
        output.writeInt(isc.getAlerting_time(), true);
    }

    public ISC read(Kryo kryo, Input input, Class<ISC> type) {
        ISC isc = new ISC();
        isc.setInterface(input.readInt(true));
        isc.setXdr_id(input.readString());
        isc.setStart_time(input.readLong(true));
        isc.setDest_ne_ip(input.readString());
        isc.setAlerting_time(input.readInt(true));
        return isc;
    }
}
