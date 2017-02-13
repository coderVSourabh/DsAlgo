package vSourabh.dataStructures.designProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sourabh
 * LeetCode: all following operations in average O(1) time.
 * 		insert(value): Inserts an item value to the set if not already present.
 * 		remove(value): Removes an item value from the set if present.
 * 		getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned
 *
 */
public class RandomizedSet {

	List<Integer> nums;
    Map<Integer, Integer> locs;
    
    java.util.Random rand = new java.util.Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if ( contain ) return false;
        locs.put( val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) return false;
        
        int loc = locs.get(val);
        if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
            int lastone = nums.get(nums.size() - 1 );
            nums.set( loc , lastone );
            locs.put(lastone, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
    
    public static void main(String[] varArgs) {

    	RandomizedSet randomSet = new RandomizedSet();
    	randomSet.insert(1);
    	randomSet.remove(2);
    	randomSet.insert(2);
    	randomSet.getRandom();
    	randomSet.remove(1);
    	randomSet.insert(2);
    	randomSet.getRandom();
    }
}
