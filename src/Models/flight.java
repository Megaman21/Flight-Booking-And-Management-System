package Models;

import database.DBmanager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class flight {
    private String flight_name;
    private String from_city;
    private String to_city;
    private java.util.Date from_date;
   // private java.util.Date to_date;
    private int total_seats;
    private int business_seats;
    private int economy_seats;
    private int firstclass_seats;
    private int business_price;
    private int economy_price;
    private int firstclass_price;
    private int id;
    private int status;
    private int price;

    public flight(){


    }
    public void save()
    {
       // java.sql.Date sqlDate = java.sql.Date.valueOf(from_date);
        DBmanager db=null;
        Connection conn=null;
        conn=db.getConnection();
        String sql = "INSERT INTO flights (flight_name,fromx,tox,departure_date,business_seats,economy_seats,firstclass_seats,status,economy_price,business_price,firstclass_price,total_seats,a_economy,a_business,a_firstclass)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, flight_name);
            stmt.setString(2,from_city);
            stmt.setString(3,to_city);
            stmt.setDate(4,new java.sql.Date(from_date.getTime()));
           // stmt.setDate(5,new java.sql.Date (to_date.getTime()));
            stmt.setInt(5,business_seats);
            stmt.setInt(6,economy_seats);
            stmt.setInt(7,firstclass_seats);
            stmt.setInt(8,0);
            stmt.setInt(9,economy_price);
            stmt.setInt(10,business_price);
            stmt.setInt(11,firstclass_price);
            stmt.setInt(12,total_seats);
            stmt.setInt(13,economy_seats);
            stmt.setInt(14,business_seats);
            stmt.setInt(15,firstclass_seats);
            stmt.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setFlight_name(String flight_name) {
        this.flight_name = flight_name;
    }

    public void setFrom_city(String from_city) {
        this.from_city = from_city;
    }

    public void setTo_city(String to_city) {
        this.to_city = to_city;
    }

    public void setFrom_date(java.util.Date from_date) {
        this.from_date = from_date;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTotal_seats(int total_seats) {
        this.total_seats = total_seats;
    }

    public void setBusiness_seats(int business_seats) {
        this.business_seats = business_seats;
    }

    public void setEconomy_seats(int economy_seats) {
        this.economy_seats = economy_seats;
    }

    public void setFirstclass_seats(int firstclass_seats) {
        this.firstclass_seats = firstclass_seats;
    }

    public String getFlight_name() {
        return flight_name;
    }

    public String getFrom_city() {
        return from_city;
    }

    public String getTo_city() {
        return to_city;
    }

    public java.util.Date getFrom_date() {
        return from_date;
    }



    public int getTotal_seats() {
        return total_seats;
    }

    public int getBusiness_seats() {
        return business_seats;
    }

    public int getEconomy_seats() {
        return economy_seats;
    }

    public int getFirstclass_seats() {
        return firstclass_seats;
    }

    public void setBusiness_price(int business_price) {
        this.business_price = business_price;
    }

    public void setEconomy_price(int economy_price) {
        this.economy_price = economy_price;
    }

    public void setFirstclass_price(int firstclass_price) {
        this.firstclass_price = firstclass_price;
    }

    public int getBusiness_price() {
        return business_price;
    }

    public int getEconomy_price() {
        return economy_price;
    }

    public int getFirstclass_price() {
        return firstclass_price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<flight> getAllFlights() throws SQLException {

        DBmanager db=null;
        Connection conn=null;
        conn=db.getConnection();
        ResultSet set;
        List<flight> list = new ArrayList<flight>();
        PreparedStatement prepStmt;
        prepStmt = conn.prepareCall("SELECT * from airline.flights");
        set = prepStmt.executeQuery();

        while (set.next()) {
            if(set.getInt(9)==0) {
                flight obj = new flight();
                obj.setId(set.getInt(1));
                obj.setFlight_name(set.getString(2));
                obj.setFrom_city(set.getString(3));
                obj.setTo_city(set.getString(4));
                obj.setFrom_date(set.getDate(5));
               // obj.setTo_date(set.getDate(6));
                obj.setBusiness_seats(set.getInt(6));
                obj.setEconomy_seats(set.getInt(7));
                obj.setFirstclass_seats(set.getInt(8));
                obj.setEconomy_price(set.getInt(10));
                obj.setBusiness_price(set.getInt(11));
                obj.setFirstclass_price(set.getInt(12));
                obj.setTotal_seats(set.getInt(13));


                list.add(obj);
            }
        }
        return list;

    }

    public List<flight> gettotalFlights() throws SQLException {

        DBmanager db=null;
        Connection conn=null;
        conn=db.getConnection();
        ResultSet set;
        List<flight> list = new ArrayList<flight>();
        PreparedStatement prepStmt;
        prepStmt = conn.prepareCall("SELECT * from airline.flights");
        set = prepStmt.executeQuery();

        while (set.next()) {
            if(set.getInt(9)==1) {
                flight obj = new flight();
                obj.setId(set.getInt(1));
                obj.setFlight_name(set.getString(2));
                obj.setFrom_city(set.getString(3));
                obj.setTo_city(set.getString(4));
                obj.setFrom_date(set.getDate(5));
                // obj.setTo_date(set.getDate(6));
                obj.setBusiness_seats(set.getInt(6));
                obj.setEconomy_seats(set.getInt(7));
                obj.setFirstclass_seats(set.getInt(8));
                obj.setEconomy_price(set.getInt(10));
                obj.setBusiness_price(set.getInt(11));
                obj.setFirstclass_price(set.getInt(12));
                obj.setTotal_seats(set.getInt(13));


                list.add(obj);
            }
        }
        return list;

    }

    public List<flight> geteveryFlight() throws SQLException{

        DBmanager db=null;
        Connection conn=null;
        conn=db.getConnection();
        ResultSet set;
        List<flight> list = new ArrayList<flight>();
        PreparedStatement prepStmt;
        prepStmt = conn.prepareCall("SELECT * from airline.flights");
        set = prepStmt.executeQuery();

        while (set.next()) {

                flight obj = new flight();
                obj.setId(set.getInt(1));
                obj.setFlight_name(set.getString(2));
                obj.setFrom_city(set.getString(3));
                obj.setTo_city(set.getString(4));
                obj.setFrom_date(set.getDate(5));
              //  obj.setTo_date(set.getDate(6));
                obj.setBusiness_seats(set.getInt(6));
                obj.setEconomy_seats(set.getInt(7));
                obj.setFirstclass_seats(set.getInt(8));
                obj.setEconomy_price(set.getInt(10));
                obj.setBusiness_price(set.getInt(11));
                obj.setFirstclass_price(set.getInt(12));
                obj.setTotal_seats(set.getInt(13));


                list.add(obj);

        }
        return list;


    }
    public flight(int id,String flightno, String from, String to, int totalseats,int economy_price,int business_price,int firstclass_price,java.util.Date date)
    { this.id=id;
        this.flight_name=flightno;
        this.from_city=from;
        this.to_city=to;
        this.economy_price=economy_price;
        this.business_price=business_price;
        this.firstclass_price=firstclass_price;
        this.from_date=date;
        //this.time=time;

       // approved="0";
        this.total_seats=totalseats;
    }

}