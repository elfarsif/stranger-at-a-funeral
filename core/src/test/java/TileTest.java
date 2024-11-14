import io.github.elfarsif.game.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TileTest {
    Tile tile;

    @BeforeEach
    void setUp(){
        tile = new Tile();
    }

    @Test
    void tileAreEmptyByDefault(){
        assertThat(tile.getTextureFileLocation())
            .isEqualTo(null);
    }

    @Test
    void setTileTextureTest(){
        tile.setTextureFileLocation("floor.png");
        assertThat(tile.getTextureFileLocation())
            .isEqualTo("floor.png");
    }

    @Test
    void changeTextureFilename(){
        tile.setTextureFileLocation("floor.png");
        tile.setTextureFileLocation("wall.png");
        assertThat(tile.getTextureFileLocation())
            .isEqualTo("wall.png");
    }



}
