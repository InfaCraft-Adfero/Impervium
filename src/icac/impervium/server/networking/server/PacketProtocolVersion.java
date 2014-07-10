package icac.impervium.server.networking.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import icac.impervium.server.networking.Packet;

public class PacketProtocolVersion extends Packet {
	
	private int protocolVersion;
	
	public PacketProtocolVersion(int protocolVersion) {
		this.protocolVersion = protocolVersion;
	}
	
	
	@Override
	public Integer getID() {
		return 0;
	}

	@Override
	public void write(DataOutputStream dos) throws Exception {
		//TODO: Write packet to stream.
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//Server->Client Packet
	}

}