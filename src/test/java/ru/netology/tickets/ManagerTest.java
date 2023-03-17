package ru.netology.tickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    Ticket item1 = new Ticket(1, 1000, "AAZ", "ABQ", 50);
    Ticket item2 = new Ticket(2, 2000, "AAZ", "ABQ", 120);
    Ticket item3 = new Ticket(3, 500, "FAZ", "MMQ", 50);
    Ticket item4 = new Ticket(4, 1500, "KLZ", "ADL", 150);
    Ticket item5 = new Ticket(5, 12_000, "AAZ", "ABQ", 400);
    Ticket item6 = new Ticket(6, 12_000, "AAZ", "ABQ", 400);
    Ticket item7 = new Ticket(7, 12_000, "AAZ", "ABX", 400);

    @Test
    public void addTicketTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.addTicket(item1);

        Ticket[] expected = {item1};
        Ticket[] actual = manager.findALl("AAZ", "ABQ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllTicketTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.addTicket(item1);
        manager.addTicket(item2);
        manager.addTicket(item3);

        Ticket[] expected = {item1, item2};
        Ticket[] actual = manager.findALl("AAZ", "ABQ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllTicketCheckSortTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.addTicket(item5);
        manager.addTicket(item3);
        manager.addTicket(item4);
        manager.addTicket(item2);
        manager.addTicket(item1);

        Ticket[] expected = {item1, item2, item5};
        Ticket[] actual = manager.findALl("AAZ", "ABQ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllTicketSortWithEqualTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.addTicket(item1);
        manager.addTicket(item2);
        manager.addTicket(item3);
        manager.addTicket(item4);
        manager.addTicket(item5);
        manager.addTicket(item6);
        manager.addTicket(item7);

        Ticket[] expected = {item1, item2, item5, item6};
        Ticket[] actual = manager.findALl("AAZ", "ABQ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllTicketCheckNotFoundTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.addTicket(item1);
        manager.addTicket(item2);
        manager.addTicket(item3);
        manager.addTicket(item4);
        manager.addTicket(item5);

        Ticket[] expected = {};
        Ticket[] actual = manager.findALl("AAA", "BBB");

        Assertions.assertArrayEquals(expected, actual);
    }
}
