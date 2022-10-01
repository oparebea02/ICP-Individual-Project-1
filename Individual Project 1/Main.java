/**
 * @author Laura Larbi-Tieku
 *
 */

import java.io.*;
import java.util.*;

public class Main {

    //Hashmap to Store Airport Data with City&Country names as the key and an array list of IATA codes (Source airport code) as values
    static HashMap<String, ArrayList<String>> cityCountrytoAirportCodeMap = new HashMap<>();

    //Hashmap to Store Airport Data with IATA code (Source airport code) as key and City&Country names as values
    static HashMap<String, String> airportCodetoCityCountryMap = new HashMap<>();

    //Hashmap to Store Route Data with IATA Code (Source Airport Code) as the key and a list of Route objects as values
    static HashMap<String, ArrayList<Routes>> routeHashmap = new HashMap<>();


    //Search algorithm; using breadth-first search to find the path
    public static ArrayList<String> breadthFirstSearch(String startingPoint, String endPoint) {
        Queue<Node> frontier = new ArrayDeque<>();
        Set<String> exploredSet = new HashSet<>();

        ArrayList<String> airportList = cityCountrytoAirportCodeMap.get(startingPoint);

        for (String airportCode : airportList) {
            frontier.add(new Node(null, null, airportCode, 0));
        }
        while (frontier.size() > 0) {
            Node node = frontier.remove();
            exploredSet.add(node.getAirportCode());

            ArrayList<Routes> routesList = routeHashmap.get(node.getAirportCode());

            if (routesList != null) {
                for (Routes childStates : routesList) {
                    Node child = new Node(node, childStates.getAirlineCode(),
                            childStates.getDestinationAirportCode(), childStates.getStops());

                    String endCityandCountry =
                            airportCodetoCityCountryMap.get(child.getAirportCode());
                    if (endCityandCountry != null){
                        if (!frontier.contains(child) && !exploredSet.contains(child.getAirportCode())) {
                            if (endCityandCountry.equals(endPoint)) {
                                return child.solutionPath();
                            }
                            frontier.add(child);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            //Reading the Routes file within a try block to handle any possible exceptions

            FileReader ReadRouteFile = new FileReader("routes.csv");
            BufferedReader BufferedRoute = new BufferedReader(ReadRouteFile);

            String routeLine = BufferedRoute.readLine();

            while (routeLine != null) {
                //Separating values in file by commas
                String[] RouteData = routeLine.split(",");

                //Creating a Route object
                Routes route = new Routes(RouteData[0], RouteData[1], RouteData[2], RouteData[4],
                        Integer.parseInt(RouteData[7]));  //casting stops to an integer since this array is an array of strings

                String SourceAirportCode = RouteData[2];

                //Checking state of route array list to append route objects
                ArrayList<Routes> routesArrayList = routeHashmap.get(SourceAirportCode);
                if (routesArrayList != null) {
                    routesArrayList.add(route);
                    routeHashmap.put(SourceAirportCode, routesArrayList);
                } else {
                    ArrayList<Routes> newRoutesArrayList = new ArrayList<>();
                    newRoutesArrayList.add(route);
                    routeHashmap.put(SourceAirportCode, newRoutesArrayList);
                }
                routeLine = BufferedRoute.readLine();
            }
           /*
          Reading the Airports file within a "try" to handle any possible exceptions
         */
            FileReader ReadAirportFile = new FileReader("airports.csv");
            BufferedReader BufferedAirport = new BufferedReader(ReadAirportFile);

            String AirportLine = BufferedAirport.readLine();

            while (AirportLine != null) {
                //Separating values in file by commas
                String[] AirportData = AirportLine.split(",");

                String CityandCountry = AirportData[2] + "," + AirportData[3];
                String AirportCode = AirportData[4];

                //Checking state of Airport Codes array list to append Airport code strings

                ArrayList<String> airportCodesArrayList = cityCountrytoAirportCodeMap.get(AirportCode);

                if (airportCodesArrayList != null) {
                    airportCodesArrayList.add(AirportCode);
                    cityCountrytoAirportCodeMap.put(CityandCountry, airportCodesArrayList);
                } else {
                    ArrayList<String> newAirportCodesArrayList = new ArrayList<>();
                    newAirportCodesArrayList.add(AirportCode);
                    cityCountrytoAirportCodeMap.put(CityandCountry, newAirportCodesArrayList);
                }

                //Adding items to airportCodetoCityCountryMap
                airportCodetoCityCountryMap.put(AirportCode, CityandCountry);

                AirportLine = BufferedAirport.readLine();
            }

            //Reading the input file
            FileReader readInputFile = new FileReader("accra-ghana.txt");
            BufferedReader bufferedInput = new BufferedReader(readInputFile);

            String source = bufferedInput.readLine();
            String destination = bufferedInput.readLine();


            //Creating the output file
            File outputFile = new File("C:\\Users\\DANIEL LARBI TIEKU\\Desktop\\Ashesi\\SECOND YEAR" +
                    "\\Semester 2\\Intermediate Computer Programming\\Individual Project 1\\winnipeg-canada_output.txt");

            //Testing breadth first search
            ArrayList<String> Solution = breadthFirstSearch(source, destination);

            //Writing the output to the file
            FileWriter writtenOutput = new FileWriter("winnipeg-canada_output.txt");

            for (int i =0; i<Solution.size(); i++){
                writtenOutput.write((Solution.get(i)));
                writtenOutput.write("\n");
            }
            writtenOutput.close();

        } catch (IOException ie) {
            System.out.println(ie.toString());
        }
    }
}

