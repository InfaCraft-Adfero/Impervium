package icac.impervium.server.networking.client;

import icac.impervium.server.datatypes.Bool;
import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.datatypes.Variant;
import icac.impervium.server.networking.IPacket;
import icac.impervium.server.networking.PacketPayload;
import icac.impervium.server.networking.StarboundInputStream;
import icac.impervium.server.networking.StarboundOutputStream;

public class PacketClientConnect implements IPacket {

	PacketPayload payload = new PacketPayload();
	private UInt8[] digest;
	private Variant claim;
	private Bool uuidFlag;
	private UInt8[] uuid;
	private String username;
	private String species;
	private UInt8[] shipworld;
	private String accountName;
	
	public PacketClientConnect() {
		uuid = new UInt8[16];
	}
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)7);
	}

	@Override
	public void write(StarboundOutputStream sos) throws Exception {
		//Client->Server Packet
	}

	@Override
	public void read(StarboundInputStream sis) throws Exception {
		//TODO: Read this packet.
	}

}
