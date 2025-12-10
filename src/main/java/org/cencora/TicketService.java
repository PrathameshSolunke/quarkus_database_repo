package org.cencora;

import java.util.List;
import java.util.Optional;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TicketService {

    @Inject
    TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll().list();
    }

    public Optional<Ticket> getTicketById(Integer id) {
        return ticketRepository.findByIdOptional(id);
    }

    @Transactional
    public Ticket saveTicket(Ticket ticket) {
        ticketRepository.persist(ticket);
        return ticket;
    }

    @Transactional
    public Ticket updateTicket(Integer id, Ticket updated) {
        Ticket existing = ticketRepository.findById(id);
        if (existing != null) {
            existing.setIssue(updated.getIssue());
            existing.setRaisedon(updated.getRaisedon());
        }
        return existing;
    }

    @Transactional
    public boolean deleteTicket(Integer id) {
        return ticketRepository.deleteById(id);
    }
}
