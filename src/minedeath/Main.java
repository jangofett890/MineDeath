package minedeath;

import org.bukkit.plugin.java.JavaPlugin;

import minedeath.world.WorldListeners;


public class Main extends JavaPlugin {
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new WorldListeners(), this);
	}
}
