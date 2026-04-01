package net.mrafton.thechaoticchemic.registry;

import net.minecraft.world.item.Item;
import net.mrafton.thechaoticchemic.TheChaoticChemic;
import net.mrafton.thechaoticchemic.elements.ElementData;
import net.mrafton.thechaoticchemic.elements.ElementItem;
import net.mrafton.thechaoticchemic.elements.ElementLoader;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(TheChaoticChemic.MOD_ID);

    private static final List<ElementData> LOADED_ELEMENTS = ElementLoader.loadElements();
    static {
        for (ElementData element : LOADED_ELEMENTS) {
            ITEMS.register(element.name(), () -> new ElementItem(
                    new Item.Properties(),
                    element
            ));
        }
    }





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
