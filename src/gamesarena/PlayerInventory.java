package gamesarena;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerInventory {
	private PlayerInventory(){}
	private static PlayerInventory instance = new PlayerInventory();
	public static PlayerInventory getInstance(){
		return instance;
	}
	public void addIntoInventory(Player player, ItemStack item){
		player.getInventory().addItem(item);
	}

}
