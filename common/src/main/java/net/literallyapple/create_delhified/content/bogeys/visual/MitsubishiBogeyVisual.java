package net.literallyapple.create_delhified.content.bogeys.visual;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.content.trains.bogey.BogeyVisual;
import com.simibubi.create.foundation.render.SpecialModels;
import dev.engine_room.flywheel.api.instance.Instance;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import dev.engine_room.flywheel.lib.instance.InstanceTypes;
import dev.engine_room.flywheel.lib.instance.TransformedInstance;
import net.minecraft.nbt.CompoundTag;

import static net.literallyapple.create_delhified.registry.ModPartialModels.*;

import java.util.function.Consumer;

public class MitsubishiBogeyVisual implements BogeyVisual {
    public MitsubishiBogeyVisual(VisualizationContext ctx, float partialTick, boolean inContraption) { }
    @Override
    public void update(CompoundTag bogeyData, float wheelAngle, PoseStack poseStack) { }
    @Override
    public void hide() { }
    @Override
    public void updateLight(int packedLight) { }
    @Override
    public void collectCrumblingInstances(Consumer<Instance> consumer) { }
    @Override
    public void delete() { }

    public static class MitsubishiSmallVisual extends MitsubishiBogeyVisual {
        public final TransformedInstance frame;
        public final TransformedInstance wheel1;
        public final TransformedInstance wheel2;

        public MitsubishiSmallVisual(VisualizationContext ctx, float partialTick, boolean inContraption) {
            super(ctx, partialTick, inContraption);

            frame = ctx.instancerProvider()
                    .instancer(InstanceTypes.TRANSFORMED, SpecialModels.flatLit(SMALL_MITSUBISHI_BOGEY_FRAME))
                    .createInstance();

            var wheelInitializer = ctx.instancerProvider()
                    .instancer(InstanceTypes.TRANSFORMED, SpecialModels.flatLit(SMALL_WHEELS));

            wheel1 = wheelInitializer.createInstance();
            wheel2 = wheelInitializer.createInstance();
        }

        @Override
        public void update(CompoundTag bogeyData, float wheelAngle, PoseStack poseStack) {
            frame.setTransform(poseStack)
                    .scale(1-1 / 512f)
                    .setChanged();

            wheel1.setTransform(poseStack)
                    .translate(0, .75f, -1f)
                    .rotateXDegrees(wheelAngle)
                    .setChanged();

            wheel2.setTransform(poseStack)
                    .translate(0, .75f, 1f)
                    .rotateXDegrees(wheelAngle)
                    .setChanged();

        }

        @Override
        public void hide() {
            super.hide();
            frame.setZeroTransform().setChanged();
            wheel1.setZeroTransform().setChanged();
            wheel2.setZeroTransform().setChanged();
        }

        @Override
        public void updateLight(int packedLight) {
            frame.light(packedLight).setChanged();
            wheel1.light(packedLight).setChanged();
            wheel2.light(packedLight).setChanged();
        }

        @Override
        public void collectCrumblingInstances(Consumer<Instance> consumer) {
            super.collectCrumblingInstances(consumer);
            consumer.accept(frame);
            consumer.accept(wheel1);
            consumer.accept(wheel2);
        }

        @Override
        public void delete() {
            super.delete();
            frame.delete();
            wheel1.delete();
            wheel2.delete();
        }
    }

    public static class MitsubishiLargeVisual extends MitsubishiBogeyVisual {
        public final TransformedInstance frame;
        public final TransformedInstance wheel1;
        public final TransformedInstance wheel2;

        public MitsubishiLargeVisual(VisualizationContext ctx, float partialTick, boolean inContraption) {
            super(ctx, partialTick, inContraption);

            frame = ctx.instancerProvider()
                    .instancer(InstanceTypes.TRANSFORMED, SpecialModels.flatLit(LARGE_MITSUBISHI_BOGEY_FRAME))
                    .createInstance();

            var wheelInitializer = ctx.instancerProvider()
                    .instancer(InstanceTypes.TRANSFORMED, SpecialModels.flatLit(LARGE_WHEELS));

            wheel1 = wheelInitializer.createInstance();
            wheel2 = wheelInitializer.createInstance();
        }

        @Override
        public void update(CompoundTag bogeyData, float wheelAngle, PoseStack poseStack) {
            frame.setTransform(poseStack)
                    .scale(1-1 / 512f)
                    .setChanged();

            wheel1.setTransform(poseStack)
                    .translate(0, .75f, -1.5f)
                    .rotateXDegrees(wheelAngle)
                    .setChanged();

            wheel2.setTransform(poseStack)
                    .translate(0, .75f, 1.5f)
                    .rotateXDegrees(wheelAngle)
                    .setChanged();

        }

        @Override
        public void hide() {
            super.hide();
            frame.setZeroTransform().setChanged();
            wheel1.setZeroTransform().setChanged();
            wheel2.setZeroTransform().setChanged();
        }

        @Override
        public void updateLight(int packedLight) {
            frame.light(packedLight).setChanged();
            wheel1.light(packedLight).setChanged();
            wheel2.light(packedLight).setChanged();
        }

        @Override
        public void collectCrumblingInstances(Consumer<Instance> consumer) {
            super.collectCrumblingInstances(consumer);
            consumer.accept(frame);
            consumer.accept(wheel1);
            consumer.accept(wheel2);
        }

        @Override
        public void delete() {
            super.delete();
            frame.delete();
            wheel1.delete();
            wheel2.delete();
        }
    }
}
