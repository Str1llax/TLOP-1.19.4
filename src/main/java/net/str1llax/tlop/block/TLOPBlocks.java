package net.str1llax.tlop.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftforge.registries.RegistryObject;
import net.str1llax.tlop.TLOP;
import net.str1llax.tlop.item.TLOPItems;

import java.util.function.Supplier;

public class TLOPBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TLOP.MODID);

    public static final RegistryObject<Block> ARSENIJ_BLOCK = registerBlock("arsenij_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlocksItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlocksItem(String name, RegistryObject<T> block){
        return TLOPItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
