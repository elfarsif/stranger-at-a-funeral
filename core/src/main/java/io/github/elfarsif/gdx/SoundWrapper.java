package io.github.elfarsif.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;


public class SoundWrapper {

    Sound currentSound;
    Sound sounds[] = new Sound[10];
    int volumeScale = 3; // 0 to 5
    float volume;

    public SoundWrapper(){
        sounds[0] = Gdx.audio.newSound(Gdx.files.internal("sounds/acoustic-lofi.wav"));
        sounds[1] = (Sound) Gdx.audio.newSound(Gdx.files.internal("sounds/chopping-wood.wav"));
        sounds[2] = (Sound) Gdx.audio.newSound(Gdx.files.internal("sounds/inventory-cursor.wav"));
        sounds[3] = (Sound) Gdx.audio.newSound(Gdx.files.internal("sounds/sword-sound.wav"));

        checkVolume();

    }

    public void checkVolume(){
        switch (volumeScale) {
            case 0:
                volume = 0.0f;
                break;
            case 1:
                volume = 0.25f;
                break;
            case 2:
                volume = 0.4f;
                break;
            case 3:
                volume = 0.6f;
                break;
            case 4:
                volume = 0.8f;
                break;
            case 5:
                volume = 1.0f;
                break;
            default:
                volume = 0.6f;
        }
    }

    public void setFile(int i){
        currentSound = sounds[i];
    }

    public void play(){
        currentSound.play(volume);
    }

    public void stop(){
        currentSound.stop();
    }

    public void loop(){
        long id = currentSound.loop();
        currentSound.setVolume(id,volume);
    }

}
