package pro.mrcl.ProjectXANA;

import mrcl.pro.GoodOldJack12.ProjectCarthage.Logic.Events.LyokoWarriorEvents.DevirtualizationEvent;
import mrcl.pro.GoodOldJack12.ProjectCarthage.Logic.Events.LyokoWarriorEvents.LyokoWarriorEvent;
import mrcl.pro.GoodOldJack12.ProjectCarthage.Logic.Events.LyokoWarriorEvents.VirtualizationEvent;
import mrcl.pro.GoodOldJack12.ProjectCarthage.Logic.Events.TowerEvents.TowerActivationEvent;
import mrcl.pro.GoodOldJack12.ProjectCarthage.Logic.Events.TowerEvents.TowerDeactivationEvent;
import mrcl.pro.GoodOldJack12.ProjectCarthage.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Team;
import pro.mrcl.ProjectXANA.Commands.possess;
import pro.mrcl.ProjectXANA.XANAAttacks.NuclearExplo;
import pro.mrcl.ProjectXANA.XANAAttacks.XanaficationPly;

public class Listener implements org.bukkit.event.Listener{
    private XANAMain plugin;
    private Main pl;
    private XanaficationPly XANAPLY;
    private possess possession;
    private NuclearExplo nuke;

    public Listener(XANAMain plugin){
        this.plugin = plugin;
        XANAPLY = new XanaficationPly(plugin.getPRC());
    }

    @EventHandler
    public void onTowerActivation(TowerActivationEvent event){
        XANAPLY.plyXanafication();
        nuke.setTowerDeactivated(false);
    }

    @EventHandler
    public void onTowerDeactivation(TowerDeactivationEvent event){
        XANAPLY.unXanafication();
        possession.unXanafication();
        nuke.setTowerDeactivated(true);
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        Player leaveplayer = event.getPlayer();
        Team team = Bukkit.getScoreboardManager().getMainScoreboard().getTeam("XANA");

        if(team.hasPlayer(leaveplayer)){
            team.removePlayer(leaveplayer);
            possession.setPlyPossessed(false);
            if(leaveplayer.equals(possession.whoAmI())) {
                possession.setPlyPossessed(false);
            }
            Bukkit.getLogger().info("[PRX]" +leaveplayer.getName() +" left the server while under XANA possession");
        }
    }

    @EventHandler
    public void onVirtualisation(VirtualizationEvent event){
        Main pl = (Main) Bukkit.getPluginManager().getPlugin("ProjectCarthage");
        LyokoWarriorEvent warrior = pl.getLyokoWarriors().get(event.)

    }

    @EventHandler
    public void onDevirtualisation(DevirtualizationEvent event){
        LyokoWarriorEvent warrior = pl.
    }
}
