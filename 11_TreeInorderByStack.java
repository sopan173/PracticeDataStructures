import java.util.*;
public class InorderByStack{
    Node root;
    static class Node{
        Node left, right;
        int data;
        Node(int d){
            this.data = d;
        }
    }
    
    void printInorder(){
        Node node =root;
        if(node == null){
            return ;
        }
        Stack<Node> st = new Stack<Node>();
        while(node != null){
            st.push(node);
            node = node.left;
        }
        while(st.size() > 0){
            node = st.pop();
            System.out.println(node.data);
            if(node.right != null){
                node = node.right;
                while(node !=null){ 
                    st.push(node);
                    node = node.left;
                }
            }
        }
    }
    
    public static void main(String [] agrs){
        InorderByStack tree = new InorderByStack();
        tree.root = new Node(20);
        tree.root.left = new Node(15);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(25);
        tree.printInorder();
    }
}


