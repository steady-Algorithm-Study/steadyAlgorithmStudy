import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1068 {
    static int x;
    static Node root = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Node[] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());

            if (t == -1) {
                root = nodes[i];
                continue;
            }

            nodes[t].addChild(nodes[i]);

        }

        x = Integer.parseInt(br.readLine());

        System.out.println(tree.countLeafNodes(root));
    }

    static class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }

        public void addChild(Node child) {
            this.children.add(child);
        }
    }

    static class Tree {
        Node root;

        int countLeafNodes(Node node) {
            if (node == null || node.val == x) {
                return 0;
            }

            if (node.children.size() == 1 && node.children.get(0).val == x) {
                return 1;
            }

            if (node.children.isEmpty()) {
                return 1;
            }

            int leafCount = 0;
            for (Node child : node.children) {
                leafCount += countLeafNodes(child);
            }

            return leafCount;
        }
    }
}
