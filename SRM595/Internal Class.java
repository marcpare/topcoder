import java.util.*;

public class LittleElephantAndIntervalsDiv1 {
  
  public static long getNumber(int M, int[] L, int[] R) {
    int N = L.length;
    Interval[] intervals = new Interval[N];
    for(int i = 0; i < N; i++) {
      intervals[i] = new Interval(L[i], R[i]);
    }
    Arrays.sort(intervals);
    
    System.out.println(Arrays.toString(intervals));
    
    
    int pow = 1;
    for(int i = 0; i < N-1; i++){
      // trim Rs
      if (intervals[i].R <= intervals[i+1].L) {
        intervals[i].R = intervals[i+1].L - 1;
      }
      if (intervals[i].L <= intervals[i].R) {
        pow++;
      }else{
        System.out.println("Skipped " + intervals[i]);  
      }
    }

    return 1<<pow;
  }
  
  private static class Interval implements Comparable {
    public int L, R;
    public Interval (int L, int R) {
      this.L = L;
      this.R = R;
    }
    public int compareTo(Object other) {
      Interval o = (Interval) other;
      if (this.L == o.L) {
        return this.R - o.R;
      }else{
        return this.L - o.L;
      }
    }
    
    public String toString () {
      return L + "," + R;
    }
  }
  
  public static void main (String[] args) {
    int[] A = {1, 1, 3};
    int[] B = {3, 2, 3};
    int[] C = {1, 2, 3};
    int[] D = {1, 1, 2};
    int[] E = {3, 1, 3};
    int[] F = {47};
    int[] G = {747};
    System.out.println(getNumber(1000, F, G));
  }
}