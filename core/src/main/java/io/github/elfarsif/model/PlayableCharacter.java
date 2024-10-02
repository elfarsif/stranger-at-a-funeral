package io.github.elfarsif.model;

import java.util.ArrayList;
import java.util.List;

public class PlayableCharacter {
    List<String> assetFiles;
    int currentAssetIndex = 0;
    float timeAccumulator = 0f;
    float frameDuration = 0.15f;

    public PlayableCharacter() {
        assetFiles = new ArrayList<>();
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

}
