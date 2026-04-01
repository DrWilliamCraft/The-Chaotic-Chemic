package net.mrafton.thechaoticchemic.datagen;

import net.minecraft.data.PackOutput;
import net.mrafton.thechaoticchemic.TheChaoticChemic;
import net.mrafton.thechaoticchemic.elements.ElementItem;
import net.mrafton.thechaoticchemic.registry.ModItems;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput output) {
        super(output, TheChaoticChemic.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addElementTranslations();
        addCustomTranslations();
    }
    private void addElementTranslations() {
        ModItems.ITEMS.getEntries().forEach(holder -> {
            if (holder.get() instanceof ElementItem) {
                String path = holder.getId().getPath();
                add(holder.get(), formatName(path));
            }
        });
    }

    private String formatName(String path) {
        String[] parts = path.split("_");
        StringBuilder builder = new StringBuilder();

        for (String part : parts) {
            if (part.isEmpty()) continue;

            if (!builder.isEmpty()) {
                builder.append(" ");
            }

            builder.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1));
        }

        return builder.toString();
    }
    private void addCustomTranslations() {
        add("itemGroup.the_chaotic_chemic.the_chaotic.item.tab","The Chaotic Chemic");
    }



}
