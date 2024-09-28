package io.github.elfarsif.model;

public class Player {
    PlayableCharacter playableCharacter;

    public void setPlayableCharacter(PlayableCharacter playableCharacter) {
        this.playableCharacter = playableCharacter;
    }

    public PlayableCharacter getPlayableCharacter() {
        return this.playableCharacter;
    }
}
