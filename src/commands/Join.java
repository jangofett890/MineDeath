package commands;

import org.bukkit.entity.Player;

import lang.Lang;
import lang.Lang.Status;

public class Join extends SubCommand{
	public void onCommand(Player player, String[] args){
		if(args.length == 0 ){sendMessage(player, "Specify an arena to join.", Status.ERROR); return;}
		if (arenaManager.getArena(player) != null){ sendMessage(player, "You are already in a game", Lang.Status.INFO); return; }
		try{ id = Integer.parseInt(args[0]); }
		catch (Exception e){sendMessage(player, args[0] + " is not a valid number", Status.ERROR); return;}
		if (a == null){ sendMessage(player, "There is no arena with the Id: "+ id, Status.ERROR); return; }
		if (a.isStarted()){ sendMessage(player, "Cannot join games late.", Status.INFO); return;}
		a.addPlayer(player);
	}
	public String name(){
		return "join";
	}
	public String info(){
		return "Join a game";
	}
	public String[] aliases(){
		return new String[]{"q"};
	}
}
