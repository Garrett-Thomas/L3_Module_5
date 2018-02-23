package other;

import java.util.ArrayList;

public class Students {
private String eyeColor;
private String name;
static ArrayList<Students> pupils = new ArrayList<Students>();
	public static void main(String[] args) {
		pupils.add(new Students("hazel", "Fritz"));
		pupils.add(new Students("brown", "Aidan"));
		pupils.add(new Students("brown", "Garrett"));
	}

	public Students(String eyeColor, String name) {
		this.eyeColor = eyeColor;
		this.name = name;
		
	}
	public String getPopularColor() {
		int c = 0;
		for (int i = 0; i < pupils.size(); i++) {
			if(pupils.get(i).eyeColor == "hazel") {
				c++;
			}
			if(pupils.get(i).eyeColor == "brown") {
				c--;
			}
		}
		if(c < 0) {
			System.out.println(1);
			return "Hazel";
		}
		else {
			System.out.println(2);
			return "Brown";
		}
	}
}
