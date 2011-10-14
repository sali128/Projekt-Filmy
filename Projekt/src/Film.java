class Film 
{
	private String tytul;;
	private String gatunek;
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