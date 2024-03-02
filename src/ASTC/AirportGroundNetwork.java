package ASTC;
import java.util.*;
public class AirportGroundNetwork {

    static boolean[] runways = new boolean[5];
    static boolean[] taxiways = new boolean[9];
    static boolean[] gate = new boolean[9];
    static int i=0;

    public String checkRunway(String typeFlight){

        for (int i=0; i<4; i++){
            if (runways[i] == true){
                for(int j=0; j<8; j++){
                    if(taxiways[j] == true){
                        runways[i] =false; taxiways[j] = false; gate[j] = false;
                        return "\nRunway No : " +(int) (i+1) + "\nTaxiway No : " + (int) (j+1) + "\nGate No : " + (int) (j+1) ;
                    }
                }
            }
        }

        if(typeFlight.equals("Imediate")){
            if(runways[4]!=false){
                runways[4] = false; taxiways[8] =false; gate[8] = false;
                return "Runway No : 5\nTaxiway No : 9\nGate No : 9";
            }else {
                return "Runway is busy : Wait";
            }

        }
        return "All Runways are busy. Wait sometime...";
    }


    AirportGroundNetwork(){
        if(i == 0){
            for(int i=0; i<5; i++){
                runways[i] =true;
            }
            for(int i=0; i<9; i++){
                taxiways[i] =true;
            }
            for(int i=0; i<9; i++){
                gate[i] =true;
            }
            i++;
        }
    }

    public void setRunways(boolean[] runways) {
        this.runways = runways;
    }
    public void setTaxiways(boolean[] taxiways) {
        this.taxiways = taxiways;
    }
    public void setGate(boolean[] gate) {
        this.gate = gate;
    }

    public boolean[] getRunways() {
        return runways;
    }
    public boolean[] getTaxiways() {
        return taxiways;
    }
    public boolean[] getGate() {
        return gate;
    }


    public boolean getRunways(int index) {
        return runways[index];
    }
    public boolean getTaxiways(int index) {
        return taxiways[index];
    }
    public boolean getGate(int index) {
        return gate[index];
    }

    public void setRunways(boolean state, int index) {
        this.runways[index] = state;
    }
    public void setTaxiways(boolean state,int index) {
        this.taxiways[index] = state;
    }
    public void setGate(boolean state, int index) {
        this.gate[index] = state;
    }




}