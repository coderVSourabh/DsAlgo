package vsourabh.datastructures.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

public class ReverseBits {

	public static int reverseBits2(int n) {
		if (n == 0) return 0;
	    
	    int result = 0;
	    for (int i = 0; i < 32; i++) {
	        result <<= 1;
	        if ((n & 1) == 1) result++;
	        n >>= 1;
	    }
	    return result;
	}
	
	
	private static final Map<Byte, Integer> cache = new HashMap<>(); // Cached
	public static int reverseBits(int n) {
	    byte[] bytes = new byte[4];
	    for (int i = 0; i < 4; i++) // convert int into 4 bytes
	        bytes[i] = (byte)((n >>> 8*i) & 0xFF);
	    int result = 0;
	    for (int i = 0; i < 4; i++) {
	        result += reverseByte(bytes[i]); // reverse per byte
	        if (i < 3)
	            result <<= 8;
	    }
	    return result;
	}
	private static int reverseByte(byte b) {
	    Integer value = cache.get(b); // first look up from cache
	    if (value != null)
	        return value;
	    value = 0;
	    // reverse by bit
	    for (int i = 0; i < 8; i++) {
	        value += ((b >>> i) & 1);
	        if (i < 7)
	            value <<= 1;
	    }
	    cache.put(b, value);
	    return value;
	}

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(43261596));
		int res = reverseBits(43261596);
		System.out.println(Integer.toBinaryString(res));
		System.out.println(res);
		
		System.out.println(Integer.toBinaryString(43261596));
		res = reverseBits2(43261596);
		System.out.println(Integer.toBinaryString(res));
		

	}

}
