package icac.impervium.server.datatypes;

import icac.impervium.server.datatypes.exception.VLQNegativeException;

public class VLQ implements DataType {
	private long value;
	private byte[] bytes;
	
	public VLQ(byte[] bytes)
	{
	    this.bytes = bytes;
		long value = 0;
	    for (int i = 0; i < bytes.length; i++)
	    {
	      int curByte = bytes[i] & 0xFF;
	      value = (value << 7) | (curByte & 0x7F);
	      if ((curByte & 0x80) == 0)
	        break;
	    }
	    this.value = value;
	}
	public VLQ(long value) throws VLQNegativeException
	{
		this.value = value;
		if (value<0) throw new VLQNegativeException();
		int numRelevantBits = 64 - Long.numberOfLeadingZeros(value);
	    int numBytes = (numRelevantBits + 6) / 7;
	    if (numBytes == 0)
	      numBytes = 1;
	    byte[] bytes = new byte[numBytes];
	    for (int i = numBytes - 1; i >= 0; i--)
	    {
	      int curByte = (int)(value & 0x7F);
	      if (i != (numBytes - 1))
	        curByte |= 0x80;
	      bytes[i] = (byte)curByte;
	      value >>>= 7;
	    }
	    this.bytes = bytes;
	}
	
	public long getLong()
	{
		return value;
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void printBinary()
	{
		String s = "";
		for (byte b : bytes)
		{
			s+=Integer.toBinaryString(b & 0xFF);
		}
		System.out.println("Bytes: " + s);
		System.out.println("Long: " + getLong());
	}
}