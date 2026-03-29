package net.mrafton.thechaoticchemic.item;

import net.minecraft.world.item.Item;
import net.mrafton.thechaoticchemic.TheChaoticChemic;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(TheChaoticChemic.MOD_ID);


    public static final DeferredItem<Item> GOLD = ITEMS.registerSimpleItem("gold");




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
