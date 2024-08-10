class Node{
    int data;
    Node next;
    Node(int data1,Node next1){
        data = data1;
        next = next1;
    }
    Node(int data1){
        data = data1;
        next = null;
    }
}

public class ArrToLL{
    public static Node arrtoll(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void Traversal(Node head){
        Node temp = head;
        System.out.print("List: ");
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print("\n");
    }
    public static int lengthofLL(Node head){
        int c = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            c++;
        }
        return c;
    }
    public static String searchInLL(Node head,int val){
        System.out.println("Search "+val+" in list: ");
        Node temp = head;
        while(temp != null){
            if(temp.data == val)
                return "found";
            temp = temp.next;
        }
        return "not found";
    }
    public static Node DeleteHead(Node head){
        System.out.print("Delete at head: ");
        if(head == null)
            return head;
        head = head.next;
        return head;
    }
    public static Node DeleteTail(Node head){
         System.out.print("Delete at tail: ");
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    public static Node DeletePositon(Node head,int k){
         System.out.print("Delete at position "+k+": ");
        if(head == null){
            return head;
        }
        if(k == 1){
            head = head.next;
            return head;
        }
        int c = 0;
        Node temp = head;
        Node prev = null;
        while(temp != null){
            c++;
            if(c == k){
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    public static Node DeleteEle(Node head,int val){
         System.out.print("Delete value: "+val+": ");
        if(head == null)
            return null;
        if(head.data == val){
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp != null){
            if(temp.data == val){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    public static Node InsertHead(Node head,int val){
        System.out.print("Insertion at head: ");
        Node temp = new Node(val,head);
        return temp;
    }
    public static Node InsertTail(Node head,int val){
        System.out.print("Insertion at tail: ");
        if(head == null){
            return new Node(val);
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newnode = new Node(val);
        temp.next = newnode;
        return head;
    }
    public static Node Insertposition(Node head,int ele,int k){
        if(head == null){
            if(k == 1){
                return new Node(ele);
            }
            else{
                return head;
            }
        }
        if(k == 1){
            return new Node(ele,head);
        }
        int c = 0;
        Node temp = head;
        while(temp != null){
            c++;
            if(c == k-1){
                Node newnode = new Node(ele);
                newnode.next = temp.next;
                temp.next = newnode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    public static Node InsertBeforeValue(Node head,int ele,int val){
        if(head == null)
            return null;
        if(val == head.data){
            return new Node(ele,head);
        }
        Node temp = head;
        while(temp.next != null){
            if(temp.next.data == val){
                Node newnode = new Node(ele,temp.next);
                temp.next = newnode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args){
        int[] arr = {34,4,6,8,56,45};
        Node head = arrtoll(arr);
        // System.out.println(head.data); 

        //Traversal
        Traversal(head);

        //Length of linked list
        System.out.println("Length: "+lengthofLL(head));

        //search an ele in ll
        System.out.println(searchInLL(head,62));

        //Delete head
        head = DeleteHead(head);
        Traversal(head);

        //Delete tail
        head = DeleteTail(head);
        Traversal(head);

        //Delete at position 'k'
        head = DeletePositon(head,3);
        Traversal(head);

        //Delete an element
        head = DeleteEle(head,6);
        Traversal(head);

        //Insert at head
        head = InsertHead(head,5);
        Traversal(head);

        //Insert at tail
        head = InsertTail(head,17);
        Traversal(head);

        //Insert at position
        head = Insertposition(head,19,4);
        Traversal(head);

        //Insert before value
        head = InsertBeforeValue(head,28,17);
        Traversal(head);
    }
}