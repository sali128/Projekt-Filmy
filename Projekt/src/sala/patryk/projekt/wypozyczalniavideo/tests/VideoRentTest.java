package sala.patryk.projekt.wypozyczalniavideo.tests;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sala.patryk.projekt.wypozyczalniavideo.Customer;
import sala.patryk.projekt.wypozyczalniavideo.InvalidMoneyAmountValue;
import sala.patryk.projekt.wypozyczalniavideo.ItemType;
import sala.patryk.projekt.wypozyczalniavideo.Movie;
import sala.patryk.projekt.wypozyczalniavideo.NoMoneyException;
import sala.patryk.projekt.wypozyczalniavideo.VideoRental;


public class VideoRentTest {

	private VideoRental videoRental;
	
	@Before
	public void setUp() throws Exception {
		videoRental = new VideoRental();
		videoRental.addNewMovie(new Movie("W pustyni i w puszczy",ItemType.TAPE,"Jan Nowak",19.99F));
		videoRental.addNewMovie(new Movie("Batman",ItemType.DVD,"Adam Xsinski",13));
		videoRental.addNewMovie(new Movie("Dr House",ItemType.CD,"Pawel Nazwisko",5));
		videoRental.addNewMovie(new Movie("Kubus Puchatek",ItemType.TAPE,"Jan Nowak",9.99F));
		videoRental.addNewMovie(new Movie("Smerfy",ItemType.TAPE,"Peyo",14.99F));
		videoRental.addNewMovie(new Movie("Gladiator",ItemType.DVD,"R. Scott",29.99F));
	}
	
	@Test
	public void showAllMoviesInVieoRental(){
		videoRental.printAllMovies();
	}
	
	@Test
	public void removeMovieFromVieoRental(){
		Movie smerfy = videoRental.findMovieByTitle("Smerfy");
		videoRental.printAllMovies();
		videoRental.removeMovieFromVideoRental(smerfy);
		videoRental.printAllMovies();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test(expected=InvalidMoneyAmountValue.class)
	public void createCustomerWithNegativeAmountOfMoney() throws InvalidMoneyAmountValue{
		Customer customer1 = new Customer("Pawel Kowalski", -200);
	}
	
	@Test(expected=NoMoneyException.class)
	public void clientHasNoMoneyToPay() throws InvalidMoneyAmountValue, NoMoneyException{
		Customer customer1 = new Customer("Pawel Kowalski", 1);
		Movie smerfy = videoRental.findMovieByTitle("Smerfy");
		Assert.assertNotNull("nie znaleziono filmu Smerfy", smerfy);
		videoRental.rentMovie(customer1, smerfy);
	}

		
}
