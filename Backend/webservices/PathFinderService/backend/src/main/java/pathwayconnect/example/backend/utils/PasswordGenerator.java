package pathwayconnect.example.backend.utils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()_+-=[]{}|;:,.<>?";

    private static final SecureRandom random = new SecureRandom();
    private static final int DEFAULT_LENGTH = 10; // Length ≥ 8

    public static String generateSecurePassword() {
        List<Character> passwordChars = new ArrayList<>();

        // Ensure required characters
        passwordChars.add(UPPER.charAt(random.nextInt(UPPER.length())));
        passwordChars.add(LOWER.charAt(random.nextInt(LOWER.length())));
        passwordChars.add(DIGITS.charAt(random.nextInt(DIGITS.length())));
        passwordChars.add(SPECIAL.charAt(random.nextInt(SPECIAL.length())));

        // Fill the rest
        String allChars = UPPER + LOWER + DIGITS + SPECIAL;
        for (int i = 4; i < DEFAULT_LENGTH; i++) {
            passwordChars.add(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle to make it random
        Collections.shuffle(passwordChars);

        // Build the password
        StringBuilder password = new StringBuilder();
        for (char c : passwordChars) {
            password.append(c);
        }

        return password.toString();
    }
}
