package TechnicalServices;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SaveLoadFile {
    
    public static boolean saveDataToFile(String filepath, ArrayList<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true))) {
            String result = data.stream().collect(Collectors.joining(";"));
            writer.write(result);
            writer.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean saveAllDataToFile(String filepath, ArrayList<ArrayList<String>> allData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, false))) {
            for (ArrayList<String> data : allData) {
                String result = data.stream().collect(Collectors.joining(";"));
                writer.write(result);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static ArrayList<ArrayList<String>> readDataFromFile(String filepath) {
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filepath))) {
            while (scanner.hasNextLine()) {
                data.add(new ArrayList<String>(Arrays.asList(scanner.nextLine().split(";"))));
            }
        } catch (IOException e) {

        }
        return data;
    }
}
