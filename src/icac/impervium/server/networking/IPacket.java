package icac.impervium.server.networking;

import icac.impervium.server.datatypes.UInt8;

import java.io.DataInputStream;

public interface IPacket {
	UInt8 getID();
	public void write(StarboundOutputStream sos) throws Exception;
	public void read(DataInputStream dis) throws Exception;
}