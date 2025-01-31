package Stepdefinition;

import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class ExtractRegFromText {

    public static void main(String[] args) {
        // Call the method that returns the array of registration numbers
        String[] regNumbers = extractRegistrationNumbers();

        // Print the registration numbers array

        System.out.println("Read Reg numbers: ");
        for (String reg : regNumbers) {
            System.out.println(reg);
        }
    }

    public static String[] extractRegistrationNumbers() {
        // Load the file from resources/input/ directory
        InputStream inputStream = ExtractRegFromText.class.getClassLoader().getResourceAsStream("input/car_input - V5.txt");

        if (inputStream == null) {
            System.out.println("File not found in resources/input/ directory.");
            return new String[0];  // Return an empty array if file is not found
        }

        List<String> regNumbers = new ArrayList<>();  // to store regNumbers

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;

            // Regular expression pattern to match "registration"
            Pattern registrationPattern = Pattern.compile(
                    "\\bregistration\\b\\s*([A-Za-z0-9]{1,7}(?:\\s+[A-Za-z0-9]{1,7})?)"
            );

            // Regular expression pattern to match "registrations"
            Pattern registrationsPattern = Pattern.compile(
                    "\\bregistrations\\b.*?([A-Za-z0-9]{1,7}(?:\\s+[A-Za-z0-9]{1,7})?)"
            );

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                // First match for "registration"
                Matcher registrationMatcher = registrationPattern.matcher(line);
                while (registrationMatcher.find()) {
                    regNumbers.add(registrationMatcher.group(1));
                }

                // Second match for "registrations"
                Matcher registrationsMatcher = registrationsPattern.matcher(line);
                if (registrationsMatcher.find()) {
                    // Split the part after "registrations" into potential registration numbers
                    String registrationsPart = line.substring(registrationsMatcher.start());

                    // Match all registration numbers after "registrations"
                    Matcher registrationNumbersMatcher = Pattern.compile(
                            "\\b([A-Za-z0-9]{1,7}(?:\\s+[A-Za-z0-9]{1,7})?)\\b"
                    ).matcher(registrationsPart);

                    while (registrationNumbersMatcher.find()) {
                        // Remove " and" if it exists
                        regNumbers.add(registrationNumbersMatcher.group(1).replace(" and", ""));
                    }
                }
            }

        } catch (IOException e) {
            // Handle any I/O errors
            System.out.println("Error reading the file: " + e.getMessage());
        }

        // Convert List to String[] and return the array
        return regNumbers.toArray(new String[0]);
    }
}