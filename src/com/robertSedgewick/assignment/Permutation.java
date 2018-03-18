package com.robertSedgewick.assignment;

import java.util.Arrays;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
	public static void main(String[] args) {
			System.out.println("Please enter some input");
			String str1 = "";
			str1 = StdIn.readLine();
			
			String[] stdInputArray = str1.split(" ");
			System.out.println(Arrays.toString(stdInputArray));
			RandomizedQueue<String> randomQueue = new RandomizedQueue<String>();
			int i=0;
			while(i < stdInputArray.length) {
				randomQueue.enqueue(stdInputArray[i++]);
			}	
			
			Iterator<String> iterator = randomQueue.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			
			System.out.println("Please enter the number of indexes that needs to be printed");
			int myInput = StdIn.readInt();
			
			while(myInput >0) {
				System.out.println(randomQueue.dequeue());
				--myInput;
			}
	}
}
