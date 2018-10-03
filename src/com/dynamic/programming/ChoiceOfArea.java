package com.dynamic.programming;

public class ChoiceOfArea {
	 int inA, inB,  x1, x2;
	 int y1,  y2,  z1,  z2;
	
	public ChoiceOfArea(int inA, int inB, int x1, int x2, int y1, int y2, int z1, int z2) {
		this.inA = inA;
		this.inB = inB;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.z1 = z1;
		this.z2 = z2;
	}
	
	public String choiceOfArea() {
		StringBuilder str = new StringBuilder();
		while(inA >0 && inB>0) {
			if(inA + x1 >=0 && inB + x2 >=0) {
				inA = inA + x1;
				inB = inB + x2;
				str.append("X");
			}
			if(inA + y1 >=0 && inB + y2 >=0) {
				inA = inA + y1;
				inB = inB + y2;
				str.append("Y");
			}
			if(inA + z1 >=0 && inB + z2 >=0) {
				inA = inA + z1;
				inB = inB + z2;
				str.append("Z");
			}
		}
		return str.toString();
	}
	
	public static void main(String[] args) {
		ChoiceOfArea coA = new ChoiceOfArea(20, 8, 3, 2, -5, -10, -20, 5);
		System.out.println(coA.choiceOfArea());
	}

}
