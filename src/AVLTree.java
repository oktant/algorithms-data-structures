package com.azerfon;

import java.util.Scanner;

/**
 * Created by oalizada on 12/15/2016.
 */
public class AVLTree {
    TreeNode root;

    class TreeNode {
        TreeNode parent, left, right;
        int height = 0;
        int key;

        public TreeNode( int key, TreeNode left, TreeNode right,TreeNode parent) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.key = key;

        }

        public String toString() {
            return ("key=" + key + " height=" + height);
        }
    }

    public void insert(TreeNode node, TreeNode insertNode) {
        if (root == null) {
            root = insertNode;
        }
        if (insertNode.key < node.key) {
            if (node.left != null) {
                insert(node.left, insertNode);
            } else {
                insertNode.parent = node.left;
                node.left = insertNode;
            }


        }
        if (insertNode.key >= node.key) {
            if (node.right != null) {
                insert(node.right, insertNode);

            } else {
                insertNode.parent = node.right;
                node.right = insertNode;
            }


        }
        updateHeights(insertNode);
        balance(insertNode);

    }



    public TreeNode findNode(TreeNode find, TreeNode node) {
        if (root == null) {
            return null;
        }
        if (find.key == node.key) {
            return node;
        } else if (find.key < node.key) {
            return findNode(find, node.left);

        } else if (find.key > node.key) {
            return findNode(find, node.right);
        }


        return null;
    }

    public boolean deleteNode(TreeNode deletedNode, TreeNode node) {
        if (root == null) {
            return false;

        } else if (root.key == deletedNode.key) {
            if (root.right == null && root.left == null) {
                root = null;
            } else if (root.right == null) {
                root = root.left;
                root.parent = null;
            } else if (root.left == null) {
                root = root.right;
                root.parent = null;
            } else {
                TreeNode min = root.right;
                if (min.right == null && min.left == null) {
                    root.key = min.key;
                    root.right = null;
                    updateHeights(root);
                    balance(root);
                    return true;
                }
                while (min.left != null) {
                    min = min.left;
                }
                root.key = min.key;
                if (min.right != null) {
                    min.right.parent = min.parent;
                }
                if (min.parent != root) {
                    min.parent.left = min.right;
                } else {
                    min.parent.right = min.right;
                }
                updateHeights(min.parent);
                balance(min.parent);
            }
            return true;
        } else {
            TreeNode locatedNode = findNode(deletedNode, root);
            if (locatedNode != null) {
                deleteHelper(locatedNode);

            } else return false;

        }
        return true;
    }

    public void deleteHelper(TreeNode locatedNode) {
        boolean left = (locatedNode.parent.left == locatedNode);
        if (locatedNode.right == null && locatedNode.left == null) {
            if (left) {
                locatedNode.parent.left = null;
            } else {
                locatedNode.parent.right = null;
            }
        } else if (locatedNode.right == null) {
            locatedNode.left.parent = locatedNode.parent;
            if (left) {
                locatedNode.parent.left = locatedNode.left;
            } else locatedNode.parent.right = locatedNode.right;
        } else if (locatedNode.left == null) {
            locatedNode.right.parent = locatedNode.parent;
            if (left) {
                locatedNode.parent.left = locatedNode.right;
            } else {
                locatedNode.parent.right = locatedNode.right;
            }


        } else if (locatedNode.right != null && locatedNode.left != null) {
            TreeNode min = locatedNode.right;
            if (min.left == null && min.right == null) {
                locatedNode.key = min.key;
                locatedNode.right = null;
                return;
            }
            while (min.left != null) {
                min = min.left;
            }
            locatedNode.key = min.key;
            if (min.right != null) {
                min.right.parent = min.parent;
            }
            if (min.parent != locatedNode) {
                min.parent.left = min.right;
            } else {
                min.parent.right = min.right;
            }
            updateHeights(min.parent);
            balance(min.parent);
            return;
        }
        updateHeights(locatedNode.parent);
        balance(locatedNode.parent);
    }

    public void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.println(node + "\n");
        printTree(node.right);
    }
    public void updateHeights(TreeNode node){
        if(node==null){
            return;
        }
        int left=-1;
        int right=-1;
        if(node.left!=null){
            left=node.left.height;
        }
        if(node.right!=null){
            right=node.right.height;
        }
        node.height=Integer.max(left, right)+1;
        updateHeights(node.parent);
    }
    public int checkBalance(TreeNode node){
        int subleft=-1, subright=-1;
        if(node.right!=null)subright=node.right.height;
        if(node.left!=null)subleft=node.left.height;
        int balance=subleft-subright;
        return balance;
    }
    private void balance(TreeNode node){
        int balance=checkBalance(node);
        if(balance<-1){
            if(checkBalance(node.right)==1) rotateRight(node.right);
            rotateLeft(node);
        }
        else if(balance>1){
            if(checkBalance(node.left)==1) rotateLeft(node.left);
            rotateRight(node);
        }
        if(node.parent!=null) balance(node.parent);

    }
    private void rotateRight(TreeNode node){
        TreeNode keep=null;
        if(node.right!=null){
            keep=node.right;
        }
        TreeNode newNode=new TreeNode(node.key,node.left.right, null, node);
        node.right=newNode;
        node.key=node.left.key;
        if(node.left.right!=null) node.left.right.parent=newNode;
        if(node.left.left!=null) node.left.left.parent=node;
        node.left=node.left.left;
        if(keep!=null){
            node.right.right=keep; keep.parent=node.right;
        }
        updateHeights(newNode);
    }
    private void rotateLeft(TreeNode node) {
       
        System.out.println("Need to rotate node " + node + " left!");

        TreeNode keepAlive = null;
        if(node.left!=null) {keepAlive = node.left; System.out.println("Need to keep alive "+keepAlive.key) ; }

        TreeNode newNode = new TreeNode(node.key, null, node.right.left, node);
        node.left = newNode;
        node.key = node.right.key;
    
        if (node.right.left != null) node.right.left.parent = newNode;
        if (node.right.right != null) node.right.right.parent = node;

        node.right = node.right.right;
        if(keepAlive!=null){ node.left.left = keepAlive; keepAlive.parent = node.left;}
        updateHeights(newNode);
    }

    public void consoleUI() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.- Add items\n"
                    + "2.- Delete items\n"
                    + "3.- Check items\n"
                    + "4.- Print tree\n"
                    + "5.- Delete tree\n");
            int choice = scan.nextInt();

            int item;
            TreeNode node;
            switch (choice) {
                case 1:
                    item = scan.nextInt();
                    while (item != -999) {
                        node = new TreeNode(item, null, null, null);
                        insert(node, root);
                        item = scan.nextInt();
                    }
                    printTree(root);
                    break;
                case 2:
                    item = scan.nextInt();
                    while (item != -999) {
                        node = new TreeNode(item, null, null, null);
                        System.out.print("\nDeleting item " + item);
                        if (deleteNode(node, root)) {
                            System.out.print(": deleted!");
                        } else {
                            System.out.print(": does not exist!");
                        }
                        item = scan.nextInt();
                    }
                    System.out.println();
                    printTree(root);
                    break;
                case 3:
                    item = scan.nextInt();
                    while (item != -999) {
                        node = new TreeNode(item, null, null, null);
                        System.out.println((findNode(node, root) != null) ? "found" : "not found");
                        item = scan.nextInt();
                    }
                    break;
                case 4:
                    printTree(root);
                    break;
            }
        }
    }
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        avl.consoleUI();
    }
}










