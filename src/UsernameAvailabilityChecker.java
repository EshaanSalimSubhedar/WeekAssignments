import java.util.*;

public class UsernameAvailabilityChecker {

    private HashMap<String, Integer> usernameMap = new HashMap<>();
    private HashMap<String, Integer> attemptFrequency = new HashMap<>();

    public boolean checkAvailability(String username) {
        attemptFrequency.put(username, attemptFrequency.getOrDefault(username, 0) + 1);
        return !usernameMap.containsKey(username);
    }

    public void registerUser(String username, int userId) {
        usernameMap.put(username, userId);
    }

    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            suggestions.add(username + i);
        }
        suggestions.add(username.replace("_", "."));
        return suggestions;
    }

    public String getMostAttempted() {
        String maxUser = "";
        int max = 0;

        for (Map.Entry<String, Integer> entry : attemptFrequency.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxUser = entry.getKey();
            }
        }
        return maxUser;
    }

    public static void main(String[] args) {
        UsernameAvailabilityChecker checker = new UsernameAvailabilityChecker();

        checker.registerUser("john_doe", 1);

        System.out.println(checker.checkAvailability("john_doe"));
        System.out.println(checker.checkAvailability("jane_smith"));

        System.out.println(checker.suggestAlternatives("john_doe"));
        System.out.println("Most attempted: " + checker.getMostAttempted());
    }
}