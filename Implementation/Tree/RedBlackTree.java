package Implementation.Tree;

class RedBlackTree {

    static class Node {
        int value;
        Node parent, left, right;
        boolean color; // true for RED, false for BLACK

        Node(int value) {
            this.value = value;
            parent = left = right = null;
            color = true; // New nodes are initially red
        }
    }

    private Node root;

    private void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;

        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }

        rightChild.parent = node.parent;

        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }

        rightChild.left = node;
        node.parent = rightChild;
    }

    private void rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;

        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }

        leftChild.parent = node.parent;

        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }

        leftChild.right = node;
        node.parent = leftChild;
    }

    private void fixInsert(Node node) {
        while (node.parent != null && node.parent.color) {
            Node parent = node.parent;
            Node grandparent = parent.parent;

            if (parent == grandparent.left) {
                Node uncle = grandparent.right;

                // Case 1: Uncle is red
                if (uncle != null && uncle.color) {
                    parent.color = false; // Black
                    uncle.color = false; // Black
                    grandparent.color = true; // Red
                    node = grandparent;
                } else {
                    // Case 2: Node is a right child
                    if (node == parent.right) {
                        node = parent;
                        rotateLeft(node);
                    }
                    // Case 3: Node is a left child
                    parent.color = false; // Black
                    grandparent.color = true; // Red
                    rotateRight(grandparent);
                }
            } else {
                Node uncle = grandparent.left;

                // Mirror Cases
                if (uncle != null && uncle.color) {
                    parent.color = false;
                    uncle.color = false;
                    grandparent.color = true;
                    node = grandparent;
                } else {
                    if (node == parent.left) {
                        node = parent;
                        rotateRight(node);
                    }
                    parent.color = false;
                    grandparent.color = true;
                    rotateLeft(grandparent);
                }
            }
        }
        root.color = false; // Ensure root is always black
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            root.color = false; // Root is always black
            return;
        }

        Node current = root;
        Node parent = null;

        // BST insertion
        while (current != null) {
            parent = current;
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                return; // Duplicate values not allowed
            }
        }

        newNode.parent = parent;
        if (value < parent.value) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        // Fix violations of Red-Black Tree properties
        fixInsert(newNode);
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(node.value + " ");
            traverseInOrder(node.right);
        }
    }
}

