package commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import lang.Lang;
import lang.Lang.Status;

public  class CommandMain implements CommandExecutor {
	protected static void print(String text, Status stat){
		Lang.print(text, stat);
	}
	protected static void sendMessage(CommandSender src, String text, Status stat){
		Lang.getInstance().sendMessage(src, text, stat);
	}

	Lang lang = Lang.getInstance();
	private ArrayList<SubCommand> commands = new ArrayList<SubCommand>();
	public void setup(){		
	commands.add(new RemoveArena());
	commands.add(new ForceStart());
	commands.add(new ForceStop());
	commands.add(new Join());
	commands.add(new Quit());
	commands.add(new CreateArena());}
	public boolean onCommand(CommandSender src, Command cmd, String lable, String[] args){
		if (checkConsole(src)){
			print("Only players can use this command.", Lang.Status.INFO);
			return true;
		}
		Player player = (Player) src;
		if (cmd.getName().equalsIgnoreCase("game")){
			if(args.length == 0){
				for (SubCommand c : commands){
					sendMessage(player,c.name() + " (" + aliesesToString(c) + ")", Lang.Status.INFO);
				}
				return true;
			}
			SubCommand target = get(args[0]);
			if(target == null){
				sendMessage(player, "/game " + args[0] + " is not valid usage.", Lang.Status.ERROR);
				return true;
			}
			ArrayList<String> a = new ArrayList<String>();
			a.addAll(Arrays.asList(args));
			a.remove(0);
			args = a.toArray((new String[a.size()]));
			try{
				target.onCommand(player, args);
			}
			catch (Exception e){
				print(e.getStackTrace().toString(), Lang.Status.SEVERE);
				sendMessage(player, "An errror has occored, " + e.getCause(), Lang.Status.SEVERE);
			}
		}
		return true;
	}
	private String aliesesToString(SubCommand cmd){
		String end = "";
		for (String a : cmd.aliases()){
			end += a + " | ";
		}
		return end.substring(0, end.lastIndexOf("| "));
	}
	public static boolean checkConsole(CommandSender src){
		if (!(src instanceof Player)){
			return true;
		}
		return false;
	}
	private SubCommand get(String name){
		for (SubCommand cmd : commands){
			if(cmd.name().equalsIgnoreCase(name)) return cmd;
		}
		return null;
	}
}