package io.github.elfarsif.model;

import java.util.ArrayList;
import java.util.List;

public class PlayableCharacter {
    List<String> assetFiles;
    int currentAssetIndex = 0;
    float timeAccumulator = 0f;
    float frameDuration = 0.15f;
    float X = 0f;
    float Y = 0f;

    public PlayableCharacter() {
        assetFiles = new ArrayList<>();
        updateTextureStanding();
    }

    public void updateTextureStanding() {
        assetFiles.clear();
        assetFiles.add("mainCharacter/playerDownStanding1.png");
        assetFiles.add("mainCharacter/playerDownStanding2.png");
        assetFiles.add("mainCharacter/playerDownStanding3.png");
        assetFiles.add("mainCharacter/playerDownStanding4.png");
        assetFiles.add("mainCharacter/playerDownStanding5.png");
        assetFiles.add("mainCharacter/playerDownStanding6.png");
    }

    public String getCurrentAssetFileName() {
        return assetFiles.get(currentAssetIndex);
    }

    public void updateTexture() {
        if(assetIsLastInList()){
            updateToFirstAsset();
        }else{
            currentAssetIndex++;
        }
    }

    public void updateTexture(float delta){
        timeAccumulator += delta;
        if(timeAccumulator > frameDuration){
            updateTexture();
            timeAccumulator = 0;
        }
    }

    private void updateToFirstAsset() {
        currentAssetIndex = 0;
    }

    private boolean assetIsLastInList() {
        return currentAssetIndex== assetFiles.size() - 1;
    }

    public void setCurrentAsserIndex(String assetFileName) {
        currentAssetIndex = assetFiles.indexOf(assetFileName);
    }

    public void setTimeAccumulator(float timeAccumulator) {
        this.timeAccumulator = timeAccumulator;
    }

    public void setFrameDuration(float frameDuration) {
        this.frameDuration = frameDuration;
    }

    public float getTimeAccumulator() {
        return timeAccumulator;
    }

    public void updateTextureWalkingRight(){
        assetFiles.clear();
        assetFiles.add("mainCharacter/walkingRight/right1.png");
        assetFiles.add("mainCharacter/walkingRight/right2.png");
        assetFiles.add("mainCharacter/walkingRight/right3.png");
        assetFiles.add("mainCharacter/walkingRight/right4.png");
        assetFiles.add("mainCharacter/walkingRight/right5.png");
        assetFiles.add("mainCharacter/walkingRight/right6.png");
    }

    public List<String> getAssetFiles() {
        return assetFiles;
    }

    public void updateTextureWalkingUp(){
        assetFiles.clear();
        assetFiles.add("mainCharacter/walkingUp/up1.png");
        assetFiles.add("mainCharacter/walkingUp/up2.png");
        assetFiles.add("mainCharacter/walkingUp/up3.png");
        assetFiles.add("mainCharacter/walkingUp/up4.png");
        assetFiles.add("mainCharacter/walkingUp/up5.png");
        assetFiles.add("mainCharacter/walkingUp/up6.png");
    }

    public void updateTextureWalkingDown(){
        assetFiles.clear();
        assetFiles.add("mainCharacter/walkingDown/down1.png");
        assetFiles.add("mainCharacter/walkingDown/down2.png");
        assetFiles.add("mainCharacter/walkingDown/down3.png");
        assetFiles.add("mainCharacter/walkingDown/down4.png");
        assetFiles.add("mainCharacter/walkingDown/down5.png");
        assetFiles.add("mainCharacter/walkingDown/down6.png");
    }

    public void updateTextureWalkingLeft(){
        assetFiles.clear();
        assetFiles.add("mainCharacter/walkingLeft/left1.png");
        assetFiles.add("mainCharacter/walkingLeft/left2.png");
        assetFiles.add("mainCharacter/walkingLeft/left3.png");
        assetFiles.add("mainCharacter/walkingLeft/left4.png");
        assetFiles.add("mainCharacter/walkingLeft/left5.png");
        assetFiles.add("mainCharacter/walkingLeft/left6.png");
    }

    public float getX() {
        return X;
    }

    public void setX(float x) {
        this.X = x;
    }

    public float getY() {
        return Y;
    }

    public void setY(float Y) {
        this.Y = Y;
    }
}
