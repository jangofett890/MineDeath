package lang;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class Lang {
	public enum Status{INFO, SEVERE, ERROR};
	private static ChatColor stat(Status status){
		if(status == Status.INFO){
			return ChatColor.YELLOW;
		}
		else if(status == Status.SEVERE){
			return ChatColor.DARK_RED;
		}
		else if (status == Status.ERROR){
			return ChatColor.RED;
		}
		else{ 
			return ChatColor.GREEN;
		}
	}
	private Lang(){}
	private static Lang instance = new Lang();
	public static Lang getInstance(){
		return instance;
	}
	public void sendMessage(CommandSender src, String message, Status status){
		src.sendMessage(stat(status) + message);
	}
	public static void print(String arg, Status status){
		Bukkit.getServer().getConsoleSender().sendMessage(stat(status) +arg);
	}
	
}
