public class AVL {
    public AVL() {
    }

    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
            this.height = 0;
        }

        public int getval() {
            return value;
        }
    }

    private Node root;

    public int height() {
        return height(root);
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    public Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        } else if (value >= node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    public Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            if (height(node.left.left) - height(node.left.right) > 0) {
                return rightrot(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                node.left = leftrot(node.left);
                return rightrot(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            if (height(node.right.left) - height(node.right.right) < 0) {
                return leftrot(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                node.right = rightrot(node.right);
                return leftrot(node);
            }
        }

        return node;
    }

    public Node leftrot(Node p) {
        Node c = p.right;
        Node t2 = c.left;

        c.left = p;
        p.right = t2;

        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;

        return c;
    }

    public Node rightrot(Node p) {
        Node c = p.left;
        Node t3 = c.right;

        c.right = p;
        p.left = t3;

        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        return c;
    }

    public void display() {
        //helper Function
        display(this.root, "Root Node is: ");
    }

    public void display(Node node, String msg) {
        if (node == null) {
            return;
        }
        System.out.println(msg + node.value);
        display(node.left, "Left child of " + node.value + " is: ");
        display(node.right, "Right child of " + node.value + " is: ");
    }

    public void oneTimeAdd(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            this.insert(arr[i]);
        }
    }
}
