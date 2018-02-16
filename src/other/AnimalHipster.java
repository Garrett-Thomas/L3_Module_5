package other;

import java.util.ArrayList;
import java.util.HashMap;

public class AnimalHipster {
	public ArrayList<String> findAnimalHipsters(HashMap<String, ArrayList<String>> network, HashMap<String, String> favoriteAnimals){
		 ArrayList<String> result = new ArrayList<String>();
		 for (String person: network.keySet()) {
			 boolean isHip = true;
			 for(String friend: network.get(person)) {
				 if(favoriteAnimals.get(friend).equals((favoriteAnimals.get(person)))) {
					 isHip = false;
				 }
		 }
			 if(isHip) {
				 result.add(person);
			 }
			
		}
		
		return result;
		
	}
}
