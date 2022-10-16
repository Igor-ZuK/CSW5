package models;

import java.util.Objects;

public class Ticket {
    private int id;

    private String code;

    private String userCode;

    private String transportType;

    private String departurePoint;

    private String arrivalPoint;

    private String departureDate;

    public Ticket() {
    }

    public Ticket(String code, String userCode, String transportType,
                  String departurePoint, String arrivalPoint, String departureDate) {
        this.code = code;
        this.userCode = userCode;
        this.transportType = transportType;
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.departureDate = departureDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketCode() {
        return code;
    }

    public void setTicketCode(String code) {
        this.code = code;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public String getDepartureData() {
        return departureDate;
    }

    public void setDepartureData(String departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(code, ticket.code)
                && Objects.equals(userCode, ticket.userCode)
                && Objects.equals(transportType, ticket.transportType)
                && Objects.equals(departurePoint, ticket.departurePoint)
                && Objects.equals(arrivalPoint, ticket.arrivalPoint)
                && Objects.equals(departureDate, ticket.departureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, userCode, transportType, departurePoint, arrivalPoint, departureDate);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", userCode='" + userCode + '\'' +
                ", transportType='" + transportType + '\'' +
                ", departurePoint='" + departurePoint + '\'' +
                ", arrivalPoint='" + arrivalPoint + '\'' +
                ", departureDate='" + departureDate + '\'' +
                '}';
    }
}
