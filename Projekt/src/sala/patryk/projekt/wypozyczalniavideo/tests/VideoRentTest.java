package sala.patryk.projekt.wypozyczalniavideo.tests;

import java.util.List;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

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
		videoRental.addNewMovie(new Movie("Kubus Puchatek: Powrot",ItemType.DVD,"Jan Nowak",29.99F));
		videoRental.addNewMovie(new Movie("Kubus Puchatek: Zemsta Prosiaczka",ItemType.DVD,"Jan Nowak",12.99F));
		videoRental.addNewMovie(new Movie("Smerfy",ItemType.TAPE,"Peyo",14.99F));
		videoRental.addNewMovie(new Movie("Gladiator",ItemType.DVD,"R. Scott",29.99F));
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void showAllMoviesInVieoRentalTest(){
		videoRental.printAllMovies();
	}
	
	@Test
	public void removeMovieFromVieoRentalTest(){
		Movie smerfy = videoRental.findMovieByTitle("Smerfy");
		videoRental.printAllMovies();
		videoRental.removeMovieFromVideoRental(smerfy);
		videoRental.printAllMovies();
	}
	
	@Test
	public void rentMovieTest(){
		Customer customer = null;
		try {
			customer = new Customer("Pawel Kowalski", 200);
		} catch (InvalidMoneyAmountValue e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Movie houseMovie = videoRental.findMovieByTitle("Dr House");
		
		try {
			videoRental.rentMovie(customer, houseMovie);
			System.out.println("Sprawdzanie czy wypozyczony film ma FLAGE AVAILABLE=FALSE");
			boolean available = houseMovie.isAvailable();
			Assert.assertFalse("BLAD! film mimo wypozyczenia ma flage dostepnosci = true", available);
			System.out.println("Udalo sie wypozyczyc film " + houseMovie.getTitle());
		} catch (NoMoneyException e) {
			e.printStackTrace();
			Assert.fail("Wystapil wyjatek w czasie proby wypozyczenia filmu: " + e.getMessage());
		}
	}
	
	@Test
	public void settingPriceTest(){
		float newPrice = 555;
		videoRental.setNewPriceForMovie("Dr House", newPrice);
		Movie movie = videoRental.findMovieByTitle("Dr House");
		Assert.assertEquals("BLAD, Nie udalo sie ustawic nowej ceny dla filmu ", movie.getPrice() ,newPrice);
		
	}

	
	@Test
	public void findByDirectorTest(){
		System.out.println("Wyszukiwanie po rezyserze...");
		List<Movie> resultList = videoRental.findMovieByDirector("Jan Nowak");
		Assert.assertNotNull("Blad, lista zwrocona z metody wyszukujacej po rezyserze zwrocila NULL",resultList);
		Assert.assertTrue("Blad, lista zwrocona z metody wyszukujacej po rezyserze jest pusta",resultList.size()>0);
		if(resultList.size()>0){
			for (int i = 0; i < resultList.size(); i++) {
				System.out.println("Znaleziono " + resultList.get(i).toString());
			}
		}
	}
	
	@Test
	public void findByDataCarrierTypeTest(){
		System.out.println("Wyszukiwanie po typie nosnika...");
		List<Movie> resultList = videoRental.findMovieByType("DVD");
		Assert.assertNotNull("Blad, lista zwrocona z metody wyszukujacej po rodzaju nosnika zwrocila NULL",resultList);
		Assert.assertTrue("Blad, lista zwrocona z metody wyszukujacej po rodzaju nosnika jest pusta",resultList.size()>0);
		if(resultList.size()>0){
			for (int i = 0; i < resultList.size(); i++) {
				System.out.println("Znaleziono " + resultList.get(i).toString());
			}
		}
	}
	
	@Test
	public void findByTitleTest(){
		Movie smerfy = videoRental.findMovieByTitle("Smerfy");		
		Assert.assertNotNull("Blad, nie znaleziono filmu Smerfy szukajac po tytule",smerfy);		
		if(smerfy!=null)
			System.out.println("Znaleziono film Smerfy wyszujujac po tytule");
	}
	
	@Test(expected=InvalidMoneyAmountValue.class)
	public void createCustomerWithNegativeAmountOfMoneyTest() throws InvalidMoneyAmountValue{
		System.out.println("Test wyjatku InvalidMoneyAmountValue ");
		Customer customer1 = new Customer("Pawel Kowalski", -200);
	}
	
	@Test(expected=NoMoneyException.class)
	public void clientHasNoMoneyToPayTest() throws InvalidMoneyAmountValue, NoMoneyException{
		System.out.println("Test wyjatku NoMoneyException ");
		Customer customer1 = new Customer("Pawel Kowalski", 1);
		Movie smerfy = videoRental.findMovieByTitle("Smerfy");
		Assert.assertNotNull("nie znaleziono filmu Smerfy", smerfy);
		System.out.println("Znaleziono film Smerfy");
		videoRental.rentMovie(customer1, smerfy);
	}
}
