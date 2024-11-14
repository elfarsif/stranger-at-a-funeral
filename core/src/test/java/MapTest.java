import io.github.elfarsif.game.Map;
import io.github.elfarsif.game.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapTest {
    Map map = new Map();

    @BeforeEach
    void setUp(){
        map = new Map();
    }

    @Test
    void givenIHaveNoMapWhenICreateAMap(){
        thenTheMapHasAGrid();
        theGridHasAHeightOf20WidthOf30();
    }

    private void thenTheMapHasAGrid() {
        assertThat(map.getGrid()).isNotNull();
    }

    private void theGridHasAHeightOf20WidthOf30() {
        assertThat(map.getGrid().length).isEqualTo(20);
        assertThat(map.getGrid()[0].length).isEqualTo(30);
    }

    @Test
    void mapGridIsAnArrayOfTilesObjects(){
        assertThat(map.getGrid()).isInstanceOf(Tile[][].class);
    }

    @Test
    void theMapIsFullOfEmptyTiles(){
        for(int i = 0; i < map.getGrid().length; i++){
            for(int j = 0; j < map.getGrid()[0].length; j++){
                assertThat(map.getGrid()[i][j]).isInstanceOf(Tile.class);
            }
        }
    }

    @Test
    void addTextureToMapTile(){
        map.addTextureToMapTile(0,0, "floor.png");
        assertThat(map.getGrid()[0][0].getTextureFileLocation())
            .isEqualTo("floor.png");
    }

}
