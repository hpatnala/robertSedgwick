package com.test.firstproject;

import com.test.dto.MinStackDTO;

public class MinStack {
	int[] arr = new int[5];
	int count = 0;
	static MinStackDTO stackDto = new MinStackDTO();
	int minVal = 0;
	
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(8);
		stack.push(4);
		stack.push(5);
		stack.push(2);
		System.out.println(stackDto.getMinVal());
	}
	
	private void push(int input) {
		arr[count++] = input;
		getMinValueAtThisPoint(input, "push");
	}

	private void getMinValueAtThisPoint(int input, String type) {	
		if(count == 1) {
			stackDto.setMinVal(input);
		}else 
			if(input < stackDto.getMinVal()) {
				stackDto.setMinVal(input);
		}	
	}
	
	private int pop() {
		int popValue = arr[count--];
		getMinValueAtThisPoint(popValue, "pop");	
		
		return popValue;
	}

}
