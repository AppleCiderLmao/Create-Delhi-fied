package net.literallyapple.create_delhified.registry;

import com.simibubi.create.content.decoration.palettes.ConnectedGlassBlock;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.literallyapple.create_delhified.CreateDelhified;
import net.literallyapple.create_delhified.blocks.LineBlock;
import net.literallyapple.create_delhified.blocks.doors.SlidingDoor.LineSlidingDoorBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {
    public static final CreateRegistrate REGISTRATE = CreateDelhified.REGISTRATE;

    // Here lies the holy block — the one which actually helped in testing Registrate.
	public static final BlockEntry<Block> EXAMPLE_BLOCK = REGISTRATE
            .block("example_block", Block::new)
            .simpleItem()
            .register();

    // Doors
    public static final BlockEntry<LineSlidingDoorBlock> DM_RED_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("dm_red", false, MapColor.METAL);

    public static final BlockEntry<LineSlidingDoorBlock> DM_YELLOW_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("dm_yellow", false, MapColor.METAL);

    public static final BlockEntry<LineSlidingDoorBlock> DM_BLUE_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("dm_blue", false, MapColor.METAL);

    public static final BlockEntry<LineSlidingDoorBlock> DM_PINK_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("dm_pink", false, MapColor.METAL);

    public static final BlockEntry<LineSlidingDoorBlock> DM_MAGENTA_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("dm_magenta", false, MapColor.METAL);

    public static final BlockEntry<LineSlidingDoorBlock> DM_VIOLET_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("dm_violet", false, MapColor.METAL);

    public static final BlockEntry<LineSlidingDoorBlock> DM_LIGHT_GRAY_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("dm_light_gray", false, MapColor.METAL);

    public static final BlockEntry<LineSlidingDoorBlock> DM_GRAY_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("dm_gray", false, MapColor.METAL);

    public static final BlockEntry<LineSlidingDoorBlock> CAB_DM_RED_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("cab_dm_red", false, MapColor.METAL);

    public static final BlockEntry<LineSlidingDoorBlock> CAB_DM_YELLOW_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("cab_dm_yellow", false, MapColor.METAL);

    public static final BlockEntry<LineSlidingDoorBlock> CAB_DM_BLUE_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("cab_dm_blue", false, MapColor.METAL);

    public static final BlockEntry<LineSlidingDoorBlock> CAB_DM_PINK_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("cab_dm_pink", false, MapColor.METAL);

    public static final BlockEntry<LineSlidingDoorBlock> CAB_DM_MAGENTA_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("cab_dm_magenta", false, MapColor.METAL);

    public static final BlockEntry<LineSlidingDoorBlock> CAB_DM_VIOLET_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("cab_dm_violet", false, MapColor.METAL);

    public static final BlockEntry<LineSlidingDoorBlock> CAB_DM_LIGHT_GRAY_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("cab_dm_light_gray", false, MapColor.METAL);

    public static final BlockEntry<LineSlidingDoorBlock> CAB_DM_GRAY_LINE_DOOR =
            CreateDelhifiedBuilderTransformers.DMSlidingDoor("cab_dm_gray", false, MapColor.METAL);

    // Blocks
    public static final BlockEntry<Block> DM_CASING =
            CreateDelhifiedBuilderTransformers.DefaultBlock("dm_casing", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> DM_LOGO_CASING =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_logo_casing", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<ConnectedGlassBlock> DM_WINDOWED_CASING =
            CreateDelhifiedBuilderTransformers.ConnectedDMWindowedCasingBlock("dm_windowed_casing",
                    () -> new SimpleCTBehaviour(CreateDelhifiedSpriteShifts.DM_WINDOWED_CASING), Blocks.BLACK_STAINED_GLASS);

    public static final BlockEntry<Block> DM_BOMBARDIER_CASING =
            CreateDelhifiedBuilderTransformers.DefaultBlock("dm_bombardier_casing", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<LineBlock> DM_BOMBARDIER_LOGO_CASING =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_bombardier_logo_casing", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<Block> DM_ROOF_CASING =
            CreateDelhifiedBuilderTransformers.DefaultBlock("dm_roof_casing", MapColor.TERRACOTTA_WHITE);

    public static final BlockEntry<ConnectedGlassBlock> DM_HLVC_VENT_CASING =
            CreateDelhifiedBuilderTransformers.ConnectedDMCasingBlock("dm_hlvc_vent_casing",
                    () -> new SimpleCTBehaviour(CreateDelhifiedSpriteShifts.DM_HLVC_VENT_CASING), Blocks.WHITE_TERRACOTTA);

    public static final BlockEntry<LineBlock> DM_RED_LINE_CASING =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_red_line_casing", MapColor.COLOR_RED);

    public static final BlockEntry<LineBlock> DM_RED_ARROW_CASING_LEFT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_red_arrow_casing_left", MapColor.COLOR_RED);

    public static final BlockEntry<LineBlock> DM_RED_ARROW_CASING_RIGHT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_red_arrow_casing_right", MapColor.COLOR_RED);

    public static final BlockEntry<LineBlock> DM_YELLOW_LINE_CASING =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_yellow_line_casing", MapColor.COLOR_YELLOW);

    public static final BlockEntry<LineBlock> DM_YELLOW_ARROW_CASING_LEFT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_yellow_arrow_casing_left", MapColor.COLOR_YELLOW);

    public static final BlockEntry<LineBlock> DM_YELLOW_ARROW_CASING_RIGHT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_yellow_arrow_casing_right", MapColor.COLOR_YELLOW);

    public static final BlockEntry<LineBlock> DM_BLUE_LINE_CASING =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_blue_line_casing", MapColor.COLOR_BLUE);

    public static final BlockEntry<LineBlock> DM_BLUE_ARROW_CASING_LEFT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_blue_arrow_casing_left", MapColor.COLOR_BLUE);

    public static final BlockEntry<LineBlock> DM_BLUE_ARROW_CASING_RIGHT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_blue_arrow_casing_right", MapColor.COLOR_BLUE);

    public static final BlockEntry<LineBlock> DM_VIOLET_LINE_CASING =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_violet_line_casing", MapColor.COLOR_PURPLE);

    public static final BlockEntry<LineBlock> DM_VIOLET_ARROW_CASING_LEFT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_violet_arrow_casing_left", MapColor.COLOR_PURPLE);

    public static final BlockEntry<LineBlock> DM_VIOLET_ARROW_CASING_RIGHT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_violet_arrow_casing_right", MapColor.COLOR_PURPLE);

    public static final BlockEntry<LineBlock> DM_PINK_LINE_CASING =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_pink_line_casing", MapColor.COLOR_PINK);

    public static final BlockEntry<LineBlock> DM_PINK_ARROW_CASING_LEFT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_pink_arrow_casing_left", MapColor.COLOR_PINK);

    public static final BlockEntry<LineBlock> DM_PINK_ARROW_CASING_RIGHT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_pink_arrow_casing_right", MapColor.COLOR_PINK);

    public static final BlockEntry<LineBlock> DM_MAGENTA_LINE_CASING =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_magenta_line_casing", MapColor.COLOR_MAGENTA);

    public static final BlockEntry<LineBlock> DM_MAGENTA_ARROW_CASING_LEFT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_magenta_arrow_casing_left", MapColor.COLOR_MAGENTA);

    public static final BlockEntry<LineBlock> DM_MAGENTA_ARROW_CASING_RIGHT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_magenta_arrow_casing_right", MapColor.COLOR_MAGENTA);

    public static final BlockEntry<LineBlock> DM_GRAY_LINE_CASING =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_gray_line_casing", MapColor.COLOR_GRAY);

    public static final BlockEntry<LineBlock> DM_GRAY_ARROW_CASING_LEFT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_gray_arrow_casing_left", MapColor.COLOR_GRAY);

    public static final BlockEntry<LineBlock> DM_GRAY_ARROW_CASING_RIGHT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_gray_arrow_casing_right", MapColor.COLOR_GRAY);

    public static final BlockEntry<LineBlock> DM_LIGHT_GRAY_LINE_CASING =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_light_gray_line_casing", MapColor.COLOR_LIGHT_GRAY);

    public static final BlockEntry<LineBlock> DM_LIGHT_GRAY_ARROW_CASING_LEFT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_light_gray_arrow_casing_left", MapColor.COLOR_LIGHT_GRAY);

    public static final BlockEntry<LineBlock> DM_LIGHT_GRAY_ARROW_CASING_RIGHT =
            CreateDelhifiedBuilderTransformers.LineBlock("dm_light_gray_arrow_casing_right", MapColor.COLOR_LIGHT_GRAY);

	public static void init() {
		// load the class and register everything
		CreateDelhified.LOGGER.info("Registering blocks for " + CreateDelhified.NAME);
	}
}
