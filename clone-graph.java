// prime exampe of dfs traversal
// goal: deep clone a graph: create a new copy of a graph (nodes n neighbors)
// I copied this from user red planet because i forgor dfs traversal
// comments explains the rest
/*
// Definition for a Node.
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
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap <Node, Node> dict = new HashMap<>();
        
        dict.put(node, new Node(node.val));
        dfs(node, dict);

        return dict.get(node);
    }

    public void dfs(Node node, HashMap<Node, Node> dict)
    {
        for (Node n : node.neighbors) // 1st loop: adding all non-existing neighbors
        {
            if (!dict.containsKey(n))
                dict.put (n, new Node (n.val));
            dict.get(node).neighbors.add(dict.get(n)); // connects all neighbors to current node
        }
        for (Node n : node.neighbors) // 2nd loop: traverse to neighbors
        {
            if (dict.get(n).neighbors.size() == 0)
                dfs(n, dict);
        }
    }
}