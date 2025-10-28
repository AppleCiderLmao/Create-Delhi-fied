package net.literallyapple.create_delhified.fabric;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.literallyapple.create_delhified.CreateDelhified;
import net.fabricmc.api.ModInitializer;

public class CreateDelhifiedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CreateDelhified.init();
        CreateDelhified.LOGGER.info(EnvExecutor.unsafeRunForDist(
                () -> () -> "{} is accessing Porting Lib on a Fabric client!",
                () -> () -> "{} is accessing Porting Lib on a Fabric server!"
                ), CreateDelhified.NAME);
        // on fabric, Registrates must be explicitly finalized and registered.
        CreateDelhified.REGISTRATE.register();
    }
}
