package com.dsalgos.graphs;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class WebCrawler {
	
	Queue<String> queue;
	Set<String> discovered;
		
	public WebCrawler() {
		queue = new Queue<String>();
		discovered = new HashSet<String>();
		String root = "http://www.uakron.edu";
		queue.enqueue(root);
		discovered.add(root);
	//	bfs();
	}
		
	private void bfs() {
		while(!queue.isEmpty()) {
			String v = queue.dequeue();
			System.out.println(v);
			In in = new In(v);
			String input = in.readAll();
			
			String regex = "http://(\\w+\\.)*(\\w+)";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(input);
			while(matcher.find()) {
				String w = matcher.group();
				if(!discovered.contains(w)) {
					queue.enqueue(w);
					discovered.add(w);
				}
			}
		}
	}

	public static void main(String[] args) {
		WebCrawler web = new WebCrawler();
		web.bfs();
	}

}
