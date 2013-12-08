/*

2013-12-05
Failed on first try.
Didn't notice the importance of the lower bound of 100

*/

import java.util.Arrays;

public class BinPacking {
  
  public int minBins(int[] item){
    Arrays.sort(item);
    int N = item.length;
    boolean[] used = new boolean[N];
    Arrays.fill(used, false);
    int ret = 0;
    for(int i = N-1; i >= 0; i--){
      if(used[i]){
        continue;
      }
      used[i] = true;
      int amount = item[i];
      for(int j = i-1; j >= 0; j--){
        if(used[j]){ continue; }
        if (amount + item[j] <= 300){
          amount += item[j];
          used[j] = true;
        }
      }
      ret++;
    }
    return ret;
  }
  /*
  public static void main(String[] args){
    BinPacking foo = new BinPacking();
    //int[] items = {150, 150, 150, 150, 150};
    //int[] items = {130, 140, 150, 160};
    //int[] items = {100, 100, 100, 100, 100, 100};
    //int[] items = {100, 200, 100, 100, 100, 100, 200, 100, 200};
    //int[] items = {157, 142, 167, 133, 135, 157, 143, 160, 141, 123, 162, 159, 165, 137, 138, 152};
    //System.out.println(foo.minBins(items));
    //System.out.println(Arrays.toString(item));
  }
  */
}