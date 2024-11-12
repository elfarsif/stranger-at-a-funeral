package io.github.elfarsif.character;

import io.github.elfarsif.Map;
import io.github.elfarsif.Wall;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private static final String STANDING_TEXTURE_1 = "mainCharacter/standing1.png";
    private static final String STANDING_TEXTURE_2 = "mainCharacter/standing2.png";
    private static final String STANDING_TEXTURE_3 = "mainCharacter/standing3.png";
    private static final String STANDING_TEXTURE_4 = "mainCharacter/standing4.png";
    private static final String STANDING_TEXTURE_5 = "mainCharacter/standing5.png";
    private static final String STANDING_TEXTURE_6 = "mainCharacter/standing6.png";

    CharacterState characterState;
    List<String> textures;
    int currentTextureIndex;
    int x,y;
    boolean isCollidingRight;
    boolean isCollidingLeft;
    boolean isCollidingTop;
    boolean isCollidingBottom;
    Map map;



    public Character(Map map){
        this.characterState = CharacterState.STANDING;
        initializeTextures();
        this.map = map;
    }

    public void initializeTextures() {
        textures = new ArrayList<>();
        textures.add(STANDING_TEXTURE_1);
        textures.add(STANDING_TEXTURE_2);
        textures.add(STANDING_TEXTURE_3);
        textures.add(STANDING_TEXTURE_4);
        textures.add(STANDING_TEXTURE_5);
        textures.add(STANDING_TEXTURE_6);
    }

    public void updateTexture() {
        if (currentTextureIndex == textures.size() - 1) {
            currentTextureIndex = 0;
        }else{
            currentTextureIndex++;
        }
    }

    public void move(String direction) {
        if (direction.equals("right") && !isCollidingRight) {
            x++;
            isCollidingLeft = false;
        } else if (direction.equals("left") && !isCollidingLeft && checkCharacterIsWithinMapBounds("left")) {
            x--;
            isCollidingRight = false;
        }else if (direction.equals("up")) {
            y++;
        }else if (direction.equals("down")) {
            y--;
        }

    }

    private boolean checkCharacterIsWithinMapBounds(String direction) {
        boolean isWithinMapBounds = true;
        if (direction.equals("left")) {
            isWithinMapBounds = map.isValidPosition(x-1,y);

        }
        return isWithinMapBounds;
    }

    public boolean verifyCollisionRight(Wall wall) {
        if(wall.getPosition()[0] == x+1 && wall.getPosition()[1] == y){
            isCollidingRight = true;
        }
        return isCollidingRight;
    }

    public boolean verifyCollisionLeft(Wall wall) {
        if(wall.getPosition()[0] == x-1 && wall.getPosition()[1] == y){
            isCollidingLeft = true;
        }
        return isCollidingLeft;
    }

    public boolean verifyCollisionTop(Wall wall) {
        if(wall.getPosition()[0] == x && wall.getPosition()[1] == y+1){
            isCollidingTop = true;
        }
        return isCollidingTop;
    }

    public CharacterState getCharacterState() {
        return this.characterState;
    }

    public void setCharacterState(CharacterState characterState) {
        checkCharacterStateIsntNull(characterState);
        this.characterState = characterState;
    }

    private void checkCharacterStateIsntNull(CharacterState characterState) {
        if (characterState == null) {
            throw new IllegalArgumentException("Character State cannot be null");
        }
    }

    public String getCurrentTextureFileName() {
        return textures.get(currentTextureIndex);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getPosition() {
        return new int[]{x, y};
    }

    public boolean isCollidingRight() {
        return isCollidingRight;
    }

    public boolean isCollidingLeft() {
        return isCollidingLeft;
    }

    public boolean isCollidingTop() {
        return isCollidingTop;
    }

    public boolean verifyCollisionBottom(Wall wall) {
        if(wall.getPosition()[0] == x && wall.getPosition()[1] == y-1){
            isCollidingBottom = true;
        }
        return isCollidingBottom;
    }

    public boolean isCollidingBottom() {
        return isCollidingBottom;
    }

    public Map getMap() {
        return map;
    }
}
