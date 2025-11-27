package net.literallyapple.create_delhified.blocks.bogey;

import com.simibubi.create.api.schematic.requirement.SpecialBlockItemRequirement;
import com.simibubi.create.content.trains.bogey.AbstractBogeyBlock;
import com.simibubi.create.content.trains.bogey.BogeySizes.BogeySize;
import com.simibubi.create.content.trains.bogey.BogeyStyle;
import com.simibubi.create.content.trains.track.TrackMaterial;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.block.ProperWaterloggedBlock;
import net.literallyapple.create_delhified.registry.ModBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.phys.Vec3;


public class DMBogeyBlock extends AbstractBogeyBlock <DMBogeyBlockEntity>
        implements IBE<DMBogeyBlockEntity>, ProperWaterloggedBlock, SpecialBlockItemRequirement {

    private final BogeyStyle defaultStyle;

    protected DMBogeyBlock(Properties props, BogeyStyle defaultStyle, BogeySize size) {
        super(props, size);
        this.defaultStyle = defaultStyle;
        registerDefaultState(defaultBlockState().setValue(WATERLOGGED, false));
    }

    @Override
    public TrackMaterial.TrackType getTrackType(BogeyStyle style) {
        return TrackMaterial.TrackType.STANDARD;
    }

    @Override
    public double getWheelPointSpacing() {
        return 2;
    }

    @Override
    public double getWheelRadius() {
        return 6.5 / 16d;
    }

    @Override
    public Vec3 getConnectorAnchorOffset() {
        return new Vec3(0, 7 / 32f, 1);
    }

    @Override
    public BogeyStyle getDefaultStyle() {
        return defaultStyle;
    }

    @Override
    public Class<DMBogeyBlockEntity> getBlockEntityClass() {
        return DMBogeyBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends DMBogeyBlockEntity> getBlockEntityType() {
        return ModBlockEntities.BOGEY.get();
    }
}