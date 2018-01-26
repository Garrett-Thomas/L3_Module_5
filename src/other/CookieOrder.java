package other;

public class CookieOrder {
	String Variety = "";
	int numBoxes = 0;
	public CookieOrder(String V, int n) {
		this.Variety = V;
		this.numBoxes = n;
	}
	public int getNumBoxes() {
		return numBoxes;
	}
	public void setNumBoxes(int n) {
		numBoxes = n;
	}
	public String getVariety() {
		return Variety;
	}
	public void setVariety(String V) {
		Variety = V;
	}
}
