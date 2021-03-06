package gamesarena;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;
import org.bukkit.plugin.Plugin;

import files.FilesMain;
import gamesarena.ArenaManager.Team;
import lang.Lang;
import lang.Lang.Status;

public class Arena {
	private int id;
	private boolean started = false;
	private Location redspawn, bluespawn;
	private PlayerInventory playerinv = PlayerInventory.getInstance();
	private ArrayList<PlayerInfo> players = new ArrayList<PlayerInfo>();
	private Lang lang = Lang.getInstance();

	
	public Arena(int id){
		this.id = id;
		ConfigurationSection conf = FilesMain.getInstance().getArena(id + "");
		this.redspawn = getLocation(conf.getConfigurationSection("redspawn"));
		this.bluespawn = getLocation(conf.getConfigurationSection("bluespawn"));
	}
	private void sendMessage(CommandSender src, String message, Status status){
		lang.sendMessage(src, message, status);
	}
	private Plugin getPlugin(){
		return FilesMain.getInstance().getPlugin();
	}
	public boolean isStarted(){
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
		return getData(player).getTeam();
	}
	public void addPlayer(Player player){
		players.add(new PlayerInfo(player.getName(), getSmallerTeam(), player.getInventory(), player.getLocation()));
		player.getInventory().clear();
		playerinv.addIntoInventory(player, new ItemStack(Material.SNOW_BALL, 1));
		player.getInventory().setHelmet(new Wool(DyeColor.valueOf(getData(player).getTeam().toString())).toItemStack(1));
		player.teleport(getSpawn(getData(player).getTeam()));
		if (players.size() >= 2 ) start();
	}
	public void removePlayer(Player player){
		players.remove(getData(player));
	}
	private Team getSmallerTeam(){
		int red = 0, blue = 0;
		for (PlayerInfo pi : players){
			if (pi.getTeam() == Team.RED) red++;
				else blue++;
			}
		if (red > blue) return Team.BLUE;
		else return Team.RED;
		}
	public boolean containsPlayer(Player player){
		return getData(player) !=null;
	}
	public void start(){
		messagePlayers("GameStarting in 30 seconds", Status.INFO);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(getPlugin(), new Runnable(){
			public void run(){
				Arena.this.started = true;
				messagePlayers("HFGL", Status.INFO);
			}
		}, 30*20);
	}
	public void stop(Player winner){
		messagePlayers(winner != null ? winner.getName() + " won the game." : "The game has ended.", Status.INFO);
		for(PlayerInfo pi : players){
			Player player = Bukkit.getServer().getPlayer(pi.getPlayerName());
			player.getInventory().clear();
			player.getInventory().addItem(pi.getPlayerInventory().getContents());
			player.getInventory().setArmorContents(pi.getPlayerInventory().getArmorContents());
			player.teleport(pi.getLocation());
		}
	}
	private void messagePlayers(String message, Status status){
		for (PlayerInfo pi : players){
			Player p = Bukkit.getServer().getPlayer(pi.getPlayerName());
			sendMessage(p, message, status);
		}
	}
	private PlayerInfo getData(Player player){
		for (PlayerInfo pi : players){
			if (pi.getPlayerName().equalsIgnoreCase(player.getName())){ return pi; }
		}
		return null;
	}
}