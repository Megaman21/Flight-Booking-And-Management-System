package Models;

import database.DBmanager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class model_db {

    private DBmanager db;
    private Connection conn;

    public model_db()
     {
         db=null;
         conn=null;
         conn=db.getConnection();

     }
    public void update_status(int id)
    {
        String query = "update flights set status = ? where idflight = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt   (1, 1);
            preparedStmt.setInt(2, id);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void delete_flight(int id)
    {

        String query = "delete from flights where idflight = ?";

        try {
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateFlight(HttpServletRequest request)
    {

        String id=request.getParameter("id");
        String economyprice=request.getParameter("economyprice");
        String firstclassprice=request.getParameter("firstclassprice");
        String businessprice=request.getParameter("businessprice");
        PreparedStatement prepStmt;
      //  Connection connection;
        ResultSet set;

        try {



            synchronized (conn){
                prepStmt = conn.prepareCall("UPDATE flights SET economy_price=?,firstclass_price=?,business_price=?,status=0 WHERE idflight=?");
                prepStmt.setString(1, economyprice);
                prepStmt.setString(2, firstclassprice);
                prepStmt.setString(3, businessprice);
                prepStmt.setString(4, id);
                prepStmt.execute();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public ArrayList<searchResult> searchFlights(HttpServletRequest request)
    {
        ArrayList<searchResult> flights=new ArrayList<>();
        String from=request.getParameter("from");
        String to=request.getParameter("to");
        String date=request.getParameter("date");
        String type=request.getParameter("class");
        String seats=request.getParameter("seats");

        PreparedStatement prepStmt;
        Connection connection;
        ResultSet set;
        int price=0;

        try {

           // connection=(Connection) request.getServletContext().getAttribute("dbconnection");
            prepStmt=conn.prepareCall("");


            synchronized (conn){
                if(type.equals("economy")) {
                    prepStmt = conn.prepareCall("SELECT * FROM flights WHERE status=1 AND LOWER(fromx)=LOWER(?) AND LOWER(tox)=LOWER(?) AND departure_date=? and a_economy>=?");
                }
                else if(type.equals("firstclass"))
                {
                    prepStmt = conn.prepareCall("SELECT * FROM flights WHERE status=1 AND LOWER(fromx)=LOWER(?) AND LOWER(tox)=LOWER(?) AND departure_date=? and flights.a_firstclass>=?");
                }
                else if(type.equals("business"))
                {
                    prepStmt = conn.prepareCall("SELECT * FROM flights WHERE status=1 AND LOWER(fromx)=LOWER(?) AND LOWER(tox)=LOWER(?) AND departure_date=? and flights.a_business>=?");
                }

            }
            java.util.Date departure_date;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                departure_date = formatter.parse(date);


            prepStmt.setString(1, from);
            prepStmt.setString(2, to);
            prepStmt.setDate(3, new java.sql.Date(departure_date.getTime()));
            prepStmt.setString(4, seats);

            set=prepStmt.executeQuery();

            while (set.next()) {
                flight f = new flight(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getInt(13),set.getInt(10),set.getInt(11),set.getInt(12),departure_date);
                if(type.equals("economy"))
                {
                    price=f.getEconomy_price()*Integer.valueOf(seats);
                }
                else if(type.equals("firstclass"))
                {
                    price=f.getFirstclass_price()*Integer.valueOf(seats);
                }
                else if(type.equals("business"))
                {
                    price=f.getBusiness_price()*Integer.valueOf(seats);
                }
                searchResult result=new searchResult(f,type,seats,String.valueOf(price));
                flights.add(result);

            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return flights;

    }
    public boolean checkBookingDeatails(HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        String user=(String) session.getAttribute("username");
        String date=(String)session.getAttribute("date");

        PreparedStatement prepStmt;
        Connection connection;
        ResultSet set;

        try {

            //connection=(Connection) request.getServletContext().getAttribute("dbconnection");

            synchronized (conn){
                prepStmt = conn.prepareCall("SELECT * FROM booking WHERE user=? AND bdate=?");
                prepStmt.setString(1, user);
                prepStmt.setString(2, date);

                set=prepStmt.executeQuery();
                set.last();
                if(set.getRow()>0)
                {
                    return false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return true;
    }
    public searchResult getFlight(HttpServletRequest request)
    {
        String flightid=request.getParameter("flightid");
        PreparedStatement prepStmt;
        Connection connection;
        ResultSet set;
        HttpSession session=request.getSession();
        String type=(String) session.getAttribute("class");
        String seats=(String) session.getAttribute("seats");
        String date=(String)session.getAttribute("date");
        int price=0;
        java.util.Date departure_date=null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            departure_date = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {

            //connection=(Connection) request.getServletContext().getAttribute("dbconnection");



            synchronized (conn){
                prepStmt = conn.prepareCall("SELECT * FROM flights WHERE idflight=?");
            }
            prepStmt.setString(1, flightid);

            set=prepStmt.executeQuery();

            set.next();
            flight f = new flight(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getInt(13),set.getInt(10),set.getInt(11),set.getInt(12),departure_date);

            if(type.equals("economy"))
            {
                price=f.getEconomy_price()*Integer.valueOf(seats);
            }
            else if(type.equals("firstclass"))
            {
                price=f.getFirstclass_price()*Integer.valueOf(seats);
            }
            else if(type.equals("business"))
            {
                price=f.getBusiness_price()*Integer.valueOf(seats);
            }

            searchResult result=new searchResult(f,type,seats,String.valueOf(price));
            return result;



        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void addBooking(HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        String username=(String) session.getAttribute("username");
        String type=(String) session.getAttribute("class");
        String seats=(String) session.getAttribute("seats");
        String flightid=request.getParameter("flightid");
        String date=(String)session.getAttribute("date");
        String price=request.getParameter("price");

        PreparedStatement prepStmt;
        Connection connection;
        ResultSet set;
        String flightname="";
        //String flighttime="";
        String from="";
        String to="";

        try {

           // connection=(Connection) request.getServletContext().getAttribute("dbconnection");

            synchronized (conn){
                prepStmt = conn.prepareCall("Insert into booking (user,flightid,seattype,price,bdate,seats)"+ "values ( ?, ?, ?, ?, ?, ?)");
            }

            //prepStmt.setString(1, "0");
            prepStmt.setString(1, username);
            prepStmt.setString(2, flightid);
            prepStmt.setString(3, type);
            prepStmt.setString(4, price);
            prepStmt.setString(5, date);
            prepStmt.setString(6, seats);

            prepStmt.execute();

            String temp=type+"available";
            prepStmt = conn.prepareCall("SELECT* FROM flights WHERE idflight=?");

            prepStmt.setInt(1, Integer.valueOf(flightid));

            int t=0;
            ResultSet set1=prepStmt.executeQuery();
            set1.next();
            flightname=set1.getString(2);
            //flighttime=set1.getString(13);
            from=set1.getString(3);
            to=set1.getString(4);

            if(type.equals("economy")) {
                //t = Integer.valueOf(set1.getString(15));
                t=set1.getInt(14);
                t = t - Integer.valueOf(seats);
                prepStmt = conn.prepareCall("UPDATE flights SET a_economy=? where idflight=? ");
            }
            else if(type.equals("firstclass"))
            {
               // t = Integer.valueOf(set1.getString(16));
                t=set1.getInt(16);
                t = t - Integer.valueOf(seats);
                prepStmt = conn.prepareCall("UPDATE flights SET a_firstclass=? where idflight=? ");
            }
            else if(type.equals("business"))
            {
                //t = Integer.valueOf(set1.getString(17));
                t=set1.getInt(15);
                t = t - Integer.valueOf(seats);
                prepStmt = conn.prepareCall("UPDATE flights SET a_business=? where idflight=? ");
            }




            prepStmt.setString(1, String.valueOf(t));
            prepStmt.setInt(2, Integer.valueOf(flightid));

            prepStmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("flightname",flightname);
       // request.setAttribute("time",flighttime);
        request.setAttribute("from",from);
        request.setAttribute("to",to);


    }
public int getavailable_seats(String flight,String date)
{
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    Date datex=null;
    try {
         datex= sdf1.parse(date);

    } catch (ParseException e) {
        e.printStackTrace();
    }

    java.sql.Date sqlStartDate =  new java.sql.Date(datex.getTime());
    PreparedStatement prepStmt;
    ResultSet set;
    try {

        //connection=(Connection) request.getServletContext().getAttribute("dbconnection");

        synchronized (conn){
            prepStmt = conn.prepareCall("SELECT * FROM flights WHERE flight_name=? AND departure_date=?");
            prepStmt.setString(1, flight);
            prepStmt.setDate(2, sqlStartDate);

            set=prepStmt.executeQuery();
            set.last();
            if(set.getRow()==0)
            {
                return -1;
            }
            else
            {
                int economy=set.getInt(14);
                int business=set.getInt(15);
                int firstclass=set.getInt(16);
                int total=economy+firstclass+business;
                return total;
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

   return 0;
}
public String getSeatPrice(String origin,String destination)
{
    int count=0;
    flight obj=new flight();
    List<flight> list=new ArrayList<flight>();
    try {

          list=obj.gettotalFlights();
        List<flight> list_t = new ArrayList<flight>();
        for(int i=0;i<list.size();i++)
        {
         if((list.get(i).getFrom_city().equals(origin))&&(list.get(i).getTo_city().equals(destination)))
           {
//              // list_t.add(list.get(i))
              return String.valueOf(list.get(i).getEconomy_price());
           }

            System.out.println(list.get(i).getFrom_city());
        }
//        if(list.size()==0)
//        {
//            return "fuck";
//        }


            return "No flight is present with given origin and destination";

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return "failed";

}
     public boolean checkemail(String email)
     {
         PreparedStatement prepStmt;
         ResultSet set;
         try {

             //connection=(Connection) request.getServletContext().getAttribute("dbconnection");

             synchronized (conn){
                 prepStmt = conn.prepareCall("SELECT * FROM users WHERE user_name=?");
                 prepStmt.setString(1, email);
                // prepStmt.setDate(2, sqlStartDate);

                 set=prepStmt.executeQuery();
                 set.last();
                 if(set.getRow()==0)
                 {
                     return false;
                 }
                 else
                 {
                     return true;
                 }
             }

         } catch (Exception e) {
             e.printStackTrace();
         }

        return true;
     }
    }

