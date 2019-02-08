package sourabhs.datastructures.array;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysSumEqualsK {

  /**
   * Time Complexity: O(N) where N is number of elements in array
   * Space Complexity: O(N), since we created a hash map which grows upto size of array
   */
  public int subarraySum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int count = 0, sum= 0;
    for(int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if(map.containsKey(sum - target))
        count += map.get(sum - target);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  /**
   * Time Complexity : O(N^2) looping the array twice
   * Space Complexity: O(1)
   */
  public int subarraySumBruteFroce(int[] nums, int target) {
    int count = 0;
    for(int i = 0; i < nums.length; i++){
      int sum = 0;
      for(int j = i; j < nums.length; j++) {
        sum += nums[j];
        if(sum == target)
          count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    CountSubArraysSumEqualsK obj = new CountSubArraysSumEqualsK();
    int res = obj.subarraySum(new int[] {3, 4, 7, 2, -3, 1, 4, 2}, 7);
    System.out.println(res);
    System.out.println("=====================");
    res = obj.subarraySumBruteFroce(new int[] {3, 4, 7, 2, -3, 1, 4, 2}, 7);
    System.out.println(res);
  }
}
