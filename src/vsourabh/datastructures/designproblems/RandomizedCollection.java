package vsourabh.datastructures.designproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Sourabh
 * 
 * LeetCode
 * Design a data structure that supports all following operations in average O(1) time.
 * 
 * Note: Duplicate elements are allowed.
 * 
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. 
 * 			  The probability of each element being returned is linearly related 
 * 			  to the number of same value the collection contains
 * 
 *
 */
public class RandomizedCollection {
	
	List<Integer> nums;
	Map<Integer, Set<Integer>> locs;
	java.util.Random rand = new java.util.Random();
	/** Initialize your data structure here. */
	public RandomizedCollection() {
		nums = new ArrayList<>();
		locs = new HashMap<>();
	}

	/** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	public boolean insert(int val) {
		boolean contain = locs.containsKey(val);
		if ( ! contain ) locs.put( val, new LinkedHashSet<>() ); 
		locs.get(val).add(nums.size());        
		nums.add(val);
		return ! contain ;
	}

	/** Removes a value from the collection. Returns true if the collection contained the specified element. */
	public boolean remove(int val) {
		boolean contain = locs.containsKey(val);
		if ( ! contain ) return false;
		
		int loc = locs.get(val).iterator().next();
		locs.get(val).remove(loc);
		if (loc < nums.size() - 1 ) {
			int lastone = nums.get( nums.size()-1 );
			nums.set( loc , lastone );
			locs.get(lastone).remove( nums.size()-1);
			locs.get(lastone).add(loc);
		}
		nums.remove(nums.size() - 1);

		if (locs.get(val).isEmpty()) locs.remove(val);
		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return nums.get( rand.nextInt(nums.size()) );
	}
	    
	public static void main(String[] args) {
		RandomizedCollection collection = new RandomizedCollection();

		collection.insert(1);
		collection.insert(1);
		collection.insert(2);

		collection.getRandom();
		collection.remove(1);

		collection.getRandom();
	}

}
