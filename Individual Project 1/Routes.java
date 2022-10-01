import java.util.Objects;

/**
 * @author Laura Larbi-Tieku
 *
 */

public class Routes {
    private String AirlineCode;
    private String AirlineID;
    private String SourceAirportCode;
    private String DestinationAirportCode;
    private int Stops;

    /**
     * Creating constructors of Routes class
     */

    public Routes(String AirlineCode, String AirlineID,
                  String SourceAirportCode, String DestinationAirportCode, int Stops) {
        this.AirlineCode = AirlineCode;
        this.AirlineID = AirlineID;
        this.SourceAirportCode = SourceAirportCode;
        this.DestinationAirportCode = DestinationAirportCode;
        this.Stops = Stops;
    }

    public int getStops() {
        return Stops;
    }

    public void setStops(int stops) {
        Stops = stops;
    }

    public String getAirlineCode() {
        return AirlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        AirlineCode = airlineCode;
    }

    public String getAirlineID() {
        return AirlineID;
    }

    public void setAirlineID(String airlineID) {
        AirlineID = airlineID;
    }

    public String getSourceAirportCode() {
        return SourceAirportCode;
    }

    public void setSourceAirportCode(String sourceAirportCode) {
        SourceAirportCode = sourceAirportCode;
    }

    public String getDestinationAirportCode() {
        return DestinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        DestinationAirportCode = destinationAirportCode;
    }

    @Override
    public String toString() {
        return "Routes{" +
                "AirlineCode='" + AirlineCode + '\'' +
                ", AirlineID='" + AirlineID + '\'' +
                ", SourceAirportCode='" + SourceAirportCode + '\'' +
                ", DestinationAirportCode='" + DestinationAirportCode + '\'' +
                ", Stops=" + Stops +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Routes routes = (Routes) o;
        return Stops == routes.Stops && Objects.equals(AirlineCode, routes.AirlineCode) && Objects.equals(AirlineID, routes.AirlineID) && Objects.equals(SourceAirportCode, routes.SourceAirportCode) && Objects.equals(DestinationAirportCode, routes.DestinationAirportCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AirlineCode, AirlineID, SourceAirportCode, DestinationAirportCode, Stops);
    }
}
