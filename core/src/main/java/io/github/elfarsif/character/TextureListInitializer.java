package io.github.elfarsif.character;

import com.badlogic.gdx.graphics.Texture;
import io.github.elfarsif.Ressource;

import java.util.ArrayList;
import java.util.List;

public class TextureListInitializer {
    List<Texture> texturesStanding;
    List<Texture> texturesWalking;
    List<Texture> texturesWalkingUp;
    List<Texture> texturesWalkingRight;
    Ressource res;

    public TextureListInitializer() {
        res = new Ressource();
        setStandingTextures();
        setWalkingDownTextures();
        setWalkingUpTextures();
        setWalkingRightTextures();
    }

    private void setWalkingRightTextures() {
        this.texturesWalkingRight = new ArrayList<>();
        texturesWalkingRight.add(res.getWalkingRight1());
        texturesWalkingRight.add(res.getWalkingRight2());
        texturesWalkingRight.add(res.getWalkingRight3());
        texturesWalkingRight.add(res.getWalkingRight4());
        texturesWalkingRight.add(res.getWalkingRight5());
        texturesWalkingRight.add(res.getWalkingRight6());
    }

    private void setWalkingUpTextures() {
        this.texturesWalkingUp = new ArrayList<>();
        texturesWalkingUp.add(res.getMainWalkingUp1());
        texturesWalkingUp.add(res.getMainWalkingUp2());
        texturesWalkingUp.add(res.getMainWalkingUp3());
        texturesWalkingUp.add(res.getMainWalkingUp4());
        texturesWalkingUp.add(res.getMainWalkingUp5());
        texturesWalkingUp.add(res.getMainWalkingUp6());

    }

    private void setWalkingDownTextures() {
        this.texturesWalking = new ArrayList<>();
        texturesWalking.add(res.getMainWalkingDown1());
        texturesWalking.add(res.getMainWalkingDown2());
        texturesWalking.add(res.getMainWalkingDown3());
        texturesWalking.add(res.getMainWalkingDown4());
        texturesWalking.add(res.getMainWalkingDown5());
        texturesWalking.add(res.getMainWalkingDown6());
    }

    private void setStandingTextures() {
        this.texturesStanding = new ArrayList<>();
        texturesStanding.add(res.getMainDownStanding1());
        texturesStanding.add(res.getMainDownStanding2());
        texturesStanding.add(res.getMainDownStanding3());
        texturesStanding.add(res.getMainDownStanding4());
        texturesStanding.add(res.getMainDownStanding5());
        texturesStanding.add(res.getMainDownStanding6());
    }
}
