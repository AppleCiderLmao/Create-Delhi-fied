package net.literallyapple.create_delhified.blocks.doors.SlidingDoor;

import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import com.simibubi.create.content.decoration.slidingDoor.SlidingDoorBlock;
import net.literallyapple.create_delhified.core.utils.PlacementUtils;
import net.literallyapple.create_delhified.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.BlockHitResult;

public class LineSlidingDoorBlock extends SlidingDoorBlock {
    public LineSlidingDoorBlock(Properties pProperties, BlockSetType pType, boolean pFolds) {
        super(pProperties, pType, pFolds);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction playerDir = ctx.getHorizontalDirection().getOpposite();
        Direction clickedFace = ctx.getClickedFace();

        if (clickedFace == Direction.NORTH || clickedFace == Direction.SOUTH) {
            playerDir = playerDir.getOpposite();
        }

        double relX = ctx.getClickLocation().x - ctx.getClickedPos().getX();
        double relZ = ctx.getClickLocation().z - ctx.getClickedPos().getZ();
        boolean hingeLeft = false;

        switch (playerDir) {
            case NORTH -> hingeLeft = relX > 0.5;
            case SOUTH -> hingeLeft = relX < 0.5;
            case WEST -> hingeLeft = relZ < 0.5;
            case EAST -> hingeLeft = relZ > 0.5;
        }

        return this.defaultBlockState()
                .setValue(FACING, playerDir)
                .setValue(HINGE, hingeLeft ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT)
                .setValue(OPEN, false);
    }


    public static boolean isDoubleDoor(DoorHingeSide hinge, BlockPos pos, Direction facing, MovementContext context) {
        if (hinge == DoorHingeSide.LEFT) {
            BlockPos posH2 = PlacementUtils.getPlaceDirectionLeft(pos, facing);
            StructureTemplate.StructureBlockInfo structureBlockInfo = context.contraption.getBlocks().get(posH2);
            if (structureBlockInfo == null)
                return false;
            if (structureBlockInfo.state().getBlock() instanceof LineSlidingDoorBlock) {
                return structureBlockInfo.state().getValue(HINGE) == DoorHingeSide.RIGHT;
            }
        }
        else {
            BlockPos posH2 = PlacementUtils.getPlaceDirectionRight(pos, facing);
            StructureTemplate.StructureBlockInfo structureBlockInfo = context.contraption.getBlocks().get(posH2);
            if (structureBlockInfo == null)
                return false;
            if (structureBlockInfo.state().getBlock() instanceof LineSlidingDoorBlock) {
                return structureBlockInfo.state().getValue(HINGE) == DoorHingeSide.LEFT;
            }
        }
        return false;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public BlockEntityType<? extends LineSlidingDoorBlockEntity> getBlockEntityType() {
        return ModBlockEntities.SLIDING_DOOR.get();
    }
}
