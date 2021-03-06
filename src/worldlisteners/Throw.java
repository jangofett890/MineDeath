package worldlisteners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Throw extends WorldMain implements Listener{
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		if(!(e.getAction() == Action.RIGHT_CLICK_AIR && !(e.getAction() == Action.RIGHT_CLICK_BLOCK))){ return; }
		if (e.getItem().getType() == Material.SNOW_BALL){
			e.getPlayer().launchProjectile(Snowball.class);
		}
	}
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		if(!(e.getEntity() instanceof Player) && !(e.getCause().equals(Snowball.class))){ return; }
	}
}
