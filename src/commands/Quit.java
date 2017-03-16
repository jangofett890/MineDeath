package commands;

import org.bukkit.entity.Player;

import lang.Lang.Status;

public class Quit extends SubCommand {
	public void onCommand(Player player, String[] args){
		if (a == null){ sendMessage(player, "You not/gam in a game", Status.INFO); return; }
		a.removePlayer(player);
	}
	public String name(){
		return "quit";
	}
	public String info(){
		return "Quit a game";
	}
	public String[] aliases(){
		return new String[]{"q"};
	}
}
