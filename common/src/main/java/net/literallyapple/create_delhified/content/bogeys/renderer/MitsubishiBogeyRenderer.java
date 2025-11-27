package net.literallyapple.create_delhified.content.bogeys.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.trains.bogey.BogeyRenderer;
import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBuffer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.Blocks;
import net.literallyapple.create_delhified.registry.ModPartialModels;

public class MitsubishiBogeyRenderer implements BogeyRenderer {
    @Override
    public void render(CompoundTag compoundTag, float wheelAngle, float partialTick, PoseStack posestack, MultiBufferSource bufferSource, int light, int overlay, boolean inContraption) {

    }

    public static class MitsubishiSmall extends MitsubishiBogeyRenderer {
        @Override
        public void render (CompoundTag compoundTag, float wheelAngle, float partialTick, PoseStack posestack, MultiBufferSource bufferSource, int light, int overlay, boolean inContraption) {
            super.render(compoundTag, wheelAngle, partialTick, posestack, bufferSource, light, overlay, inContraption);

            VertexConsumer buffer = bufferSource.getBuffer(RenderType.cutoutMipped());
            SuperByteBuffer wheels = CachedBuffers.partial(AllPartialModels.SMALL_BOGEY_WHEELS, Blocks.AIR.defaultBlockState());

            CachedBuffers.partial(ModPartialModels.SMALL_MITSUBISHI_BOGEY_FRAME, Blocks.AIR.defaultBlockState())
                .scale(1-1 / 512f)
                .light(light)
                .overlay(overlay)
                .renderInto(posestack, buffer);

            for (int i = 0; i < 2; i++) {
                wheels.translate(0, 0, i+1f)
                        .rotateXDegrees(wheelAngle)
                        .light(light)
                        .overlay(overlay)
                        .renderInto(posestack, buffer);
            }
        }
    }

    public static class MitsubishiLarge extends MitsubishiBogeyRenderer {
        @Override
        public void render (CompoundTag compoundTag, float wheelAngle, float partialTick, PoseStack posestack, MultiBufferSource bufferSource, int light, int overlay, boolean inContraption) {
            super.render(compoundTag, wheelAngle, partialTick, posestack, bufferSource, light, overlay, inContraption);

            VertexConsumer buffer = bufferSource.getBuffer(RenderType.cutoutMipped());
            SuperByteBuffer wheels = CachedBuffers.partial(ModPartialModels.LARGE_WHEELS, Blocks.AIR.defaultBlockState());

            CachedBuffers.partial(ModPartialModels.LARGE_MITSUBISHI_BOGEY_FRAME, Blocks.AIR.defaultBlockState())
                .scale(1-1 / 512f)
                .light(light)
                .overlay(overlay)
                .renderInto(posestack, buffer);

            for (int i = 0; i < 2; i++) {
                wheels.translate(0, .75f, i+1.5f)
                        .rotateXDegrees(wheelAngle)
                        .light(light)
                        .overlay(overlay)
                        .renderInto(posestack, buffer);
            }
        }
    }
}