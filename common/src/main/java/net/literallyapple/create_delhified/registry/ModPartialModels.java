package net.literallyapple.create_delhified.registry;

import com.jozufozu.flywheel.core.PartialModel;
import com.simibubi.create.foundation.utility.Couple;
import net.literallyapple.create_delhified.CreateDelhified;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class ModPartialModels {
    public static final Map<ResourceLocation, Couple<PartialModel>> FOLDING_DOORS = new HashMap<>();

    static {

    }

    private static void putFoldingDoor(String path) {
        FOLDING_DOORS.put(CreateDelhified.id(path),
                Couple.create(block(path + "/fold_left"), block(path + "/fold_right")));
    }

    private static PartialModel block(String path) {
        return new PartialModel(CreateDelhified.id("block/" + path));
    }

    public static void init() {
        CreateDelhified.LOGGER.info("Registering Partial Models for " + CreateDelhified.NAME);
    }
}
