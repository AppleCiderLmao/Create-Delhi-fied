package net.literallyapple.create_delhified.core.utils;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class LineSlidingDoorProperties {
    SoundEvent open = SoundEvents.WAXED_SIGN_INTERACT_FAIL; // These values don't matter just ignore them.
    SoundEvent close = SoundEvents.WAXED_SIGN_INTERACT_FAIL; // These are reconfigured later in the MovementBehaviour class anyway.
    float speed = .30f;

    public LineSlidingDoorProperties(SoundEvent open, SoundEvent close, float speed) {
        this.open = open;
        this.close = close;
        this.speed = speed;
    }

    public SoundEvent GetOpen() {
        return open;
    }

    public SoundEvent GetClose() {
        return close;
    }

    public float GetSpeed() {
        return speed;
    }
}
