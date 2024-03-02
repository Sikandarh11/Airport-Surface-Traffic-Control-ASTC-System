package ASTC;

import java.io.Serializable;
import java.util.ArrayList;

public class AirplaneRelatedTask implements Serializable {

    public String landingTask(Task task){
        AirportGroundNetwork agn = new AirportGroundNetwork();

        if(task.getLandingType().equals("Normal")){
            return agn.checkRunway("Normal");
        }
        else if (task.getLandingType().equals("Imediate")){
            return agn.checkRunway("Imediate");
        }else {
            return "All Runways are busy. Wait sometime";
        }

    }


    public String EnteringTask(Task task){
        Task tasks = new Task(task.getAeroplaneName(), task.getID(), task.getPassengerCount(), task.getLandingType(), task.getFlightType(), task.getSource());
        groundNetworkTaskList.add(tasks);
        return landingTask(tasks);
    }

    public String ExitingTask(String type){
        AirportGroundNetwork agn = new AirportGroundNetwork();
        if(type.equals("Normal")){
            return agn.checkRunway("Normal");
        }else if(type.equals("Imediate")){
            return agn.checkRunway("Imediate");
        }else {
            return "All Runways are busy. Wait sometime";
        }
    }




    static ArrayList<Task> groundNetworkTaskList = new ArrayList<>();

    public ArrayList<Task> getGroundNetworkTaskList() {
        return groundNetworkTaskList;
    }

    public static void setGroundNetworkTaskList(ArrayList<Task> GroundNetworkTaskList) {
        groundNetworkTaskList = GroundNetworkTaskList;
    }








}
