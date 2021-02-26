package Algorithms3;

import java.util.*;

public class t133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> visit = new HashMap<>();
        return dfs(visit, node);
    }

    public Node dfs(Map<Node, Node> visit, Node node) {
        if (node == null)
            return node;

        if (visit.containsKey(node))
            return visit.get(node);

        Node clone = new Node(node.val, new ArrayList<>());
        visit.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(visit, neighbor));
        }
        return clone;
    }


    public static void main(String[] args) {
        System.out.println("测试一下deepin的git");
    }
}
