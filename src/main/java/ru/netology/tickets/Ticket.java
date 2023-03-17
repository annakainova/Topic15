package ru.netology.tickets;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String departureAirport;
    private String destinationAirport;
    private int time; // in min

    public Ticket(int id, int price, String departureAirport, String destinationAirport, int time) {
        this.id = id;
        this.price = price;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}
