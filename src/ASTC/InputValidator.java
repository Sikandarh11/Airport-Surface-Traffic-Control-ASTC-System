package ASTC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputValidator {

    public static boolean isValidPassengerCount(String passengerCount) {
        try {
            int count = Integer.parseInt(passengerCount);
            return count > 0 && count<5001;
        } catch (NumberFormatException e) {

            return false;
        }
    }

    //Landing Request Function
    public static boolean ComboboxInputValidation(String str1, String str2, String str3) {
        return !str1.equals("Select Source") && !str2.equals("Landing Type") && !str3.equals("Flight Type");
    }

    //Add Airplane fuuntion
    public static boolean ComboboxInputValidation(String str1, String str2, String str3, String str4, String str5, String str6) {
        return !str1.equals("Select Source") && !str2.equals("Select Destination") && !str3.equals("Select Time") &&
                !str4.equals("Select Passenger") && !str5.equals("Select Priority") && !str6.equals("Select Class");
    }

    public static boolean txtisNotEmpty(String value1, String value2) {
        return !value1.equals("") && !value2.equals("");
    }

    public static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            Date parsedDate = dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
