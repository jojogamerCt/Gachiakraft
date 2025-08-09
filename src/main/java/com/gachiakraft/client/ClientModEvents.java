package com.gachiakraft.client;

import com.gachiakraft.Gachiakraft;
import com.gachiakraft.client.gui.CharacterCreationScreen;
import com.gachiakraft.client.render.CustomPlayerRenderer;
import com.gachiakraft.client.model.CustomPlayerModel;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

/**
 * Handles client-side registrations and events.
 */
@Mod.EventBusSubscriber(modid = Gachiakraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    public static KeyMapping OPEN_SCREEN;

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        OPEN_SCREEN = new KeyMapping("key.gachiakraft.customize", GLFW.GLFW_KEY_C, "key.categories.misc");
        event.register(OPEN_SCREEN);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityType.PLAYER, ctx -> new CustomPlayerRenderer(ctx, false));
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CustomPlayerModel.LAYER_LOCATION, CustomPlayerModel::createBodyLayer);
    }
}

@Mod.EventBusSubscriber(modid = Gachiakraft.MODID, value = Dist.CLIENT)
class ClientForgeEvents {
    @SubscribeEvent
    public static void onKey(InputEvent.Key event) {
        if (ClientModEvents.OPEN_SCREEN != null && ClientModEvents.OPEN_SCREEN.consumeClick()) {
            Minecraft.getInstance().setScreen(new CharacterCreationScreen());
        }
    }
}
