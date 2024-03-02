package ASTC;

public class FlightTime {
    private int hours;
    private int minutes;
    private int seconds;

    private FlightTime flightStartTime;
    private FlightTime flightEndingTime;

    public FlightTime(String timeString) {

        String[] timeRange = timeString.split("-");
        flightStartTime = parseTime(timeRange[0]);
        flightEndingTime = parseTime(timeRange[1]);
    }
    public FlightTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }



    private FlightTime parseTime(String time) {
        String[] timeParts = time.split(":|\\s");

        int parsedHours = Integer.parseInt(timeParts[0]);
        int parsedMinutes = Integer.parseInt(timeParts[1]);

        FlightTime flighttime = new FlightTime(parsedHours, parsedMinutes, 0);

        return flighttime;
    }






    public String getTime() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }






    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }



    public FlightTime getFlightStartTime() {
        return flightStartTime;
    }

    public void setFlightStartTime(FlightTime flightStartTime) {
        this.flightStartTime = flightStartTime;
    }

    public FlightTime getFlightEndingTime() {
        return flightEndingTime;
    }

    public void setFlightEndingTime(FlightTime flightEndingTime) {
        this.flightEndingTime = flightEndingTime;
    }
    FlightTime(){}

}









































