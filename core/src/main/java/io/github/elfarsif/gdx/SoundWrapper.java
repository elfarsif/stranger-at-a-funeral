package io.github.elfarsif.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;


public class SoundWrapper {

    Sound currentSound;
    Sound sounds[] = new Sound[3];


    public SoundWrapper(){
        sounds[0] = Gdx.audio.newSound(Gdx.files.internal("sounds/lofi.wav"));
        sounds[1] = (Sound) Gdx.audio.newSound(Gdx.files.internal("sounds/chopping-wood.wav"));
    }

    public void setFile(int i){
        currentSound = sounds[i];
    }

    public void play(){
        currentSound.play();
    }

    public void stop(){
        currentSound.stop();
    }

    public void loop(){
        currentSound.loop();
    }

}
