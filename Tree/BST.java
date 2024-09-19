
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST {

    Node root;

    public void addNode(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node curr = root;
            while (true) {
                if (curr.data == value) {
                    break;
                }
                if (value > curr.data) {
                    if (curr.right == null) {
                        curr.right = new Node(value);
                        break;
                    } else {
                        curr = curr.right;
                    }

                } else {
                    if (curr.left == null) {
                        curr.left = new Node(value);
                        break;
                    } else {
                        curr = curr.left;
                    }
                }
            }

        }
    }

    public boolean search(int val) {
        Node curr = root;
        while (curr != null) {
            if (val < curr.data) {
                curr = curr.left;
            } else if (val > curr.data) {
                curr = curr.right;
            } else {
                return true;
            }
        }
        return false;
    }

    Node remove(Node root, int val) {
        if (root == null) {
            return root;
        }
        if (root.data < val) {
            root.right = remove(root.right, val);
        } else if (root.data > val) {
            root.left = remove(root.left, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = MaxValue(root.left);
            root.left = remove(root.left, root.data);
        }
        return root;
    }

    int MaxValue(Node root) {
        int ret = Integer.MIN_VALUE;
        while (root != null) {
            ret = Math.max(ret, root.data);
            root = root.right;
        }
        return ret;
    }

    public void inOrder() {
        inOrder(root);
    }

    protected void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    protected void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public void postOrder() {
        postOrder(root);
    }

    protected void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void printLeaf() {
        printLeaf(root);
    }

    private void printLeaf(Node root) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            System.out.println(root.data);
        }
        printLeaf(root.left);
        printLeaf(root.right);

    }

    private boolean isLeaf(Node root) {
        if (root == null) {
            return false;
        }
        return root.left == null && root.right == null;
    }
 
    private int CountOfLeaves() {
        return CountOfLeaves(root);
    }

    private int CountOfLeaves(Node root) {
        if (root == null)return 0;
        if (isLeaf(root)) {
            return 1;
        }
        return CountOfLeaves(root.left) + CountOfLeaves(root.right);
    }

    public static void main(String[] args) {
        BST t = new BST();
//        t.addNode(5);
//        t.addNode(4);
//        t.addNode(6);
//        System.out.println(t.countOfNodes());
//        List <Integer> res = t.postorderTraversal();
//        System.out.println(res.toString());
//        int a[] = {10, 5, 12, 7, 14, 3, 11, 1, 4, 13, 16};
//        for (int i = 0; i < a.length; i++) {
//            t.addNode(a[i]);
//        }
        t.root =  new Node(1);
        t.root.left = new Node(2);
        t.root.left.left = new Node(2);
        t.root.right = new Node(3);
        t.root.right.left=new Node(2);
        t.root.right.right=new Node(4);
        t.root = fun(t.root, 2);
        t.printLevelOrder();
        
//        System.out.println(t.CountOfLeaves(t.root));
//        t.addNode(19);
//        t.addNode(4);
//        t.addNode(10);
//        t.addNode(5);
//        t.addNode(17);
//        t.addNode(43);
//        t.addNode(31);
//        t.addNode(49);
    }

    public int countOfNodes() {
        return countOfNodes(root);
    }

    private int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countOfNodes(root.left) + countOfNodes(root.right);
    }

    public int SumOfLeaves() {
        return SumOfLeaves(root);
    }

    private int SumOfLeaves(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        }
        return SumOfLeaves(root.left) + SumOfLeaves(root.right);
    }
//    private int height(Node root) {
//        if(root == null) return 0;
//        int leftTree=0,rightTree =0;
//        if(root.left!=null)
//        leftTree =1+  height(root.left);
//        if(root.right!=null)
//        rightTree =1+ height(root.right);
//        return Math.max(rightTree, leftTree);
//        
//    }
//    public int height (){
//        return height(root);
//    }

    public boolean hasPathSum(int sum) {
        return hasPathSum(root, sum);
    }

    private boolean hasPathSum(Node root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum == root.data) {
            return true;
        }
        return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
    }

    public List<Integer> preorderTraversal() {
        return preorderTraversal(root);
    }

    private List<Integer> preorderTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.add(root.data);
        if (root.left != null) {
            res.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            res.addAll(preorderTraversal(root.right));
        }
        return res;
    }

    public List<Integer> inorderTraversal() {
        return inorderTraversal(root);
    }

    private List<Integer> inorderTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        if (root.left != null) {
            res.addAll(inorderTraversal(root.left));
        }
        res.add(root.data);
        if (root.right != null) {
            res.addAll(inorderTraversal(root.right));
        }
        return res;
    }

    public List<Integer> postorderTraversal() {
        return postorderTraversal(root);
    }

    private List<Integer> postorderTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        if (root.left != null) {
            res.addAll(postorderTraversal(root.left));
        }
        if (root.right != null) {
            res.addAll(postorderTraversal(root.right));
        }
        res.add(root.data);
        return res;
    }

