package vsourabh.datastructures.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sourabh
 * LeetCode:
 * Given n points on a 2D plane, find the 
 * maximum number of points that lie on 
 * the same straight line.
 */
 class PointOnLine {
     int x;
     int y;
     PointOnLine() { x = 0; y = 0; }
     PointOnLine(int a, int b) { x = a; y = b; }
}
public class MaxPointOnLine {
	
	public int maxPoints(PointOnLine[] points) {
		if (points==null) return 0;
		if (points.length<=2) return points.length;

		Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
		int result=0;
		for (int i=0;i<points.length;i++){ 
			map.clear();
			int overlap=0,max=0;
			for (int j=i+1;j<points.length;j++){
				int x=points[j].x-points[i].x;
				int y=points[j].y-points[i].y;
				if (x==0&&y==0){
					overlap++;
					continue;
				}
				int gcd=generateGCD(x,y);
				if (gcd!=0) {
					x/=gcd;
					y/=gcd;
				}

				if (map.containsKey(x)){
					if (map.get(x).containsKey(y)){
						map.get(x).put(y, map.get(x).get(y)+1);
					} else {
						map.get(x).put(y, 1);
					}   					
				} else {
					Map<Integer,Integer> m = new HashMap<>();
					m.put(y, 1);
					map.put(x, m);
				}
				max=Math.max(max, map.get(x).get(y));
			}
			result=Math.max(result, max+overlap+1);
		}
		return result;
	}
	
	private int generateGCD(int a,int b){
		if (b==0) return a;
		else return generateGCD(b,a%b);
	}

	public static void main(String[] args) {
		MaxPointOnLine obj = new MaxPointOnLine();
		PointOnLine pointA = new PointOnLine();
		PointOnLine pointB = new PointOnLine(1,1);
		PointOnLine pointC = new PointOnLine(2,2);
		PointOnLine pointD = new PointOnLine(3,3);
		PointOnLine pointE = new PointOnLine(5,3);
		
		int result = obj.maxPoints(new PointOnLine[] 
				{pointA, pointB, pointC, pointD, pointE});
		System.out.println("number of Points on Line are " + result);

	}

}
