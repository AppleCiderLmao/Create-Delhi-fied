package net.literallyapple.create_delhified;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.literallyapple.create_delhified.registry.*;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateDelhified {
    public static final String MOD_ID = "create_delhified";
    public static final String NAME = "Create: Delhi-fied";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);


    public static void init() {
        LOGGER.info("Wait no who was I again? I forgot the script... Ah right, let me try again.");
        LOGGER.info("{} initializing! Create version: {} on platform: {}", NAME, Create.VERSION, ModExpectPlatform.platformName());
        ModBlocks.init(); // hold registrate in a separate class to avoid loading early on forge
        ModTabs.init();
        ModBlockEntities.init();
        ModTags.init();
        ModPartialModels.init();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
