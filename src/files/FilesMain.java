package files;

import java.io.File;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
@SuppressWarnings("unchecked")
public class FilesMain {
	private Plugin plugin;
	private FilesMain(){}
	private static FilesMain instance = new FilesMain();
	public static FilesMain getInstance(){
		return instance;
	}
	public Plugin getPlugin(){
		return plugin;
	}
	private FileConfiguration arenas; 
	private FileConfiguration gameModes; 
	private File arenaFile;
	private File gameFile;
	
	public void setup(Plugin p){
		this.plugin = p;
		mkdir(p);
	//Create Files
		arenaFile = new File(p.getDataFolder(), "arenas.yml");
		gameFile = new File(p.getDataFolder(), "games.yml");
	//Check Files Existence
		check(gameFile);
		check(arenaFile);
	//Load the Config for files
		gameModes = YamlConfiguration.loadConfiguration(gameFile);
		arenas = YamlConfiguration.loadConfiguration(arenaFile);
	}
//Games
	public <T> T getGames(String path){
		return (T) gameModes.get(path);
	}
	public void setGames(String path, Object value){
		gameModes.set(path, value);
		try{ gameModes.save(gameFile); }
		catch (Exception e){ e.printStackTrace(); }
		saveGames();
	}
	private void saveGames(){
		try{ gameModes.save(gameFile); }
		catch (Exception e){ e.printStackTrace(); }
	}
	public ConfigurationSection createConfigurationSectionGame(String string){
		ConfigurationSection s = gameModes.createSection(string);
		saveArena();
		return s;
	}
//Arenas
	public <T> T getArena(String path){
		return (T) arenas.get(path);
	}
	public void setArena(String path, Object value){
		arenas.set(path, value);
		try{ arenas.save(arenaFile); }
		catch (Exception e){ e.printStackTrace(); }
		saveArena();
	}
	private void saveArena(){
		try{ arenas.save(arenaFile); }
		catch (Exception e){ e.printStackTrace(); }
	}
	public ConfigurationSection createConfigurationSectionArena(String string){
		ConfigurationSection s = arenas.createSection(string);
		saveArena();
		return s;
	}
//Other Stuff
	private void mkdir(Plugin p){
		if (!p.getDataFolder().exists()) p.getDataFolder().mkdir();
	}
	private void check(File file){
		if (!file.exists()){
			try {file.createNewFile();}
			catch (Exception e){e.printStackTrace();}
		}
	}
}
