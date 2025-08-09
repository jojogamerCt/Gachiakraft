package com.gachiakraft.client.render;

import com.gachiakraft.client.customization.CustomizationManager;
import com.gachiakraft.client.model.CustomPlayerModel;
import com.gachiakraft.client.texture.TextureGenerator;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;

/**
 * Player renderer that uses dynamically generated textures based on customization data.
 */
public class CustomPlayerRenderer extends PlayerRenderer {
    public CustomPlayerRenderer(EntityRendererProvider.Context context, boolean slim) {
        super(context, slim);
        this.model = new CustomPlayerModel<>(context.bakeLayer(CustomPlayerModel.LAYER_LOCATION));
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractClientPlayer player) {
        return TextureGenerator.generate(CustomizationManager.get());
    }
}
