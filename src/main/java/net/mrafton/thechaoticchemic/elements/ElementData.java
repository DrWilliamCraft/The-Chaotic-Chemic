package net.mrafton.thechaoticchemic.elements;

public record ElementData(
        String name,
        int atomicNumber,
        String abbreviation,
        int group,
        int period,
        MatterState matterState,
        MetalType metalType,
        boolean artificial,
        String color
) {
}
