package Models;

public class searchResult {
    private flight flight;
    String seatType;
    String totalSeats;
    String price;

    public searchResult(flight flight,String seatType,String totalSeats,String price)
    {
        this.flight=flight;
        this.seatType=seatType;
        this.totalSeats=totalSeats;
        this.price=price;
    }

    public flight getFlight() {
        return flight;
    }

    public String getPrice() {
        return price;
    }

    public String getSeatType() {
        return seatType;
    }

    public String getTotalSeats() {
        return totalSeats;
    }

    public void setFlight(flight flight) {
        this.flight = flight;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public void setTotalSeats(String totalSeats) {
        this.totalSeats = totalSeats;
    }
}
