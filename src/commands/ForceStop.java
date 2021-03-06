package commands;

import org.bukkit.entity.Player;

import lang.Lang;
import lang.Lang.Status;

public class ForceStop extends SubCommand{
	public void onCommand(Player player, String[] args){
		if(args.length == 0 ){sendMessage(player, "Specify an arena to join.", Status.ERROR);}
		if (arenaManager.getArena(player) != null){ sendMessage(player, "You are already in a game", Lang.Status.INFO); return; }
		try{ id = Integer.parseInt(args[0]); }
		catch (Exception e){sendMessage(player, args[0] + " is not a valid number", Status.ERROR); return;}
		if (a == null){ sendMessage(player, "There is no arena with the Id: "+ id, Status.ERROR); }
		if (!a.isStarted()){ sendMessage(player, "Game is not started.", Status.INFO);}
		a.stop(null);
		sendMessage(player, "Arena stopped.", Status.INFO);
	}
	public String name(){
		return "force stop";
	}
	public String info(){
		return "Stops an arena";
	}
	public String[] aliases(){
		return new String[]{"fstop", "stop"};
	}
}
