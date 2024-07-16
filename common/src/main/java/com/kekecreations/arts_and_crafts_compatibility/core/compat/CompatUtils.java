package com.kekecreations.arts_and_crafts_compatibility.core.compat;

import com.kekecreations.arts_and_crafts.common.block.ACFlowerPotBlock;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.Services;
import com.kekecreations.arts_and_crafts_compatibility.core.platform.services.IPlatformHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class CompatUtils {
    public static final String ARTS_AND_CRAFTS = "arts_and_crafts";
    public static final String GILDED_SHERDS = "gildedsherds";
    public static final String OH_MY_SHERD = "ohmysherd";
    public static final String BUILT = "built";
    public static final String FARMERS_DELIGHT = "farmersdelight";
    public static final String TWIGS = "twigs";
    public static final String CAFFEINATED = "caffeinated";
    public static final String DECORATIVE_BLOCKS = "decorative_blocks";
    public static final String NEAPOLITAN = "neapolitan";
    public static final String SPAWN = "spawn";
    public static final String BIOME_MAKEOVER = "biomemakeover";
    public static final String ALEX_CAVES = "alexscaves";
    public static final String ECOLOGICS = "ecologics";


    public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        return Services.REGISTRY.register(BuiltInRegistries.ITEM, name, itemSupplier);
    }

    public static <T extends Block> Supplier<T> registerBlockWithItem(String name, java.util.function.Supplier<T> blockSupplier) {
        return Services.REGISTRY.registerBlockWithItem(name, blockSupplier);
    }

    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        return Services.REGISTRY.registerBlock(name, blockSupplier);
    }

    public static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntityType(String name, Supplier<BlockEntityType<T>> type) {
        return Services.REGISTRY.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, name, type);
    }

    public static <T extends BlockEntity> BlockEntityType<T> createBlockEntity(IPlatformHelper.BlockEntitySupplier<T> blockEntitySupplier, Block... blocks) {
        return Services.PLATFORM.createBlockEntity(blockEntitySupplier, blocks);
    }


    public static ACFlowerPotBlock flowerPot(Block block, DyeColor dyeColor) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        return new ACFlowerPotBlock(block, dyeColor, properties);
    }
}