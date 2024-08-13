import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Boj1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, TreeNode> nodes = new HashMap<>();
        TreeNode root = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();

            nodes.putIfAbsent(parent, new TreeNode(parent));
            TreeNode parentNode = nodes.get(parent);

            if (!Objects.equals(leftChild, ".")) {
                nodes.putIfAbsent(leftChild, new TreeNode(leftChild));
                parentNode.left = nodes.get(leftChild);
            }

            if (!Objects.equals(rightChild, ".")) {
                nodes.putIfAbsent(rightChild, new TreeNode(rightChild));
                parentNode.right = nodes.get(rightChild);
            }

            if (root == null) {
                root = parentNode;
            }
        }

        preorderTraversal(root);
        System.out.println();
        inorderTraversal(root);
        System.out.println();
        postorderTraversal(root);
    }

    static class TreeNode {
        String value;
        TreeNode left;
        TreeNode right;

        TreeNode(String value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    static void preorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    static void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.value);
        inorderTraversal(node.right);
    }

    static void postorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.value);
    }

}
