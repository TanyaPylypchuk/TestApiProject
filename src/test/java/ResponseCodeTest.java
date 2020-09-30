import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;


//import static io.restassured.RestAssured.when;


public class ResponseCodeTest {
    @Test
    public void testResponseCode() {

                when().
                get(" http://ip.jsontest.com/").
                then().
                assertThat().
                statusCode(200);
    }
}
