package net.literallyapple.create_delhified.registry;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import net.literallyapple.create_delhified.CreateDelhified;

public class CreateDelhifiedSpriteShifts {
    public static final CTSpriteShiftEntry
            DM_WINDOWED_CASING = getCT(AllCTTypes.OMNIDIRECTIONAL, "dm_windowed_casing", "dm_windowed_casing"),
            DM_HLVC_VENT_CASING = getCT(AllCTTypes.OMNIDIRECTIONAL, "dm_hlvc_vent_casing", "dm_hlvc_vent_casing");

    public static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
        return CTSpriteShifter.getCT(type, CreateDelhified.id("block/dm_casing/" + blockTextureName), CreateDelhified.id("block/dm_casing/" + connectedTextureName + "_connected"));
    }
}
