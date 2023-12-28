package bruteforce;

import java.util.Scanner;

public class BruteForce {

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);

        String input = S.nextLine().trim(); // Trim to remove leading/trailing spaces
        int length;

        // Check for " -Aa" or " -AA" in the input
        boolean includeLowercase = input.contains(" -Aa");
        boolean uppercaseOnly = input.contains(" -AA");

        // Extract the length from the input
        try {
            length = Integer.parseInt(input.split(" ")[0].replaceAll("[^0-9]", ""));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid length.");
            return;
        }

        // Extract the special characters from the input
        String specialCharacters = "";
        if (input.contains(" -")) {
            specialCharacters = input.substring(input.indexOf(" -") + 2);
        }

        Generator(length, includeLowercase, uppercaseOnly, specialCharacters);
    }

    public static void Generator(int length, boolean includeLowercase, boolean uppercaseOnly, String specialCharacters) {
        String characters = "";

        if (includeLowercase && uppercaseOnly) {
            characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        } else if (includeLowercase) {
            characters = "abcdefghijklmnopqrstuvwxyz";
        } else if (uppercaseOnly) {
            characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        } else {
            characters = "abcdefghijklmnopqrstuvwxyz";
        }

        // Add special characters if provided
        characters += specialCharacters;

        generateStrings("", characters, length);
    }

    public static void generateStrings(String prefix, String characters, int length) {
        if (length == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < characters.length(); i++) {
            generateStrings(prefix + characters.charAt(i), characters, length - 1);
        }
    }
}
