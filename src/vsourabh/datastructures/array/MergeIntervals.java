package vsourabh.datastructures.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sourabh
 * 
 * Leetcode: 
 * Given a collection of intervals, 
 * merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * Return [1,6],[8,10],[15,18].
 *
 */
public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
	    if (intervals.size() <= 1)
	        return intervals;
	    
	    // Sort by ascending starting point using an anonymous Comparator
	    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
	    
	    List<Interval> result = new LinkedList<Interval>();
	    int start = intervals.get(0).start;
	    int end = intervals.get(0).end;
	    
	    for (Interval interval : intervals) {
	        if (interval.start <= end) // Overlapping intervals, move the end if needed
	            end = Math.max(end, interval.end);
	        else {                     // Disjoint intervals, add the previous one and reset bounds
	            result.add(new Interval(start, end));
	            start = interval.start;
	            end = interval.end;
	        }
	    }
	    
	    // Add the last interval
	    result.add(new Interval(start, end));
	    return result;
	}
	public static void main(String[] args) {
		MergeIntervals obj = new MergeIntervals();
		List<Interval> input = new ArrayList<>();
		input.add(obj.createInterval(1, 5));
		input.add(obj.createInterval(2, 6));
		input.add(obj.createInterval(8, 10));
		input.add(obj.createInterval(9, 11));
		input.add(obj.createInterval(11, 12));
		input.add(obj.createInterval(15, 18));
		
		List<Interval> output = obj.merge(input);
		output.forEach(i -> {
			System.out.print("[" + i.start + "," + i.end + "] ");
		});
	}
	
	public Interval createInterval(int start, int end) {
		return new Interval(start, end);
	}
	
	private class Interval {
		int start;
		int end;
		Interval(int s, int e) { start = s; end = e; }
	}

}
