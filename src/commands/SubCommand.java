package commands;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import files.FilesMain;
import gamesarena.Arena;
import gamesarena.ArenaManager;
import gamesarena.ArenaManager.Team;
import lang.Lang;
import lang.Lang.Status;

public abstract class SubCommand {
	public ArenaManager arenaManager = ArenaManager.getInstance();
	public FilesMain files= FilesMain.getInstance();
	public Arena a;
	protected Team team;
	public int id = 0;
	protected static void print(String text, Status stat){
		Lang.print(text, stat);
	}
	protected ConfigurationSection createConfigurationSection(String string){
		return FilesMain.getInstance().createConfigurationSectionArena(string);
	}
	protected void sendMessage(Player player, String text, Status status){
		Lang.getInstance().sendMessage(player, text, status);
	}
	protected void createConfigSection(int id){
		files.createConfigurationSectionArena(id + "");
	}
	protected void getArena(int id){
		arenaManager.getArena(id);
	}
	protected void getArena(Player player){
		arenaManager.getArena(player);
	}
	public abstract void onCommand(Player player, String[] args);
	public abstract String name();
	public abstract String info();
	public abstract String[] aliases();
}
