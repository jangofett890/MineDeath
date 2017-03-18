package gamesarena;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import files.FilesMain;
import gamesarena.ArenaManager.Team;

public class Arena {
	private int id;
	private boolean started = false;
	private Location redspawn, bluespawn;
	private HashMap<String, Team> players = new HashMap<String, Team>();
	
	public Arena(int id){
		this.id = id;
		ConfigurationSection conf = FilesMain.getInstance().get(id + "");
		this.redspawn = getLocation(conf.getConfigurationSection("redspawn"));
		this.bluespawn = getLocation(conf.getConfigurationSection("bluespawn"));
		
	}
	public boolean isStated(){
		return started;
	}
	public void setStarted(boolean bool){
		this.started = bool;
	}
	private Location getLocation(ConfigurationSection path){
		return new Location(Bukkit.getServer().getWorld("world"), path.getDouble("x"), path.getDouble("y"), path.getDouble("z"));
	}
	public int getId(){
		return id;
	}
	public Location getSpawn(Team team){
		switch(team){
		case RED: return redspawn;
		case BLUE: return bluespawn;
		default: return null;
		}
	}
	public Team getTeam(Player player){
		return players.get(player.getName());
	}
	public void addPlayer(Player player){
		players.put(player.getName(), getSmallerTeam());
	}
	public void removePlayer(Player player){
		players.remove(player);
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