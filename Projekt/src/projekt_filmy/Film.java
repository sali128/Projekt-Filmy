package projekt_filmy;
import java.util.*;
class Film 
{
	public String tytul;;
	public String gatunek;
	public Film(String tytul, String gatunek)
	{
		this.gatunek=gatunek;
		this.tytul=tytul;
	}
	public void printFilm()
	{
		System.out.println("Film::"+tytul+" gatunek "+gatunek);
	}
}