package film_shop.persistance;

public class Customer {

	private int cID;
	private String first_name;
	private String last_name;
	private String email;
	private String address;
	private String city;
	private String postcode;
	private int age;
	private boolean loyalty;

	public Customer() {

	}

	public Customer(int cID, String first_name, String last_name, String email, String address, String city,
			String postcode, int age, boolean loyalty) {
		super();
		this.cID = cID;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.address = address;
		this.city = city;
		this.postcode = postcode;
		this.age = age;
		this.loyalty = loyalty;
	}

	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getLoyalty() {
		if (this.loyalty) {
			return 1;
		} else {
			return 0;
		}
	}

	public void setLoyalty(boolean loyalty) {
		this.loyalty = loyalty;
	}

	@Override
	public String toString() {

		return getcID() + " | " + getFirst_name() + " " + getLast_name() + " | " + getEmail() + " | " + getAddress()
				+ " | " + getCity() + " | " + getPostcode() + " | " + getAge() + " | " + getLoyalty();
	}

}
