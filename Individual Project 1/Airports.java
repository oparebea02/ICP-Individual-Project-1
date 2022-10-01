/**
 * @author Laura Larbi-Tieku
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Airports {
    private static String AirportID;
    private static String AirportName;
    private static String CityName;
    private static String Country;
    private static String IATACode;

    /**
     * Creating constructors of Airports class */

    public Airports(String AirportID, String AirportName,
                 String CityName, String Country, String IATACode) {
        this.AirportID = AirportID;
        this.AirportName = AirportName;
        this.CityName = CityName;
        this.Country = Country;
        this.IATACode = IATACode;
    }


    /**Accessor and mutator methods for Airports Class
     *
     * @return
     */

    public static String getAirportID() {
        return AirportID;
    }

    public static void setAirportID(String airportID) {
        AirportID = airportID;
    }

    public static String getAirportName() {
        return AirportName;
    }

    public static void setAirportName(String airportName) {
        AirportName = airportName;
    }

    public static String getCityName() {
        return CityName;
    }

    public static void setCityName(String cityName) {
        CityName = cityName;
    }

    public static String getCountry() {
        return Country;
    }

    public static void setCountry(String country) {
        Country = country;
    }

    public static String getIATACode() {
        return IATACode;
    }

    public static void setIATACode(String IATACode) {
        Airports.IATACode = IATACode;
    }

    public static void main(String[] args) {

    }

}





