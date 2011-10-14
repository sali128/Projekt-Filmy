
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
	public void printFilms()
	{
		for(Film c : this.films) c.printFilm();
	}

}
