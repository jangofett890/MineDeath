package minedeath;

import org.bukkit.plugin.java.JavaPlugin;

import commands.CommandMain;
import files.FilesMain;
import worldlisteners.WorldListeners;


public class Main extends JavaPlugin {
	FilesMain files = FilesMain.getInstance();
	CommandMain cm = new CommandMain();
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new WorldListeners(), this);
		getCommand("game").setExecutor(cm);
		cm.setup();
		files.setup(this);
	}
}
