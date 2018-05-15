package com.robertSedgewick.assignment;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item>{
		
		private Item[] listOfObjects;
		private int count = 0;
		
		@SuppressWarnings("unchecked")
		public RandomizedQueue() {
			listOfObjects = (Item[]) new Object[20];
		}
		
	   public boolean isEmpty()  {
		  return count == 0;
	   }
	   
	   public int size()    {
		  return count;
	   }
	   
	   public void enqueue(Item item) {
		   if(item == null) {
			  throw new java.lang.IllegalArgumentException();
		   }
		   
		   if (listOfObjects != null && listOfObjects.length >0) {
			  listOfObjects[count++] = item;
		  }
	   }
	   
	   public Item dequeue()   {
		   if(isEmpty()) {
			   throw new java.util.NoSuchElementException();
		   }
		   
		   Item temp = null;
		   if( listOfObjects.length >0) {
			  
			  temp = listOfObjects[StdRandom.uniform(count)];	 
			  count++;
		  }
		  return temp;
	   }
	   
	   public Item sample()   {
		   if(isEmpty()) {
			   throw new java.util.NoSuchElementException();
		   }
		   
		   Item temp = null;
		   if ( listOfObjects.length >0) {
			  temp = listOfObjects[StdRandom.uniform(count)];	  
		   }
		  return temp;
	   }
	   
	   public boolean contains(Item ch) {
		   for(int i=0;i < count; i++) {
			   if(listOfObjects[i] == ch) {
				   return true;
			   }
		   }
		   return false;
	   }
	   
	   @SuppressWarnings("hiding")
	private class RandamizedIterator<Item> implements Iterator<Item>{
			int tempCount = count;
			int countOfItem = 0;
		    @Override
			public boolean hasNext() {
				return tempCount != 0;
			}	
		    
		    public void remove() {
		    		throw new java.lang.UnsupportedOperationException();
		    }
	
			@SuppressWarnings("unchecked")
			@Override
			public Item next() {	
				tempCount--;
				return (Item) listOfObjects[countOfItem++];				
			} 
	   }
	
		public static void main(String[] args) {
			RandomizedQueue<Integer> randomized = new RandomizedQueue<Integer>();
			randomized.enqueue(3);
			randomized.enqueue(4);
			randomized.enqueue(5);
			randomized.enqueue(2);
			randomized.enqueue(1);
			randomized.enqueue(8);
			randomized.enqueue(7);
			randomized.enqueue(6);
			randomized.enqueue(9);
			randomized.enqueue(0);
			
			Iterator<Integer> iterator = randomized.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			System.out.println("Deque element: "+randomized.dequeue());	
		}

		@Override
		public Iterator<Item> iterator() {		
			return new RandamizedIterator<Item>();
		}
	
}
