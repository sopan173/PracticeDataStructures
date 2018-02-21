public class LevelOrderTraversal{
    static class Node{
        Node left,right;
        int data;
        Node(int d){
            this.left = this.right = null;
            this.data = d;
        }
    }
    
    static class BinaryTree{
        Node root;
        BinaryTree(){
            this.root = null;
        }
    }
    public static void main(String [] agrs){
        BinaryTree bt =  new BinaryTree();
        bt.root = new Node(10);
        bt.root.left = new Node(20);
        bt.root.right = new Node(30);
        bt.root.left.left = new Node(25);
        getLevel(bt.root);
    }
    static void getLevel(Node root){
        int height = getHeight(root);
        for(int i = 0 ; i <= height; i++){
            printAtLevel(root,i);
        }
    }
    static void printAtLevel(Node node, int lev){
        if(node == null){
            return;
        }
        if(lev == 1){
             System.out.println(node.data+ " ");
        }else if(lev>1){
            printAtLevel(node.left, lev-1);
            printAtLevel(node.right, lev-1);
        }
    }
    
    static int getHeight(Node node){
        if(node ==null){
            return 0;
        }
        int lheight = getHeight(node.left);
        int rheight = getHeight(node.right);
        if(lheight > rheight)
            return lheight+1;
        return rheight+1;
    }
    
}
