package com.algo.leetcode;

public class AddTwoNumbers {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	
	public static void main(String[] args) {
		//Load first list
		ListNode l1 = new ListNode(2);
		ListNode four = new ListNode(4);
		ListNode three = new ListNode(3);
		l1.next = four;
		four.next = three;
		three.next = null;
		print(l1);
		//Load second list
		ListNode l2 = new ListNode(5);
		ListNode six = new ListNode(6);
		ListNode fourtwo = new ListNode(7);
		l2.next = six;
		six.next = fourtwo;
		fourtwo.next = null;
		System.out.println();
		print(l2);
		ListNode l3 = addTwoNumbers(l1, l2);
		System.out.println();
		print(l3);
	}
	
	private static void print(ListNode l3) {
		ListNode current = l3;
		while(current != null) {
			System.out.print(current.val);
			if(current.next != null) {
				System.out.print("->");
			}
			current = current.next;
		}
	}
	
	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carryOn = 0;
		ListNode l3 = null;
		ListNode current = null;
		while(l1 != null && l2 != null) {
			int sum = l1.val + l2.val;
			if(carryOn > 0) {
				sum = sum + carryOn;
			}
			if(sum > 9) {
				carryOn = sum/10;
				if(l3 == null) {
					l3 = new ListNode(sum%10);
					l3.next = null;
					current = l3;
				}else {
					ListNode lfirst = new ListNode(sum%10);
					current.next = lfirst;
					lfirst.next = null;
					current = lfirst;
					
				}
			}else {
				if(l3 == null) {
					l3 = new ListNode(sum%10);
					l3.next = null;
					current = l3;
				}else {
					ListNode lfirst = new ListNode(sum%10);
					current.next = lfirst;
					lfirst.next = null;
					current = lfirst;
				}
			}
			l1 =  l1.next;
			l2 = l2.next;
			
		}
		if(carryOn > 0) {
			ListNode lfirst = new ListNode(carryOn);
			current.next = lfirst;
			lfirst.next = null;
			current = lfirst;
		}
		return l3;
    }
	
	private static void loadToListNode(ListNode l3, int sum, ListNode current) {
		if(l3 == null) {
			l3 = new ListNode(sum%10);
			l3.next = null;
			current = l3;
		}else {
			ListNode lfirst = new ListNode(sum%10);
			current.next = lfirst;
			lfirst.next = null;
			current = lfirst;
			
		}
	}

}
