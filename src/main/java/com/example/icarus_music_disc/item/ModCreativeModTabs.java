package com.example.icarus_music_disc.item;

import com.example.icarus_music_disc.Icarus_music_disc;
import com.example.icarus_music_disc.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Modifier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Icarus_music_disc.MODID);

    public static final RegistryObject<CreativeModeTab> ICARUS_MUSIC_DISC_TAB = CREATIVE_MODE_TABS.register("icarus_music_disc_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativemodetab.icarus_music_disc_tab"))
                    .displayItems((pParametres, pOutput) -> {
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModItems.RAW_SAPPHIRE.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());

                        //Blocks
                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());

                        //vanilla

                        pOutput.accept(Items.DIAMOND);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
