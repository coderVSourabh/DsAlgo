package sourabhs.datastructures.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TwoSum3 {

	Set<Integer> num;
	Set<Integer> sum;
	public TwoSum3() {
		this.sum = new HashSet<>();
		this.num = new HashSet<>();
	}

	public void add(int number) {		
		if(sum.contains(number))
			sum.add(number * 2);
		else {
			Iterator<Integer> iter = num.iterator();
			while(iter.hasNext()) {
				sum.add(iter.next() + number);
			}
			num.add(number);
		}
			
	}
	
	public boolean find(int value) {
		return sum.contains(value);
	}
	
	public static void main(String[] args) {
		TwoSum3 obj = new TwoSum3();
		obj.add(2);obj.add(3);obj.add(5);obj.add(1);
		boolean res = obj.find(4);
		System.out.println(res);
	}
}
