package data_structures;

public class Snake {
	int viciousness = 0;
	boolean venomous = false;

	public Snake(int vic, boolean ven) {
		this.viciousness = vic;
		this.venomous = ven;
	}

	public int vic() {
		return viciousness;

	}

	public boolean ven() {
		return venomous;
	}
}
