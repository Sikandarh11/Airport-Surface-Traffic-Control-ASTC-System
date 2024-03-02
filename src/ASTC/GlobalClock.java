package ASTC;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GlobalClock {
    private String time;
    private String date;
    private int hours;
    private int minutes;

    public GlobalClock() {
        startGlobalClock();
    }

    private void startGlobalClock() {
        Thread clock = new Thread(() -> {
            try {
                while (true) {
                    Calendar cal = new GregorianCalendar();
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    int month = cal.get(Calendar.MONTH) + 1;
                    int year = cal.get(Calendar.YEAR);

                    int hours = cal.get(Calendar.HOUR_OF_DAY);
                    int minutes = cal.get(Calendar.MINUTE);
                    int seconds = cal.get(Calendar.SECOND);

                    this.hours = hours;
                    this.minutes = minutes;

                    this.time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                    this.date = day + "/ " + month + "/ " + year + ".";

                    Thread.sleep(1000);
                }
            } catch (InterruptedException ie) {
                System.out.println("An error occurred...");
                ie.printStackTrace();
            }
        });

        clock.start();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTimeExternally(String externalTime) {
        this.time = externalTime;
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
}
