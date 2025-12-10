package org.cencora;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    private Integer id;
    private String issue;
    private LocalDate raisedon;

    public Ticket() {}

    public Ticket(int id, String issue, LocalDate raisedon) {
        this.id = id;
        this.issue = issue;
        this.raisedon = raisedon;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getIssue() { return issue; }
    public void setIssue(String issue) { this.issue = issue; }

    public LocalDate getRaisedon() { return raisedon; }
    public void setRaisedon(LocalDate raisedon) { this.raisedon = raisedon; }

    @Override
    public String toString() {
        return "Ticket [id=" + id + ", issue=" + issue + ", raisedon=" + raisedon + "]";
    }
}
