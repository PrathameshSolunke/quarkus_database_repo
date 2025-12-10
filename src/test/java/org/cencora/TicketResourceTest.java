package org.cencora;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class TicketResourceTest {

    @Test
    void testCreateTicket() {
        Ticket testTicket = new Ticket(201, "Create test", LocalDate.now());
        Ticket actual =
                given()
                        .contentType("application/json")
                        .body(testTicket)
                        .when()
                        .post("/tickets/post")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(Ticket.class);
        assertEquals(testTicket.getId(), actual.getId());
    }

    @Test
    void testGetAllTickets() {
        List<Ticket> tickets =
                given()
                        .when().get("/tickets/get")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(new TypeRef<List<Ticket>>() {});
        assertTrue(tickets.size() >= 1);
    }

    @Test
    void testGetTicketById() {
        Ticket expected = new Ticket(202, "Find by ID test", LocalDate.now());
        given()
                .contentType("application/json")
                .body(expected)
                .when()
                .post("/tickets/post")
                .then()
                .statusCode(200);

        Ticket actual =
                given()
                        .when().get("/tickets/get/202")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(Ticket.class);
        assertEquals(expected.getId(), actual.getId());
    }

    @Test
    void testUpdateTicket() {
        Ticket original = new Ticket(203, "Original issue", LocalDate.now());
        given()
                .contentType("application/json")
                .body(original)
                .when()
                .post("/tickets/post")
                .then()
                .statusCode(200);

        Ticket updated = new Ticket(203, "Updated issue", LocalDate.now());
        Ticket actual =
                given()
                        .contentType("application/json")
                        .body(updated)
                        .when()
                        .put("/tickets/update/203")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(Ticket.class);
        assertEquals("Updated issue", actual.getIssue());
    }

    @Test
    void testDeleteTicket() {
        Ticket toDelete = new Ticket(204, "Delete test", LocalDate.now());
        given()
                .contentType("application/json")
                .body(toDelete)
                .when()
                .post("/tickets/post")
                .then()
                .statusCode(200);

        given()
                .when().delete("/tickets/delete/204")
                .then()
                .statusCode(200);
    }
}
