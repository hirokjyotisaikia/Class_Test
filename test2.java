
// 1.Age calculator where any date is input by the user and it gives the age

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.print("Enter birthdate (DD/MM/YYYY) or 'exit' to quit: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                LocalDate birthDate = LocalDate.parse(input, formatter);
                LocalDate currentDate = LocalDate.now();

                if (birthDate.isAfter(currentDate)) {
                    System.out.println("Birthdate cannot be in the future.");
                    continue;
                }

                Period age = Period.between(birthDate, currentDate);
                System.out.printf("Age: %d years, %d months, and %d days%n",
                        age.getYears(), age.getMonths(), age.getDays());

            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use DD/MM/YYYY.");
            }
        }

        scanner.close();
        System.out.println("Program terminated.");
    }
}
