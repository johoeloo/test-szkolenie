import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//library JUnit do pom  https://mvnrepository.com/
//annotations https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations
public class JunitTest {
    private static final String STRING_TEST = "stringTestowy";

    @BeforeAll
    public static void beforeAll() {
        System.out.println("=====beforeAll======");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("=====afterAll======");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("=====beforeEach======");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("=====afterEach======");
    }

    //mvn clean test -Dgroups="(!zadania | string)" <-- selects specific test
    @Disabled("disabled because of jira case 123")
    @RepeatedTest(5) //repeat 5 times
    @Test
    @Tags({@Tag("tag1"), @Tag("tag2")}) //can be run by tag
    @DisplayName("here we can put name")
    public void firstTest() {
        assertEquals(2+3,5);
        assertNotEquals(2+2,5);
        assertTrue(STRING_TEST.contains("st"));
        assertTrue(STRING_TEST.endsWith("wy"));
        assertEquals(STRING_TEST,"stringTestowy");
    }

    @Test
    public void junitTest() {
        //Double - problem with round, for money use BigDecimal
        //System.out.println(0.2*0.2);
        //assertEquals(0.2*0.2, 0.04);

        double result = new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue();
        assertEquals(result, 0.04);
    }

    @Test
    public void stringTest() {
        //Double - problem with round, for money use BigDecimal
        //System.out.println(0.2*0.2);
        //assertEquals(0.2*0.2, 0.04);

        String simple = "simpleString";
        String simpleString = "simpleString";

        String simpleString2 = new String("simpleString");
        String simpleString3 = new String("simpleString");

        assertSame("simpleString", simpleString);
        assertSame(simple, simpleString);
        //assertSame(simpleString, simpleString2);
        //assertSame(simpleString2, simpleString3);

        // for strings always use equals
        assertTrue(simpleString == simple);
        //assertTrue(simpleString == simpleString3);
    }

    @Test
    public void googleTruthTest() {
        assertThat(STRING_TEST).contains("ingT");
    }


    @Test
    @DisplayName("zadanie1")
    public void zadanie() {
        String resultString = "Wordpress powers 34% of the internet";
        assertThat(resultString).startsWith("Wordpress powers ");
        assertThat(resultString).endsWith("% of the internet");
        String result = resultString.replaceAll("[^\\d.]", "");
        assertThat(result).matches("^\\d+$");
        Integer resultInt = Integer.valueOf(resultString.replaceAll("[^\\d.]", ""));
        assertTrue(resultInt<100);
        assertTrue(resultInt>0);
    }

    @Tags({@Tag("nested"), @Tag("junit")})
    @DisplayName("Nested")
    @Nested
    public class NestedTest {

        @Order(2)
        @DisplayName("List test")
        @Test
        public void listTest() {
            List<Integer> result = Arrays.asList(1,2,3,4,5);
            List<Integer> expected = Arrays.asList(3,4,5);

            assertThat(result).containsAnyIn(expected);
            assertTrue(result.containsAll(expected));
            assertThat(result).hasSize(5);
            assertThat(result).containsAnyOf(1,2);

        }
        @Order(1)
        @DisplayName("Exception test")
        @Test
        public void exceptionTest() {

            GamePlay gamePlay = new GamePlay();
            Assertions.assertThrows(IllegalArgumentException.class, () -> gamePlay.play(0));
        }
    }
}
