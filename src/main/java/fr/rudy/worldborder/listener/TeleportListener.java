package fr.rudy.worldborder.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import fr.rudy.worldborder.Main;

public class TeleportListener implements Listener {

    private final Main plugin;

    public TeleportListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (plugin.getMyConfig().isDisableOutOfBorderTeleport()) {
//            if (plugin.getManager().isInBorder(event.getTo())) {
//                event.setCancelled(true);
//                event.getPlayer().sendMessage(plugin.getMessages().getOutOfBorderTeleport(event.getTo().getWorld().getName()));
//            }
        }
    }

    /*@EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Bukkit.broadcastMessage("onPlayerTeleport OK");
        event.getPlayer().sendMessage("OKKK");
        if (!plugin.getManager().isWithinBorder(event.getTo())) {
            event.setCancelled(true);
        }
    }*/
}
