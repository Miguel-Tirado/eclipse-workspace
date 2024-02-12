
public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list1 = new ListNode(1);
		ListNode temp = list1;
		
		ListNode list2 = new ListNode(1);
		ListNode temp2 = list2;
		
		// point the temp head to a newly created node with a val of 2 
		temp.next = new ListNode(2);
		// Set the pointer to the next node address 
		temp = temp.next;
		
		temp.next = new ListNode(4);
		temp = temp.next;
		temp = list1;
		
		temp2.next = new ListNode(3);
		temp2 = temp2.next;
		
		temp2.next = new ListNode(4);
		temp2 = temp2.next;
		temp2 = list2;
		
		ListNode temp3 = mergeTwoLists(list1,list2);
		
		while (temp3 != null) {
			System.out.print(temp3.val + " ");
			temp3 = temp3.next;
		}
		


	}
	
	public static ListNode mergeTwoLists (ListNode list1, ListNode list2) {
		ListNode prehead = new ListNode(-1);
		ListNode cur = prehead;
		
		while (list1 != null && list2 != null) {
			if(list1.val <= list2.val) {
				cur.next = list1;
				list1 = list1.next;
			} else {
				cur.next = list2;
				list2 = list2.next;
			}
			cur = cur.next;
		}
		
		cur.next = list1 == null ? list2 : list1;
		return prehead.next;
	}

}
