package com.algos.geeks;

import edu.princeton.cs.algs4.Stack;

public class StringExpression {
	
	boolean isBalanced = true;
	
	public boolean verifybalance(String str) {	
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == '[')	stack.push(str.charAt(i)); 
			else if(str.charAt(i) == '(')	stack.push(str.charAt(i)); 
			else if(str.charAt(i) == '{')	stack.push(str.charAt(i));
			else	 {
				char pop=' ';
				if(!stack.isEmpty())		pop = stack.pop();
				checkForBrackets(str.charAt(i), pop);
			}	
			if(!isBalanced)	break;
		}
		return isBalanced;
	}
	
	private void checkForBrackets(char charAt, Character pop) {
		if(charAt == ')'  &&  pop != '(') {
			isBalanced = false;
		}
		else if(charAt == ']'  &&  pop != '[') {
			isBalanced = false;
		}
		else if(charAt == '}'  &&  pop != '{') {
			isBalanced = false;
		}
	}

	public static void main(String[] args) {
		StringExpression se = new StringExpression();
		System.out.println(se.verifybalance("[()]{}{[()()]()}}"));
	}

}
