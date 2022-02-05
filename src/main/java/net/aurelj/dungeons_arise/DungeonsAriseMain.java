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

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.mojang.serialization.Codec;
import net.aurelj.dungeons_arise.config.ConfigHelper;
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
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Mod(DungeonsAriseMain.MODID)
public class DungeonsAriseMain {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "dungeons_arise";
    public static net.aurelj.dungeons_arise.config.WDAConfig.WDAConfigValues WDAConfig = null;

    public DungeonsAriseMain() {

        WDAConfig = ConfigHelper.register(ModConfig.Type.COMMON, net.aurelj.dungeons_arise.config.WDAConfig.WDAConfigValues::new, "when-dungeons-arise-common.toml");

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        WDAStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
        modEventBus.addListener(this::setup);

        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);
        forgeBus.addListener(EventPriority.NORMAL, IllagerCorsairStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, IllagerGalleyStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, TyphonStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, UndeadPirateShipStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, BanditTowersStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, BanditVillageStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, IllagerCampsiteStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, MerchantCampsiteStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, CeryneianHindStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, ShirazPalaceStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, AviaryStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, HeavenlyChallengerStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, HeavenlyConquerorStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, HeavenlyRiderStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, LighthouseStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, SmallBlimpStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, AbandonedTempleStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, IllagerFortStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, MonasteryStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, ThornbornTowersStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, GiantMushroomStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, MushroomHouseStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, MushroomMinesStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, MushroomVillageStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, InfestedTempleStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, PlagueAsylumStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, JungleTreeHouseStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, ColiseumStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, FishingHutStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, IllagerWindmillStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, SmallPrairieHouseStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, WishingWellStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, FoundryStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, ScorchedMinesStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, MiningSystemStructure::setupStructureSpawns);

    }

    public void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            WDAStructures.setupStructures();
            WDAConfiguredStructures.registerConfiguredStructures();
        });
    }

    private static Method GETCODEC_METHOD;
    public void addDimensionalSpacing(final WorldEvent.Load event) {
        if(event.getWorld() instanceof ServerLevel serverLevel) {
            ChunkGenerator chunkGenerator = serverLevel.getChunkSource().getGenerator();
            if (chunkGenerator instanceof FlatLevelSource && serverLevel.dimension().equals(Level.OVERWORLD)) {
                return;
            }

            StructureSettings worldStructureConfig = chunkGenerator.getSettings();

            HashMap<StructureFeature<?>, HashMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>>> WDAStructureToMultiMap = new HashMap<>();

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.illagerCorsairGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.OCEAN) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_ILLAGER_CORSAIR, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.illagerGalleyGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.OCEAN) {
                            associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_ILLAGER_GALLEY, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.typhonGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.OCEAN) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_TYPHON, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.undeadPirateShipGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.OCEAN) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_UNDEAD_PIRATE_SHIP, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.banditTowersGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.MESA) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_BANDIT_TOWERS, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.banditVillageGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.MESA) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_BANDIT_VILLAGE, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.illagerCampsiteGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.MOUNTAIN || biomeCategory == Biome.BiomeCategory.PLAINS) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_ILLAGER_CAMPSITE, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.merchantCampsiteGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.MOUNTAIN || biomeCategory == Biome.BiomeCategory.PLAINS) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_MERCHANT_CAMPSITE, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.ceryneianHindGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.DESERT) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_CERYNEIAN_HIND, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.shirazPalaceGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.DESERT) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_SHIRAZ_PALACE, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.aviaryGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.THEEND) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_AVIARY, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if((biomeCategory == Biome.BiomeCategory.THEEND) || (biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE)
                        && DungeonsAriseMain.WDAConfig.heavenlyChallengerGenerates.get()) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_HEAVENLY_CHALLENGER, biomeEntry.getKey());
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if((biomeCategory == Biome.BiomeCategory.THEEND) || (biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE)
                        && DungeonsAriseMain.WDAConfig.heavenlyConquerorGenerates.get()) {
                    associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_HEAVENLY_CONQUEROR, biomeEntry.getKey());
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if((biomeCategory == Biome.BiomeCategory.THEEND) || (biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE)
                        && DungeonsAriseMain.WDAConfig.heavenlyRiderGenerates.get()) {
                    associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_HEAVENLY_RIDER, biomeEntry.getKey());
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.smallBlimpGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.PLAINS || biomeCategory == Biome.BiomeCategory.TAIGA) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_SMALL_BLIMP, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.lighthouseGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.BEACH) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_LIGHTHOUSE, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.abandonedTempleGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.MOUNTAIN || biomeCategory == Biome.BiomeCategory.TAIGA) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_ABANDONED_TEMPLE, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.illagerFortGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.ICY || biomeCategory == Biome.BiomeCategory.TAIGA) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_ILLAGER_FORT, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.monasteryGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.MOUNTAIN || biomeCategory == Biome.BiomeCategory.TAIGA) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_MONASTERY, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.thornbornTowersGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.FOREST) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_THORNBORN_TOWERS, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.giantMushroomGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.FOREST || biomeCategory == Biome.BiomeCategory.MUSHROOM) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_GIANT_MUSHROOM, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.mushroomHouseGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.PLAINS || biomeCategory == Biome.BiomeCategory.FOREST) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_MUSHROOM_HOUSE, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.mushroomMinesGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.SWAMP || biomeCategory == Biome.BiomeCategory.FOREST) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_MUSHROOM_MINES, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.mushroomVillageGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.SWAMP || biomeCategory == Biome.BiomeCategory.FOREST) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_MUSHROOM_VILLAGE, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.infestedTempleGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.TAIGA) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_INFESTED_TEMPLE, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.plagueAsylumGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.JUNGLE || biomeCategory == Biome.BiomeCategory.FOREST) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_PLAGUE_ASYLUM, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.jungleTreeHouseGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.JUNGLE) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_JUNGLE_TREE_HOUSE, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.coliseumGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.PLAINS) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_COLISEUM, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.fishingHutGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.BEACH) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_FISHING_HUT, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.illagerWindmillGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.PLAINS) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_ILLAGER_WINDMILL, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.smallPrairieHouseGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.PLAINS) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_SMALL_PRAIRIE_HOUSE, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.wishingWellGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.PLAINS) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_WISHING_WELL, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.foundryGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.MOUNTAIN || biomeCategory == Biome.BiomeCategory.DESERT) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_FOUNDRY, biomeEntry.getKey());
                    }
                }
            }

            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.miningSystemGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.FOREST || biomeCategory == Biome.BiomeCategory.PLAINS) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_MINING_SYSTEM, biomeEntry.getKey());
                    }
                }
            }
            
            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet())
            {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE
                        && DungeonsAriseMain.WDAConfig.scorchedMinesGenerates.get()) {
                    if(biomeCategory == Biome.BiomeCategory.DESERT || biomeCategory == Biome.BiomeCategory.FOREST) {
                        associateBiomeToConfiguredStructure(WDAStructureToMultiMap, WDAConfiguredStructures.CONFIGURED_SCORCHED_MINES, biomeEntry.getKey());
                    }
                }
            }


            ImmutableMap.Builder<StructureFeature<?>, ImmutableMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>>> tempStructureToMultiMap = ImmutableMap.builder();
            worldStructureConfig.configuredStructures.entrySet().stream().filter(entry -> !WDAStructureToMultiMap.containsKey(entry.getKey())).forEach(tempStructureToMultiMap::put);

            WDAStructureToMultiMap.forEach((key, value) -> tempStructureToMultiMap.put(key, ImmutableMultimap.copyOf(value)));

            worldStructureConfig.configuredStructures = tempStructureToMultiMap.build();

            try {
                if(GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "codec");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(chunkGenerator));
                if(cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
            }
            catch(Exception e){
                DungeonsAriseMain.LOGGER.error("Was unable to check if " + serverLevel.dimension().location() + " is using Terraforged's ChunkGenerator.");
            }


            if(chunkGenerator instanceof FlatLevelSource &&
                serverLevel.dimension().equals(Level.OVERWORLD)){
                return;
            }

            Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<>(worldStructureConfig.structureConfig());
            tempMap.putIfAbsent(WDAStructures.MONASTERY.get(), StructureSettings.DEFAULTS.get(WDAStructures.MONASTERY.get()));
            tempMap.putIfAbsent(WDAStructures.ILLAGER_CAMPSITE.get(), StructureSettings.DEFAULTS.get(WDAStructures.ILLAGER_CAMPSITE.get()));
            tempMap.putIfAbsent(WDAStructures.ABANDONED_TEMPLE.get(), StructureSettings.DEFAULTS.get(WDAStructures.ABANDONED_TEMPLE.get()));
            tempMap.putIfAbsent(WDAStructures.LIGHTHOUSE.get(), StructureSettings.DEFAULTS.get(WDAStructures.LIGHTHOUSE.get()));
            tempMap.putIfAbsent(WDAStructures.MUSHROOM_VILLAGE.get(), StructureSettings.DEFAULTS.get(WDAStructures.MUSHROOM_VILLAGE.get()));
            tempMap.putIfAbsent(WDAStructures.SMALL_PRAIRIE_HOUSE.get(), StructureSettings.DEFAULTS.get(WDAStructures.SMALL_PRAIRIE_HOUSE.get()));
            tempMap.putIfAbsent(WDAStructures.FISHING_HUT.get(), StructureSettings.DEFAULTS.get(WDAStructures.FISHING_HUT.get()));
            tempMap.putIfAbsent(WDAStructures.MUSHROOM_MINES.get(), StructureSettings.DEFAULTS.get(WDAStructures.MUSHROOM_MINES.get()));
            tempMap.putIfAbsent(WDAStructures.COLISEUM.get(), StructureSettings.DEFAULTS.get(WDAStructures.COLISEUM.get()));
            tempMap.putIfAbsent(WDAStructures.MERCHANT_CAMPSITE.get(), StructureSettings.DEFAULTS.get(WDAStructures.MERCHANT_CAMPSITE.get()));
            tempMap.putIfAbsent(WDAStructures.WISHING_WELL.get(), StructureSettings.DEFAULTS.get(WDAStructures.WISHING_WELL.get()));
            tempMap.putIfAbsent(WDAStructures.ILLAGER_FORT.get(), StructureSettings.DEFAULTS.get(WDAStructures.ILLAGER_FORT.get()));
            tempMap.putIfAbsent(WDAStructures.INFESTED_TEMPLE.get(), StructureSettings.DEFAULTS.get(WDAStructures.INFESTED_TEMPLE.get()));
            tempMap.putIfAbsent(WDAStructures.HEAVENLY_RIDER.get(), StructureSettings.DEFAULTS.get(WDAStructures.HEAVENLY_RIDER.get()));
            tempMap.putIfAbsent(WDAStructures.MINING_SYSTEM.get(), StructureSettings.DEFAULTS.get(WDAStructures.MINING_SYSTEM.get()));
            tempMap.putIfAbsent(WDAStructures.HEAVENLY_CONQUEROR.get(), StructureSettings.DEFAULTS.get(WDAStructures.HEAVENLY_CONQUEROR.get()));
            tempMap.putIfAbsent(WDAStructures.SCORCHED_MINES.get(), StructureSettings.DEFAULTS.get(WDAStructures.SCORCHED_MINES.get()));
            tempMap.putIfAbsent(WDAStructures.UNDEAD_PIRATE_SHIP.get(), StructureSettings.DEFAULTS.get(WDAStructures.UNDEAD_PIRATE_SHIP.get()));
            tempMap.putIfAbsent(WDAStructures.FOUNDRY.get(), StructureSettings.DEFAULTS.get(WDAStructures.FOUNDRY.get()));
            tempMap.putIfAbsent(WDAStructures.SMALL_BLIMP.get(), StructureSettings.DEFAULTS.get(WDAStructures.SMALL_BLIMP.get()));
            tempMap.putIfAbsent(WDAStructures.BANDIT_VILLAGE.get(), StructureSettings.DEFAULTS.get(WDAStructures.BANDIT_VILLAGE.get()));
            tempMap.putIfAbsent(WDAStructures.TYPHON.get(), StructureSettings.DEFAULTS.get(WDAStructures.TYPHON.get()));
            tempMap.putIfAbsent(WDAStructures.CERYNEIAN_HIND.get(), StructureSettings.DEFAULTS.get(WDAStructures.CERYNEIAN_HIND.get()));
            tempMap.putIfAbsent(WDAStructures.HEAVENLY_CHALLENGER.get(), StructureSettings.DEFAULTS.get(WDAStructures.HEAVENLY_CHALLENGER.get()));
            tempMap.putIfAbsent(WDAStructures.ILLAGER_CORSAIR.get(), StructureSettings.DEFAULTS.get(WDAStructures.ILLAGER_CORSAIR.get()));
            tempMap.putIfAbsent(WDAStructures.ILLAGER_GALLEY.get(), StructureSettings.DEFAULTS.get(WDAStructures.ILLAGER_GALLEY.get()));
            tempMap.putIfAbsent(WDAStructures.MUSHROOM_HOUSE.get(), StructureSettings.DEFAULTS.get(WDAStructures.MUSHROOM_HOUSE.get()));
            tempMap.putIfAbsent(WDAStructures.GIANT_MUSHROOM.get(), StructureSettings.DEFAULTS.get(WDAStructures.GIANT_MUSHROOM.get()));
            tempMap.putIfAbsent(WDAStructures.SHIRAZ_PALACE.get(), StructureSettings.DEFAULTS.get(WDAStructures.SHIRAZ_PALACE.get()));
            tempMap.putIfAbsent(WDAStructures.PLAGUE_ASYLUM.get(), StructureSettings.DEFAULTS.get(WDAStructures.PLAGUE_ASYLUM.get()));
            tempMap.putIfAbsent(WDAStructures.BANDIT_TOWERS.get(), StructureSettings.DEFAULTS.get(WDAStructures.BANDIT_TOWERS.get()));
            tempMap.putIfAbsent(WDAStructures.THORNBORN_TOWERS.get(), StructureSettings.DEFAULTS.get(WDAStructures.THORNBORN_TOWERS.get()));
            tempMap.putIfAbsent(WDAStructures.JUNGLE_TREE_HOUSE.get(), StructureSettings.DEFAULTS.get(WDAStructures.JUNGLE_TREE_HOUSE.get()));
            tempMap.putIfAbsent(WDAStructures.AVIARY.get(), StructureSettings.DEFAULTS.get(WDAStructures.AVIARY.get()));
            worldStructureConfig.structureConfig = tempMap;
        }
   }

    private static void associateBiomeToConfiguredStructure(Map<StructureFeature<?>, HashMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>>> STStructureToMultiMap, ConfiguredStructureFeature<?, ?> configuredStructureFeature, ResourceKey<Biome> biomeRegistryKey) {
        STStructureToMultiMap.putIfAbsent(configuredStructureFeature.feature, HashMultimap.create());
        HashMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>> configuredStructureToBiomeMultiMap = STStructureToMultiMap.get(configuredStructureFeature.feature);
        if(configuredStructureToBiomeMultiMap.containsValue(biomeRegistryKey)) {
            DungeonsAriseMain.LOGGER.error("""
                    Detected 2 ConfiguredStructureFeatures that share the same base StructureFeature trying to be added to same biome. One will be prevented from spawning.
                    This issue happens with vanilla too and is why a Snowy Village and Plains Village cannot spawn in the same biome because they both use the Village base structure.
                    The two conflicting ConfiguredStructures are: {}, {}
                    The biome that is attempting to be shared: {}
                """,
                    BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.getId(configuredStructureFeature),
                    BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.getId(configuredStructureToBiomeMultiMap.entries().stream().filter(e -> e.getValue() == biomeRegistryKey).findFirst().get().getKey()),
                    biomeRegistryKey
            );
        }
        else{
            configuredStructureToBiomeMultiMap.put(configuredStructureFeature, biomeRegistryKey);
        }
    }
}
