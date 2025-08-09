package com.gachiakraft.client.customization;

/**
 * Simple client-side storage for customization data.
 */
public class CustomizationManager {
    private static final CustomizationData DATA = new CustomizationData();

    public static CustomizationData get() {
        return DATA;
    }
}
