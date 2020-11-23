package me.Shamed.LobbyAntiVoid;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public class Main extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {

	}

	@EventHandler()
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		new BukkitRunnable() {
			public void run(){
				if(player.getLocation().getY()<=-40){
					player.teleport(player.getWorld().getSpawnLocation());
					player.setHealth(20);
					player.setSaturation(20);
				}
			}
		}.runTaskTimer(this, 0, 0);
	}
	
	@EventHandler()
	public void onPlayerDamage(EntityDamageEvent e){
		if(e.getEntity() instanceof Player){
			e.setDamage(0);
			e.setCancelled(true);	
		}
	}

}