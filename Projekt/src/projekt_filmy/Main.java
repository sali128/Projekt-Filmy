package projekt_filmy;



//import projekt_filmy_events.Filmevent;

public class Main 
{
	
	
	public static void main( String [] argv ) 
	{
		Lista lst = new Lista("ala","kot");
		lst.getFilms().add(new Film("Piraci z karaibów","przygodowy"));
		lst.getFilms().add(new Film("Rambo","akcja"));
		lst.getFilms().add(new Film("Krwawy sport","sportowy"));
		lst.getFilms().add(new Film("Bruce wszechmogacy","komedia"));
		lst.getKlient().printFilms();
		
		//iFilmProcesses ChangeBox=new Paczka.ChangeBox();
	
	}

}
