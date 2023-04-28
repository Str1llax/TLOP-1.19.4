package net.str1llax.tlop.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.str1llax.tlop.TLOP;

@Mod.EventBusSubscriber(modid = TLOP.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TLOPTabs {
    public static CreativeModeTab TLOP_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
        TLOP_TAB = event.registerCreativeModeTab(new ResourceLocation(TLOP.MODID, "tlop_tab"),
                builder -> builder.icon(() -> new ItemStack(TLOPItems.DARK_PRISMARINE_SHARD.get()))
                        .title(Component.translatable("cmt.tlop_tab")));
    }
}
