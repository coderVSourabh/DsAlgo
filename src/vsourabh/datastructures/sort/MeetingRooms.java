package vsourabh.datastructures.sort;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

	public static boolean canAttendMeetings(Interval[] intervals) {
		if(intervals == null) return false;
		
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		
		for(int i = 1; i < intervals.length; i++) {
			if(intervals[i].start < intervals[i-1].end)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Interval[] intervals = new Interval[] {new Interval(0, 10), new Interval(11, 26), new Interval(27, 45)};
		boolean res = canAttendMeetings(intervals);
		System.out.println(res);
		
		intervals = new Interval[] {new Interval(0, 30), new Interval(11, 26), new Interval(27, 45)};
		res = canAttendMeetings(intervals);
		System.out.println(res);
	}

}


class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
