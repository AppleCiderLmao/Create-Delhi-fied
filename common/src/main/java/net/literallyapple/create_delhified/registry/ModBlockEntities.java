package net.literallyapple.create_delhified.registry;

import com.simibubi.create.content.trains.bogey.BogeyBlockEntityRenderer;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.literallyapple.create_delhified.CreateDelhified;
import net.literallyapple.create_delhified.blocks.doors.SlidingDoor.LineSlidingDoorBlockEntity;
import net.literallyapple.create_delhified.blocks.doors.SlidingDoor.LineSlidingDoorBlockRenderer;
import net.literallyapple.create_delhified.blocks.bogey.DMBogeyBlockEntity;

import static net.literallyapple.create_delhified.registry.ModBlocks.*;

public class ModBlockEntities {
    public static final CreateRegistrate REGISTRATE = CreateDelhified.REGISTRATE;

    public static final BlockEntityEntry<LineSlidingDoorBlockEntity> SLIDING_DOOR =
            REGISTRATE.blockEntity("sliding_door", LineSlidingDoorBlockEntity::new)
                    .renderer(() -> LineSlidingDoorBlockRenderer::new)
                    .validBlocks(DM_RED_LINE_DOOR, DM_BLUE_LINE_DOOR, DM_YELLOW_LINE_DOOR, DM_VIOLET_LINE_DOOR,
                            DM_PINK_LINE_DOOR, DM_MAGENTA_LINE_DOOR, DM_LIGHT_GRAY_LINE_DOOR, DM_GRAY_LINE_DOOR,
                            CAB_DM_RED_LINE_DOOR, CAB_DM_BLUE_LINE_DOOR, CAB_DM_YELLOW_LINE_DOOR, CAB_DM_VIOLET_LINE_DOOR,
                            CAB_DM_PINK_LINE_DOOR, CAB_DM_MAGENTA_LINE_DOOR, CAB_DM_LIGHT_GRAY_LINE_DOOR, CAB_DM_GRAY_LINE_DOOR)
                    .register();

    public static final BlockEntityEntry<DMBogeyBlockEntity> BOGEY =
            REGISTRATE.blockEntity("bogey", DMBogeyBlockEntity::new)
            .renderer(() -> BogeyBlockEntityRenderer::new)
            .validBlocks(DOUBLEAXLE_BOGEY_BLOCK, LARGE_DOUBLEAXLE_BOGEY_BLOCK)
            .register();

    public static void init() {
        CreateDelhified.LOGGER.info("Registering Block Entities for " + CreateDelhified.NAME);
    }
}
