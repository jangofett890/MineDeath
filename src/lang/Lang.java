package lang;
import org.bukkit.Bukkit;

public class Lang {
	public static void print(String arg){
		Bukkit.getServer().getConsoleSender().sendMessage(arg);
	}
}
