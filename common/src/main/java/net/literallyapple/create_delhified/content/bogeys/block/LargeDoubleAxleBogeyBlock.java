package net.literallyapple.create_delhified.content.bogeys.block;

import com.simibubi.create.AllBogeyStyles;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import net.literallyapple.create_delhified.blocks.bogey.DMBogeyBlock;
import net.minecraft.world.phys.Vec3;

public class LargeDoubleAxleBogeyBlock extends DMBogeyBlock {
    public LargeDoubleAxleBogeyBlock(Properties props) {
        super(props, AllBogeyStyles.STANDARD, BogeySizes.LARGE);
    }

    @Override
    public Vec3 getConnectorAnchorOffset() {
        return new Vec3(0, 7 / 32f, 32 / 32f);
    }
}