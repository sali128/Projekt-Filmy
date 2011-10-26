package projekt_filmy;

import java.util.*;
class Klient {

	public String imie;
	public String nazwisko;
	public ArrayList<Film> films = new ArrayList<Film>();
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
	}
	public void oddajFilm(Film f){
		films.remove(f);
	}
	public Film jestFilm(Film f){
		if (films.indexOf(f) != -1)
				{
				return f;
		}
		else
		System.out.println("nie ma filmu");
		return f;
		
	}
	public void zmienFilm(Film f, String nowyTytul, String nowyGatunek){
		f.tytul= nowyTytul;
		f.gatunek = nowyGatunek;
	}
	public void printFilms()
	{
		for(Film c : this.films) c.printFilm();
	}

}
