package fr.seaskycore;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.*;
import com.comphenix.protocol.reflect.FieldAccessException;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import fr.seaskycore.MOBIA.MobEventHandler;
import fr.seaskycore.aquatique.*;
import fr.seaskycore.caisse.lunaire.armure.PantalonLunaireCMD;
import fr.seaskycore.caisse.lunaire.armure.BotteLunaireCMD;
import fr.seaskycore.caisse.lunaire.armure.CasqueLunaireCMD;
import fr.seaskycore.caisse.lunaire.armure.PlastronLunaireCMD;
import fr.seaskycore.caisse.lunaire.manager.LunaireArmure;
import fr.seaskycore.caisse.lunaire.outils.HacheLunaireCMD;
import fr.seaskycore.caisse.lunaire.outils.PelleLunaireCMD;
import fr.seaskycore.caisse.lunaire.outils.PiocheLunaireCMD;
import fr.seaskycore.cluescroll.CluescrollCommand;
import fr.seaskycore.cluescroll.CluescrollRareCommand;
import fr.seaskycore.cmd.ClassementCMD;
import fr.seaskycore.cmd.GrimoireCMD;
import fr.seaskycore.cmd.VoteCMD;
import fr.seaskycore.cmd.WhoisCommand;
import fr.seaskycore.essentials.admin.CommandGamemode;
import fr.seaskycore.essentials.base.FeedCMD;
import fr.seaskycore.essentials.mod.CommandSudo;
import fr.seaskycore.essentials.mod.EnderchestCommand;
import fr.seaskycore.essentials.mod.InvseeCommand;
import fr.seaskycore.furnace.FurnaceCMD;
import fr.seaskycore.furnace.cook.Cook;
import fr.seaskycore.furnace.manage.Manage;
import fr.seaskycore.listener.*;
import fr.seaskycore.pirate.*;
import fr.seaskycore.pirate.armure.BottePirateCMD;
import fr.seaskycore.pirate.armure.CasquePirateCMD;
import fr.seaskycore.pirate.armure.PantalonPirateCMD;
import fr.seaskycore.pirate.armure.PlastronPirateCMD;
import fr.seaskycore.pirate.armure.manager.PirateArmure;
import fr.seaskycore.sucess.armure.BotteFarmeurCMD;
import fr.seaskycore.sucess.armure.PantalonFarmeurCMD;
import fr.seaskycore.aquatique.listener.MobKillLAquatiqueistener;
import fr.seaskycore.caisse.lunaire.glaive.GlaiveNoelCMD;
import fr.seaskycore.caisse.lunaire.glaive.MobKillListener;
import fr.seaskycore.cluescroll.CluescrollEpiqueCommand;
import fr.seaskycore.cluescroll.CluescrollLegendaireCommand;
import fr.seaskycore.listener.armure.farm.FarmArmure;
import fr.seaskycore.listener.armure.noel.NoelArmure;
import fr.seaskycore.nv.NightVisonCMD;
import fr.seaskycore.poubelles.PoubelleCommand;
import fr.seaskycore.sucess.armure.CasqueFarmeurCMD;
import fr.seaskycore.sucess.armure.PlastronFarmeurCMD;
import fr.seaskycore.sucess.outils.EpeeFarmeurCMD;
import fr.seaskycore.sucess.outils.PelleFarmeurCMD;
import fr.seaskycore.sucess.outils.PiocheFarmeurCMD;
import fr.seaskycore.sucess.outils.HacheFarmeurCMD;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Level;

public class Main extends JavaPlugin {

    Manage manage;
    public static Main instance;
    private Cook cook;
    private Economy economy;

    private ArmorStand armorStand;

    private final FileConfiguration config;

    public static ArrayList<Material> blocks;

    WorldGuardPlugin worldGuardPlugin;

    public static Exception error;


    ProtocolManager protocolManager;

    public Main() {
        this.manage = new Manage();
        this.cook = new Cook();
        this.config = this.getConfig();
    }




