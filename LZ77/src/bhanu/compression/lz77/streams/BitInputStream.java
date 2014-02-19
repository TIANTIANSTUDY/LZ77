package bhanu.compression.lz77.streams;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Stream to read individual bits from under laying Byte stream in Big-endian
 */
public final class BitInputStream {

	private InputStream inputStream;

	private int nextBits;

	private int numberOfBitsRemaining;

	private boolean isEndOfStream;

	public BitInputStream(InputStream in) {
		if (in == null) {
			throw new NullPointerException("Argument is null");
		}
		inputStream = in;
		numberOfBitsRemaining = 0;
		isEndOfStream = false;
	}

	/**
	 * 
	 * @return zero or one if there is a bit available. or -1 for end of stream
	 * @throws IOException
	 */
	public int read() throws IOException {
		if (isEndOfStream)
			return -1;
		if (numberOfBitsRemaining == 0) {
			nextBits = inputStream.read();
			if (nextBits == -1) {
				isEndOfStream = true;
				return -1;
			}
			numberOfBitsRemaining = 8;
		}
		numberOfBitsRemaining--;
		return (nextBits >>> numberOfBitsRemaining) & 1;
	}

	/**
	 * Read next n bits from stream and return.
	 * 
	 * @param n no.of bits to read from stream
	 * @return
	 * @throws IOException
	 */
	public int read(int n) throws IOException {
		int output = 0;
		for (int i = 0; i < n; i++) {
			int val = readNoEof();
			output = output << 1 | val;
		}
		return output;
	}

	public byte readByte() throws IOException {
		return (byte) read(8);
	}

	/**
	 * 
	 * @return Zero or one if there is a bit available. throws EOFException for end of stream
	 * @throws IOException
	 */
	public int readNoEof() throws IOException {
		int result = read();
		if (result != -1)
			return result;
		else
			throw new EOFException("End of stream reached");
	}

	/**
	 * close the input stream.
	 */
	public void close() throws IOException {
		inputStream.close();
	}

}