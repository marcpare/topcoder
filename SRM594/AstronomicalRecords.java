/*

Failed a few of the system tests.

The minimal subsequence code needed to be DP, not greedy.

Otherwise, had it right!

*/

import java.util.*;

public class AstronomicalRecords {
  
  public int minCovering(long[] A, long[] B) {
    int b = 0;
    int matches = 0;
    for(int a = 0; a < A.length; a++){
      // try to find a match for A[a]
      for(int bb = b; bb < B.length; bb++){
        if (A[a] == B[bb]) {
          matches++;
          b = bb+1;
          break;
        }
      }
    }
        
    int ret = A.length + B.length - matches;
    /*
    System.out.println(ret);
    System.out.println(Arrays.toString(A));
    System.out.println(Arrays.toString(B));
    */
    return ret;
  }
  
  public long[] multiplied(int[] A, int M) {
    long[] ret = new long[A.length];
    for(int i = 0; i < A.length; i++){
      ret[i] = (long)A[i]*M;
    }
    return ret;
  }
  
  public int minimalPlanets(int[] A, int[] B) {    
    int ret = A.length+B.length;
    for (int i = 0; i < A.length; i++) {
      for (int k = 0; k < B.length; k++) {
        
        long[] C = multiplied(A, B[k]);
        long[] D = multiplied(B, A[i]);
        
        ret = Math.min(minCovering(C, D), ret);
      }
    }
    return ret;
  }
  
  public static void main(String[] args){
    AstronomicalRecords foo = new AstronomicalRecords();
    int[] A = {1,2,3,4};
    int[] B = {2,4,6,8};
    int[] C = {2,3,2,3,2,3,2};
    int[] D = {600,700,600,700,600,700,600};
    int[] E = {1,2,3,4,5,6,7,8,9};
    int[] F = {6,7,8,9,10,11,12};
    int[] G = {100000000,200000000};
    int[] H = {200000000,100000000};
    int[] I = new int[50];
    Arrays.fill(I, 1000000000);
    System.out.println(foo.minimalPlanets(I, I));
  }
}