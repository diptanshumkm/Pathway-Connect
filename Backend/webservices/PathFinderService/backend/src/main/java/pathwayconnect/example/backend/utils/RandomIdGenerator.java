package pathwayconnect.example.backend.utils;
import java.security.*;



public class RandomIdGenerator {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomId() {
        StringBuilder sb = new StringBuilder(8);

        // Generate 4 random letters
        for (int i = 0; i < 4; i++) {
            sb.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
        }

        // Generate 4 random digits
        for (int i = 0; i < 4; i++) {
            sb.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }

        return sb.toString();
    }


}
