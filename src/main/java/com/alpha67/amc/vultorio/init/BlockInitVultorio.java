package com.alpha67.amc.vultorio.init;

import com.alpha67.amc.amc;
import com.alpha67.amc.mcreator.AlphatabItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockInitVultorio {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, amc.MODID);

    public static final RegistryObject<Block> alphariumore = registerBlock("alphariumore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> tests = registerBlock("tests",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> ruby_ore_nether = registerBlock("ruby_ore_nether",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> rubyore = registerBlock("rubyore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ItemInitVultorio.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(AlphatabItemGroup.tab)));
    }
}
