package commands.set;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import commands.SubCommand;
import gamesarena.ArenaManager.Team;
import lang.Lang.Status;

public class SetArenaLocation extends SubCommand{

	@Override
	public void onCommand(Player player, String[] args) {
		if(args.length < 2){
			sendMessage(player, "Specify more arguments", Status.ERROR);
		}
		try{ id = Integer.parseInt(args[0]); }
		catch (Exception e){sendMessage(player, args[0] + " is not a valid number", Status.ERROR); return;}
		if (a == null){ sendMessage(player, "There is no arena with the Id: "+ id, Status.ERROR); }
		team = null;
		try { team = Team.valueOf(args[1]); }
		catch (Exception e){
			sendMessage(player, args[1] + " is not a vali arena", Status.ERROR);
			return;
		}
		ConfigurationSection s = createConfigurationSection(a.getId() + "." + team.toString().toLowerCase() + "spawn");
		s.set("world" , player.getWorld().getName());
		s.set("x" , player.getLocation().getX());
		s.set("y" , player.getLocation().getY());
		s.set("z" , player.getLocation().getZ());
		sendMessage(player, "Set: " + team.toString().toLowerCase(), Status.INFO);
	}
	public String name() {
		return "setspawn";
	}

	public String info() {
		return "Sets an arena Location";
	}
	public String[] aliases() {
		return new String[]{"sa"};
	}
	//set multiple spawns to write to a file then have a fucntion to randomly select a spawn to place the player in.
}
