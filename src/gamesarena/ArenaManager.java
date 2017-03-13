package gamesarena;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class ArenaManager {
	public enum Team {RED,BLUE}
	private ArenaManager(){}
	private static ArenaManager instance = new ArenaManager();
	public static ArenaManager getInstance(){
		return instance;
	}
	private ArrayList<Arena> arena = new ArrayList<Arena>();
	public void setup(){
		//Config Time :)
	}
	public Arena getArena(int id){
		for (Arena a : arena){
			if (a.getId() == id) return a;
		}
		return null;
	}
	public Arena getArena(Player player){
		for (Arena a : arena){
			if(a.containsPlayer(player)) return a;
		}
		return null;
	}
}