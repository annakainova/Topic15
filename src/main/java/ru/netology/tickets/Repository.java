package ru.netology.tickets;

public class Repository {

    Ticket[] tickets = new Ticket[0];

    public Ticket[] getAll() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];

        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void deleteTicket(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length - 1];

        int i = 0;
        for (Ticket t : tickets) {
            if (t.id != ticket.id) {
                tmp[i] = t;
                i++;
            }
        }
        tickets = tmp;
    }
}
