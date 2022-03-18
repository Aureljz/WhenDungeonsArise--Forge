/*      MIT License

        Copyright (c) 2022 TelepathicGrunt

        Permission is hereby granted, free of charge, to any person obtaining a copy
        of this software and associated documentation files (the "Software"), to deal
        in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
        copies of the Software, and to permit persons to whom the Software is
        furnished to do so, subject to the following conditions:

        The above copyright notice and this permission notice shall be included in all
        copies or substantial portions of the Software.

        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
        SOFTWARE. */
/* package net.aurelj.dungeons_arise;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.PlainVillagePools;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;

public class WDAConfiguredStructures {

    public static ConfiguredStructureFeature<?, ?> CONFIGURED_MONASTERY = WDAStructures.MONASTERY.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_ILLAGER_CAMPSITE = WDAStructures.ILLAGER_CAMPSITE.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_ABANDONED_TEMPLE = WDAStructures.ABANDONED_TEMPLE.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_LIGHTHOUSE = WDAStructures.LIGHTHOUSE.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_MUSHROOM_VILLAGE = WDAStructures.MUSHROOM_VILLAGE.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_SMALL_PRAIRIE_HOUSE = WDAStructures.SMALL_PRAIRIE_HOUSE.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_FISHING_HUT = WDAStructures.FISHING_HUT.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_MUSHROOM_MINES = WDAStructures.MUSHROOM_MINES.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_COLISEUM = WDAStructures.COLISEUM.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_MERCHANT_CAMPSITE = WDAStructures.MERCHANT_CAMPSITE.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_WISHING_WELL = WDAStructures.WISHING_WELL.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_ILLAGER_FORT = WDAStructures.ILLAGER_FORT.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_INFESTED_TEMPLE = WDAStructures.INFESTED_TEMPLE.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_HEAVENLY_RIDER = WDAStructures.HEAVENLY_RIDER.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_MINING_SYSTEM = WDAStructures.MINING_SYSTEM.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_HEAVENLY_CONQUEROR = WDAStructures.HEAVENLY_CONQUEROR.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_SCORCHED_MINES = WDAStructures.SCORCHED_MINES.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_UNDEAD_PIRATE_SHIP = WDAStructures.UNDEAD_PIRATE_SHIP.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_FOUNDRY = WDAStructures.FOUNDRY.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_SMALL_BLIMP = WDAStructures.SMALL_BLIMP.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_BANDIT_VILLAGE = WDAStructures.BANDIT_VILLAGE.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_TYPHON = WDAStructures.TYPHON.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_CERYNEIAN_HIND = WDAStructures.CERYNEIAN_HIND.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_HEAVENLY_CHALLENGER = WDAStructures.HEAVENLY_CHALLENGER.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_ILLAGER_CORSAIR = WDAStructures.ILLAGER_CORSAIR.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_ILLAGER_GALLEY = WDAStructures.ILLAGER_GALLEY.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_MUSHROOM_HOUSE = WDAStructures.MUSHROOM_HOUSE.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_GIANT_MUSHROOM = WDAStructures.GIANT_MUSHROOM.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_SHIRAZ_PALACE = WDAStructures.SHIRAZ_PALACE.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_PLAGUE_ASYLUM = WDAStructures.PLAGUE_ASYLUM.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_BANDIT_TOWERS = WDAStructures.BANDIT_TOWERS.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_THORNBORN_TOWERS = WDAStructures.THORNBORN_TOWERS.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_JUNGLE_TREE_HOUSE = WDAStructures.JUNGLE_TREE_HOUSE.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_AVIARY = WDAStructures.AVIARY.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_ILLAGER_WINDMILL = WDAStructures.ILLAGER_WINDMILL.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));

    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_monastery"), CONFIGURED_MONASTERY);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_illager_campsite"), CONFIGURED_ILLAGER_CAMPSITE);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_abandoned_temple"), CONFIGURED_ABANDONED_TEMPLE);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_lighthouse"), CONFIGURED_LIGHTHOUSE);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_mushroom_village"), CONFIGURED_MUSHROOM_VILLAGE);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_small_prairie_house"), CONFIGURED_SMALL_PRAIRIE_HOUSE);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_fishing_hut"), CONFIGURED_FISHING_HUT);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_mushroom_mines"), CONFIGURED_MUSHROOM_MINES);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_coliseum"), CONFIGURED_COLISEUM);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_merchant_campsite"), CONFIGURED_MERCHANT_CAMPSITE);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_wishing_well"), CONFIGURED_WISHING_WELL);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_illager_fort"), CONFIGURED_ILLAGER_FORT);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_infested_temple"), CONFIGURED_INFESTED_TEMPLE);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_heavenly_rider"), CONFIGURED_HEAVENLY_RIDER);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_mining_system"), CONFIGURED_MINING_SYSTEM);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_heavenly_conqueror"), CONFIGURED_HEAVENLY_CONQUEROR);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_scorched_mines"), CONFIGURED_SCORCHED_MINES);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_undead_pirate_ship"), CONFIGURED_UNDEAD_PIRATE_SHIP);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_foundry"), CONFIGURED_FOUNDRY);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_small_blimp"), CONFIGURED_SMALL_BLIMP);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_bandit_village"), CONFIGURED_BANDIT_VILLAGE);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_typhon"), CONFIGURED_TYPHON);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_ceryneian_hind"), CONFIGURED_CERYNEIAN_HIND);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_heavenly_challenger"), CONFIGURED_HEAVENLY_CHALLENGER);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_illager_corsair"), CONFIGURED_ILLAGER_CORSAIR);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_illager_galley"), CONFIGURED_ILLAGER_GALLEY);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_mushroom_house"), CONFIGURED_MUSHROOM_HOUSE);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_giant_mushroom"), CONFIGURED_GIANT_MUSHROOM);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_shiraz_palace"), CONFIGURED_SHIRAZ_PALACE);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_plague_asylum"), CONFIGURED_PLAGUE_ASYLUM);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_bandit_towers"), CONFIGURED_BANDIT_TOWERS);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_thornborn_towers"), CONFIGURED_THORNBORN_TOWERS);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_jungle_tree_house"), CONFIGURED_JUNGLE_TREE_HOUSE);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_aviary"), CONFIGURED_AVIARY);
        Registry.register(registry, new ResourceLocation(DungeonsAriseMain.MODID, "configured_illager_windmill"), CONFIGURED_ILLAGER_WINDMILL);


    }
}
*/