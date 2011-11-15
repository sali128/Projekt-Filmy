package sala.patryk.projekt.wypozyczalniavideo;

public class Movie {

	private String title;
	private ItemType type;
	private String director;
	private boolean available;
	private float price;

	public Movie(String title, ItemType type, String director, float price) {
		super();
		this.title = title;
		this.type = type;
		this.director = director;
		this.available = true; // film po utworzeniu jest ZAWSZE dostepny
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Film [tytul=" + title + ", nosnik=" + type + ", rezyser="
				+ director + ", dostepność=" + available + ", cena=" + price
				+ "]";
	}

	

}
