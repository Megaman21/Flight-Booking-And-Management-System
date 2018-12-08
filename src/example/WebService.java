package example;
import Models.model_db;

import javax.jws.WebMethod;
import javax.xml.ws.Endpoint;

@javax.jws.WebService()
public class WebService {
  @WebMethod
  public int getavailable_seats(String flight,String date) {

    int result = new model_db().getavailable_seats(flight,date);
    System.out.println(result);
    return result;
  }
 @WebMethod
   public String getSeatPrice(String origin, String destination)
  {
    return new model_db().getSeatPrice(origin,destination);
  }

//  @WebMethod
//  public String getSeatPrice(String origin, String destination)
//  {
//    return new model_db().getSeatPrice(origin,destination);
//  }
  public static void main(String[] argv) {
    Object implementor = new WebService();
    String address = "http://localhost:9000/WebService";
    Endpoint.publish(address, implementor);
  }
}
