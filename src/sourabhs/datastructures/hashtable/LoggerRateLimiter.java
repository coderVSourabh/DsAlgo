package sourabhs.datastructures.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * Design a logger system that receive stream of messages 
 * along with its timestamps, each message should be printed 
 * if and only if it is not printed in the last 10 seconds.
 * 
 * Given a message and a timestamp (in seconds granularity), 
 * return true if the message should be printed in the given 
 * timestamp, otherwise returns false.
 * 
 * It is possible that several messages arrive roughly at the same time.
 * 
 * Example:
 * Logger logger = new Logger();
 * 
 * // logging string "foo" at timestamp 1
 * logger.shouldPrintMessage(1, "foo"); returns true; 
 * 
 * // logging string "bar" at timestamp 2
 * logger.shouldPrintMessage(2,"bar"); returns true;
 * 
 * // logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;
 * 
 * // logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;
 * 
 * // logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;
 * 
 * // logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 * 
 */
public class LoggerRateLimiter {

	private Map<String, Integer> ok = new HashMap<>();

	/**
	 * Instead of logging print times, I store when it's 
	 * ok for a message to be printed again. Should be 
	 * slightly faster, because I don't always have to 
	 * add or subtract (e.g., timestamp < log[message] + 10) 
	 * but only do in the true case. Also, it leads to a 
	 * shorter/simpler longest line of code. Finally, C++ 
	 * has 0 as default, so I can just use ok[message].
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (timestamp < ok.getOrDefault(message, 0))
			return false;
		ok.put(message, timestamp + 10);
		return true;
	}
	
	public static void main(String[] args) {
		LoggerRateLimiter obj = new LoggerRateLimiter();
		boolean result = obj.shouldPrintMessage(1, "log It!");
		System.out.println("The result is " + result);
		
		result = obj.shouldPrintMessage(1, "log It!");
		System.out.println("The result is " + result);
		
		result = obj.shouldPrintMessage(2, "log It!");
		System.out.println("The result is " + result);
		
		result = obj.shouldPrintMessage(3, "log it!");
		System.out.println("The result is " + result);
		
		result = obj.shouldPrintMessage(4, "log It!");
		System.out.println("The result is " + result);
		
		result = obj.shouldPrintMessage(5, "log It!");
		System.out.println("The result is " + result);
		
		result = obj.shouldPrintMessage(6, "log 6!");
		System.out.println("The result is " + result);
		
		result = obj.shouldPrintMessage(7, "log It!");
		System.out.println("The result is " + result);
		
		result = obj.shouldPrintMessage(8, "log It!");
		System.out.println("The result is " + result);
		
		result = obj.shouldPrintMessage(9, "log It!");
		System.out.println("The result is " + result);
		
		result = obj.shouldPrintMessage(10, "log 9!");
		System.out.println("The result is " + result);

		result = obj.shouldPrintMessage(11, "log It!");
		System.out.println("The result is " + result);
	}

}
