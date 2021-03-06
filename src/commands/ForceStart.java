package commands;

import org.bukkit.entity.Player;

import lang.Lang;
import lang.Lang.Status;

public class ForceStart extends SubCommand{
	public void onCommand(Player player, String[] args){
		if(args.length == 0 ){sendMessage(player, "Specify an arena to join.", Status.ERROR);}
		if (arenaManager.getArena(player) != null){ sendMessage(player, "You are already in a game", Lang.Status.INFO); return; }
		try{ id = Integer.parseInt(args[0]); }
		catch (Exception e){sendMessage(player, args[0] + " is not a valid number", Status.ERROR); return;}
		if (a == null){ sendMessage(player, "There is no arena with the Id: "+ id, Status.ERROR); return; }
		if (a.isStarted()){ sendMessage(player, "Game has already started", Status.INFO); return;}
		a.start();
		sendMessage(player, "Arena started.", Status.INFO);
	}
	public String name(){
		return "forcestart";
	}
	public String info(){
		return "forcestart";
	}
	public String[] aliases(){
		return new String[]{"fsart", "start"};
	}
}
