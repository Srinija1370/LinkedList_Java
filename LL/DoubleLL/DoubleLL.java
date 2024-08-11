class Node{
    int data;
    Node next;
    Node back;
    Node(int data1,Node next1,Node back1){
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }
    Node(int data1){
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}
public class DoubleLL{
    public static Node arrtodll(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    public static void Traversal(Node head){
        System.out.print("List: ");
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.print("\n");
    }
    public static Node DeleteHead(Node head){
        System.out.print("Deletion at Head: ");
        if(head == null || head.next == null){
            return null;
        }
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }
    public static Node DeleteTail(Node head){
        System.out.print("Deletion at Tail: ");
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node prev = temp.back;
        prev.next = null;
        temp.back = null;
        return head;
    }
    public static Node DeletePostion(Node head,int k){
        System.out.print("Delete at position "+k+": ");
        Node temp = head;
        int c = 0;
        while(temp != null){
            c++;
            if(c == k){
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        Node front = temp.next;

        if(prev == null && front == null){
            return null;
        }else if(prev == null){
            return DeleteHead(head);
        }else if(front == null){
            return DeleteTail(head);
        }

        prev.next = front;
        front.back = prev;
        temp.back = null;
        temp.next = null;
        return head;
    }
    public static Node DeleteNode(Node head,Node temp){
        System.out.print("Delete Node: ");
        Node prev = temp.back;
        Node front = temp.next;
        if(front == null){ //tail node
            prev.next = null;
            temp.back = null;
        }
        else{
            prev.next = front;
            front.back = prev;
            temp.next = null;
            temp.back = null;
        }
        return head;
    }
    public static Node InsertBeforeHead(Node head,int val){
        System.out.print("Insertion before head: ");
        if(head == null)
            return new Node(val);
        Node newnode = new Node(val,head,null);
        head.back = newnode;
        return newnode;
    }
    public static Node InsertBeforeTail(Node head,int val){
        System.out.print("Insertion before tail: ");
        if(head == null){
            return new Node(val);
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node prev = temp.back;
        Node newnode = new Node(val,temp,prev);
        prev.next = newnode;
        temp.back = newnode;
        return head;
    }
    public static Node InsertBeforeKthNode(Node head,int val,int k){
        System.out.print("Insertion before node-"+k+": ");
        if(k == 1){
            return InsertBeforeHead(head,val);
        }
        Node temp = head;
        int c = 0;
        while(temp != null){
            c++;
            if(c == k){
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        Node newnode = new Node(val,temp,prev);
        prev.next = newnode;
        temp.back = newnode;
        return head;
    }
    public static void InsertionBeforeNode(Node head,int val,Node node){
        System.out.print("Insertion before "+node.data+": ");
        Node prev = node.back;
        Node newnode = new Node(val,node,prev);
        prev.next = newnode;
        node.back = newnode;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        Node head = arrtodll(arr);
        Traversal(head);

        //Delete at head
        head = DeleteHead(head);
        Traversal(head);

        //Delete at tail
        head = DeleteTail(head);
        Traversal(head);

        //Delete at kth position 
        head = DeletePostion(head,3);
        Traversal(head);

        //Delete node 
        head = DeleteNode(head,head.next);
        Traversal(head);

        //Insertion before head
        head = InsertBeforeHead(head,100);
        Traversal(head);

        //Insetion before tail
        head = InsertBeforeTail(head,120);
        Traversal(head);

        //Insertion before kth position
        head = InsertBeforeKthNode(head,140,3);
        Traversal(head);

        //Insertion before node
        InsertionBeforeNode(head,200,head.next.next);
        Traversal(head);
    }
}