package com.algos.geeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.algos.geeks.MergeTwoLL.ListNode;

public class UnionAndIntersection {

	public static void main(String[] args) {
	//Load first list
		ListNode l1 = new ListNode(8);
		ListNode four = new ListNode(4);
		ListNode three = new ListNode(3);
		ListNode eight = new ListNode(6);
		ListNode seven = new ListNode(9);
		l1.next = four;
		four.next = three;
		three.next = eight;
		eight.next = seven;
		seven.next = null;
		print(l1);
	//Load second list
		ListNode l2 = new ListNode(5);
		ListNode six = new ListNode(6);
		ListNode fourtwo = new ListNode(9);
		l2.next = six;
		six.next = fourtwo;
		fourtwo.next = null;
		System.out.println();
		print(l2);
		findUnionIntersectFrmMap(unionAndIntersetLL(l1, l2));	
	}
	
	public static void print(ListNode ll) {
		ListNode curr = ll;
		while(curr != null) {
			System.out.print(curr.val);
			System.out.print(",");
			curr = curr.next;
		}
		System.out.println();
	}
	
	public static void findUnionIntersectFrmMap(Map<Integer, Integer> map) {
		List<Integer> unionlist = new ArrayList<Integer>();
		List<Integer> intersectionlist = new ArrayList<Integer>();
		for(Integer key : map.keySet()) {
			if(map.get(key) > 1) {
				intersectionlist.add(key);
				unionlist.add(key);
			}else {
				unionlist.add(key);
			}
		}
		System.out.println("Intersection List: " + intersectionlist);
		System.out.println("Union List: " + unionlist.toString());
	}
	
	
	public static Map<Integer, Integer> unionAndIntersetLL(ListNode l1, ListNode l2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		ListNode curr1 = l1;
		ListNode curr2 = l2;
		while(curr1 != null || curr2 != null) {
			if(curr1 != null) {
				if(!map.containsKey(curr1.val)){
					map.put(curr1.val, 1);
				}else {
					map.put(curr1.val, map.get(curr1.val) + 1);
				}
				curr1 = curr1.next;
			}
			if(curr2 != null) {
				if(!map.containsKey(curr2.val)){
					map.put(curr2.val, 1);
				}else {
					map.put(curr2.val, map.get(curr2.val) + 1);
				}
				curr2 = curr2.next;
			}
		}
		return map;
	}

}
