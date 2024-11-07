package controller;

import java.util.Scanner;

/**
 *
 */
public class Input {
    private static Scanner keyboard = new Scanner(System.in);

    /**
     * Prompt user to enter an integer.
     *
     * @param prompt prompt message
     * @param min    the minimum value
     * @param max    the maximum value
     * @return an integer.
     */
    public static int enterInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt + ": ");
            try {
                int value = Integer.parseInt(keyboard.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer between " + min + " and " + max + ".");
            }
        }
    }

    public static char enterChar(String validChars) {
        validChars = validChars.toLowerCase();

        while (true) {
            char[] chars = validChars.toUpperCase().toCharArray();

            System.out.print("enter ");
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
                if (i < chars.length - 1) {
                    System.out.print('/');
                }
            }
            System.out.print(": ");

            String s = keyboard.nextLine().toLowerCase();
            if (s.length() == 1 && validChars.contains(s)) {
                return s.charAt(0);
            }
        }
    }
}
