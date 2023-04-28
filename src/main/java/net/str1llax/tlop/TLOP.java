package net.str1llax.tlop;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.str1llax.tlop.block.TLOPBlocks;
import net.str1llax.tlop.item.TLOPItems;
import net.str1llax.tlop.item.TLOPTabs;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TLOP.MODID)
public class TLOP {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "tlop";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TLOP() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        TLOPItems.register(modEventBus);
        TLOPBlocks.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(TLOPItems.DARK_PRISMARINE_SHARD);
            event.accept(TLOPItems.PRISMARINE_STICK);
            event.accept(TLOPItems.DARK_PRISMARINE_STICK);
        }

        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(TLOPBlocks.ARSENIJ_BLOCK);
        }

        if(event.getTab() == TLOPTabs.TLOP_TAB) {
            event.accept(TLOPItems.DARK_PRISMARINE_SHARD);
            event.accept(TLOPItems.PRISMARINE_STICK);
            event.accept(TLOPItems.DARK_PRISMARINE_STICK);
            event.accept(TLOPBlocks.ARSENIJ_BLOCK);
        }
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
