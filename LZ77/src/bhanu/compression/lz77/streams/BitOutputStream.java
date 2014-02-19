package bhanu.compression.lz77.streams;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Writes stream of bits into output stream. accumulates 8 bits and writes as byte to the stream.
 */
public class BitOutputStream {

	private OutputStream output;

	private int currentByte;

	private int numberOfBitsInCurrentByte;

	public BitOutputStream(OutputStream out) {
		if (out == null)
			throw new NullPointerException("Output stream can not be null");
		output = out;
		currentByte = 0;
		numberOfBitsInCurrentByte = 0;
	}

	public void write(boolean b) throws IOException {
		currentByte = currentByte << 1 | (b ? 1 : 0);
		numberOfBitsInCurrentByte++;
		if (numberOfBitsInCurrentByte == 8) {
			output.write(currentByte);
			numberOfBitsInCurrentByte = 0;
		}
	}

	/**
	 * Write 8 bit Byte to the stream
	 * 
	 * @param b Byte
	 * @throws IOException
	 */
	public void write(Byte b) throws IOException {
		int n = b.intValue();
		for (int i = 7; i >= 0; i--) {
			write((n >> i & 1) > 0 ? true : false);
		}
	}

	/**
	 * if there are no less than 8 bits, then pad with remaining bits at the end and close the stream
	 */
	public void close() throws IOException {
		while (numberOfBitsInCurrentByte != 0) {
			write(Boolean.FALSE);
		}
		output.close();
	}

}
