package gamesarena;

import org.bukkit.Location;
import org.bukkit.inventory.PlayerInventory;

import gamesarena.ArenaManager.Team;

public class PlayerInfo {
	private String player;
	private Team team;
	private PlayerInventory inventory;
	private Location location;
	
	public PlayerInfo(String player, Team team, PlayerInventory inventory, Location location){
		this.player = player;
		this.team = team;
		this.inventory = inventory;
		this.location = location;
	}
	public String getPlayerName(){
		return player;
	}
	public Team getTeam(){
		return team;
	}
	public PlayerInventory getPlayerInventory(){
		return inventory;
	}
	public Location getLocation(){
		return location;
	}
}
