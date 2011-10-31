import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger; //logger


package projekt_filmy;

import java.util.*;
public class Klient {

	public String imie;
	public String nazwisko;
	public ArrayList<Film> films = new ArrayList<Film>();
	
	private static Logger logger = Logger(Klient.class);//logger
	
	
	public Klient(String imie, String nazwisko)
	{
		this.imie = imie;
		this.nazwisko = nazwisko;
	}
	public Klient(String imie, String nazwisko,ArrayList<Film> films)
	{
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.films=films;
	}
	public void wypozyczFilm(Film f){
		films.add(f);
		logger.info("wypozyczono film "+ f); //logger
	}
	public void oddajFilm(Film f){
		 films.remove(f);
		logger.info("oddano film"); //logger
		
	}
	public Film jestFilm(Film f) throws wyjatek { //throws wyjatek
		if (films.indexOf(f) != -1)
				{
				return f;
		}
		else
		System.out.println("nie ma filmu");
		throw new wyjatek ("nie ma filmu w bazie"); //throw new
		return f;
		
	}
	public void zmienFilm(Film f, String nowyTytul, String nowyGatunek){
		f.tytul= nowyTytul;
		f.gatunek = nowyGatunek;
		logger.info("zmieniono film"); //logger
	}
	public void printFilms()
	{
		for(Film c : this.films) c.printFilm();
	}

}
