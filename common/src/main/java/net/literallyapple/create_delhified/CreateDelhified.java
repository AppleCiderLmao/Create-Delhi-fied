package net.literallyapple.create_delhified;

import com.simibubi.create.CreateBuildInfo;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.createmod.catnip.lang.FontHelper;
import net.literallyapple.create_delhified.blocks.doors.SlidingDoor.LineSlidingDoorBlock;
import net.literallyapple.create_delhified.registry.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;

public class CreateDelhified {
    public static final String MOD_ID = "create_delhified";
    public static final String NAME = "Create: Delhi-fied";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);


    public static void init() {
        LOGGER.info("Wait no who was I again? I forgot the script... Ah right, let me try again.");
        LOGGER.info("{} initializing! Create version: {} on platform: {}", NAME, CreateBuildInfo.VERSION, ModExpectPlatform.platformName());
        ModBlocks.init(); // hold registrate in a separate class to avoid loading early on forge
        ModTabs.init();
        ModBlockEntities.init();
        ModTags.init();
        ModPartialModels.init();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    @Nullable
    public static KineticStats create(Item item) {
        if (item instanceof BlockItem blockItem) {
            Block block = blockItem.getBlock();
            if (block instanceof LineSlidingDoorBlock) {
                return new KineticStats(block);
            }
            // ...
        }
        return null;
    }

    static {
        REGISTRATE.setTooltipModifierFactory(item -> {
            return new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE).andThen(TooltipModifier.mapNull(create(item)));
        });
    }
}
