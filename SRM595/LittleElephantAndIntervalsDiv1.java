// failed sys tests :(
// Because of a SINGLE character. Forgot the "L" after "1" in the return statement
// My solution matched the analysis solution almost line for line.
import java.util.*;

public class LittleElephantAndIntervalsDiv1 {
  
  public static long getNumber(int M, int[] L, int[] R) {
    int N = L.length;
    int[] balls = new int[M+1];
    Arrays.fill(balls, 0);
    for(int i = 0; i < N; i++) {
      for(int k = L[i]; k <= R[i]; k++){
        balls[k] = (i+1);
      }
    }
    HashSet<Integer> left = new HashSet<Integer>();
    for(int i = 0; i <= M; i++){
      if (balls[i] > 0) left.add(balls[i]);
    }
    return 1L << left.size();
  }
  
  public static void main (String[] args) {
    int[] A = {1, 1, 3};
    int[] B = {3, 2, 3};
    int[] C = {1, 2, 3};
    int[] D = {1, 1, 2};
    int[] E = {3, 1, 3};
    int[] F = {47};
    int[] G = {747};
    System.out.println(getNumber(4, D, E));
  }
}