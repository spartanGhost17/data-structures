package dataStructures.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    Node root;
    private int height;
    public class Node {
        public int value;
        public Node left;
        public Node right;
        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return this.root;
    }

    public boolean rContains(int value) {
        Node root = this.root;
        return rContains(root, value);
    }

    private boolean rContains(Node currentNode, int value) {
        if(currentNode == null) return false;
        if(currentNode.value == value) return true;
        if(value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }
    public boolean contains(int value) {
        //Node node = new Node(value);
        //if(this.root == null) return false;
        Node temp = this.root;
        while(temp != null) {
            if(value < temp.value) {
                temp = temp.left;
            } else if(value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public void rInsert(int value) {
        if(this.root == null) this.root = new Node(value);
        rInsert(this.root, value);
    }

    public Node rInsert(Node current, int value) {

        if(current == null) return new Node(value);
        if(value < current.value) {
            current.left = rInsert(current.left, value);
        } else if (value > current.value) {
            current.right = rInsert(current.right, value);
        }
        return current;
    }

    public boolean insert(int value) {
        Node node = new Node(value);
        if(this.root == null) {
            this.root = node;
            return true;
        }
        Node temp = this.root;
        while(true) {
            //if it is the same value -> cannot insert
            if(temp.value == node.value) return false;
            if(node.value < temp.value) {//go left
                if(temp.left == null) {
                    temp.left = node;
                    return true;
                }
                temp = temp.left;
            } else { //go right
                if(temp.right == null) {
                    temp.right = node;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    /**
     * delete node recursive
     * @param value
     */
    public void deleteNode(int value) {
        //look for the item
        //check if right exist -> move right as parent
        //else check if left exist -> move left as parent
        if(this.root == null) return;
        deleteNode(this.root, value);
    }

    private Node deleteNode(Node current, int value) {
        if(current == null) return null;

        if(value < current.value) {
            current.left = deleteNode(current, value);
        } else if (value > current.value) {
            current.right = deleteNode(current, value);
        } else {
            if(current.left == null && current.right == null) {
                return null;
            } else if(current.left == null) {
                current = current.right;
            } else if(current.right == null) {
                current = current.left;
            } else {
                int subTreeMin = minValue(current.right);
                current.value = subTreeMin;
                current.right = deleteNode(current.right, subTreeMin);
            }
        }
        return current;
    }

    /**
     * helper to fin min value in sub tree for delete
     * @param current
     * @return
     */
    private int minValue(Node current) {
        while(current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public List<Integer> BFS() {
        Node current = this.root;
        Queue<Node> queue = new LinkedList<>();
        List<Integer> results = new ArrayList<>();
        queue.add(current);

        while(queue.size() > 0) {
            current = queue.remove();
            results.add(current.value);
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
        return results;
    }

    public List<Integer> DFSPreOrder() {
        Node current = this.root;
        List<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if(currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if(currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(this.root);
        return results;
    }

    // Preorder traversal using DFS
    public List<Integer> DFSPreOrder2() {
        List<Integer> result = new ArrayList<>();
        DFSPreOrder2(this.root, result);
        return result;
    }

    private void DFSPreOrder2(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.value); // Process the current node
        DFSPreOrder2(node.left, result); // Recursively traverse left subtree
        DFSPreOrder2(node.right, result); // Recursively traverse right subtree
    }

    /**
     * DFS Post order
     * @return
     */
    public List<Integer> DFSPostOrder() {
        List<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if(currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if(currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
                results.add(currentNode.value);
            }
        }
        new Traverse(this.root);
        return results;
    }
    public List<Integer> DFSPostOrder2() {
        List<Integer> results = new ArrayList<>();
        DFSPostOrder2(this.root, results);
        return results;
    }

    private void DFSPostOrder2(Node current, List<Integer> results) {
        if(current == null) return;
        DFSPostOrder2(current.left, results);
        DFSPostOrder2(current.right, results);
        results.add(current.value);
    }

    public List<Integer> DFSInOrder() {
        List<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if(currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if(currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(this.root);
        return results;
    }

    public List<Integer> DFSInOrder2() {
        List<Integer> results = new ArrayList<>();
        DFSInOrder2(this.root, results);
        return results;
    }

    public void DFSInOrder2(Node currentNode, List<Integer> results) {
        if(currentNode == null) return;
        DFSInOrder2(currentNode.left, results);
        results.add(currentNode.value);
        DFSInOrder2(currentNode.right, results);
    }


    /**
     * search for Max depth of a tree
     * @return
     */
    public int maxDepth() {
        return DFSMaxDepth(this.root);
    }

    public int DFSMaxDepth(Node currentNode) {
        if(currentNode == null) return 0;

        int left = DFSMaxDepth(currentNode.left);//1
        int right = DFSMaxDepth(currentNode.right);
        return 1 + Math.max(left, right);
    }

    /**
     * find minimum depth of binary tree
     * traverse all node in level order BFS, which will place their children in queue for the next level
     * then return at first leaf
     * @return
     */
    public int MinDepth() {
        Node currentNode = this.root;
        if(currentNode == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        int level = 1;
        //[[3], [9, 20], [7, 10], [15, 7]]
        //{1: [3], 2: [9, 20]}
        queue.offer(currentNode);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(node.left == null && node.right == null) {
                    return level;
                }

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return level;
    }
}
