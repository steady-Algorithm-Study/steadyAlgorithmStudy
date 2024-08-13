import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj2263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] inorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] postorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        TreeNode node = buildTree(inorder, postorder);
        preorderTraversal(node);
    }

    static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        // 중위 순회에서의 인덱스를 빠르게 찾기 위해 맵을 사용
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeRecursive(inorderIndexMap, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    // 재귀적으로 트리 구성
    static TreeNode buildTreeRecursive(Map<Integer, Integer> inorderIndexMap, int[] postorder,
                                       int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return null;
        }

        // 후위 순회에서의 루트 노드
        int rootValue = postorder[postorderEnd];
        TreeNode root = new TreeNode(rootValue);

        // 중위 순회에서 루트 노드의 인덱스
        int inorderRootIndex = inorderIndexMap.get(rootValue);
        int leftTreeSize = inorderRootIndex - inorderStart;

        // 좌우 서브트리 재구성
        root.left = buildTreeRecursive(inorderIndexMap, postorder, inorderStart, inorderRootIndex - 1,
                postorderStart, postorderStart + leftTreeSize - 1);
        root.right = buildTreeRecursive(inorderIndexMap, postorder, inorderRootIndex + 1, inorderEnd,
                postorderStart + leftTreeSize, postorderEnd - 1);

        return root;
    }

    // 전위 순회 (Preorder Traversal)
    static void preorderTraversal(TreeNode node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
