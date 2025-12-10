package org.cencora;

import java.util.List;
import java.util.Optional;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tickets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TicketResource {

    @Inject
    TicketService ticketService;

    @GET
    @Path("/get")
    public Response getAllTickets() {
        List<Ticket> list = ticketService.getAllTickets();
        return Response.ok(list).build();
    }

    @GET
    @Path("/get/{id}")
    public Response getTicketById(@PathParam("id") Integer id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        if (ticket.isPresent()) {
            return Response.ok(ticket.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/post")
    @Transactional
    public Response saveTicket(Ticket ticket) {
        return Response.ok(ticketService.saveTicket(ticket)).build();
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    public Response updateTicket(@PathParam("id") Integer id, Ticket updatedTicket) {
        Ticket updated = ticketService.updateTicket(id, updatedTicket);
        if (updated == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deleteTicket(@PathParam("id") Integer id) {
        boolean deleted = ticketService.deleteTicket(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok("Ticket deleted with id: " + id).build();
    }
}
