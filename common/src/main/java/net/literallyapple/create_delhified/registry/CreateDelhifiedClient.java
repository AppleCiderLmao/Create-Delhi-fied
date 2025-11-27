package net.literallyapple.create_delhified.registry;

import net.literallyapple.create_delhified.compat.Mods;
import net.literallyapple.create_delhified.compat.steamnrails.MenuImpl;

public class CreateDelhifiedClient {
    public static void init() {
        Mods.RAILWAYS.executeIfInstalled(() -> MenuImpl::init);
    }
}
