package projekt_filmy_events;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Paczka {
	
	
	private Film film;
	
	private List processes= new ArrayList();
	
	public synchronized void addProcess(IFilmProcesses process)
	{
		processes.add(process);
		
	}
	public synchronized void removeProcess(IFilmProcesses process)
	{
		processes.remove(process);
		
	}
	
	public synchronized void exevuteFilmProcess()
	{
		FilmEvent filmEvent= new FilmEvent(this,film);
		
		Iterator procs=processes.iterator();
		while(procs.hasNext())
		{
			((IFilmProcesses) procs.next() ).processFilm(filmEvent);
		}
		
	}
	public static class ChangeBox implements IFilmProcesses
	{
		
		public void processFilm (FilmEvent filmEvent){
		
			System.out.println(filmEvent.get_film() + "pudelko zmieniona");
		
		}
	}
		
	
	
	}
	

