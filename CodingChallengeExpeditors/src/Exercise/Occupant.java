package Exercise;

public class Occupant implements Comparable<Occupant> {

	// occupants first name
	private String firstName;
	
	// occupants last name
	private String lastName;
	
	// occupants street address
	private String streetAddress;
	
	// occupants city
	private String city;
	
	// occupants state
	private String state;
	
	// occupants age
	private int age;
	
	// Occupant constructor
	public Occupant(String firstName, String lastName, String streetAddress, 
			String city, String state, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.age = age;
	
	}

	// getter for first name
	public String getFirstName() {
		return firstName;
	}

	// getter for last name
	public String getLastName() {
		return lastName;
	}

	// getter for street address of occupants residence
	public String getStreetAddress() {
		return streetAddress;
	}

	// getter for city of occupants residence
	public String getCity() {
		return city;
	}

	// getter for state of occupants residence
	public String getState() {
		return state;
	}

	// occupants age
	public int getAge() {
		return age;
	}
	
	/**
	 * @return the full address of the occupants residence 
	 * */  
	public String fullAddress() {
		return getStreetAddress().toLowerCase() + " " + getCity().toLowerCase() + ", " + getState().toLowerCase();
	}
	
	/**
	 * @return string of occupants information
	 * */
	@Override
	public String toString() {
		return firstName + ", " + lastName + ", " + streetAddress + ", " + age;
	}
	
	/**
	 * @param Occupant 
	 * @return int returns 0 if equal another number if otherwise
	 * */
	@Override
	public int compareTo(Occupant occ) {
		//if statement to determine if last name are the equal
		if (this.lastName.compareToIgnoreCase(occ.lastName) == 0) {
			// determine if first names are the same
			return this.firstName.compareToIgnoreCase(occ.firstName);
		}
		// if lastnames are not equal
		return this.lastName.compareToIgnoreCase(occ.lastName);
	}
	
	
}
