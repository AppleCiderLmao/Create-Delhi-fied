package net.literallyapple.create_delhified.forge;

import dev.architectury.platform.forge.EventBuses;
import net.literallyapple.create_delhified.CreateDelhified;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CreateDelhified.MOD_ID)
public class CreateDelhifiedForge {
    public CreateDelhifiedForge() {
        // register Architectury API with the modEventBus so it doesn't keep crying
        EventBuses.registerModEventBus(CreateDelhified.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        // registrate must be given the mod event bus on forge before registration
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CreateDelhified.REGISTRATE.registerEventListeners(eventBus);
        CreateDelhified.init();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT,
                () -> CreateDelhifiedForgeClient::init);
    }
}
