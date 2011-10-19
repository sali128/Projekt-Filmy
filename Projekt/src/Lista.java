import java.util.*;
class Lista
{
	public Lista( String imie, String nazwisko)
	{
		films = new ArrayList<Film>();
		o = new Klient(imie,nazwisko,films);
	}
	private ArrayList<Film> films;
	private  Klient o;
	Klient getKlient()
	{
		return o;
	}
	ArrayList<Film> getFilms()
	{
		return films;
	}
}

