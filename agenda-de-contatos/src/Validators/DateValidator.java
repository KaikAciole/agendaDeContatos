package Validators;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator extends Validator<String> {
    @Override
    public boolean validate(String data) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.parse(data);

            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
