package film_shop.persistance;

public class Product {

	private int pID;
	private String name;
	private String director;
	private String genre;
	private String release_date;
	private String language;
	private int age_rating;
	private float price;

	public Product() {

	}

	public Product(int pID, String name, String director, String genre, String release_date, String language,
			int age_rating, float price) {
		super();
		this.pID = pID;
		this.name = name;
		this.director = director;
		this.genre = genre;
		this.release_date = release_date;
		this.language = language;
		this.age_rating = age_rating;
		this.price = price;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getAge_rating() {
		return age_rating;
	}

	public void setAge_rating(int age_rating) {
		this.age_rating = age_rating;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return getpID() + " | " + getName() + " | " + getDirector() + " | " + getGenre() + " | " + getRelease_date()
				+ " | " + getLanguage() + " | " + getAge_rating() + " |  £" + getPrice();
	}

}
