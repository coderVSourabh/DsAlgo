package vSourabh.dataStructures.array;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import vSourabh.algo.sorting.QuickSort;


/**
 * Given array check and number X
 * check if any two elements in the 
 * array add to the number X
 * 
 * @author Sourabh
 *
 */
public class ArrayRandomElementSumEqualsNum {

	/**
	 * LeetCode 
	 * 
	 * Time Complexity : O(n)
	 * Space Complexity: O(n)
	 * 
	 */
	public static int[] checkTwoSumEqualsTarget(int[] numbers, int sum) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(sum - numbers[i])) {
	            result[1] = i + 1;
	            result[0] = map.get(sum - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i + 1);
	    }
	    return result;
	}
	
	/**
	 * Time Complexity : O(nLog(n))
	 * Space Complexity: O(1)
	 * 
	 */
	public static boolean checkSumOfTwoElements(int[] array, int sum) {
		int left = 0, right = array.length -1;
		
		QuickSort qSort = new QuickSort();
		qSort.quickSort(array, left, right);
		
		while(left < right) {
			if (array[left] + array[right] == sum) 
				return true;
			else if(array[left] + array[right] < sum) 
				left++;
			else if (array[left] + array[right] > sum) 
				right--;
		}
		return false;
	}
	
	
	public static void checkSumOfTripletElements(int[] arr, int tripletSum) {
		if (arr.length < 3)
			return;
		
		QuickSort qSort = new QuickSort();
		qSort.quickSort(arr, 0, arr.length  -1);
		int left, right, sum = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			left = i + 1;
			right = arr.length - 1;
			while (left < right) {
				sum = arr[i] + arr[left] + arr[right];
				if (sum == tripletSum) {
					System.out.println("1st=" + arr[i] + ",2nd=" + arr[left] + ",3rd=" + arr[right] + " :: Sum=" + sum);
					left++;
					right--;
				} else if (sum > tripletSum) {
					right--;
				} else {
					left++;
				}
			}
		}
	}
	
	/**
	 * Time Complexity : O(n*n)
	 * Space Complexity: O(n*n)
	 */
	public static void checkSumOfQuadElementsWithtoutSorting(int[] arr, int size, int quadSum) {
		if (size < 4)
			return;
		ElemPairSum[] elePair = new ElemPairSum[(size * (size - 1)) / 2];

		int count = 0;
		// make n(n-1)/2 pairs
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				elePair[count++] = new ElemPairSum(arr[i] + arr[j], i, j);
			}
		}
		Map<Integer, ElemPairSum> map = new HashMap<>();
		for (ElemPairSum ele : elePair) {
			int reminder = quadSum - ele.value;
			if (map.containsKey(reminder)) {
				if (noCommonIndex(ele, map.get(reminder))) {
					System.out.println("1st=" + arr[ele.first] + ", 2nd=" + arr[ele.second] + ", 3rd="
							+ arr[map.get(reminder).first] + ", 4th=" + arr[map.get(reminder).second] + ", sum=" + quadSum);
					return;
				}
			} else {
				map.put(ele.value, ele);
			}
		}

	}

	/**
	 *  Time Complexity:  O(n*n*log(n)) 
	 *  Space Complexity: O(n*n)
	 */
	public static void checkSumOfQuadElementsWihtSorting(int[] arr, int size, int quadSum) {
		if (size < 4)
			return;
		ElemPairSum[] es = new ElemPairSum[(size * (size - 1)) / 2];

		int count = 0;
		
		// make n(n-1)/2 pairs
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				es[count++] = new ElemPairSum(arr[i] + arr[j], i, j);
			}
		}

		Arrays.sort(es, new Comparator<ElemPairSum>() {
			@Override
			public int compare(ElemPairSum o1, ElemPairSum o2) {
				return o1.value - o2.value;
			}
		});
		
		int l = 0, r = count - 1, sum;
		while (l < r) {
			sum = es[l].value + es[r].value;
			if (sum == quadSum && noCommonIndex(es[l], es[r])) {
				System.out.println("1st=" + arr[es[l].first] + ", 2nd=" + arr[es[l].second] + ", 3rd=" + arr[es[r].first]
						+ ", 4th=" + arr[es[r].second] + ", sum=" + quadSum);
				l++;
				r--;
			} else if (sum > quadSum) {
				r--;
			} else {
				l++;
			}
		}
	}

	private static boolean noCommonIndex(ElemPairSum e1, ElemPairSum e2) {
		if (e1.first == e2.first || e1.first == e2.second || e1.second == e2.first || e1.second == e2.second) {
			return false;
		}
		return true;
	}

	/**
	 * Time Complexity : O(n*n*n)
	 * Space Complexity: O(1)
	 */
	public static void checkSumOfQuadElementsWithSortingNotOptimized(int[] arr, int size, int quadSum) {
		
		QuickSort qSort = new QuickSort();
		qSort.quickSort(arr, 0, size  -1);
		
		int l, r, sum;
		for (int i = 0; i < size - 3; i++) {
			for (int j = i + 1; j < size - 2; j++) {
				l = j + 1;
				r = size - 1;
				while (l < r) {
					sum = arr[i] + arr[j] + arr[l] + arr[r];
					if (sum == quadSum) {
						System.out.println(
								"1st=" + arr[i] + ", 2nd=" + arr[j] + ", 3rd=" + arr[l] + ", 4th=" + arr[r] + ", sum=" + quadSum);
						l++;
						r--;
						break;
					} else if (sum > quadSum) {
						r--;
					} else {
						l++;
					}
				}
			}
		}
	}



	/**
	 *  Time Complexity : O(nlogn)
	 *  Space Complexity: O(1)
	 */
	public static int checkSumOfTwoElementCloseToNumUsingSorting(int[] arr, int size, int num) {
		
		Arrays.sort(arr);
		int sum, min1, min2;
		sum = min1 = min2 = Integer.MAX_VALUE;
		int left = 0, right = size - 1;
		int t;
		while (left < right) {
			t = arr[left] + arr[right] - num;
			if (Math.abs(t) < Math.abs(sum)) {
				sum = t;
				min1 = arr[left];
				min2 = arr[right];
			}
			if (t < 0) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println("min1=" + min1 + ", min2=" + min2 + " :: sum=" + sum);
		return num-sum;
	}

	/**
	 * Time Complexity : O(n*n)
	 * Space Complexity: O(1)
	 */
	public static int checkSumOfTwoElementCloseToZero(int[] arr, int size) {
		int sum = Integer.MAX_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {

				if (Math.abs(arr[i] + arr[j]) < Math.abs(sum)) {
					sum = arr[i] + arr[j];
					min1 = arr[i];
					min2 = arr[j];
				}
			}
		}

		System.out.println("min1=" + min1 + ", min2=" + min2 + " :: sum=" + sum);
		return sum;
	}
	
	public static void checkSumPairOfTwoArraysCloseToNum(int[] arr1, int[] arr2, int size1, int size2, int num) {
		int x1 = Integer.MAX_VALUE, x2 = Integer.MAX_VALUE;
		int l1 = 0;// left of 1st array
		int r2 = size2 - 1; // right of 2nd array
		int minDiff = Integer.MAX_VALUE;
		int curDiff;
		while (l1 < size1 && r2 >= 0) {
			curDiff = arr1[l1] + arr2[r2] - num;
			if (Math.abs(curDiff) < Math.abs(minDiff)) {
				minDiff = curDiff;
				x1 = arr1[l1];
				x2 = arr2[r2];
			}
			if (curDiff < 0) {
				l1++;
			} else if (curDiff > 0) {
				r2--;
			} else {
				break;
			}
		}
		System.out.println("x1=" + x1 + ", x2=" + x2 + ", close To : " + num);
	}

	
	public static void main(String[] args) {
		int arr[] = new int[] {10, -6, 12, 0 , -1 , 5 , 11 , 24 , 18 , 15 };
		int sum = -20;
		System.out.println("\n*********************Double Sum ****************************");
		if (ArrayRandomElementSumEqualsNum.checkSumOfTwoElements(arr, sum))
			System.out.println("Array has 2 element with Sum : " + sum);
		else 
			System.out.println("Array has no 2 elements with sum : "+ sum);
		
		int[] varArr = new int[]{2, 7, 11, 15};
		int[] resultIndex = checkTwoSumEqualsTarget(varArr, 9);
		System.out.println("Two Number sum to 9 is [" + varArr[resultIndex[0] - 1] + "," +  varArr[resultIndex[1] - 1] +"]");
		
		System.out.println("\n*********************Triplet Sum ****************************");
		arr = new int[]{ 1, 4, 12, 6, 10, 8 };
		checkSumOfTripletElements(arr, 22);
		
		arr = new int[] { 10, 2, 3, 4, 5, 9, 7, 8 };
		int size = arr.length;
		System.out.println("\n*********************Quad Sum No Sorting****************************");
		checkSumOfQuadElementsWithtoutSorting(arr, size, 23);
		System.out.println("\n*************Quad Sum With Sorting Optimized*******************");
		checkSumOfQuadElementsWihtSorting(arr, size, 23);
		System.out.println("\n*************Quad Sum With Sorting not optizimed******************");
		checkSumOfQuadElementsWithSortingNotOptimized(arr, size, 23);
		
		arr = new int[]{ 10, 22, 28, 29, 30, 40, -9};
		System.out.println("\n*************Two Number Sum With Sorting Close to Num******************");
		sum = checkSumOfTwoElementCloseToNumUsingSorting(arr, arr.length, 54);
		System.out.println("close Sum: "+sum);
		
		System.out.println("\n*************Two Number Sum With Sorting Close to 0******************");
		checkSumOfTwoElementCloseToZero(arr, arr.length);
		
		arr = new int[] { 1, 4, 5, 7 };
		int arr2[] = { 10, 20, 32, 40 };
		System.out.println("\n*************Two Arrays Pair Sum  Close to Num******************");
		checkSumPairOfTwoArraysCloseToNum(arr, arr2, arr.length, arr2.length, 31);
		
		
	}

}

class ElemPairSum {
	int value;
	int first;
	int second;

	public ElemPairSum(int value, int first, int second) {
		super();
		this.value = value;
		this.first = first;
		this.second = second;
	}
	
	public ElemPairSum(int first, int second) {
		super();
		this.first = first;
		this.second = second;
		this.value = this.first + this.second;
	}

	@Override
	public String toString() {
		return  "first Element: " + first + ", second Element:" + second + "; Sum of Pair: " + value;
	}

}