    @Override
    public void onEnable() {


        if (!setupEconomy()) {
            getLogger().severe("Vault or an economy plugin is not installed! Disabling the plugin.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }


        this.manage.load(this);
        Main.instance = this;
        Objects.requireNonNull(this.getCommand("furnace")).setExecutor((CommandExecutor)new FurnaceCMD(this.cook));
        Objects.requireNonNull(this.getCommand("furnaceall")).setExecutor((CommandExecutor)new FurnaceCMD(this.cook));
        getServer().getPluginManager().registerEvents(new TotemListener(), this);
        getServer().getPluginManager().registerEvents(new BowListener(), this);
        getServer().getPluginManager().registerEvents(new GolemListener(), this);
        getServer().getPluginManager().registerEvents(new ZombieListener(), this);
        getServer().getPluginManager().registerEvents(new ZombiePigListener(), this);
        getServer().getPluginManager().registerEvents(new MobEventHandler(), this);

        getServer().getPluginManager().registerEvents(new CultureHandler(), this);



        if (getServer().getPluginManager().isPluginEnabled("Vault") &&
                getServer().getPluginManager().isPluginEnabled("Essentials")) {

            // Récupérez l'économie depuis Vault
            Economy economy = getServer().getServicesManager().getRegistration(Economy.class).getProvider();

            // Enregistrez la commande
            getCommand("cluescrollcomun").setExecutor(new CluescrollCommand(economy));
            getCommand("cluescrollrare").setExecutor(new CluescrollRareCommand(economy));
            getCommand("cluescrollepique").setExecutor(new CluescrollEpiqueCommand(economy));
            getCommand("cluescrolllegendaire").setExecutor(new CluescrollLegendaireCommand(economy));

            this.getCommand("poubelle").setExecutor((CommandExecutor)new PoubelleCommand(this));
            this.getCommand("trash").setExecutor((CommandExecutor)new PoubelleCommand(this));
            this.getCommand("majid").setExecutor((CommandExecutor)new PoubelleCommand(this));

            getServer().getPluginManager().registerEvents(new CactusDamageListener(), this);
            getServer().getPluginManager().registerEvents(new ZombieVillagoisListener(), this);
            getServer().getPluginManager().registerEvents(new WitchListener(), this);
            getServer().getPluginManager().registerEvents(new ArmorStandListener(), this);
            getServer().getPluginManager().registerEvents(new MobSpawnListener(), this);

            this.getCommand("vision").setExecutor((CommandExecutor)new NightVisonCMD(this));
            getServer().getPluginManager().registerEvents(new CommandListener(), this);



            this.getCommand("casquelunaire").setExecutor((CommandExecutor)new CasqueLunaireCMD());
            this.getCommand("plastronlunaire").setExecutor((CommandExecutor)new PlastronLunaireCMD());
             this.getCommand("pantalonlunaire").setExecutor((CommandExecutor)new PantalonLunaireCMD());
            this.getCommand("bottelunaire").setExecutor((CommandExecutor)new BotteLunaireCMD());
            this.getCommand("Glaivelunaire").setExecutor((CommandExecutor)new GlaiveNoelCMD());
            getServer().getPluginManager().registerEvents(new MobKillListener(this), this);
            this.getServer().getPluginManager().registerEvents((Listener)new LunaireArmure(), (Plugin)this);
            this.getCommand("hachelunaire").setExecutor((CommandExecutor)new HacheLunaireCMD());
            this.getCommand("pellelunaire").setExecutor((CommandExecutor)new PelleLunaireCMD());
            this.getCommand("piochelunaire").setExecutor((CommandExecutor)new PiocheLunaireCMD());

            this.getCommand("vote").setExecutor((CommandExecutor)new VoteCMD());



            this.getCommand("casquefarmeur").setExecutor((CommandExecutor)new CasqueFarmeurCMD());

            this.getCommand("plastronfarmeur").setExecutor((CommandExecutor)new PlastronFarmeurCMD());

            this.getCommand("pantalonfarmeur").setExecutor((CommandExecutor)new PantalonFarmeurCMD());

            this.getCommand("bottefarmeur").setExecutor((CommandExecutor)new BotteFarmeurCMD());

            this.getCommand("epeefarmeur").setExecutor((CommandExecutor)new EpeeFarmeurCMD());

            this.getCommand("piochefarmeur").setExecutor((CommandExecutor)new PiocheFarmeurCMD());
            this.getCommand("pellefarmeur").setExecutor((CommandExecutor)new PelleFarmeurCMD());
            this.getCommand("hachefarmeur").setExecutor((CommandExecutor)new HacheFarmeurCMD());


            this.getServer().getPluginManager().registerEvents((Listener)new FarmArmure(), (Plugin)this);
            this.getServer().getPluginManager().registerEvents((Listener)new NoelArmure(), (Plugin)this);


            this.getCommand("epeeaquatique").setExecutor((CommandExecutor)new EpeeAquatiqueCMD());
            getServer().getPluginManager().registerEvents(new MobKillLAquatiqueistener(this), this);

            this.getCommand("hacheaquatique").setExecutor((CommandExecutor)new HacheAquatiqueCMD());
            this.getCommand("piochequatique").setExecutor((CommandExecutor)new PiocheAquatiqueCMD());
            this.getCommand("pelleaquatique").setExecutor((CommandExecutor)new PelleAquatiqueCMD());
            this.getCommand("pechequatique").setExecutor((CommandExecutor)new PecheAquatiqueCMD());


            this.getCommand("casqueaquatique").setExecutor((CommandExecutor)new CasqueAquatiqueCMD());
            this.getCommand("plastronaquatique").setExecutor((CommandExecutor)new PlastronAquatiqueCMD());
            this.getCommand("pantalonaquatique").setExecutor((CommandExecutor)new PantalonAquatiqueCMD());
            this.getCommand("botteaquatique").setExecutor((CommandExecutor)new BotteAquatiqueCMD());



            this.getCommand("epeepirate").setExecutor((CommandExecutor)new EpeePiratequeCMD());
            getServer().getPluginManager().registerEvents(new MobKillPirateListener(this), this);


            this.getCommand("casqueapirate").setExecutor((CommandExecutor)new CasquePirateCMD());
            this.getCommand("plastronpirate").setExecutor((CommandExecutor)new PlastronPirateCMD());
            this.getCommand("pantalonpirate").setExecutor((CommandExecutor)new PantalonPirateCMD());
            this.getCommand("botteapirate").setExecutor((CommandExecutor)new BottePirateCMD());
            this.getServer().getPluginManager().registerEvents((Listener)new PirateArmure(), (Plugin)this);

            this.getCommand("hachepirate").setExecutor((CommandExecutor)new HachePirateCMD());
            this.getCommand("pellepirate").setExecutor((CommandExecutor)new PellePirateCMD());
            this.getCommand("piochepirate").setExecutor((CommandExecutor)new PiochePirateCMD());

            this.getCommand("grimoire").setExecutor((CommandExecutor)new GrimoireCMD());
            this.getCommand("classement").setExecutor((CommandExecutor)new ClassementCMD());
            getServer().getPluginManager().registerEvents(new CactusGrowthListener(), this);
            getServer().getPluginManager().registerEvents(new NoCropJump(), this);
            getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
            generateBorder();


            // TODO Essentials
            this.getCommand("feed").setExecutor((CommandExecutor)new FeedCMD());
            getCommand("whois").setExecutor(new WhoisCommand());
            getCommand("invsee").setExecutor(new InvseeCommand());
            getCommand("enderchest").setExecutor(new EnderchestCommand());
            getCommand("ec").setExecutor(new EnderchestCommand());

            this.registerGamemodesCommands();
            this.registerModerationCommands();






        } else {
            getLogger().warning("Vault ou Essentials n'est pas activé. Le plugin ne fonctionnera pas correctement.");
        }


        (this.protocolManager = ProtocolLibrary.getProtocolManager()).addPacketListener((PacketListener)new PacketAdapter(this, ListenerPriority.NORMAL, new PacketType[] { PacketType.Play.Client.TAB_COMPLETE }) {
            public void onPacketReceiving(final PacketEvent event) {
                if (event.getPacketType() == PacketType.Play.Client.TAB_COMPLETE) {
                    try {
                        if (event.getPlayer().hasPermission("seasky.pluginsbypass")) {
                            return;
                        }
                        final PacketContainer packet = event.getPacket();
                        final String message = ((String)packet.getSpecificModifier((Class)String.class).read(0)).toLowerCase();
                        if ((message.startsWith("/") && !message.contains(" ")) || (message.startsWith("/ver") && !message.contains("  ")) || (message.startsWith("/version") && !message.contains("  ")) || (message.startsWith("/?") && !message.contains("  ")) || (message.startsWith("/about") && !message.contains("  ")) || (message.startsWith("/help") && !message.contains("  "))) {
                            event.setCancelled(true);
                        }
                    }
                    catch (FieldAccessException e) {
                        Main.this.getLogger().log(Level.SEVERE, "Couldn't access field.", (Throwable)e);
                    }
                }
            }
        });
    }

    public void registerGamemodesCommands() {
        this.registerCommand("gmc", (CommandExecutor)new CommandGamemode());
        this.registerCommand("gms", (CommandExecutor)new CommandGamemode());
        this.registerCommand("gma", (CommandExecutor)new CommandGamemode());
        this.registerCommand("gmsp", (CommandExecutor)new CommandGamemode());
        this.registerCommand("gamemode", (CommandExecutor)new CommandGamemode());
    }

    private void registerCommand(final String name, final CommandExecutor ce) {
        this.getCommand(name).setExecutor(ce);
        System.out.println("Command " + name + " loaded !");
    }

    public void registerModerationCommands() {
        this.registerCommand("sudo", (CommandExecutor)new CommandSudo());
    }


    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }

        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }

