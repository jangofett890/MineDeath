package commands;

import org.bukkit.entity.Player;

public class Join extends SubCommand{
	public void onCommand(Player player, String[] args){
		
	}
	public String name(){
		return "join";
	}
	public String info(){
		return "Join a game";
	}
	public String[] aliases(){
		return new String[]{"J"};
	}
}
