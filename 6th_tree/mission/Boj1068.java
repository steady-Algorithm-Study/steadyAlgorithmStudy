import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1068 {
    static class Node{
        int parent;
        List<Integer> child;

        public Node(){
            parent = -1;
            child = new ArrayList<>();
        }
    }
    static int N;
    static int removeCount;
    static Node[] tree;
    static int removeNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new Node[N];

        for(int i = 0; i < N; i++){
            tree[i] = new Node();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            int parent = Integer.parseInt(st.nextToken());

            tree[i].parent = parent;

            if(parent != -1){
                tree[parent].child.add(i);
            }

//            System.out.println(i + " " + parent);
        }

        int total = 0;
        int root = 0;
        for(int i = 0; i < N; i++){
            if(tree[i].child.isEmpty()){
                total++;
            }
            if(tree[i].parent == -1)
                root = i;
        }

        removeNode = Integer.parseInt(br.readLine());

        if(removeNode == root){
            System.out.println(0);
            return;
        }
        removeCount = 0;

//        System.out.println(total);
        dfs(removeNode);

//        System.out.println(total);
        System.out.println(total - removeCount);
    }

    public static void dfs(int node){
//        System.out.println(node);
        if(tree[node].child.isEmpty()){
            removeCount++;
            if(tree[tree[node].parent].child.size() == 1)
                removeCount--;
            return;
        }

        for(int child : tree[node].child){
            dfs(child);

        }
    }
}
