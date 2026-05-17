package roastery.services;

import java.util.Scanner;

public class InputValidator {
    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Please enter a whole number.");
            }
        }
    }

    public static double readPositiveDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                double value = Double.parseDouble(input.trim());
                if (value <= 0) {
                    throw new IllegalArgumentException("Value must be greater than zero.");
                }
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Please enter a numeric value.");
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static double readPercentage(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                double value = Double.parseDouble(input.trim());
                if (value < 0 || value > 100) {
                    throw new IllegalArgumentException("Value must be between 0 and 100.");
                }
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Please enter a numeric value.");
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static String readNonEmptyString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input != null && !input.trim().isEmpty()) {
                return input.trim();
            }
            System.out.println("Input must not be empty.");
        }
    }
}
