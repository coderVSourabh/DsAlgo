/**
 * 
 */
package sourabhs.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sourabh
 *
 */
@SuppressWarnings("unused")
public class KnapsackSoln {
	
	public static Comparator<KnapSack> knapSackCompare = new Comparator<KnapSack>() {
		@Override
		public int compare(KnapSack k1, KnapSack k2) {
			
			if (k1.unitPrice > k2.unitPrice)
				return -1;
			else if (k1.unitPrice < k2.unitPrice)
				return 1;
			return 0;
		}
	};
	
	/**
	 * Time Complexity: same as Time taken to sort the List O(nLog(n))
	 */
	public double greedyKnapSack(List<KnapSack> knapSackList, int knapSackSize ) {
		double totalPrice = 0;
		for(KnapSack knapSack : knapSackList) {
			knapSack.unitPrice = knapSack.price/knapSack.weight;
		}
		
		//Introduced in Java8 same as Tim Sort from Python
		knapSackList.sort((bag1, bag2) ->  bag2.unitPrice.compareTo(bag1.unitPrice));
		
		// Or Can be used Collection Sort
		//Collections.sort(knapSackList, knapSackCompare);
		
		//System.out.println(knapSackList);
		for(KnapSack knapSack : knapSackList) {
			if(knapSackSize > 0 && knapSackSize >= knapSack.weight) {
				knapSackSize -= knapSack.weight;
				totalPrice = knapSack.price;
			} else if (knapSackSize > 0 && knapSackSize <= knapSack.weight ) {
				totalPrice += knapSack.price*(knapSackSize/knapSack.weight);
				knapSackSize = 0;
			} else {
				break;
			}
		}
		return totalPrice;
	}
	
	public static void main(String[] args) {
		KnapsackSoln soln = new KnapsackSoln();
		List<KnapSack> knapSack = new ArrayList<>();
		knapSack.add(new KnapSack(10, 2F));
		knapSack.add(new KnapSack(5, 3F));
		knapSack.add(new KnapSack(15, 5F));
		knapSack.add(new KnapSack(10, 10F));
		knapSack.add(new KnapSack(25, 9F));
		knapSack.add(new KnapSack(16, 7F));
		knapSack.add(new KnapSack(30, 12F));
		knapSack.add(new KnapSack(13, 6F));
		knapSack.add(new KnapSack(11, 4F));

		System.out.println("Total Price is :" + soln.greedyKnapSack(knapSack, 24));
	}

}

class KnapSack {
	int weight;
	float price;
	Float unitPrice;
	
	public KnapSack(int wt, float cost) {
		this.weight = wt;
		this.price = cost;
	}

	@Override
	public String toString() {
		return "KnapSack [weight=" + weight + ", price=" + price + ", unitPrice=" + unitPrice + "]";
	}
}