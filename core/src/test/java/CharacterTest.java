import io.github.elfarsif.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import io.github.elfarsif.game.character.Character;
import io.github.elfarsif.game.character.CHARACTER_STATE;
import io.github.elfarsif.game.MapObject;

public class CharacterTest {
    Character character = new Character();

    @BeforeEach
    void setUp(){
        character = new Character();
    }

    @Test
    void characterIsStandingByDefault(){
        assertThat(character.getState()).isEqualTo(CHARACTER_STATE.STANDING);
    }

    @Test
    void characterStartsAtPositionBottomLeftCorner(){
        Position expectedPosition = new Position(0, 0);
        assertThat(character.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void characterMovesUp(){
        character.moveUp();
        Position expectedPosition = new Position(0, 1);
        assertThat(character.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void characterMovesDown(){
        character.moveDown();
        Position expectedPosition = new Position(0, -1);
        assertThat(character.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void characterMovesLeft(){
        character.moveLeft();
        Position expectedPosition = new Position(-1, 0);
        assertThat(character.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void characterMovesRight(){
        character.moveRight();
        Position expectedPosition = new Position(1, 0);
        assertThat(character.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void characterHitsMapObject(){
        MapObject object = new MapObject();
        object.setPosition(0, 1);
        character.setPosition(0,1);
        assertThat(character.hitsObject(object)).isTrue();
    }

    @Test
    void characterDoesNotHitMapObject(){
        MapObject object = new MapObject();
        object.setPosition(0, 1);
        character.setPosition(0,0);
        assertThat(character.hitsObject(object)).isFalse();
    }

    @Test
    void characterHasStandingTextureFileNameByDefault(){
        String actualTextureFileName = character.getCurrentTextureFileLocation();
        assertThat(actualTextureFileName).isEqualTo("character/standing1.png");
    }

}
