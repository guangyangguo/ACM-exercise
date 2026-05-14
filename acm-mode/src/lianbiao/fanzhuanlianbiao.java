package lianbiao;

public class fanzhuanlianbiao {

    /*
    * 206 翻转链表
    * */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode res = reverseList(head);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prenode = null;
        ListNode nextnode = head.next;
        ListNode currnode = head;
        while (nextnode != null){
            currnode.next = prenode;
            prenode = currnode;
            currnode = nextnode;
            nextnode = nextnode.next;
        }
        currnode.next = prenode;
        return currnode;
    }
}
