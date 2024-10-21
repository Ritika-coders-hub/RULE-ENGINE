public class Main {
    public static void main(String[] args) {
        RuleEngine engine = new RuleEngine();
        
        // Sample rule: "(age > 30 AND department = 'Sales') OR (age < 25 AND department = 'Marketing')"
        String rule = "age > 30 AND department = Sales OR age < 25 AND department = Marketing";
        Node ast = engine.createRule(rule);  // Create AST from rule

        // Sample user data
        User user1 = new User(35, "Sales", 60000, 3);
        User user2 = new User(24, "Marketing", 45000, 1);
        
        // Evaluate rule for users
        boolean result1 = engine.evaluateRule(ast, user1);
        boolean result2 = engine.evaluateRule(ast, user2);
        
        System.out.println("User 1 eligibility: " + result1); // Output should be true
        System.out.println("User 2 eligibility: " + result2); // Output should be true
    }
}



