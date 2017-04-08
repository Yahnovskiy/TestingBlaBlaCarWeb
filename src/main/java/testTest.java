import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Bigbubble on 08-Apr-17.
 */
public class testTest {


        static int Day;
        int Month;
        int Year;

    public static void DDD(String args[]){
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formattedDate = new SimpleDateFormat("dd.MM.yyyy");

             Day = calendar.get(Calendar.DAY_OF_MONTH);
             System.out.print("Daye " + Day
            );
//        Month = calendar.get(Calendar.MONTH);
//        Year = calendar.get(Calendar.YEAR);
        }
}


