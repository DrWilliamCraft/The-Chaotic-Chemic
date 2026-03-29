package net.mrafton.thechaoticchemic.datagen;

import net.minecraft.data.PackOutput;
import net.mrafton.thechaoticchemic.TheChaoticChemic;
import net.mrafton.thechaoticchemic.item.ModItems;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheChaoticChemic.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
