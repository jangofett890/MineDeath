package games;

import java.util.HashMap;

import flags.Bool;
import flags.Flag;

public class GamesMain {
	public HashMap<String, Flag<?>> flags = new HashMap<String, Flag<?>>();
	private Bool teams = new Bool("teams", false);
	
	public void setupFlags(){
		addFlag(teams);
	}
	private void addFlag(Flag<?> flag){
		flags.put(flag.getName(), flag);
	}
	public Flag<?> getFlag(String name){
		return flags.get(name);
	}
}
