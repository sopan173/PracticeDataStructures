public class DLL{
    static Node head = null;
    class Node{
        Node next;
        Node prev;
        int data;
        Node(int d){
            this.data = d;
            this.next = null;
            this.prev = null;
        }
    }
    
    //append
    void push(int data){
        Node temp = new Node(data);
        if(head ==null){
            head = temp;
            return;
        }
        temp.next = head;
        head.prev = temp;
        head = temp;
    }
    void print(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data+" - ");
            temp = temp.next;
        }
    }
    
    Node getMiddle(Node node){
        Node slow = node;
        Node fast = node;
        while(fast.next != null  && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
        }
        Node temp = slow.next;
        slow.next = null;
     //   System.out.println("Middle - "+temp.data);
        return temp;
    }
    // merge sorting
    Node mergeSort(Node node){
        if(node == null || node.next == null){
            return node;
        }
        Node right = getMiddle(node);
        node = mergeSort(node);
        right = mergeSort(right);
        return merge(node,right);
    }
    //merging
    Node merge(Node first, Node second){
        if(first == null){
            return second;
        }
        if(second == null){
            return first;
        }
        if(first.data < second.data){
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        }else{
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }
    
    //reversing list
    void reverse(){
        if(head == null){
            return;
        }
        Node current = head;
        Node prev = null;
        Node temp = null;
        while(current != null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current= current.prev;
        }
        if(temp != null){
            head = temp.prev;
        }
    }
    
    public static void main(String [] args){
        System.out.println("tst");
        DLL dll = new DLL();
        dll.push(10);
        dll.push(20);
        dll.push(30);
        dll.push(40);
        dll.push(34);
        dll.push(22);
        dll.push(12);
        dll.push(19);
        dll.print();
        head = dll.mergeSort(head);
        System.out.println("Merge Sorting - ");
        dll.print();
        dll.reverse();
        System.out.println("Reversing - ");

        dll.print();

    }
    
    
    
}
