package net.literallyapple.create_delhified.registry;

import com.simibubi.create.AllBogeyStyles;
import com.simibubi.create.content.trains.bogey.BogeySizes;
import com.simibubi.create.content.trains.bogey.BogeyStyle;
import com.simibubi.create.content.trains.bogey.BogeyStyle.SizeRenderer;
import net.literallyapple.create_delhified.CreateDelhified;
import net.literallyapple.create_delhified.content.bogeys.renderer.MitsubishiBogeyRenderer;
import net.literallyapple.create_delhified.content.bogeys.visual.MitsubishiBogeyVisual;
import net.minecraft.network.chat.Component;

public class CreateDelhifiedBogeyStyles {
    public static final BogeyStyle
       MITSUBISHI_BOGEY =
       bogeyBuilder("mitsubishi").displayName(Component.translatable(CreateDelhified.MOD_ID + ".bogeys.style.mitsubishi"))
        .size(BogeySizes.SMALL, ModBlocks.DOUBLEAXLE_BOGEY_BLOCK, () -> () -> new SizeRenderer(new MitsubishiBogeyRenderer.MitsubishiSmall(), MitsubishiBogeyVisual.MitsubishiSmallVisual::new))
        .size(BogeySizes.LARGE, ModBlocks.LARGE_DOUBLEAXLE_BOGEY_BLOCK, () -> () -> new SizeRenderer(new MitsubishiBogeyRenderer.MitsubishiLarge(), MitsubishiBogeyVisual.MitsubishiLargeVisual::new))
        .build();
       // BOMBARDIER_BOGEY =
       // bogeyBuilder("bombardier").displayName(Component.translatable(CreateDelhified.MOD_ID + ".bogeys.style.bombardier"))
       //  .size(BogeySizes.SMALL, ModBlocks.DOUBLEAXLE_BOGEY_BLOCK, () -> () -> new SizeRenderer(new BombardierBogeyRenderer.BombardierSmall(), BombardierBogeyVisual.BombardierSmallVisual::new))
       //  .size(BogeySizes.LARGE, ModBlocks.DOUBLEAXLE_BOGEY_BLOCK, () -> () -> new SizeRenderer(new BombardierBogeyRenderer.BombardierLarge(), BombardierBogeyVisual.BombardierLargeVisual::new))
       //  .build();

    private static BogeyStyle.Builder bogeyBuilder(String name) {
        return new BogeyStyle.Builder(CreateDelhified.id(name), AllBogeyStyles.STANDARD_CYCLE_GROUP);
    }

    public static void init() {
        // load the class and register everything
        CreateDelhified.LOGGER.info("Registering Bogey Styles for " + CreateDelhified.NAME);
    }
}
