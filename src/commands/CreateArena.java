package commands;

import org.bukkit.entity.Player;

import lang.Lang.Status;

public class CreateArena extends SubCommand{
	public void onCommand(Player player, String[] args) {
		id = arenaManager.getArenas().size() + 1;
		createConfigSection(id);
		sendMessage(player, "Created Arena: " + id, Status.INFO);
	}
	public String name() {
		return "create";
	}
	public String info() {
		return "Create an Arena";
	}
	public String[] aliases() {
		return new String[]{ "ca" };
	}
}
