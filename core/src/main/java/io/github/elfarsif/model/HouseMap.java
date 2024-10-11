package io.github.elfarsif.model;

public class HouseMap implements Map{
    @Override
    public String getAssetFileName() {
        return "tilemaps/main_house_interior.tmx" ;
    }

    @Override
    public void addCharacter(Character character) {
        character.setX((float) 7.5*16);
        character.setY((float) 5*16);
    }
}
