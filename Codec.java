import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(",");
        } else {
            sb.append(node.val).append(",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }
    
    private TreeNode deserializeHelper(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("#")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = deserializeHelper(nodes);
            node.right = deserializeHelper(nodes);
            return node;
        }
    }
    
    public static void main(String[] args) {
        Codec codec = new Codec();
        
        // Example tree creation
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        
        // Serialize the tree
        String serialized = codec.serialize(root);
        System.out.println("Serialized tree: " + serialized);
        
        // Deserialize the tree
        TreeNode deserializedRoot = codec.deserialize(serialized);
        
        // Validate by comparing original and deserialized trees
        System.out.println("Original tree:");
        printInorder(root);
        System.out.println("\nDeserialized tree:");
        printInorder(deserializedRoot);
    }
    
    // Helper method to print inorder traversal of tree
    private static void printInorder(TreeNode node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.val + " ");
            printInorder(node.right);
        }
    }
}
