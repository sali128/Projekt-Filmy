package sala.patryk.projekt.wypozyczalniavideo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class VideoRental {

	private float totalCashInVideoRental = 0;

	private static Logger logger = Logger.getLogger(VideoRental.class);

	private List<Movie> videoList;

	public VideoRental() {
		videoList = new ArrayList<Movie>();
		logger.debug("Zrobiono nowa wypozyczalnie video");
	}

	public void removeMovieFromVideoRental(Movie movie) {
		videoList.remove(movie);
		logger.debug("Usunieto film z wypozyczalni: " + movie.getTitle());
	}
	
	public void setNewPriceForMovie(String movieTitle, float newPrice){
		Movie movie = findMovieByTitle(movieTitle);
		movie.setPrice(newPrice);
	}

	public void addNewMovie(Movie movie) {
		videoList.add(movie);
		logger.debug("dodano nowy film do wypozyczalni: " + movie.getTitle());
	}

	public void printAllMovies() {
		logger.info("Lista wszystkich filmow w wypozyczalni");
		for (Movie movie : videoList) {
			logger.info(movie.toString());
		}
	}

	public List<Movie> findMovieByDirector(String director) {
		List<Movie> resultList = new ArrayList<Movie>();
		for (Movie movie : videoList) {
			if (movie.getDirector().equals(director))
				resultList.add(movie);
		}
		return resultList;
	}

	public List<Movie> findMovieByType(String type) {
		List<Movie> resultList = new ArrayList<Movie>();
		for (Movie movie : videoList) {
			if (movie.getType().equals(ItemType.valueOf(type)))
				resultList.add(movie);
		}
		return resultList;
	}

	public Movie findMovieByTitle(String title) {
		for (Movie movie : videoList) {
			if (movie.getTitle().equals(title)) {
				return movie;
			}
		}
		return null;
	}

	public void rentMovie(Customer customer, Movie smerfyMovie)
			throws NoMoneyException {
		if (smerfyMovie.isAvailable()) {
			float moneyFromCustomer;
			moneyFromCustomer = customer.payMoney(smerfyMovie.getPrice());
			totalCashInVideoRental = totalCashInVideoRental + moneyFromCustomer;
			smerfyMovie.setAvailable(false); // film nie bedzie juz dostepny
												// poniewaz wlasnie jest
												// wypozyczany
			customer.takeMovie(smerfyMovie);
			logger.debug("Klient " + customer.getName()
					+ " wlasnie wypozyczyl film " + smerfyMovie.getTitle());
		}
	}
}
