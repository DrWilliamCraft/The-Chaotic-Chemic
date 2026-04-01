package net.mrafton.thechaoticchemic.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.mrafton.thechaoticchemic.TheChaoticChemic;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheChaoticChemic.MOD_ID);


    public static final Supplier<CreativeModeTab> THE_CHAOTIC_CHEMIC =
            CREATIVE_MODE_TABS.register("the_chaotic_chemic",()->CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.the_chaotic_chemic.the_chaotic.item.tab"))
                    //.icon(()->new ItemStack(ModItems..get()))
                    .displayItems((itemDisplayParameters, output) -> {
                        ModItems.ITEMS.getEntries().forEach(item -> output.accept(item.get()));

                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
