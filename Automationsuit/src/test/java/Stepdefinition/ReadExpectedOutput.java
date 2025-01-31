package Stepdefinition;

import java.io.*;
import java.util.*;

public class ReadExpectedOutput {

    public static void main(String[] args) {
        // Specify the file path (make sure the file is in resources/input/ directory)
        String filePath = "input/car_output - V5.txt";

        System.out.println("File path resolved to: " + ReadExpectedOutput.class.getClassLoader().getResource(filePath));


        // Call the method to read the CSV file and get the data as an array
        Car[] cars = readCSV(filePath);

        // Print the data from the array
        if (cars != null && cars.length > 0) {
            for (Car car : cars) {
                System.out.println(car);
            }
        } else {
            System.out.println("No data found or the file is empty.");
        }
    }

    public static Car[] readCSV(String filePath) {
        List<Car> carList = new ArrayList<>();

        // Load the file from the resources/input/ directory
        InputStream inputStream = ReadExpectedOutput.class.getClassLoader().getResourceAsStream(filePath);

        if (inputStream == null) {
            System.out.println("File not found in resources/input/ directory.");
            return null;  // Return null if file is not found
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            // Skip the header line
            br.readLine();

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                // Split the line into fields by comma
                String[] fields = line.split(",");

                // Ensure the line has the expected number of columns (3)
                if (fields.length == 3) {
                    String regNumber = fields[0].trim();  // First column: VARIANT_REG
                    String makeModel = fields[1].trim();  // Second column: MAKE_MODEL
                    String year = fields[2].trim();       // Third column: YEAR

                    // Create a Stepdefinition.Car object and add it to the list
                    carList.add(new Car(regNumber, makeModel, year));
                } else {
                    System.out.println("Skipping malformed line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        // Convert the List<Stepdefinition.Car> to a Stepdefinition.Car[] array
        return carList.toArray(new Car[0]);
    }
}

// Define a Stepdefinition.Car class to hold the data for each row
class Car {
    private String regNumber;
    private String makeModel;
    private String year;

    public Car(String regNumber, String makeModel, String year) {
        this.regNumber = regNumber;
        this.makeModel = makeModel;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Reg Number: " + regNumber + ", Make/Model: " + makeModel + ", Year: " + year;
    }
}
