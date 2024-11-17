package fr.rudy.worldborder;

import org.bukkit.plugin.java.JavaPlugin;
import fr.rudy.worldborder.commands.Commands;
import fr.rudy.worldborder.config.Config;
import fr.rudy.worldborder.config.Messages;
import fr.rudy.worldborder.listener.TeleportListener;

public final class Main extends JavaPlugin {

    private Config config;
    private BordersManager manager;
    private Messages messages;

    @Override
    public void onEnable() {
        this.config = new Config(this);
        this.manager = new BordersManager(this);
        this.messages = new Messages(this);
        manager.createBorders();
        // Enregistrement de la commande
        getCommand("border").setExecutor(new Commands(this));
        getCommand("worldborder").setExecutor(new Commands(this));
        getServer().getPluginManager().registerEvents(new TeleportListener(this), this);
    }

    @Override
    public void onDisable() { }

    public void reloadPlugin() {
        this.messages = new Messages(this);
        manager.removeBorders();
        this.config = new Config(this);
        manager.createBorders();
    }

    public Config getMyConfig() {
        return config;
    }

    public BordersManager getManager() {
        return manager;
    }

    public Messages getMessages() {
        return messages;
    }
}
