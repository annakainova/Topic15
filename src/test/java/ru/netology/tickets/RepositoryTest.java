package ru.netology.tickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    Ticket item1 = new Ticket(1, 1000, "AAZ", "ABQ", 50);
    Ticket item2 = new Ticket(2, 2000, "AQZ", "AGQ", 120);
    Ticket item3 = new Ticket(3, 500, "FAZ", "MMQ", 50);
    Ticket item4 = new Ticket(4, 1500, "KLZ", "ADL", 150);
    Ticket item5 = new Ticket(5, 12_000, "SKZ", "GHW", 400);

    @Test
    public void addTicketTest() {
        Repository repo = new Repository();

        repo.addTicket(item1);

        Ticket[] expected = {item1};
        Ticket[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void checkFindAllTest() {
        Repository repo = new Repository();

        repo.addTicket(item1);
        repo.addTicket(item2);

        Ticket[] expected = {item1, item2};
        Ticket[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void checkDeleteTicketTest() {
        Repository repo = new Repository();

        repo.addTicket(item1);
        repo.addTicket(item2);

        repo.deleteTicket(item1);

        Ticket[] expected = {item2};
        Ticket[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
