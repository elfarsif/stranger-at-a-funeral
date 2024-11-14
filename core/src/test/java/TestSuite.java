import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Test Suite")
@SelectClasses({CharacterTest.class,MapTest.class,TileTest.class})
public class TestSuite {

}
