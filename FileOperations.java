import java.io.*;
import java.util.Scanner;

public class FileOperations {

    // Method to write text to a file
    public static void writeToFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
            System.out.println("✅ File written successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    // Method to read text from a file
    public static void readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("\n📄 File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading from file: " + e.getMessage());
        }
    }

    // Method to modify a file (replace a word with another word)
    public static void modifyFile(String filename, String oldWord, String newWord) {
        try {
            // Read original file content
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);
            StringBuilder fileContent = new StringBuilder();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                line = line.replaceAll(oldWord, newWord); // Replace text
                fileContent.append(line).append(System.lineSeparator());
            }
            fileScanner.close();

            // Write modified content back to the file
            FileWriter writer = new FileWriter(file);
            writer.write(fileContent.toString());
            writer.close();
            System.out.println("🔁 File modified successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error modifying file: " + e.getMessage());
        }
    }

    // Main method to demonstrate all file operations
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = "example.txt";

        System.out.println("Enter text to write to the file:");
        String content = sc.nextLine();

        // 1. Write
        writeToFile(filename, content);

        // 2. Read
        readFromFile(filename);

        // 3. Modify
        System.out.print("\nEnter word to be replaced: ");
        String oldWord = sc.nextLine();
        System.out.print("Enter new word: ");
        String newWord = sc.nextLine();

        modifyFile(filename, oldWord, newWord);

        // 4. Read after modification
        readFromFile(filename);

        sc.close();
    }
}
