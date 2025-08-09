package com.gachiakraft.client.texture;

import com.gachiakraft.client.customization.CustomizationData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;
import com.mojang.blaze3d.platform.NativeImage;

/**
 * Generates very simple player textures at runtime.
 */
public class TextureGenerator {
    public static ResourceLocation generate(CustomizationData data) {
        NativeImage image = new NativeImage(NativeImage.Format.RGBA, 64, 64, false);
        int skin = 0xFFC6864B; // basic skin tone
        fill(image, 0, 0, 64, 64, skin);

        if (data.getGender() == CustomizationData.Gender.MALE) {
            drawMaleUnderwear(image);
        } else {
            drawFemaleUnderwear(image);
        }

        DynamicTexture texture = new DynamicTexture(image);
        return Minecraft.getInstance().getTextureManager().register("gachiakraft/player_" + data.hashCode(), texture);
    }

    private static void fill(NativeImage img, int x, int y, int w, int h, int color) {
        for (int i = x; i < x + w; i++) {
            for (int j = y; j < y + h; j++) {
                img.setPixelRGBA(i, j, color);
            }
        }
    }

    private static void drawMaleUnderwear(NativeImage img) {
        int color = 0xFFFFFFFF;
        fill(img, 16, 32, 32, 16, color); // simple white box
    }

    private static void drawFemaleUnderwear(NativeImage img) {
        int bra = 0xFFFFB6C1; // pink
        int slipper = 0xFF808080; // gray for slippers
        fill(img, 16, 32, 32, 16, bra); // bra area
        fill(img, 16, 48, 32, 16, slipper); // slippers
    }
}
