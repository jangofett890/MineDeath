package commands;

import org.bukkit.entity.Player;

import lang.Lang;
import lang.Lang.Status;

public class RemoveArena extends SubCommand {
	public void onCommand(Player player, String[] args) {
		if (args.length == 0) {
			sendMessage(player, "Specify an arena to delete", Status.ERROR);
			return;
		}
		try{ id = Integer.parseInt(args[0]); }
		catch (Exception e){sendMessage(player, args[0] + " is not a valid number", Lang.Status.ERROR); return;}
		if (a == null){ sendMessage(player, "There is no arena with the Id: "+ id, Lang.Status.ERROR); }
		if (a.isStated()){ sendMessage(player, "Cannot delete in progress games", Lang.Status.INFO);}
		files.set(id + "", null);
		arenaManager.setup();
	}
	public String name() {
		return "delete";
	}
	public String info() {
		return "Remove an arena";
	}
	public String[] aliases() {
		return new String[] { "ra" } ;
	}
}
