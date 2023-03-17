package ru.netology.tickets;

import java.util.Arrays;
import java.util.Comparator;

public class Manager {

    Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void addTicket(Ticket ticket) {
        repository.addTicket(ticket);
    }

    public Ticket[] findALl(String from, String to) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repository.getAll()) {

            if (ticket.getDepartureAirport() == from && ticket.getDestinationAirport() == to) {
                Ticket[] tmp = new Ticket[result.length + 1];

                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }

        Arrays.sort(result);
        return result;
    }

    public Ticket[] findALl(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repository.getAll()) {

            if (ticket.getDepartureAirport() == from && ticket.getDestinationAirport()== to) {
                Ticket[] tmp = new Ticket[result.length + 1];

                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }

        Arrays.sort(result, comparator);
        return result;
    }
}
