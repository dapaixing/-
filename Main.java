/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0726;
class Node{
    int val;
    Node next = null;
    
    Node(int val){
        this.val = val;
    }
}


/**
 *
 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node n1 = new Node(6);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(6);
        Node n5 = new Node(5);
        Node n6 = new Node(1);
        
        n1.next = n2.next;
        n2.next = n3.next;
        n3.next = n4.next;
        n4.next = n5.next;
        n5.next = n6.next;
        
        Node removeAll = removeAll(n1,6);
        System.out.print(removeAll);
        // TODO code application logic here
    }
    public static Node removeAll(Node head,int val){
        Node prev = null;
        Node cur = head;
        while( cur != null){
            if(cur.val == val){
                if(cur == head){
                    head = cur.next;
                }else{
                    prev.next = cur;
                }
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
    public static Node merge(Node head1,Node head2){
        Node cur1 = head1;
        Node cur2 = head2;
        Node result = null;
        Node p = result;
        while(cur2 != null&&cur2 != null){
            if(cur1.val < cur2.val){
                if(result == null){
                    result = cur1;
                }else{
                    p.next = cur1;
                    p = p.next;
                }
                cur1 = cur1.next;
            }else{
                if(result == null){
                    result = cur2;
                }else{
                    p.next = cur2;
                    p = p.next;
                }
                cur2 = cur2.next;
            }
        }
        return result;
    }
    public static Node partition(Node head,int val){
        Node cur = head;
        Node max = null;
        Node p = max;
        Node min = null;
        Node t = min;
        while(cur != null){
            if(cur.val < val){
                if(min == null){
                    min = cur;
                }else{
                    t.next = cur;
                }
                t = t.next;
                cur = cur.next;
            }else{
                if(max == null){
                    max = cur;
                }else{
                    p.next = cur;
                }
                p = p.next;
                cur = cur.next;
            }
        }
        if(min == null){
            p.next = null;
            return max;
        }else{
            if(max == null){
            t.next = max;
            return min;
        }else{
                p.next = null;
                t.next = max;
                return min;
            }
        }
    }
    public static Node FindKthToTail(Node head,int k){
        Node cur = head;
        Node next = head;
        while(k-1>0){
            next = next.next;
            if(next == null){
                return null;
            }
        }
        while(next.next != null){
            next = next.next;
            cur = cur.next;
        }
        return cur;
    }
}
