//package org.cencora;
//
//import io.quarkus.test.junit.QuarkusTest;
//import org.junit.jupiter.api.Test;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.is;
//
//@QuarkusTest
//class GreetingResourceTest {
//    @Test
//    void testHelloEndpoint() {
//        given()
//          .when().get("/hello")
//          .then()
//             .statusCode(200)
//             .body(is("Hello from Quarkus REST"));
//    }
//
//}

package org.cencora;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class GreetingResourceTest {

//    @Test
//    void testHelloEndpoint() {
//        given()
//                .when().get("/hello")
//                .then()
//                .statusCode(200)
//                .body(is("Hello from Quarkus REST"));
//    }
//
//    @Test
//    void testMeetingGreeting() {
//        GreetingService greetingService = new GreetingService();
//        String response = greetingService.meetingGreeting("John");
//        assertEquals("Hello John Welcome", response);
//
//    }
//    @Test
//    void  testMeetupGreeting(){
//        GreetingService greetingService=new GreetingService();
//        String response=greetingService.meetupGreeting("John");
//        assertEquals("Hello  John Welcome",response);
//    }
//    @Test
//    void testDateTime(){
//        given()
//                .when().get("/greeting/datetime");
//        .then()
//                .statusCode(200)
//                .body(is(LocalDate.now()))
//
//
//    }


}

