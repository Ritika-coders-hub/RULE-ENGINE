import java.util.Stack;

public class RuleEngine {
    // Method to create AST from rule string
    public Node createRule(String rule) {
        Stack<Node> stack = new Stack<>();
        String[] tokens = rule.split(" ");
        
        for (String token : tokens) {
            if (token.equals("AND") || token.equals("OR")) {
                Node right = stack.pop();
                Node left = stack.pop();
                stack.push(new Node("operator", left, right)); // Create operator node
            } else {
                stack.push(new Node("operand", token)); // Create operand node
            }
        }
        return stack.pop(); // Root node of the AST
    }

    // Method to evaluate a rule (AST) against user data
    public boolean evaluateRule(Node node, User user) {
        if (node.type.equals("operator")) {
            boolean leftEval = evaluateRule(node.left, user);
            boolean rightEval = evaluateRule(node.right, user);

            if (node.value.equals("AND")) {
                return leftEval && rightEval;
            } else if (node.value.equals("OR")) {
                return leftEval || rightEval;
            }
        } else if (node.type.equals("operand")) {
            // Example condition evaluation (basic condition parsing)
            String[] condition = node.value.split(">");
            if (condition.length == 2) {
                String field = condition[0].trim();
                int value = Integer.parseInt(condition[1].trim());
                
                if (field.equals("age")) {
                    return user.age > value;
                }
            }
        }
        return false;
    }
}

