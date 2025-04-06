package Implementation.Tree;

class AVLTree {
    static class Node {
        int value, height;
        Node left, right;

        Node(int value) {
            this.value = value;
            height = 1; // A new node starts with height 1
        }
    }

    Node root;

    int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    int getBalanceFactor(Node node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    Node rotateRight(Node y) {
        Node x = y.left;
        Node T = x.right;

        // Perform rotation
        x.right = y;
        y.left = T;

        // Update heights
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x; // New root
    }

    Node rotateLeft(Node x) {
        Node y = x.right;
        Node T = y.left;

        // Perform rotation
        y.left = x;
        x.right = T;

        // Update heights
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y; // New root
    }

    Node insert(Node node, int value) {
        // Regular BST insertion
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            // Duplicate values not allowed
            return node;
        }

        // Update height of current node
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        // Get balance factor and balance the tree
        int balance = getBalanceFactor(node);

        // Left heavy
        if (balance > 1 && value < node.left.value) {
            return rotateRight(node);
        }

        // Right heavy
        if (balance < -1 && value > node.right.value) {
            return rotateLeft(node);
        }

        // Left-Right case
        if (balance > 1 && value > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right-Left case
        if (balance < -1 && value < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(node.value + " ");
            traverseInOrder(node.right);
        }
    }
}

