package com.teammetallurgy.aquaculture.init;

import com.mojang.datafixers.types.Type;
import com.teammetallurgy.aquaculture.Aquaculture;
import com.teammetallurgy.aquaculture.block.tileentity.NeptunesBountyTileEntity;
import com.teammetallurgy.aquaculture.block.tileentity.TackleBoxTileEntity;
import net.minecraft.Util;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class AquaBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_DEFERRED = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Aquaculture.MOD_ID);
    public static final RegistryObject<BlockEntityType<NeptunesBountyTileEntity>> NEPTUNES_BOUNTY = register("neptunes_bounty", () -> BlockEntityType.Builder.of(NeptunesBountyTileEntity::new, AquaBlocks.NEPTUNES_BOUNTY.get()));
    public static final RegistryObject<BlockEntityType<TackleBoxTileEntity>> TACKLE_BOX = register("tackle_box", () -> BlockEntityType.Builder.of(TackleBoxTileEntity::new, AquaBlocks.TACKLE_BOX.get()));

    public static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(@Nonnull String name, @Nonnull Supplier<BlockEntityType.Builder<T>> initializer) {
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, Aquaculture.MOD_ID + ":" + name);
        return BLOCK_ENTITY_DEFERRED.register(name, () -> initializer.get().build(type));
    }
}