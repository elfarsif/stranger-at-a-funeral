package io.github.elfarsif.model;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Game {
    Player player;
    Map map;
    public boolean isMoving = false;

    public Game(Player player, Map map) {
        this.player = player;
        this.map = map;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void moveUp(Sprite sprite) {
        sprite.translateY(1);
        PlayableCharacter playableCharacter = player.getPlayableCharacter();
        playableCharacter.updateTextureWalkingUp();
        isMoving = true;
    }

    public Map getMap() {
        return this.map;
    }

    public void moveDown(Sprite sprite) {
        sprite.translateY(-1);
        this.player.getPlayableCharacter().updateTextureWalkingDown();
        isMoving = true;
    }

    public void moveLeft(Sprite sprite) {
        sprite.translateX(-1);
        this.player.getPlayableCharacter().updateTextureWalkingLeft();
        isMoving = true;
    }

    public void moveRight(Sprite sprite) {
        sprite.translateX(1);
        PlayableCharacter playableCharacter = player.getPlayableCharacter();
        playableCharacter.updateTextureWalkingRight();
        isMoving = true;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void stopMoving(){
        if(!isMoving){
            player.getPlayableCharacter().updateTextureStanding();
        }
    }

    public void setCharacterInHouse() {
        player.getPlayableCharacter().setX((float) 7.5*16);
        player.getPlayableCharacter().setY((float) 5*16);
    }
}
