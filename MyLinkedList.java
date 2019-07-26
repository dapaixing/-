class Node{
    int val;//date|element
    Node next;//如果 next == null 表示最后一个节点


    public Node(int val) {
        this.val = val;
        Node next = null;
    }

    public String toString(){
        return String.format("Node(%d)",val);
    }

}
public class MyLinkedList{
    public static void main(String[] args){
        Node head = null;
        head = pushFront(head,0);
        head = pushFront(head,1);
        head = pushFront(head,2);
        head = pushFront(head,0);
        head = pushFront(head,0);
		/*
		head = popBack(head);
		head = popFront(head);
		head = popFront(head);
		head = popFront(head);
		*/
        //head = reverseList(head);
		/*
		for(Node cur = head;cur != null;cur = cur.next){
			System.out.println(cur);
		}
		*/

        print(head);
    }
    /*
    int val = 0;
    Node node = new Node(val);
    node.new = head;
    head = node;
    */
    //头插
    private static Node pushFront(Node head,int val){
        Node node = new Node(val);
        node.next = head;
        return node;
    }
    //尾插
    private static Node pushBack(Node head,int val){
        Node node = new Node(val);

        if(head == null){
            return node;
        }
        else{
            Node last = head;
            while(last.next != null){
                last = last.next;
            }
            last.next = node;
            return head;
        }
    }
    //头删
    private static Node popFront(Node head){
        if(head == null){
            System.err.println("链表为空，不能删除！");
            return head;
        }
        head = head.next;
        return head;
    }
    //尾删
    private static Node popBack(Node head){
        if(head == null){
            System.err.println("链表为空，不能删除！");
            return head;
        }
        Node last = head;
        if(last.next == null){
            last = null;
            return head;
        }
        else{
            while(last.next.next != null){
                last = last.next;
            }
            last.next = null;
            return head;
        }
    }
    //打印
    private static void print(Node head){
        for(Node cur = head;cur != null;cur = cur.next){
            System.out.println(cur);
        }
    }
    //反转链表
    public static Node reverseList(Node head){
        if(head == null){
            return head;
        }
        Node p1 = head;
        Node p2 = head.next;
        Node p3 = head;
        while (p2 != null){
            p3.next = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3.next;
        }
        return p1;

    }
    private static void pushAfter(Node pos,int val){
        Node node = new Node(val);
        node.next = pos.next;
        pos.next = node;
    }
    public static Node removeElements(Node head,int val){
        Node cur = null;
        if(head == null){
            return null;
        }
        else{
            Node next = head;
            while (next != null){
                if(next.next.val == val){
                    cur = next;
                    cur.next = next.next.next.
                            next = cur.next;
                }
                else{
                    cur = next;
                    next = next.next;
                }
            }
        }
        if(head.val == val){
            head = head.next;
        }
        return head;
    }
    //找到两个单链表相交的起始节点
    public static Node getIntersectionNode(Node headA, Node headB){
        if (headA == null||headB == null){
            return null;
        }
        Node pa = headA;
        Node pb = headB;
        while(pa != pb){
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
    //判断环形链表
    public static boolean Solution(Node head){
        if(head == null || head.next == null)
            return  false;
        Node cur = head;
        Node next = head;
        while (next !=null && next.next!= null){
            cur = cur.next;
            next = next.next.next;
            if(cur == next){
                return true;
            }
        }
        return false;
    }
    //环形链表的第一个节点
    public static Node detectCycle(Node head){
        Node cur = head;
        Node next = head;
        boolean t = false;
        while (next !=null && next.next!= null){
            cur = cur.next;
            next = next.next.next;
            if(cur == next){
                t = true;
                break;
            }
        }
        if(t){
            Node p = head;
            while (p != cur){
                p = p.next;
                cur = cur.next;
            }
            return p;
        }else
            return null;
    }
}