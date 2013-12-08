/*

2013-12-06
Failed on first try, tried naive BFS. One of the test cases
was the counter-example.
Didn't notice the suffix/substring property.

*/

import java.util.Arrays;
import java.util.*;

public class LittleElephantAndString {

  public String ordered(String S){
    char[] chars = S.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }
  
  public String reversed(String S){
    return new StringBuilder(S).reverse().toString();
  }
  
  public int getNumber(String A, String B){
    if (!ordered(A).equals(ordered(B))){ return -1; }
    if (A.equals(B)){ return 0; }
    
    // count subsequence of A that is suffix of B
    A = reversed(A);
    B = reversed(B);
    int N = B.length();
    int i = 0;
    //char b = B.charAt(i);
    for(int j = 0; j < N; j++){
      if (A.charAt(j) == B.charAt(i)){
        i++;
      }
    }
    return N-i;
  }
  
  /*
  public String moveToStart(String s, int i){
    if(i == 0){
      return s;      
    }else{
      return s.charAt(i) + s.substring(0, i) + s.substring(i+1);
    }
  }

  public int getNumber(String A, String B){
    if (!ordered(A).equals(ordered(B))){
      return -1;
    }
    if (A.equals(B)){
      return 0;
    }
    Queue<String> q = new LinkedList<String>();
    Queue<Integer> counts = new LinkedList<Integer>();
    q.add(A);
    counts.add(0);
    Set<String> seen = new HashSet<String>();
    int N = A.length();
    while (true) {
      String s = q.poll();
      int count = counts.poll();
      seen.add(s);
      for(int i = 1; i < N; i++){
        String t = moveToStart(s, i);
        if (seen.contains(t)) { continue; }
        if (t.equals(B)) {
          return count+1;
        }else{
          q.add(t);
          counts.add(count+1);
        }
      }
    }
  }
    */
  
  public static void main(String[] args){
    LittleElephantAndString foo = new LittleElephantAndString();
    
    //System.out.println(foo.moveToStart("ABC", 0));
    //System.out.println(foo.moveToStart("ABC", 1));
    //System.out.println(foo.moveToStart("ABC", 2));
    
    System.out.println(foo.getNumber("ABC", "CBA"));
    System.out.println(foo.getNumber("A", "B"));
    System.out.println(foo.getNumber("AAABBB", "BBBAAA"));
    System.out.println(foo.getNumber("A", "A"));
    System.out.println(foo.getNumber("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "ZYXWVUTSRQPONMLKJIHGFEDCBA"));
    System.out.println(foo.getNumber("DCABA", "DACBA"));
  }

}