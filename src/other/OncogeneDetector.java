package other;

import java.util.ArrayList;

public class OncogeneDetector {

	@SuppressWarnings("unused")
	boolean isOncogene(ArrayList<String> healthySequences, ArrayList<String> cancerSequences, String gene) {
		int numsHealthy = 0, numsCancer = 0;
		if (gene == "") {
			return false;
		}
		for (int i = 0; i < healthySequences.size(); i++) {
			if (healthySequences.get(i).contains(gene)) {
				numsHealthy++;
			}
		}
		for (int j = 0; j < cancerSequences.size(); j++) {
			if (cancerSequences.get(j).contains(gene)) {
				numsCancer++;
			}
		}
		
		if (numsCancer > numsHealthy ) {
			System.out.println(numsCancer / cancerSequences.size() + " " + numsHealthy / healthySequences.size());
			return true;
		} else if (numsCancer < numsHealthy ) {
			System.out.println(numsCancer / cancerSequences.size() + " " + numsHealthy / healthySequences.size());
			return false;
		}

		return false;

	}

}
