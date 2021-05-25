import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;


//import static io.restassured.RestAssured.when;


public class ResponseCodeTest {
    @Test
    public void testResponseCode() {
        String s= System.getProperty("BASE_URL");
        String k= System.getenv("BASE_URL");
          System.out.println("PROPERTY: " + s);
         System.out.println("ENV: " + k);
                when().
                get(s).
                then().
                assertThat().
                statusCode(200);
    }
}
