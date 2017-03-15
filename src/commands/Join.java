package commands;

import org.bukkit.entity.Player;

import lang.Lang;

public class Join extends SubCommand{
	
	public void onCommand(Player player, String[] args){
		if (arenaManager.getArena(player) != null){ sendMessage(player, "You are already in a game", Lang.Status.INFO); return; }
		try{ id = Integer.parseInt(args[0]); }
		catch (Exception e){sendMessage(player, args[0] + " is not a valid number", Lang.Status.ERROR); return;}
		if (a == null){ sendMessage(player, "There is no arena with the Id: "+ id, Lang.Status.ERROR); }
		if (a.isStated()){ sendMessage(player, "Cannot join games late.", Lang.Status.INFO);}
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
