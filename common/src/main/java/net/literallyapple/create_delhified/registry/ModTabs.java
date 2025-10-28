package net.literallyapple.create_delhified.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.literallyapple.create_delhified.CreateDelhified;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {
    public static final CreateRegistrate REGISTRATE = CreateDelhified.REGISTRATE;

    public static final DeferredRegister<CreativeModeTab> TAB_REGISTER = DeferredRegister.create(CreateDelhified.MOD_ID, Registries.CREATIVE_MODE_TAB);

    // public static RegistryEntry<CreativeModeTab> CREATE_DMRC_BLOCKS_TAB = REGISTRATE
    //         .defaultCreativeTab("create_dmrc_blocks_tab")
    //         .register();

    public static final RegistrySupplier<CreativeModeTab> CREATE_DELHIFIED_BLOCKS_TAB =
            TAB_REGISTER.register(new ResourceLocation(CreateDelhified.MOD_ID, "blocks_tab"),
                    () -> CreativeTabRegistry.create(
                            Component.translatable("itemGroup." + CreateDelhified.MOD_ID + ".blocks_tab"),
                            () -> new ItemStack(ModBlocks.DM_LOGO_CASING.asItem())
            ));

    public static final RegistrySupplier<CreativeModeTab> CREATE_DELHIFIED_DOORS_TAB =
            TAB_REGISTER.register(new ResourceLocation(CreateDelhified.MOD_ID, "doors_tab"),
                    () -> CreativeTabRegistry.create(
                            Component.translatable("itemGroup." + CreateDelhified.MOD_ID + ".doors_tab"),
                            () -> new ItemStack(ModBlocks.DM_RED_LINE_DOOR.asItem())
                    ));

    public static void init() {
        // load the class and register everything
        CreateDelhified.LOGGER.info("Registering Creative Mode Tabs for " + CreateDelhified.NAME);
        TAB_REGISTER.register();
    }
}
