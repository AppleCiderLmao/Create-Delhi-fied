package net.literallyapple.create_delhified.blocks.bogey;

import com.simibubi.create.AllBogeyStyles;
import com.simibubi.create.content.trains.bogey.AbstractBogeyBlockEntity;
import com.simibubi.create.content.trains.bogey.BogeyStyle;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class DMBogeyBlockEntity extends AbstractBogeyBlockEntity {
    public DMBogeyBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public BogeyStyle getDefaultStyle() {
        if (getBlockState().getBlock() instanceof DMBogeyBlock bogeyBlock)
            return bogeyBlock.getDefaultStyle();
        return AllBogeyStyles.STANDARD;
    }
}