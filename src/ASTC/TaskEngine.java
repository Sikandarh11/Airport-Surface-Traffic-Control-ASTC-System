package ASTC;

import java.io.Serializable;
import java.util.ArrayList;

public class TaskEngine extends Thread implements Serializable {

    public void collectingTasks(Task task) {
        Task tasks = new Task(task.getID(), task.getSource(), task.getDestination(),
                task.getPassengerCount(), task.getTime(), task.getPriority(), task.getAeroplaneName(), task.getSelectClass(), task.getDepartureDate());
        Tasklist.add(tasks);
        System.out.println("Collecting Task Called");
    }

    public void PriorityTask(Task task) {
        try {
            if (task.getPriority().equals("Imediate")) {
                task.setTime((new FlightTime(globalClock.getHours() + 1, globalClock.getMinutes(), 0)).getTime());
                collectingTasks(task);

            } else if (task.getPriority().equalsIgnoreCase("Normal")) {
                collectingTasks(task);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }





    

    //Continue*********************************************************************************************
    public void dispatchTasks() {
        for (Task tasks : Tasklist) {
            FlightTime ft = new FlightTime(tasks.getTime());

            if (ft.getFlightStartTime().getHours() == globalClock.getHours()
                    && ft.getFlightStartTime().getMinutes() == globalClock.getMinutes()) {
                AirplaneClass ap = new AirplaneClass();
                AirplaneRelatedTask art = new AirplaneRelatedTask();

                ap.flightDeparture(tasks, art.ExitingTask(tasks.getPriority()) );
            }
        }
    }

    private static ArrayList<Task> Tasklist = new ArrayList<>();
    private GlobalClock globalClock = new GlobalClock();

    public TaskEngine(GlobalClock globalClock) {
        this.globalClock = globalClock;


    }

    public ArrayList<Task> getTasklist() {
        return Tasklist;
    }


}























