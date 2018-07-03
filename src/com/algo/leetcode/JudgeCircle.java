package com.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class JudgeCircle {
	
	public static boolean judgeCircle(String moves) {
		int x=0, y=0;
		for(char c : moves.toCharArray()) {
			if(c == 'U') y++;
			else if(c == 'D') y--;
			else if(c == 'R') x++;
			else if(c == 'L') x--;
		}
		return x==0 && y==0;
	}
	
	public static int findLUSlength(String a, String b) {
        Map < String, Integer > map = new HashMap <String, Integer > ();
        for (String s: new String[] {a, b}) {
            for (int i = 0; i < (1 << s.length()); i++) {
                String t = "";
                for (int j = 0; j < s.length(); j++) {
                    if (((i >> j) & 1) != 0) {
                    	System.out.println(i >> j);
                        t += s.charAt(j);
                        System.out.println(t + " t ");
                    }
                }
                if (map.containsKey(t))
                    map.put(t, map.get(t) + 1);
                else
                    map.put(t, 1);
            }
        }
        System.out.println(map.toString());
        int res = -1;
        for (String s: map.keySet()) {
            if (map.get(s) == 1)
                res = Math.max(res, s.length());
        }
        return res;
    }
	
	public static int findLUSlength1(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }
	
	public static void main(String[] args) {
		String moves = "UD";
		System.out.println(judgeCircle(moves));
		System.out.println(findLUSlength("abcd", "cdc"));
		System.out.println(findLUSlength1("abcd", "cdc"));
	}
}
