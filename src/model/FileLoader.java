package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Read lines of a file.
 */
public class FileLoader {

    public static List<String[]> loadFileLines(String pathname) throws FileNotFoundException {
        List<String[]> result = new ArrayList<String[]>();

        Scanner scanner = new Scanner(new File(pathname));
        scanner.nextLine(); // skip header
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] tokens = line.split("\\s+");
            result.add(tokens);
        }
        scanner.close();

        return result;
    }
}
