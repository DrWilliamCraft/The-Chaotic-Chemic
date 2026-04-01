package net.mrafton.thechaoticchemic.datagen;

import net.minecraft.data.PackOutput;
import net.mrafton.thechaoticchemic.TheChaoticChemic;
import net.mrafton.thechaoticchemic.elements.ElementItem;
import net.mrafton.thechaoticchemic.registry.ModItems;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Arrays;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheChaoticChemic.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        generateElementBaseModels();
        generateElementItemModels();
    }

    private void generateElementBaseModels() {
        for (String type : Arrays.asList("solid", "liquid", "gas")) {
            withExistingParent("element_" + type + "_model", mcLoc("item/generated"))
                    .texture("layer0", modLoc("item/element_" + type + "_layer_0"))
                    .texture("layer1", modLoc("item/element_" + type + "_layer_1"));
        }
    }

    private void generateElementItemModels() {
        ModItems.ITEMS.getEntries().forEach(holder -> {
            var item = holder.get();

            if (item instanceof ElementItem elementItem) {
                String name = holder.getId().getPath();
                String state = elementItem.getData().matterState().name().toLowerCase();

                withExistingParent(name, modLoc("item/element_" + state + "_model"));
            }
        });
    }
}