import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.util.Calendar.*;

public class Main {

    public static void main(String[] args) throws ParseException, InterruptedException {
        Main main = new Main();
        System.out.println(main.getDateOfPayday(7));
    }

    private String getDateOfPayday(int month) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        if (month >= 0 && month < 13) {
            calendar.set(MONTH, month - 1);
            calendar.set(DAY_OF_MONTH, 15);

            if (calendar.get(DAY_OF_MONTH) == 15) {
                if (calendar.get(DAY_OF_WEEK) == SATURDAY) {
                    calendar.add(Calendar.DATE, 2);
                }
                if (calendar.get(DAY_OF_WEEK) == SUNDAY) {
                    calendar.add(Calendar.DATE, 1);
                }
            }
        } else {
            return "Please enter month number from 1 to 12";
        }

        return simpleDateFormat.format(calendar.getTime());
    }
}
/* Pytania:
1 - Co w przypadku gdy dzień 15 wypada w dzień roboczy ale jest to dzień wolny od pracy (święto) ?
2 - Co w przypadku jeśli księgowa ma wolne w dniu wypłaty ?
 */
