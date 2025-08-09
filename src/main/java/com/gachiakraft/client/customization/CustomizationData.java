package com.gachiakraft.client.customization;

/**
 * Holds the player's customization choices.
 */
public class CustomizationData {
    public enum Gender { MALE, FEMALE }
    public enum HairStyle { SHORT, LONG }
    public enum HairColor { BLACK, BLONDE }
    public enum EyeColor { BLUE, GREEN }

    private Gender gender = Gender.MALE;
    private HairStyle hairStyle = HairStyle.SHORT;
    private HairColor hairColor = HairColor.BLACK;
    private EyeColor eyeColor = EyeColor.BLUE;

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }
    public HairStyle getHairStyle() { return hairStyle; }
    public void setHairStyle(HairStyle hairStyle) { this.hairStyle = hairStyle; }
    public HairColor getHairColor() { return hairColor; }
    public void setHairColor(HairColor hairColor) { this.hairColor = hairColor; }
    public EyeColor getEyeColor() { return eyeColor; }
    public void setEyeColor(EyeColor eyeColor) { this.eyeColor = eyeColor; }
}
