/**
 * @author Laura Larbi-Tieku
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Airlines {

    private String AirlineID;
    private String AirlineName;
    private String Alias;
    private String Country;


    public Airlines(String AirlineID, String AirlineName,
                    String Alias, String Country) {
        this.AirlineID = AirlineID;
        this.AirlineName = AirlineName;
        this.Alias = Alias;
        this.Country = Country;
    }

    /**
     * accessor method for Airline name:
     * @return
     */

    public String getAirlineName () {
        return AirlineName;
    }

    public String getAirlineID () {
        return AirlineID;
    }

    public static void main(String[] args) {

        try {
            FileReader ReadAirlineFile = new FileReader("airlines.csv");
            BufferedReader BufferedAirline = new BufferedReader(ReadAirlineFile);
        }
        catch (IOException io){
            System.out.println(io.toString());
        }

    }
}
