package net.literallyapple.create_delhified.registry;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.data.Couple;
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
        return PartialModel.of(CreateDelhified.id("block/" + path));
    }

    public static void init() {
        CreateDelhified.LOGGER.info("Registering Partial Models for " + CreateDelhified.NAME);
    }
}
