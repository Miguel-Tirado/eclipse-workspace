
public class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) {
		// data part
		this.val = val;
	}
	ListNode (int val, ListNode next) {
		// data part
		this.val = val;
		// address part also a pointer to the next node
		this.next = next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
