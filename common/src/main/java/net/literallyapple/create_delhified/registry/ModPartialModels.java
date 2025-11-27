package net.literallyapple.create_delhified.registry;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.data.Couple;
import net.literallyapple.create_delhified.CreateDelhified;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class ModPartialModels {
    public static final Map<ResourceLocation, Couple<PartialModel>> FOLDING_DOORS = new HashMap<>();

    public static final PartialModel
        SMALL_WHEELS = block("dm_bogey/wheels/small_wheels"),
        LARGE_WHEELS = block("dm_bogey/wheels/large_wheels"),

        SMALL_MITSUBISHI_BOGEY_FRAME = block("dm_bogey/frame/small_mitsubishi"),
        SMALL_BOMBARDIER_BOGEY_FRAME = block("dm_bogey/frame/large_bombardier"),
        LARGE_MITSUBISHI_BOGEY_FRAME = block("dm_bogey/frame/large_mitsubishi"),
        LARGE_BOMBARDIER_BOGEY_FRAME = block("dm_bogey/frame/large_bombardier")
    ;

    /*
     * I don't know why the method 'putFoldingDoor' exists as it isn't even used.
     * I kept it I guess, probably won't remove it, scream all you want hehe :)
     */
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
