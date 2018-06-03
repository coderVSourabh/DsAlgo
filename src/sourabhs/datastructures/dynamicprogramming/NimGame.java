package sourabhs.datastructures.dynamicprogramming;

public class NimGame {

	public static boolean canWinNim(int n) {
		return n%4 != 0;
	}
	
	public static boolean canWinNimDP(int n) {
		if(n<4) return true;
		boolean[] res = new boolean[n];
		res[0] = res[1] = res[2] = true;
		for(int i=3;i<n;i++)
		    res[i]=(res[i-1]==false || res[i-2]==false || res[i-3]==false);
		return res[n-1];
	}

	public static void main(String[] args) {
		boolean res = canWinNim(4);
		System.out.println(res);
		
		res = canWinNimDP(4);
		System.out.println(res);
		
		res = canWinNim(5);
		System.out.println(res);
		
		res = canWinNimDP(5);
		System.out.println(res);
	}

}
