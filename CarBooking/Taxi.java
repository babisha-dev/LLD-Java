package CarBooking;

import java.util.List;
import java.util.ArrayList;

public class Taxi {
    int id;
    int totalEarnings=0;
    char currentPoint = 'A';
    List<Booking> bookings=new ArrayList<>();
    public Taxi(int id){
        this.id=id;
    }
public boolean isAvailable(int requestTime){
  if(bookings.isEmpty()) return true;
  Booking lastBooking=bookings.get(bookings.size()-1);
  return lastBooking.dropTime <= requestTime;
}

    
}
