package core.tree;

public class RecursiveEx {
    public int factorial(int n) {
        if (n == 1) return 1;           // f(1) = 1
        return n * factorial(n - 1); // f(n) = n * f(n-1)
    }

    public int sum(int[] arr, int n) {
        if (n == 0) return arr[n];          // f(0) = arr[0]
        return arr[n] + sum(arr, n - 1); // f(n) = arr[n] + f(n-1)
    }

    public int fib(int n) {
        if (n <= 1) return n;                 // f(1) = 1, f(0) = 0
        return fib(n - 1) + fib(n - 2); // f(n) = f(n-1) + f(n-2)
    }

    public int count(TreeNode node) {
        if (node == null) return 0;                      // C(null) = 0
        return 1 + count(node.left) + count(node.right); // C(n) = 1 + C(left) + C(right)
    }

    public int maxDepth(TreeNode node) {
        if (node == null) return 0;                                     // D(null) = 0
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right)); // D(n) = 1 + max(D(left), D(right))
    }

    public int sum(TreeNode node) {
        if (node == null) return 0;                           // S(null) = 0
        return node.value + sum(node.left) + sum(node.right); // S(n) = n.value + S(left) + S(right)
    }


    public static void main(String[] args) {
        RecursiveEx ex = new RecursiveEx();
        System.out.println(ex.factorial(4) == 24);

        int[] arr = {1, 2, 3};
        System.out.println(ex.sum(arr, 2) == 6);
    }
}

