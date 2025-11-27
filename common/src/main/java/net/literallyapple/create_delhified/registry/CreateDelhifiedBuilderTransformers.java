package net.literallyapple.create_delhified.registry;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.decoration.palettes.ConnectedGlassBlock;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.literallyapple.create_delhified.CreateDelhified;
import net.literallyapple.create_delhified.blocks.LineBlock;
import net.literallyapple.create_delhified.blocks.behaviour.SlidingDoor.LineSlidingDoorMovementBehaviour;
import net.literallyapple.create_delhified.blocks.behaviour.SlidingDoor.LineSlidingDoorMovingInteraction;
import net.literallyapple.create_delhified.blocks.bogey.DMBogeyBlock;
import net.literallyapple.create_delhified.blocks.doors.SlidingDoor.LineSlidingDoorBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

import static com.simibubi.create.api.behaviour.interaction.MovingInteractionBehaviour.interactionBehaviour;
import static com.simibubi.create.api.behaviour.movement.MovementBehaviour.movementBehaviour;
import static com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlock.GLASS_SET_TYPE;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class CreateDelhifiedBuilderTransformers {
    public static final CreateRegistrate REGISTRATE = CreateDelhified.REGISTRATE;
    
    public static BlockEntry<Block> DefaultBlock(String pId, MapColor pColor) {
        return REGISTRATE
                .block(pId, Block::new)
                .initialProperties(() -> Blocks.GLASS)
                .properties(p -> p.sound(SoundType.STONE).mapColor(pColor))
                .transform(pickaxeOnly())
                .tag(ModTags.AllBlockTags.FRAMEABLE.tag)
                .loot((lr, block) -> lr.add(block, lr.createSingleItemTable(block)))
                .item()
                .tab(ModTabs.CREATE_DELHIFIED_BLOCKS_TAB.getKey())
                .build()
                .register();

    }

    public static BlockEntry<LineBlock> LineBlock(String id, MapColor color) {
        return REGISTRATE
                .block(id, LineBlock::new)
                .initialProperties(() -> Blocks.WHITE_CONCRETE)
                .properties(p -> p.mapColor(color))
                .transform(pickaxeOnly())
                .tag(ModTags.AllBlockTags.FRAMEABLE.tag)
                .tag(ModTags.AllBlockTags.LINE_BLOCKS.tag)
                .loot((lr, block) -> lr.add(block, lr.createSingleItemTable(block)))
                .item()
                .tag(ModTags.AllItemTags.LINE_BLOCKS.tag)
                .tab(ModTabs.CREATE_DELHIFIED_BLOCKS_TAB.getKey())
                .build()
                .register();
    }

    public static BlockEntry<ConnectedGlassBlock> ConnectedDMWindowedCasingBlock(String id, Supplier<ConnectedTextureBehaviour> behaviour, Block stainedBlock) {
        return REGISTRATE
                .block(id, ConnectedGlassBlock::new)
                .onRegister(connectedTextures(behaviour))
                .addLayer(() -> RenderType::translucent)
                .initialProperties(() -> stainedBlock)
                .properties((p) -> p.isValidSpawn(CreateDelhifiedBuilderTransformers::never)
                        .isRedstoneConductor(CreateDelhifiedBuilderTransformers::never)
                        .isSuffocating(CreateDelhifiedBuilderTransformers::never)
                        .isViewBlocking(CreateDelhifiedBuilderTransformers::never)
                        .noOcclusion())
                .transform(pickaxeOnly())
                .tag(ModTags.AllBlockTags.FRAMEABLE.tag)
                .loot((lr, block) -> lr.add(block, lr.createSingleItemTable(block)))
                .item()
                .tab(ModTabs.CREATE_DELHIFIED_BLOCKS_TAB.getKey())
                .build()
                .register();
    }

    public static BlockEntry<ConnectedGlassBlock> ConnectedDMCasingBlock(String id, Supplier<ConnectedTextureBehaviour> behaviour, Block stainedBlock) {
        return REGISTRATE
                .block(id, ConnectedGlassBlock::new)
                .onRegister(connectedTextures(behaviour))
                .initialProperties(() -> stainedBlock)
                .properties((p) -> p.isValidSpawn(CreateDelhifiedBuilderTransformers::never)
                        .isRedstoneConductor(CreateDelhifiedBuilderTransformers::never))
                .transform(pickaxeOnly())
                .tag(ModTags.AllBlockTags.FRAMEABLE.tag)
                .loot((lr, block) -> lr.add(block, lr.createSingleItemTable(block)))
                .item()
                .tab(ModTabs.CREATE_DELHIFIED_BLOCKS_TAB.getKey())
                .build()
                .register();
    }

    public static <B extends DMBogeyBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> bogey() {
        return b -> b.initialProperties(SharedProperties::softMetal)
                .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
                .properties(BlockBehaviour.Properties::noOcclusion)
                .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
                .properties(p -> p.mapColor(MapColor.PODZOL))
                .transform(pickaxeOnly())
                .blockstate((c, p) -> BlockStateGen.horizontalAxisBlock(c, p, s -> p.models()
                        .getExistingFile(p.modLoc("block/bogie/top"))))
                .loot((p, l) -> p.dropOther(l, AllBlocks.RAILWAY_CASING.get()))
                .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag);
    }

    public static <B extends LineSlidingDoorBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> slidingDoor(String type) {
        return b -> b.initialProperties(() -> Blocks.OAK_DOOR) // for villager AI..
                .properties(p -> p.strength(3.0F, 6.0F))
                .transform(pickaxeOnly())
                .onRegister(interactionBehaviour(new LineSlidingDoorMovingInteraction()))
                .onRegister(movementBehaviour(new LineSlidingDoorMovementBehaviour(type)))
                .tag(BlockTags.DOORS)
                .tag(ModTags.AllBlockTags.DOORS.tag)
                .tag(AllTags.AllBlockTags.NON_DOUBLE_DOOR.tag)
                .loot((lr, block) -> lr.add(block, lr.createDoorTable(block)))
                .item()
                .tag(ItemTags.DOORS)
                .tag(ModTags.AllItemTags.DOORS.tag)
                .tag(AllTags.AllItemTags.CONTRAPTION_CONTROLLED.tag)
                .tab(ModTabs.CREATE_DELHIFIED_DOORS_TAB.getKey())
                .build();
    }

     public static BlockEntry<LineSlidingDoorBlock> DMSlidingDoor(String type, boolean folds, MapColor colour) {
        return REGISTRATE.block("door_" + type, p -> new LineSlidingDoorBlock(p, GLASS_SET_TYPE.get(), folds))
                .initialProperties(AllBlocks.FRAMED_GLASS_DOOR)
                .properties(p -> p.sound(SoundType.METAL).mapColor(colour))
                .addLayer(() -> RenderType::translucent)
                .transform(CreateDelhifiedBuilderTransformers.slidingDoor(type))
                .properties(BlockBehaviour.Properties::noOcclusion)
                .register();
     }

    public static boolean never(BlockState p_235436_0_, BlockGetter p_235436_1_, BlockPos p_235436_2_) {
        return false;
    }

    public static Boolean never(BlockState p_235427_0_, BlockGetter p_235427_1_, BlockPos p_235427_2_,
                                EntityType<?> p_235427_3_) {
        return false;
    }
}
