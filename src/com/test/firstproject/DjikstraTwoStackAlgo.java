//Arithmetic expression evaluation - using stack and queue - Djikstra's - Two stack algorithm
	/*Left Parenthesis - Ignore
	 Right Parenthesis - Pop operand and 2 values
	 Push that result of applying the operator to the two values to 
	 the operand stack
	 Implement for multiple operations*/
package com.test.firstproject;

import java.util.Scanner;

public class DjikstraTwoStackAlgo {

	int[] operand = new int[8];
	String[] operator = new String[8];
	int operandCount = 0;
	int operatorCount = 0;
	
	public static void main(String[] args) { 
		String expression = "( ( 7 - ( ( 4 * ( 2 + 3 ) )  - 5 ) ) / 2 )";
		DjikstraTwoStackAlgo twoStack = new DjikstraTwoStackAlgo();		
		try {
			System.out.println(twoStack.evaluateDjikstra(expression));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	private int evaluateDjikstra(String expression) throws Exception {	
		try {
			Scanner tokenize = new Scanner(expression);
			while(tokenize.hasNext()) {
				String next = tokenize.next();
				if(next != null && (next.equals("-") || next.equals("+") || next.equals("*") || next.equals("/"))) {
					pushOperator(next.trim());
				}else if(next.equals(")")) {
					boolean push = false;
					int result = 0;
					int value1 = popOperand();
					int value2 = popOperand();
					String opator = popOperator();
					switch(opator) {
					case "*": 
						result = (value1 * value2);
						push = true;
						break;
					case "/": 
						result = (value2 / value1 );
						push = true;
						break;
					case "+": 
						result = (value1 + value2);
						push = true;
						break;
					case "-": 
						result = (value2 - value1);
						push = true;
						break;
					case "":
						push = false;
						break;
					}
					if(push) {
						pushOperand(result);
					}
				}else if(next != null && !next.equals("(")){
					pushOperand(Integer.valueOf(next));
				}
			}
		}catch(Exception ex) {
			throw ex;
		}
		return popOperand();
	}
	
	private String popOperator() {
		if(operatorCount >0) {
			operatorCount = operatorCount-1;
			String opator = operator[operatorCount];
			 operator[operatorCount] = "";
			return opator;
		}
		return "";
	}

	private int popOperand() {
		if(operandCount >0) {
			operandCount = operandCount-1;
			int opand = operand[operandCount];
			operand[operandCount] = 0;
			return opand;
		}
		return 0;
	}

	private void pushOperand(int opand){
		if(operandCount < operand.length)
			operand[operandCount++] = opand;
	}
	
	private void pushOperator(String string){
		if(operandCount < operand.length)
			operator[operatorCount++] = string;
	}

}
