package worldlisteners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import gamesarena.ArenaManager;

public class BlockBreak extends WorldMain implements Listener {
	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent e){
		if(ArenaManager.getInstance().getArena(e.getPlayer()) != null){ e.setCancelled(true); }
	}
}
