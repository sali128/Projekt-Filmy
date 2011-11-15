package sala.patryk.projekt.wypozyczalniavideo;

import org.apache.log4j.Logger;


public class Main {

	private static Logger logger= Logger.getLogger(Main.class);
	
	public static void main(String[] args) {

		VideoRental videoRental = new VideoRental();
		
		videoRental.addNewMovie(new Movie("W pustyni i w puszczy",ItemType.TAPE,"Jan Nowak",19.99F));
		videoRental.addNewMovie(new Movie("Batman",ItemType.DVD,"Adam Xsinski",13));
		videoRental.addNewMovie(new Movie("Dr House",ItemType.CD,"Pawel Nazwisko",5));
		videoRental.addNewMovie(new Movie("Kubus Puchatek",ItemType.TAPE,"Jan Nowak",9.99F));
		videoRental.addNewMovie(new Movie("Smerfy",ItemType.TAPE,"Peyo",14.99F));
		videoRental.addNewMovie(new Movie("Gladiator",ItemType.DVD,"R. Scott",29.99F));

		videoRental.printAllMovies();
		
		try {
			Customer customer1 = new Customer("Pawel Kowalski", -200);
		
		}catch (InvalidMoneyAmountValue exception) {
			logger.error(exception.getMessage());
		}
		
		Customer customer2 = null;
		try {
			customer2 = new Customer("Pawel Baranowski", 20);
		} catch (InvalidMoneyAmountValue e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		customer2.showAllMyRentedMovies();
		
		Movie smerfyMovie = videoRental.findMovieByTitle("Smerfy");
		Movie gladiatororMovie = videoRental.findMovieByTitle("Gladiator");
		Movie batmanMovie = videoRental.findMovieByTitle("Batman");
		try{	
			videoRental.rentMovie(customer2 , gladiatororMovie);
			videoRental.rentMovie(customer2 , smerfyMovie);
			videoRental.rentMovie(customer2 , batmanMovie);
		} catch (NoMoneyException e) {
			logger.error(e.getMessage());
		}
		
		customer2.showAllMyRentedMovies();
		
		videoRental.printAllMovies();
		
	}

}
