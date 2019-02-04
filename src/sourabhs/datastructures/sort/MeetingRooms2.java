package sourabhs.datastructures.sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {

  /**
   * Time Complexity : O(NlogN) due to sorting of elements
   * Space Complexity: O(N)
   */
  public int minMeetingRooms(Interval2[] intervals) {

    // Base case
    if(intervals == null || intervals.length == 0) return 0;

    Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);

    Queue<Integer> rooms = new PriorityQueue<>();
    rooms.offer(intervals[0].end);

    for(int i = 1; i < intervals.length; i++) {
      if(intervals[i].start  >= rooms.peek())
        rooms.poll();
      rooms.offer(intervals[i].end);
    }
    return rooms.size();
  }

  public static void main(String[] args) {
    MeetingRooms2 obj = new MeetingRooms2();
    Interval2[] intervals = new Interval2[] {new Interval2(0, 30), new Interval2(5, 10), new Interval2(15, 20)};
    int res = obj.minMeetingRooms(intervals);
    System.out.println(res);
    System.out.println("=====================");
    intervals = new Interval2[] {new Interval2(7, 30), new Interval2(2, 4)};
    res = obj.minMeetingRooms(intervals);
    System.out.println(res);
    System.out.println("=====================");
    intervals = new Interval2[] {new Interval2(1, 10), new Interval2(2, 7), new Interval2(3, 19)
        , new Interval2(8, 12), new Interval2(10, 20), new Interval2(11, 30)};
    res = obj.minMeetingRooms(intervals);
    System.out.println(res);
  }
}

class Interval2 {
  int start;
  int end;
  Interval2() {start = 0; end = 0;}
  Interval2(int s, int e) {start = s; end = e;}
}