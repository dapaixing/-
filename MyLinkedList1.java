class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        Node next = null;
    }
}

public class MyLinkedList {
    public static void main(String[] args) {
        Node head = null;
        head = pushFront(head,0);
        head = pushFront(head,1);
        head = pushFront(head,2);
        head = pushFront(head,3);
        head = pushFront(head,4);
        head = pushFront(head,5);
//        head = pushBack(head,1);
//        head = pushBack(head,2);
//        head = pushBack(head,3);
//        head = pushBack(head,4);
//        head = pushBack(head,5);
//        head = popFront(head);
//        head = popFront(head);
//        head = popFront(head);
//        head = popFront(head);
//        head = popFront(head);
//        head = popBack(head);
//        head = popBack(head);
//        head = popBack(head);
//        head = popBack(head);
//        head = popBack(head);
        //head = reversList(head);
        print(head);
    }

    public static Node pushFront(Node head,int val) {
        Node node = new Node(val);
        node.next = head;
        return node;
    }

    public static void print(Node head){
        for(Node cur = head;cur != null;cur = cur.next){
            System.out.print(cur.value+" ");
        }
    }
    public static Node pushBack(Node head, int val) {
        Node node = new Node(val);

        if (head == null) {
            return node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
            return head;
        }
    }

    public static Node popFront(Node head) {
        if (head == null) {
            System.out.println("链表为空，不能删除！");
            return null;
        }
        head = head.next;
        return head;
    }

    public static Node popBack(Node head) {
        if (head == null) {
            System.out.println("链表为空不能删除！");
            return head;
        }
        Node last = head;
        if (last.next == null) {
            last = null;
            return head;
        } else {
            while (last.next.next != null) {
                last = last.next;
            }
            last.next = null;
            return head;
        }
    }

    public static Node reversList(Node head) {
        if (head == null) {
            return head;
        }
        Node p1 = head;
        Node p2 = head;
        Node p3 = head.next;
        while (p3 != null) {
            p2.next = p3.next;
            p3.next = p1;
            p1 = p3;
            p3 = p2.next;

        }
        return p1;
    }

    public static void pushAfter(Node pos, int val) {
        Node node = new Node(val);
        node.next = pos.next;
        pos.next = node;
    }

    public static Node removeElements(Node head, int val) {
        Node cur = null;
        if (head == null) {
            System.out.println("链表为空不能删除！");
        } else {
            Node tmp = head;
            while (tmp != null) {
                if (tmp.next.value == val) {
                    cur = tmp;
                    cur.next = tmp.next.next;
                    tmp = cur.next;
                } else {
                    cur = tmp;
                    tmp = tmp.next;
                }
            }
        }
        if (head.value == val) {
            head = head.next;
        }
        return head;
    }

    //找到两个链表相交的起始节点
    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Node pa = headA;
        Node pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

    public static boolean Solution(Node head) {
        if (head == null || head.next == null) {
            return false;
        } else {
            Node cur = head;
            Node tmp = head;
            while (tmp != null && tmp.next != null) {
                cur = cur.next;
                tmp = tmp.next.next;
                if (cur == tmp) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Node detectCycle(Node head) {
        Node cur = head;
        Node tmp = head;
        boolean t = false;
        while (tmp != null || tmp.next != null){
            cur = cur.next;
            tmp = tmp.next.next;
            if(cur == tmp){
                t = false;
                break;
            }
        }
        if(t){
            Node p = head;
            while (p != cur) {
                p = p.next;
            }
            return p;
        }
        return null;
    }
}
