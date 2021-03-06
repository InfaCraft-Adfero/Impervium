package icac.impervium.server.networking.server;

import icac.impervium.server.datatypes.Bool;
import icac.impervium.server.datatypes.UInt64;
import icac.impervium.server.datatypes.UInt8;
import icac.impervium.server.datatypes.VLQ;
import icac.impervium.server.datatypes.exception.VLQNegativeException;
import icac.impervium.server.networking.IPacket;
import icac.impervium.server.networking.PacketPayload;
import icac.impervium.server.networking.StarboundInputStream;
import icac.impervium.server.networking.StarboundOutputStream;

public class PacketConnectionResponse implements IPacket {

	PacketPayload payload = new PacketPayload();
	private Bool success;
	private VLQ clientID;
	private String rejectionReason;
	private Bool celestialInfo;
	private int orbitalLevels;
	private int chunkSize;
	private int xyMin;
	private int xyMax;
	private int zMin;
	private int zMax;
	private VLQ sectorsNumber;
	private String sectorID;
	private String sectorName;
	private UInt64 sectorSeed;
	private String sectorPrefix;
	//TODO: Variant DataType
	
	public PacketConnectionResponse(boolean success, long clientID, boolean celestrialInfo) {
		this.success = new Bool(success);
		try {
			this.clientID = new VLQ(clientID);
		} catch (VLQNegativeException e) {
			e.printStackTrace();
		}
		this.celestialInfo = new Bool(celestrialInfo);
		//TODO: put stuff into the payload
	}
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)1);
	}

	@Override
	public void write(StarboundOutputStream sos) throws Exception {
		sos.writeUInt8(this.getID());
		sos.writePayload(this.payload);
		//TODO: write this packet
	}

	@Override
	public void read(StarboundInputStream sis) throws Exception {
		//Server->Client Packet
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = new Bool(success);
	}

	/**
	 * @param clientID the clientID to set
	 */
	public void setClientID(VLQ clientID) {
		this.clientID = clientID;
	}

	/**
	 * @param rejectionReason the rejectionReason to set
	 */
	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	/**
	 * @param celestialInfo the celestialInfo to set
	 */
	public void setCelestialInfo(boolean celestialInfo) {
		this.celestialInfo = new Bool(celestialInfo);
	}

	/**
	 * @param orbitalLevels the orbitalLevels to set
	 */
	public void setOrbitalLevels(int orbitalLevels) {
		this.orbitalLevels = orbitalLevels;
	}

	/**
	 * @param chunkSize the chunkSize to set
	 */
	public void setChunkSize(int chunkSize) {
		this.chunkSize = chunkSize;
	}

	/**
	 * @param xyMin the xyMin to set
	 */
	public void setXyMin(int xyMin) {
		this.xyMin = xyMin;
	}

	/**
	 * @param xyMax the xyMax to set
	 */
	public void setXyMax(int xyMax) {
		this.xyMax = xyMax;
	}

	/**
	 * @param zMin the zMin to set
	 */
	public void setzMin(int zMin) {
		this.zMin = zMin;
	}

	/**
	 * @param zMax the zMax to set
	 */
	public void setzMax(int zMax) {
		this.zMax = zMax;
	}

	/**
	 * @param sectorsNumber the sectorsNumber to set
	 */
	public void setSectorsNumber(VLQ sectorsNumber) {
		this.sectorsNumber = sectorsNumber;
	}

	/**
	 * @param sectorID the sectorID to set
	 */
	public void setSectorID(String sectorID) {
		this.sectorID = sectorID;
	}

	/**
	 * @param sectorName the sectorName to set
	 */
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	/**
	 * @param sectorSeed the sectorSeed to set
	 */
	public void setSectorSeed(long sectorSeed) {
		this.sectorSeed = new UInt64(sectorSeed);
	}

	/**
	 * @param sectorPrefix the sectorPrefix to set
	 */
	public void setSectorPrefix(String sectorPrefix) {
		this.sectorPrefix = sectorPrefix;
	}

}