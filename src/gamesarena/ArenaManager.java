package gamesarena;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import files.FilesMain;

public class ArenaManager {
	public enum Team {RED,BLUE}
	private ArenaManager(){}
	private static ArenaManager instance = new ArenaManager();
	public static ArenaManager getInstance(){
		return instance;
	}
	private ArrayList<Arena> arena = new ArrayList<Arena>();
	public void setup(){
		for (int i : FilesMain.getInstance().<List<Integer>>getArena("ids")){
			arena.add(new Arena(i));
		}
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
	public ArrayList<Arena> getArenas(){
		return arena;
	}
}