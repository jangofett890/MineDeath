package minedeath;

import org.bukkit.plugin.java.JavaPlugin;

import commands.CommandMain;
import gamesarena.ArenaManager;
import minedeath.world.WorldListeners;


public class Main extends JavaPlugin {
	CommandMain cm = new CommandMain();
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new WorldListeners(), this);
		ArenaManager.getInstance().setup();
		cm.setup();
		getCommand("game").setExecutor(cm);
		
	}
}
