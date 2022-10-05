package Exercise;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

public class CodingExerciseMain {

	public static void main(String[] args) {

		// Map to store and organize data of occupants
		HashMap<String, List<Occupant>> occupantData = new HashMap<>();
		
		try {
			// create scanner object of the file
			Scanner scan = new Scanner(new File("src/Sample.txt"));
			// use newline as delimiter to distinguish between data
			scan.useDelimiter("\\n");
			// while the file has another line
			while (scan.hasNextLine()) {

				// current line variable to keep track of the current line
				String currentLine = scan.next();
				// if the current line isn't blank
				if (!currentLine.isBlank()) {
					// split based on commmas, save line to an array
					String[] arrayForLineofData = currentLine.split(",");
					// remove double quotes and spaces
					String firstName = arrayForLineofData[0].replace("\"", "").trim();
					String lastName = arrayForLineofData[1].replace("\"", "").trim();
					String address = arrayForLineofData[2].replace("\"", "").replace(".", "").trim();
					String city = arrayForLineofData[3].replace("\"", "").trim();
					String state = arrayForLineofData[4].replace("\"", "").trim();
					// parse string to integer for age
					int age = Integer.parseInt(arrayForLineofData[5].replace("\"", "").trim());
					
					// create a new occupant to store occupant information
					Occupant occupant = new Occupant(firstName, lastName, address, city, state, age);
					
					// list to store every occupant
					List<Occupant> listOfOccupants = new ArrayList<Occupant>();
					
					// add 
					if (occupantData.containsKey(occupant.fullAddress())) {
						listOfOccupants.addAll(occupantData.get(occupant.fullAddress()));
					}
					
					// add occupant to list of occupants
					listOfOccupants.add(occupant);
					
					// put the key and value into the map
					occupantData.put(occupant.fullAddress(), listOfOccupants);
				}

			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Entry<String, List<Occupant>> entry: occupantData.entrySet()) {
			// print the address and the number of occupants in each household
			System.out.println(entry.getKey() + ", number of occupants: " + entry.getValue().size());
			// sort list of occupants
			List<Occupant> listOfOccupants = entry.getValue();
			Collections.sort(listOfOccupants);
			// boolean to determine if occupant is older than 18 year of age
			boolean eighteenPlus = false;
			// iterate over list of occupants to determine if there are any over the age of 18
			for (int i = 0; i < listOfOccupants.size(); i++) {
				if (listOfOccupants.get(i).getAge() > 18 ) {
					// print occupants over 18
					System.out.println(listOfOccupants.get(i).toString());
					eighteenPlus = true;
				}
			}
			// if there isn't an occupant 18 plus
			if (eighteenPlus == false) {
				System.out.println("There aren't any occupants who are over the age of 18");
			}
			System.out.println();
			
		}
		
	}

}
