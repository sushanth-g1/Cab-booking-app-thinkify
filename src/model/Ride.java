package model;

public class Ride {
    public String driverName;
    public int[] source;
    public int[] destination;
    public boolean available;
    public Ride(String driverName,int[] source, int[] destination, boolean available){
        this.available = available;
        this.destination = destination;
        this.driverName = driverName;
        this.source = source;
    }
}
