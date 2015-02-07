/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coincraft;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;
/**
 *
 * @author tking
 */


public class EntryPoint extends JavaPlugin {
    public Location battle;
    public Location jail;
    public void onEnable() {
     Random randomizer = new Random();
         this.getServer().getLogger().info("Coincraft Enabled.");
         this.getServer().getPluginManager().registerEvents(new BlockBreak(this.getServer()), this);
         this.getServer().getPluginManager().registerEvents(new PlayerReady(this.getServer()), this);
 //        java.util.List<org.bukkit.World> w = this.getServer().getWorlds();
         this.battle = new Location(this.getServer().getWorld("battle"), 66, 68, 204); 
         this.jail = new Location(this.getServer().getWorld("jail"), -32, 65,15);
        //this.getServer().getWorld("battle").setSpawnLocation(66, 68, 204);
         for(int x = 59; x < 83; x++) {
             for(int y = 0 ; y < this.getServer().getWorld("battle").getMaxHeight(); y++) { 
                 for(int z = 197; z < 218; z++) {
                     if(this.getServer().getWorld("battle").getBlockAt(x, y, z).getType().equals(org.bukkit.Material.DIAMOND_ORE)) {
                         this.getServer().getWorld("battle").getBlockAt(x,y,z).setType(org.bukkit.Material.STONE);
                     }
                 }
             }
           }
         Location diamond = new Location(this.getServer().getWorld("battle"),(double)59 + randomizer.nextInt(83 - 59),(double)randomizer.nextInt(5) + 1,(double) 197 + randomizer.nextInt(218 - 197));
        this.getServer().getLogger().info("Diamond ore at: " + diamond.toString());
       
//this.getServer().getWorld("battle").getBlockAt(diamond).setType(org.bukkit.Material.DIAMOND_ORE);
       
    }
}
