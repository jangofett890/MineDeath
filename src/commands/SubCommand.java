package commands;

import org.bukkit.entity.Player;

import gamesarena.Arena;
import gamesarena.ArenaManager;
import lang.Lang;
import lang.Lang.Status;

public abstract class SubCommand {
	public ArenaManager arenaManager = ArenaManager.getInstance();
	public int id = 0;
	public Arena a = arenaManager.getArena(id);
	protected static void print(String text, Status stat){
		Lang.print(text, stat);
	}
	protected static void sendMessage(Player player, String text, Status stat){
		Lang.sendMessage(player, text, stat);
	}
	public abstract void onCommand(Player player, String[] args);
	public abstract String name();
	public abstract String info();
	public abstract String[] aliases();
}
