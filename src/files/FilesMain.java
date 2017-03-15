package files;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class FilesMain {
	private FilesMain(){}
	private static FilesMain instance = new FilesMain();
	public static FilesMain getInstance(){
		return instance;
	}
	private FileConfiguration arenas;
	private File arenaFile;
	public void setup(Plugin p){
		if (!p.getDataFolder().exists()) p.getDataFolder().mkdir();
		arenaFile = new File(p.getDataFolder(), "arenas.yml");
		if (!arenaFile.exists()){
			try {arenaFile.createNewFile();}
			catch (Exception e){e.printStackTrace();}
		}
		arenas = YamlConfiguration.loadConfiguration(arenaFile);
	}
	@SuppressWarnings("unchecked")
	public <T>  T get(String path){
		return (T) arenas.get(path);
	}
	public void set(String path, Object valuse){
		arenas.set(path, valuse);
		try{ arenas.save(arenaFile); }
		catch (Exception e){ e.printStackTrace(); }
		save();
	}
	public void createConfigurationSection(String string){
		arenas.createSection(string);
		save();
	}
	private void save(){
		try{ arenas.save(arenaFile); }
		catch (Exception e){ e.printStackTrace(); }
	}
}
