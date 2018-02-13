public class LinkedList{
    Node head;
    class Node{
        Node next;
        int data;
        Node(int d){
            data = d;
            next = null;
        }
    }
    
    public void append(int data){
        Node newnode = new Node(data);
        //apend at head
        if(head==null){
            head = new Node(data);
            return;
        }
        //append at last
        Node last = head;
        while(last.next!=null){
            last = last.next;
        }
        last.next = newnode;
    }
    
    public void push(int newdata){
        Node newnode = new Node(newdata);
        if(head ==null){
            head = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }
    
    //insert after node or location
    public void insertAfter(int loc, int newdata){
        Node newnode = new Node(newdata);
        int i=0;
        Node temp = head;
        while(i<loc-1){
            temp = temp.next;
            i++;
        }
        Node after = temp.next;
        temp.next = newnode;
        newnode.next = after;
    }
    //print nodes
    public void printNodes(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data+" - ");
            temp = temp.next;
        }
    }
    //get count of nodes
    public int getCountRec(Node temp){
        if(temp==null){
            return 0;
        }
        return getCountRec(temp.next)+1;
    }
    //wrapper class
    public int getCount(){
        System.out.println("Node Count - "+getCountRec(head));
        return getCountRec(head);
    }
    //reversing
    public Node reverse(Node node){
        Node next = null;
        Node prev = null;
        Node curr = head;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return prev;
    }
    public Node reverseNodes(){
        return reverse(head);
    }
    public static void main(String [] args){
        System.out.println("test");
        LinkedList ll = new LinkedList();
        ll.append(10);
        ll.push(20);
        ll.push(30);
        ll.append(40);
        ll.insertAfter(2,4);
        ll.printNodes();
        ll.getCount();
        ll.reverseNodes();
        ll.printNodes();
   
    }
}
