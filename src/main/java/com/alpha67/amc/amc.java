package com.alpha67.amc;


import com.alpha67.amc.koda.BlockInitKoda;
import com.alpha67.amc.koda.ItemInitKoda;
import com.alpha67.amc.vultorio.init.BlockInitVultorio;
import com.alpha67.amc.vultorio.init.ItemInitVultorio;
import com.alpha67.amc.vultorio.word.OreGeneration;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import net.minecraft.block.Block;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

@Mod(amc.MODID)
public class amc {

    public static final String MODID ="amc";

    public static final Logger LOGGER = LogManager.getLogger(amc.class);
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation("amc", "amc"), () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    public amc() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        //IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //décracation class de vultorio
        //ItemInitVultorio.register(eventBus);
        //BlockInitVultorio.register(eventBus);
        //MinecraftForge.EVENT_BUS.register(this);
        //MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);

        //déclaration class de koda
        //ItemInitKoda.register(eventBus);
        //BlockInitKoda.register(eventBus);
    }


    public void setup(FMLCommonSetupEvent e)
    {

    }

    @SubscribeEvent
    public void clientSetup(FMLClientSetupEvent e)
    {

    }

    @SubscribeEvent
    public void onClientSetup(final FMLClientSetupEvent e){
        e.getMinecraftSupplier().get().execute(this::updateTitle);
    }

    private void updateTitle(){
        String Name = "Alpha67";
        final MainWindow window = Minecraft.getInstance().getMainWindow();
        window.setWindowTitle(Name);


    }



    }






