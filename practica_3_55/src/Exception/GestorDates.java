package Exception;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class GestorDates {

    private static final DateTimeFormatter FORMAT =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate convertir(String text)
            throws DataIncorrectaException {

        try {
            return LocalDate.parse(text, FORMAT);
        } catch (DateTimeParseException e) {
            throw new DataIncorrectaException(
                "Data incorrecta. Format correcte: dd/MM/yyyy"
            );
        }
    }
}
