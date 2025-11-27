package net.literallyapple.create_delhified.compat.steamnrails;

import com.railwayteam.railways.api.bogeymenu.v0.BogeyMenuManager;
import com.railwayteam.railways.api.bogeymenu.v0.entry.BogeyEntry;
import com.railwayteam.railways.api.bogeymenu.v0.entry.CategoryEntry;
import net.literallyapple.create_delhified.CreateDelhified;
import net.minecraft.resources.ResourceLocation;

import static net.literallyapple.create_delhified.registry.CreateDelhifiedBogeyStyles.*;

public interface MenuImpl {
    BogeyMenuManager INSTANCE = BogeyMenuManager.INSTANCE;
        CategoryEntry DOUBLE_AXLE = INSTANCE.getCategoryById(new ResourceLocation("railways", "bogey_menu/category/doubleaxles"));

    BogeyEntry
        MITSUBISHI = INSTANCE.addToCategory(DOUBLE_AXLE, MITSUBISHI_BOGEY, CreateDelhified.id("textures/gui/bogey_icons/dm_bogey.png"));
        // BOMBARDIER = INSTANCE.addToCategory(DOUBLE_AXLE, BOMBARDIER_BOGEY, CreateDelhified.id("textures/gui/bogey_icons/dm_bogey.png"));

    public static void init() {
        CreateDelhified.LOGGER.info(("Registering Steam 'n' Rails Menu Impl for " + CreateDelhified.NAME));
    }
}
