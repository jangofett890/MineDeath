package gamesarena;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import gamesarena.ArenaManager.Team;

public class Arena {
	private int id;
	private Location spawn1, spawn2;
	private HashMap<String, Team> players = new HashMap<String, Team>();
	
	public Arena(int id){
		
	}
	public int getId(){
		return id;
	}
	public Location getSpawn(Team team){
		switch(team){
		case RED: return spawn1;
		case BLUE: return spawn2;
		default: return null;
		}
	}
	public Team getTeam(Player player){
		return players.get(player.getName());
	}
	public void addPlayer(Player player){
		players.put(player.getName(), getSmallerTeam());
	}
	private Team getSmallerTeam(){
		int red = 0, blue = 0;
		for (String p : players.keySet()){
			if (players.get(p) == Team.RED) red++;
				else blue++;
			}
		if (red > blue) return Team.BLUE;
		else return Team.RED;
		}
	public boolean containsPlayer(Player player){
		return players.keySet().contains(player.getName());
	}
}