        economy = rsp.getProvider();
        return economy != null;
    }




    public static void printErrorMessage(final CommandSender s, final Exception e) {
        s.sendMessage( "§cUne erreur est survenue, entrez '§6/error§c' pour voir le bug");
        e.printStackTrace();
        Main.error = e;
    }






    public static Main get() {
        return Main.instance;
    }


    public static Main getInstance() {
        return instance;
    }


    public Economy getEconomy() {
        return economy;
    }

    private void registerEvents(Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, this);
        }
    }

    public void generateBorder() {
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setCenter(new Location(Bukkit.getWorld("spawn"), 231.5, 75, 363.5));
        border.setSize(750);
        // Autres opérations si nécessaires
    }

    public boolean worldGuardIsEnable() {
        return Bukkit.getServer().getPluginManager().isPluginEnabled("WorldGuard");
    }

    static {
        Main.blocks = new ArrayList<Material>();
    }

    public static void invFullToDrop(final HashMap<Integer, ItemStack> invFull, final Player player) {
        for (int i = 0; i < invFull.values().size(); ++i) {
            player.getWorld().dropItem(player.getLocation(), (ItemStack)new ArrayList<ItemStack>(invFull.values()).get(i));
        }
    }

    public boolean canBuild(final Player p, final Block block) {
        //   return this.worldGuardPlugin.canBuild(p, block);
        return this.worldGuardPlugin.equals(p);
    }
}
