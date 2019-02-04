package sourabhs.datastructures.array;

import java.util.*;

public class TaskScheduler {

  /**
   * Time Complexity: O(N) where N is number of tasks.
   */
  public int leastInterval(char[] tasks, int n) {
    int[] map = new int[26];
    for(char c : tasks) // O(N) for the loop
      map[c - 'A']++;
    Arrays.sort(map); // O(26log(26))
    int maxTaskCount = map[25] - 1, slots = maxTaskCount * n;
    for(int i = 24; i >= 0 && map[i] > 0; i--) //O(1) max 26 times
      slots -= Math.min(map[i], maxTaskCount);
    return slots < 0 ? slots + tasks.length : tasks.length;
  }

  public int leastInterval2(char[] tasks, int n) {
    int[] map = new int[26];
    for(char c : tasks) // O(N) adding the value to for loop
      map[c - 'A']++;

    Queue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
    for(int i : map)  // O(26) for looping the map
      if(i > 0)
        queue.offer(i); // O(26 log26) + O(26) for sorting and reversing in the priority queue

    int time = 0;
    while(!queue.isEmpty()) { //O(26) loop through the map
      int i = 0;
      List<Integer> list = new ArrayList<>();
      while(i < n) { // loop till n to add value before idle
        if(!queue.isEmpty()) {// if queue is not empty add to list or if empty increase the idle time
          if(queue.peek() > 1)
            list.add(queue.poll() - 1);
          else
            queue.poll();
        }
        time++;
        if(queue.isEmpty() && list.size() == 0)
          break;
        i++;
      }
      for(int l : list)
        queue.add(l);
    }
    return time;
  }

  public static void main(String[] args) {
    TaskScheduler obj = new TaskScheduler();
    int res = obj.leastInterval(new char[] {'A', 'B', 'A', 'B', 'A', 'A', 'B', 'B'}, 2);
    System.out.println(res);
    System.out.println("=====================");
    res = obj.leastInterval2(new char[] {'A', 'B', 'A', 'B', 'A', 'A', 'B', 'B'}, 2);
    System.out.println(res);
    System.out.println("=====================");
    res = obj.leastInterval2(new char[] {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E'}, 2);
    System.out.println(res);
    System.out.println("=====================");
    res = obj.leastInterval2(new char[] {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E'}, 2);
    System.out.println(res);
    System.out.println("=====================");
  }
}
