package ASTC;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Clock;
import java.time.ZoneId;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Task extends AirplaneRelatedTask implements Serializable {



    public Task(String name, String id, String passengerCount, String landingType, String flightType, String source) {
        this.ID = id;
        this.source = source;
        aeroplaneName = name;
        this.passengerCount = passengerCount;
        this.landingType = landingType;
        this.flightType = flightType;
    }


    public Task(String ID, String source, String destination, String passengerCount, String time, String priority, String aeroplaneName, String selectClass, String departureDate) {
        this.ID = ID;
        this.passengerCount = passengerCount;
        this.time = time;
        this.priority = priority;
        this.source = source;
        this.destination = destination;
        ShortestPath sp = new ShortestPath(source, destination);
        this.shortestPath = sp.getShortestPathCost();
        this.aeroplaneName = aeroplaneName;
        this.selectClass = selectClass;
        this.departureDate = departureDate;
    }

    private String source;
    private String aeroplaneName;
    private String ID;
    private String passengerCount;
    private String priority;


    public String getLandingType() {
        return landingType;
    }

    String landingType;
    String flightType;

    private String time;
    private String destination;
    private FlightTime Flight_time;
    private String shortestPath;
    private String selectClass;
    private String departureDate;

    public String getShortestPath() {
        return shortestPath;
    }

    public String getSelectClass() {
        return selectClass;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        destination = destination;
    }

    public String getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(String passengerCount) {
        this.passengerCount = passengerCount;
    }

    public FlightTime getFlight_time() {
        return Flight_time;
    }

    public void setFlight_time(FlightTime flight_time) {
        Flight_time = flight_time;
    }


    public String getAeroplaneName() {
        return aeroplaneName;
    }

    public void setAeroplaneName(String aeroplaneName) {
        aeroplaneName = aeroplaneName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }


    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public void setShortestPath(String shortestPath) {
        this.shortestPath = shortestPath;
    }










}
