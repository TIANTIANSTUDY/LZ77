package bhanu.compression.lz77;

public class Match {
	private int length;
	private int distance;
	  

	public Match() {
		this(-1,-1);
	}

	public Match(int matchLength, int matDistance) {
		super();
		this.length = matchLength;
		this.distance = matDistance;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int matchLength) {
		this.length = matchLength;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int matDistance) {
		this.distance = matDistance;
	}

}
