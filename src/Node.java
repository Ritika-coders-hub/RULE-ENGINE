public class Node {
    String type; // "operator" for AND/OR or "operand" for conditions
    Node left;   // Left child node (another Node)
    Node right;  // Right child node (another Node)
    String value; // Condition for operand nodes (e.g., "age > 30")

    // Constructor for Operator nodes (AND/OR)
    public Node(String type, Node left, Node right) {
        this.type = type;
        this.left = left;
        this.right = right;
    }

    // Constructor for Operand nodes (conditions)
    public Node(String type, String value) {
        this.type = type;
        this.value = value;
    }
}

