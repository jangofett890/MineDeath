package worldlisteners;

import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import lang.Lang;

public class WorldListeners extends WorldMain implements Listener{
	@EventHandler
	public void onIntereact(PlayerInteractEvent e){
		block = e.getClickedBlock();
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(block.getState() instanceof Sign){
				sign = (Sign) e.getClickedBlock().getState();
				readSign(sign);
				setLine(sign, 0, "GameMap");
				update(sign);
			}
		}
	}
	@EventHandler
	public void signTextChange(SignChangeEvent e){
		sign = (Sign) e.getBlock().getState();
		player = e.getPlayer();
		int locX = (int) Math.round(player.getLocation().getX());
		int locY = (int) Math.round(player.getLocation().getY());
		int locZ = (int) Math.round(player.getLocation().getZ());
		String xyz = Integer.toString(locX) + ", " + Integer.toString(locY) + ", " + Integer.toString(locZ);
		if(e.getLine(0).equalsIgnoreCase("test")){
			setLine(sign, 0, "GameMap");
			update(sign);
			print(xyz, Lang.Status.INFO);
		}
	}
}
