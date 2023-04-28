package net.str1llax.tlop.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.str1llax.tlop.TLOP;

public class TLOPItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TLOP.MODID);

    public static final RegistryObject<Item> DARK_PRISMARINE_SHARD = ITEMS.register("dark_prismarine_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PRISMARINE_STICK = ITEMS.register("prismarine_stick", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DARK_PRISMARINE_STICK = ITEMS.register("dark_prismarine_stick", () -> new Item(new Item.Properties()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
