package net.mrafton.thechaoticchemic.elements;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.mrafton.thechaoticchemic.TheChaoticChemic;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ElementLoader {
    private static final String ELEMENTS_PATH ="/data/the_chaotic_chemic/element/elements.json";

    public static List<ElementData> loadElements() {
        List<ElementData> elements = new ArrayList<>();

        try (InputStream stream = ElementLoader.class.getResourceAsStream(ELEMENTS_PATH)) {
            if (stream == null) {
                throw new IllegalStateException("Could not find " + ELEMENTS_PATH);
            }

            JsonObject root = JsonParser.parseReader(
                    new InputStreamReader(stream, StandardCharsets.UTF_8)
            ).getAsJsonObject();

            JsonArray array = root.getAsJsonArray("elements");

            for (JsonElement entry : array) {
                JsonObject obj = entry.getAsJsonObject();

                String name = obj.get("name").getAsString();
                int atomicNumber = obj.get("atomic_number").getAsInt();
                String abbreviation = obj.get("abbreviation").getAsString();
                int group = obj.get("group").getAsInt();
                int period = obj.get("period").getAsInt();

                MatterState matterState = MatterState.valueOf(
                        obj.get("matter_state").getAsString().toUpperCase(Locale.ROOT)
                );

                MetalType metalType = MetalType.valueOf(
                        obj.get("metal_type").getAsString().toUpperCase(Locale.ROOT)
                );

                boolean artificial = obj.has("artificial") && obj.get("artificial").getAsBoolean();
                String color = obj.get("color").getAsString();

                elements.add(new ElementData(
                        name,
                        atomicNumber,
                        abbreviation,
                        group,
                        period,
                        matterState,
                        metalType,
                        artificial,
                        color
                ));
            }

            TheChaoticChemic.LOGGER.info("Loaded {} elements from json.", elements.size());

        } catch (Exception e) {
            throw new RuntimeException("Failed to load elements from " + ELEMENTS_PATH, e);
        }
        return elements;
    }
}
