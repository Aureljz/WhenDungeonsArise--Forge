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
package net.aurelj.dungeons_arise;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.aurelj.dungeons_arise.structures.aquatic.IllagerCorsairStructure;
import net.aurelj.dungeons_arise.structures.aquatic.IllagerGalleyStructure;
import net.aurelj.dungeons_arise.structures.aquatic.TyphonStructure;
import net.aurelj.dungeons_arise.structures.aquatic.UndeadPirateShipStructure;
import net.aurelj.dungeons_arise.structures.bandit.BanditTowersStructure;
import net.aurelj.dungeons_arise.structures.bandit.BanditVillageStructure;
import net.aurelj.dungeons_arise.structures.campsites.IllagerCampsiteStructure;
import net.aurelj.dungeons_arise.structures.campsites.MerchantCampsiteStructure;
import net.aurelj.dungeons_arise.structures.desertic.CeryneianHindStructure;
import net.aurelj.dungeons_arise.structures.desertic.ShirazPalaceStructure;
import net.aurelj.dungeons_arise.structures.eerie.AviaryStructure;
import net.aurelj.dungeons_arise.structures.eerie.HeavenlyChallengerStructure;
import net.aurelj.dungeons_arise.structures.eerie.HeavenlyConquerorStructure;
import net.aurelj.dungeons_arise.structures.eerie.HeavenlyRiderStructure;
import net.aurelj.dungeons_arise.structures.enigmatic.LighthouseStructure;
import net.aurelj.dungeons_arise.structures.enigmatic.SmallBlimpStructure;
import net.aurelj.dungeons_arise.structures.fortified.AbandonedTempleStructure;
import net.aurelj.dungeons_arise.structures.fortified.IllagerFortStructure;
import net.aurelj.dungeons_arise.structures.fortified.MonasteryStructure;
import net.aurelj.dungeons_arise.structures.fortified.ThornbornTowersStructure;
import net.aurelj.dungeons_arise.structures.fungi.GiantMushroomStructure;
import net.aurelj.dungeons_arise.structures.fungi.MushroomHouseStructure;
import net.aurelj.dungeons_arise.structures.fungi.MushroomMinesStructure;
import net.aurelj.dungeons_arise.structures.fungi.MushroomVillageStructure;
import net.aurelj.dungeons_arise.structures.haunted.InfestedTempleStructure;
import net.aurelj.dungeons_arise.structures.haunted.PlagueAsylumStructure;
import net.aurelj.dungeons_arise.structures.jungle.JungleTreeHouseStructure;
import net.aurelj.dungeons_arise.structures.prairie.*;
import net.aurelj.dungeons_arise.structures.underworld.FoundryStructure;
import net.aurelj.dungeons_arise.structures.underworld.MiningSystemStructure;
import net.aurelj.dungeons_arise.structures.underworld.ScorchedMinesStructure;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class WDAStructures {

    public static final DeferredRegister<StructureFeature<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, DungeonsAriseMain.MODID);
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> MONASTERY = DEFERRED_REGISTRY_STRUCTURE.register("monastery", () -> (new MonasteryStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> ILLAGER_CAMPSITE = DEFERRED_REGISTRY_STRUCTURE.register("illager_campsite", () -> (new IllagerCampsiteStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> ABANDONED_TEMPLE = DEFERRED_REGISTRY_STRUCTURE.register("abandoned_temple", () -> (new AbandonedTempleStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> LIGHTHOUSE = DEFERRED_REGISTRY_STRUCTURE.register("lighthouse", () -> (new LighthouseStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> MUSHROOM_VILLAGE = DEFERRED_REGISTRY_STRUCTURE.register("mushroom_village", () -> (new MushroomVillageStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> SMALL_PRAIRIE_HOUSE = DEFERRED_REGISTRY_STRUCTURE.register("small_prairie_house", () -> (new SmallPrairieHouseStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> FISHING_HUT = DEFERRED_REGISTRY_STRUCTURE.register("fishing_hut", () -> (new FishingHutStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> MUSHROOM_MINES = DEFERRED_REGISTRY_STRUCTURE.register("mushroom_mines", () -> (new MushroomMinesStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> COLISEUM = DEFERRED_REGISTRY_STRUCTURE.register("coliseum", () -> (new ColiseumStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> MERCHANT_CAMPSITE = DEFERRED_REGISTRY_STRUCTURE.register("merchant_campsite", () -> (new MerchantCampsiteStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> WISHING_WELL = DEFERRED_REGISTRY_STRUCTURE.register("wishing_well", () -> (new WishingWellStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> ILLAGER_FORT = DEFERRED_REGISTRY_STRUCTURE.register("illager_fort", () -> (new IllagerFortStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> INFESTED_TEMPLE = DEFERRED_REGISTRY_STRUCTURE.register("infested_temple", () -> (new InfestedTempleStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> HEAVENLY_RIDER = DEFERRED_REGISTRY_STRUCTURE.register("heavenly_rider", () -> (new HeavenlyRiderStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> MINING_SYSTEM = DEFERRED_REGISTRY_STRUCTURE.register("mining_system", () -> (new MiningSystemStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> HEAVENLY_CONQUEROR = DEFERRED_REGISTRY_STRUCTURE.register("heavenly_conqueror", () -> (new HeavenlyConquerorStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> SCORCHED_MINES = DEFERRED_REGISTRY_STRUCTURE.register("scorched_mines", () -> (new ScorchedMinesStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> UNDEAD_PIRATE_SHIP = DEFERRED_REGISTRY_STRUCTURE.register("undead_pirate_ship", () -> (new UndeadPirateShipStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> FOUNDRY = DEFERRED_REGISTRY_STRUCTURE.register("foundry", () -> (new FoundryStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> SMALL_BLIMP = DEFERRED_REGISTRY_STRUCTURE.register("small_blimp", () -> (new SmallBlimpStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> BANDIT_VILLAGE = DEFERRED_REGISTRY_STRUCTURE.register("bandit_village", () -> (new BanditVillageStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> TYPHON = DEFERRED_REGISTRY_STRUCTURE.register("typhon", () -> (new TyphonStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> CERYNEIAN_HIND = DEFERRED_REGISTRY_STRUCTURE.register("ceryneian_hind", () -> (new CeryneianHindStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> HEAVENLY_CHALLENGER = DEFERRED_REGISTRY_STRUCTURE.register("heavenly_challenger", () -> (new HeavenlyChallengerStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> ILLAGER_CORSAIR = DEFERRED_REGISTRY_STRUCTURE.register("illager_corsair", () -> (new IllagerCorsairStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> ILLAGER_GALLEY = DEFERRED_REGISTRY_STRUCTURE.register("illager_galley", () -> (new IllagerGalleyStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> MUSHROOM_HOUSE = DEFERRED_REGISTRY_STRUCTURE.register("mushroom_house", () -> (new MushroomHouseStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> GIANT_MUSHROOM = DEFERRED_REGISTRY_STRUCTURE.register("giant_mushroom", () -> (new GiantMushroomStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> SHIRAZ_PALACE = DEFERRED_REGISTRY_STRUCTURE.register("shiraz_palace", () -> (new ShirazPalaceStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> PLAGUE_ASYLUM = DEFERRED_REGISTRY_STRUCTURE.register("plague_asylum", () -> (new PlagueAsylumStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> BANDIT_TOWERS = DEFERRED_REGISTRY_STRUCTURE.register("bandit_towers", () -> (new BanditTowersStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> THORNBORN_TOWERS = DEFERRED_REGISTRY_STRUCTURE.register("thornborn_towers", () -> (new ThornbornTowersStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> JUNGLE_TREE_HOUSE = DEFERRED_REGISTRY_STRUCTURE.register("jungle_tree_house", () -> (new JungleTreeHouseStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> AVIARY = DEFERRED_REGISTRY_STRUCTURE.register("aviary", () -> (new AviaryStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> ILLAGER_WINDMILL = DEFERRED_REGISTRY_STRUCTURE.register("illager_windmill", () -> (new IllagerWindmillStructure(JigsawConfiguration.CODEC)));

    /* public static void setupStructures() {
        setupMapSpacingAndLand(
                MONASTERY.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.monasterySpacing.get(),
                        DungeonsAriseMain.WDAConfig.monasterySeparation.get(),
                        182626182),
                DungeonsAriseMain.WDAConfig.monasteryTransformsTerrain.get());
        setupMapSpacingAndLand(
                ILLAGER_CAMPSITE.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.illagerCampsiteSpacing.get(),
                        DungeonsAriseMain.WDAConfig.illagerCampsiteSeparation.get(),
                        372632837),
                DungeonsAriseMain.WDAConfig.illagerCampsiteTransformsTerrain.get());
        setupMapSpacingAndLand(
                ABANDONED_TEMPLE.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.abandonedTempleSpacing.get(),
                        DungeonsAriseMain.WDAConfig.abandonedTempleSeparation.get(),
                        43726253),
                DungeonsAriseMain.WDAConfig.abandonedTempleTransformsTerrain.get());
        setupMapSpacingAndLand(
                LIGHTHOUSE.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.lighthouseSpacing.get(),
                        DungeonsAriseMain.WDAConfig.lighthouseSeparation.get(),
                        283742673),
                DungeonsAriseMain.WDAConfig.lighthouseTransformsTerrain.get());
        setupMapSpacingAndLand(
                MUSHROOM_VILLAGE.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.mushroomVillageSpacing.get(),
                        DungeonsAriseMain.WDAConfig.mushroomVillageSeparation.get(),
                        573733422),
                DungeonsAriseMain.WDAConfig.mushroomVillageTransformsTerrain.get());
        setupMapSpacingAndLand(
                SMALL_PRAIRIE_HOUSE.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.smallPrairieHouseSpacing.get(),
                        DungeonsAriseMain.WDAConfig.smallPrairieHouseSeparation.get(),
                        73563524),
                DungeonsAriseMain.WDAConfig.smallPrairieHouseTransformsTerrain.get());
        setupMapSpacingAndLand(
                FISHING_HUT.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.fishingHutSpacing.get(),
                        DungeonsAriseMain.WDAConfig.fishingHutSeparation.get(),
                        643827193),
                DungeonsAriseMain.WDAConfig.fishingHutTransformsTerrain.get());
        setupMapSpacingAndLand(
                MUSHROOM_MINES.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.mushroomMinesSpacing.get(),
                        DungeonsAriseMain.WDAConfig.mushroomMinesSeparation.get(),
                        98376172),
                DungeonsAriseMain.WDAConfig.mushroomMinesTransformsTerrain.get());
        setupMapSpacingAndLand(
                COLISEUM.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.coliseumSpacing.get(),
                        DungeonsAriseMain.WDAConfig.coliseumSeparation.get(),
                        1626626631),
                DungeonsAriseMain.WDAConfig.coliseumTransformsTerrain.get());
        setupMapSpacingAndLand(
                MERCHANT_CAMPSITE.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.merchantCampsiteSpacing.get(),
                        DungeonsAriseMain.WDAConfig.merchantCampsiteSeparation.get(),
                        68534678),
                DungeonsAriseMain.WDAConfig.merchantCampsiteTransformsTerrain.get());
        setupMapSpacingAndLand(
                WISHING_WELL.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.wishingWellSpacing.get(),
                        DungeonsAriseMain.WDAConfig.wishingWellSeparation.get(),
                        465869302),
                DungeonsAriseMain.WDAConfig.wishingWellTransformsTerrain.get());
        setupMapSpacingAndLand(
                ILLAGER_FORT.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.illagerFortSpacing.get(),
                        DungeonsAriseMain.WDAConfig.illagerFortSeparation.get(),
                        563835947),
                DungeonsAriseMain.WDAConfig.illagerFortTransformsTerrain.get());
        setupMapSpacingAndLand(
                INFESTED_TEMPLE.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.infestedTempleSpacing.get(),
                        DungeonsAriseMain.WDAConfig.infestedTempleSeparation.get(),
                        297069583),
                DungeonsAriseMain.WDAConfig.infestedTempleTransformsTerrain.get());
        setupMapSpacingAndLand(
                HEAVENLY_RIDER.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.heavenlyRiderSpacing.get(),
                        DungeonsAriseMain.WDAConfig.heavenlyRiderSeparation.get(),
                        337746352),
                DungeonsAriseMain.WDAConfig.heavenlyRiderTransformsTerrain.get());
        setupMapSpacingAndLand(
                MINING_SYSTEM.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.miningSystemSpacing.get(),
                        DungeonsAriseMain.WDAConfig.miningSystemSeparation.get(),
                        263511737),
                DungeonsAriseMain.WDAConfig.miningSystemTransformsTerrain.get());
        setupMapSpacingAndLand(
                HEAVENLY_CONQUEROR.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.heavenlyConquerorSpacing.get(),
                        DungeonsAriseMain.WDAConfig.heavenlyConquerorSeparation.get(),
                        374552443),
                DungeonsAriseMain.WDAConfig.heavenlyConquerorTransformsTerrain.get());
        setupMapSpacingAndLand(
                SCORCHED_MINES.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.scorchedMinesSpacing.get(),
                        DungeonsAriseMain.WDAConfig.scorchedMinesSeparation.get(),
                        1332446387),
                DungeonsAriseMain.WDAConfig.scorchedMinesTransformsTerrain.get());
        setupMapSpacingAndLand(
                UNDEAD_PIRATE_SHIP.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.undeadPirateShipSpacing.get(),
                        DungeonsAriseMain.WDAConfig.undeadPirateShipSeparation.get(),
                        952444271),
                DungeonsAriseMain.WDAConfig.undeadPirateShipTransformsTerrain.get());
        setupMapSpacingAndLand(
                FOUNDRY.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.foundrySpacing.get(),
                        DungeonsAriseMain.WDAConfig.foundrySeparation.get(),
                        277663662),
                DungeonsAriseMain.WDAConfig.foundryTransformsTerrain.get());
        setupMapSpacingAndLand(
                SMALL_BLIMP.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.smallBlimpSpacing.get(),
                        DungeonsAriseMain.WDAConfig.smallBlimpSeparation.get(),
                        446553372),
                DungeonsAriseMain.WDAConfig.smallBlimpTransformsTerrain.get());
        setupMapSpacingAndLand(
                BANDIT_VILLAGE.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.banditVillageSpacing.get(),
                        DungeonsAriseMain.WDAConfig.banditVillageSeparation.get(),
                        1111272534),
                DungeonsAriseMain.WDAConfig.banditVillageTransformsTerrain.get());
        setupMapSpacingAndLand(
                TYPHON.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.typhonSpacing.get(),
                        DungeonsAriseMain.WDAConfig.typhonSeparation.get(),
                        357769433),
                DungeonsAriseMain.WDAConfig.typhonTransformsTerrain.get());
        setupMapSpacingAndLand(
                CERYNEIAN_HIND.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.ceryneianHindSpacing.get(),
                        DungeonsAriseMain.WDAConfig.ceryneianHindSeparation.get(),
                        222266352),
                DungeonsAriseMain.WDAConfig.ceryneianHindTransformsTerrain.get());
        setupMapSpacingAndLand(
                HEAVENLY_CHALLENGER.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.heavenlyChallengerSpacing.get(),
                        DungeonsAriseMain.WDAConfig.heavenlyChallengerSeparation.get(),
                        826638829),
                DungeonsAriseMain.WDAConfig.heavenlyChallengerTransformsTerrain.get());
        setupMapSpacingAndLand(
                ILLAGER_CORSAIR.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.illagerCorsairSpacing.get(),
                        DungeonsAriseMain.WDAConfig.illagerCorsairSeparation.get(),
                        777463524),
                DungeonsAriseMain.WDAConfig.illagerCorsairTransformsTerrain.get());
        setupMapSpacingAndLand(
                ILLAGER_GALLEY.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.illagerGalleySpacing.get(),
                        DungeonsAriseMain.WDAConfig.illagerGalleySeparation.get(),
                        995537231),
                DungeonsAriseMain.WDAConfig.illagerGalleyTransformsTerrain.get());
        setupMapSpacingAndLand(
                MUSHROOM_HOUSE.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.mushroomHouseSpacing.get(),
                        DungeonsAriseMain.WDAConfig.mushroomHouseSeparation.get(),
                        347766182),
                DungeonsAriseMain.WDAConfig.mushroomHouseTransformsTerrain.get());
        setupMapSpacingAndLand(
                GIANT_MUSHROOM.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.giantMushroomSpacing.get(),
                        DungeonsAriseMain.WDAConfig.giantMushroomSeparation.get(),
                        497362534),
                DungeonsAriseMain.WDAConfig.giantMushroomTransformsTerrain.get());
        setupMapSpacingAndLand(
                SHIRAZ_PALACE.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.shirazPalaceSpacing.get(),
                        DungeonsAriseMain.WDAConfig.shirazPalaceSeparation.get(),
                        888377716),
                DungeonsAriseMain.WDAConfig.shirazPalaceTransformsTerrain.get());
        setupMapSpacingAndLand(
                PLAGUE_ASYLUM.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.plagueAsylumSpacing.get(),
                        DungeonsAriseMain.WDAConfig.plagueAsylumSeparation.get(),
                        637271616),
                DungeonsAriseMain.WDAConfig.plagueAsylumTransformsTerrain.get());
        setupMapSpacingAndLand(
                BANDIT_TOWERS.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.banditTowersSpacing.get(),
                        DungeonsAriseMain.WDAConfig.banditTowersSeparation.get(),
                        1577726152),
                DungeonsAriseMain.WDAConfig.banditTowersTransformsTerrain.get());
        setupMapSpacingAndLand(
                THORNBORN_TOWERS.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.thornbornTowersSpacing.get(),
                        DungeonsAriseMain.WDAConfig.thornbornTowersSeparation.get(),
                        292377166),
                DungeonsAriseMain.WDAConfig.thornbornTowersTransformsTerrain.get());
        setupMapSpacingAndLand(
                JUNGLE_TREE_HOUSE.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.jungleTreeHouseSpacing.get(),
                        DungeonsAriseMain.WDAConfig.jungleTreeHouseSeparation.get(),
                        240573269),
                DungeonsAriseMain.WDAConfig.jungleTreeHouseTransformsTerrain.get());
        setupMapSpacingAndLand(
                AVIARY.get(), // Instance
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.aviarySpacing.get(),
                        DungeonsAriseMain.WDAConfig.aviarySeparation.get(),
                        492512635),
                DungeonsAriseMain.WDAConfig.aviaryTransformsTerrain.get());
        setupMapSpacingAndLand(
                ILLAGER_WINDMILL.get(),
                new StructureFeatureConfiguration(DungeonsAriseMain.WDAConfig.illagerWindmillSpacing.get(),
                        DungeonsAriseMain.WDAConfig.illagerWindmillSeparation.get(),
                        277746726),
                DungeonsAriseMain.WDAConfig.illagerWindmillTransformsTerrain.get());
    } */

    /* public static <F extends StructureFeature<?>> void setupMapSpacingAndLand(
            F structure,
            StructureFeatureConfiguration structureFeatureConfiguration,
            boolean transformSurroundingLand)
    {
        StructureFeature.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);
        if(transformSurroundingLand){
            StructureFeature.NOISE_AFFECTING_FEATURES =
                    ImmutableList.<StructureFeature<?>>builder()
                            .addAll(StructureFeature.NOISE_AFFECTING_FEATURES)
                            .add(structure)
                            .build();
        }

        StructureSettings.DEFAULTS =
                ImmutableMap.<StructureFeature<?>, StructureFeatureConfiguration>builder()
                        .putAll(StructureSettings.DEFAULTS)
                        .put(structure, structureFeatureConfiguration)
                        .build();

        BuiltinRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
            Map<StructureFeature<?>, StructureFeatureConfiguration> structureMap = settings.getValue().structureSettings().structureConfig();

            if(structureMap instanceof ImmutableMap){
                Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureFeatureConfiguration);
                settings.getValue().structureSettings().structureConfig = tempMap;
            }
            else{
                structureMap.put(structure, structureFeatureConfiguration);
            }
        });
    } */
}