//    public void Print_level() {
//        Print_level(root);
//    }
//    private void Print_level(Node root) {
//        if (root == null) {
//            return;
//        }
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        while (!q.isEmpty()) {
//            Node curr = q.remove();
//            System.out.println(curr.data);
//            if (curr.left != null) {
//                q.add(curr.left);
//            }
//            if (curr.right != null) {
//                q.add(curr.right);
//            }
//        }
//    }
    public int SumOfRange(int low, int high) {
        return SumOfRange(root, low, high);
    }

    private int SumOfRange(Node root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.data >= low && root.data <= high) {
            sum = sum + root.data;
        }

        return sum + SumOfRange(root.left, low, high) + SumOfRange(root.right, low, high);
    }

    public int SumOfLeftLeaves() {
        return SumOfLeftLeaves(root);
    }

    private int SumOfLeftLeaves(Node root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.data;
            }
        }
        return sum + SumOfLeftLeaves(root.left) + SumOfLeftLeaves(root.right);
    }

    public Node lowestCommonAncestor(Node p, Node q) {
        return lowestCommonAncestor(root, p, q);
    }

    private Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (p.data < root.data && q.data < root.data) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.data > root.data && q.data > root.data) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    public boolean isSymmetric(Node root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(Node T1, Node T2) {
        if (T1 == null && T2 == null) {
            return true;
        }
        if (T2 == null || T1 == null) {
            return false;
        }
        return (T2.data == T1.data) && isSymmetric(T1.left, T2.right) && isSymmetric(T1.right, T2.left);
    }

    public boolean isSameTree(BST p, BST q) {
        return isSameTree(p.root, q.root);
    }

    public boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public Node invert(Node root) {
        if (root == null) {
            return null;
        }
        Node l = root.left;
        root.left = invert(root.right);
        root.right = invert(l);

        return root;
    }

    private List<Integer> getSortedList() {
        List<Integer> ans = new LinkedList<>();
        if (root != null) {
            getSortedList(root, ans);
        }
        return ans;
    }

    public void getSortedList(Node root, List<Integer> ans) {
        if (root.left != null) {
            getSortedList(root.left, ans);
        }
        ans.add(root.data);
        if (root.right != null) {
            getSortedList(root.right, ans);
        }
    }

    public boolean isFull() {
        return isFull(root);
    }

    private boolean isFull(Node root) {
        if (root == null) {
            return true;
        } else if (root.left == null ^ root.right == null) {
            return false;
        }
        return isFull(root.left) && isFull(root.right);
    }

    private boolean isFully(Node root) {
        if (root == null) {
            return true;
        }
        boolean ans = true;
        ans = (root.left != null || root.right == null) && (root.left == null || root.right != null);

        return ans && isFull(root.left) && isFull(root.right);
    }

    public void BFS() {
        if (root != null) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Node curr = q.poll();
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                    System.out.print(curr.data + " ");
                }
                System.out.println();
            }
        }
    }

    //BFS using recurison
    public void printLevelOrder() {
        int h = maxDepth(root);
        int i;
        for (i = 1; i <= h; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    private void printGivenLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    public boolean findTarget(Node root, int k) {
        return helper(root, new HashSet<Integer>(), k);
    }

    boolean helper(Node root, HashSet<Integer> s, int k) {
        if (root == null) {
            return false;
        }
        if (s.contains(k - root.data)) {
            return true;
        }
        s.add(root.data);
        return helper(root.left, s, k) || helper(root.right, s, k);
    }

    private int res;

    public int sumNumbers(Node root) {
        if (root == null) {
            return 0;
        }
        res = 0;
        sumNumbers(root, 0);
        return res;
    }

    private void sumNumbers(Node root, int val) {
        int curr = val * 10 + root.data;
        if (root.left == null && root.right == null) {
            res += curr;
            return;
        }
        if (root.left != null) {
            sumNumbers(root.left, curr);
        }
        if (root.right != null) {
            sumNumbers(root.right, curr);
        }
    }

//    public String PathOfEle(int val) {
//        return PathOfEle(root, val);
//    }

//    private String PathOfEle(Node root, int val) {
//        if(root == null)return "";
//        String str = "";
//        if(root.data == val)return str;
//        str+=root.data+"->";
//        PathOfEle(root.left,val);
//        PathOfEle(root.right,val);
//    }
    public static String path(Node root, int v) {
        String s = "";
        while (root != null && root.data != v) {
            s += root.data + "->";
            root = root.data < v ? root.right : root.left;
        }
        return root == null ? "" : s + root.data;
    }
    
    public static int maxPath (Node root){
        if(root == null)return 0;
        int sum =0;
        sum= sum+root.data;
        if(root.left == null && root.right ==null){
            return sum;
        }
        return sum+ Math.max(maxPath(root.left), maxPath(root.right));
    }
    
    public static Node fun (Node root,int t){
        if(root == null)return null;
        if(root.left != null){
            root.left = fun(root.left,t);
        }if(root.right!=null){
           root.right = fun(root.right,t);
        }
      if((root.data == t )&& (root.left == null && root.right == null)) return null;
      return root;
    }
    
    
}
