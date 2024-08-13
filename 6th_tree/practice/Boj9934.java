import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj9934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[(int) (Math.pow(2, K) - 1)];
        int i = 0;

        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        TreeNode root = buildTreeRecursive(arr, 0, arr.length - 1);

        levelOrderTraversal(root);

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

    static TreeNode buildTreeRecursive(int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        // 중간 인덱스를 계산하여 루트 노드를 결정
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(inorder[mid]);

        // 왼쪽과 오른쪽 서브트리를 재귀적으로 구성
        node.left = buildTreeRecursive(inorder, start, mid - 1);
        node.right = buildTreeRecursive(inorder, mid + 1, end);

        return node;
    }

    static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 현재 레벨에 있는 노드의 수

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                System.out.print(current.value + " ");

                // 왼쪽 자식을 큐에 추가
                if (current.left != null) {
                    queue.add(current.left);
                }

                // 오른쪽 자식을 큐에 추가
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            System.out.println(); // 현재 레벨이 끝나면 줄바꿈
        }
    }
}
