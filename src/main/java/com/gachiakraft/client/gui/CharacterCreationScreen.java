package com.gachiakraft.client.gui;

import com.gachiakraft.client.customization.CustomizationData;
import com.gachiakraft.client.customization.CustomizationManager;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/**
 * Simple screen that lets the player choose basic appearance options.
 */
public class CharacterCreationScreen extends Screen {
    public CharacterCreationScreen() {
        super(Component.literal("Character Creation"));
    }

    @Override
    protected void init() {
        CustomizationData data = CustomizationManager.get();
        int y = this.height / 4;
        addRenderableWidget(Button.builder(Component.literal("Gender: " + data.getGender()), b -> {
            data.setGender(data.getGender() == CustomizationData.Gender.MALE ? CustomizationData.Gender.FEMALE : CustomizationData.Gender.MALE);
            b.setMessage(Component.literal("Gender: " + data.getGender()));
        }).bounds(this.width / 2 - 100, y, 200, 20).build());

        y += 24;
        addRenderableWidget(Button.builder(Component.literal("Hair: " + data.getHairStyle()), b -> {
            data.setHairStyle(data.getHairStyle() == CustomizationData.HairStyle.SHORT ? CustomizationData.HairStyle.LONG : CustomizationData.HairStyle.SHORT);
            b.setMessage(Component.literal("Hair: " + data.getHairStyle()));
        }).bounds(this.width / 2 - 100, y, 200, 20).build());

        y += 24;
        addRenderableWidget(Button.builder(Component.literal("Hair Color: " + data.getHairColor()), b -> {
            data.setHairColor(data.getHairColor() == CustomizationData.HairColor.BLACK ? CustomizationData.HairColor.BLONDE : CustomizationData.HairColor.BLACK);
            b.setMessage(Component.literal("Hair Color: " + data.getHairColor()));
        }).bounds(this.width / 2 - 100, y, 200, 20).build());

        y += 24;
        addRenderableWidget(Button.builder(Component.literal("Eye Color: " + data.getEyeColor()), b -> {
            data.setEyeColor(data.getEyeColor() == CustomizationData.EyeColor.BLUE ? CustomizationData.EyeColor.GREEN : CustomizationData.EyeColor.BLUE);
            b.setMessage(Component.literal("Eye Color: " + data.getEyeColor()));
        }).bounds(this.width / 2 - 100, y, 200, 20).build());

        y += 30;
        addRenderableWidget(Button.builder(Component.literal("Done"), b -> this.onClose())
                .bounds(this.width / 2 - 100, y, 200, 20).build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
    }
}
