package io.github.elfarsif.model;

import java.util.ArrayList;
import java.util.List;

public class PlayableCharacter {
    List<String> assetFiles;
    int currentAssetIndex = 0;

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

    private void updateToFirstAsset() {
        currentAssetIndex = 0;
    }

    private boolean assetIsLastInList() {
        return currentAssetIndex== assetFiles.size() - 1;
    }

    public void setCurrentAsserIndex(String assetFileName) {
        currentAssetIndex = assetFiles.indexOf(assetFileName);
    }
}
