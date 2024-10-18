package acceptanceTests;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterTest {

    @DisplayName("Single test successful")
    @Test
    public void testSingleSuccessTest() {
        assertThat(1).isEqualTo(1);
    }

    @DisplayName(" daaaaaatest successful")
    @Test
    public void test2() {
        assertThat(1).isEqualTo(1);
    }


}
