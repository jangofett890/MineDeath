package minedeath;

import org.bukkit.plugin.java.JavaPlugin;

import commands.CommandMain;
import files.FilesMain;
import gamesarena.ArenaManager;
import minedeath.world.WorldListeners;


public class Main extends JavaPlugin {
	FilesMain files = FilesMain.getInstance();
	CommandMain cm = new CommandMain();
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new WorldListeners(), this);
		files.setup(this);
		files.set("ids.1", "Sup");
		ArenaManager.getInstance().setup();
		cm.setup();
		getCommand("game").setExecutor(cm);
	}
}
