/**
 * @author Laura Larbi-Tieku
 *
 */

import java.util.ArrayList;
import java.util.Collections;

public class Node {
    private Node Parent;
    private String AirportCode; //the airport code is the state
    private String AirlineCode;
    private int Stops;

    public Node(Node Parent, String AirlineCode, String AirportCode, int Stops) {
        this.Parent = Parent;
        this.AirlineCode = AirlineCode;
        this.AirportCode = AirportCode;
        this.Stops = Stops;
    }

    public int getStops() {
        return Stops;
    }

    public void setStops(int stops) {
        Stops = stops;
    }

    public String getAirportCode() {
        return AirportCode;
    }

    public void setAirportCode(String airportCode) {
        AirportCode = AirportCode;
    }

    public Node getParent() {
        return Parent;
    }

    public void setParent(Node parent) {
        Parent = parent;
    }

    public String getAirlineCode() {
        return AirlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        AirlineCode = airlineCode;
    }



   public ArrayList<String> solutionPath(){
        //To-Do: Implement this method to generate the solution path

       ArrayList<String> sequenceList = new ArrayList();
       ArrayList<Integer> stopsList = new ArrayList();
       ArrayList<String> airportCodesList = new ArrayList();
       ArrayList<String> airlineCodesList = new ArrayList();

       Node currentNode = this;

       while (currentNode != null){
           stopsList.add(currentNode.getStops());
           airlineCodesList.add(currentNode.getAirlineCode());
           airportCodesList.add(currentNode.getAirportCode());

           currentNode = currentNode.Parent;
       }

       //Reversing each list to generate the items from start to finish instead of the other way round
       Collections.reverse(stopsList);
       Collections.reverse(airlineCodesList);
       Collections.reverse(airportCodesList);

       for (int i = 0; i < airlineCodesList.size() - 1; i++){
           String resultingStatement = i+1 + ". " + airlineCodesList.get(i+1) + " from " + airportCodesList.get(i) +
                   " to " + airportCodesList.get(i+1) + " " + stopsList.get(i) + " stops";

           sequenceList.add(resultingStatement);
       }
       return sequenceList;
   }
}


