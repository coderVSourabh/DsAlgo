package sourabhs.datastructures.string;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. 
 * For example, it returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n) 
 * that reads n characters from the file.
 * 
 * Note:
 * The read function will only be called once for each test case.
 * 
 * Understand the problem:
 * This seemingly easy coding question has some tricky edge cases. When read4 returns
 * less than 4, we know it must reached the end of file. However, take note that read4
 * returning 4 could mean the last 4 bytes of the file.
 * 
 * To make sure that the buffer is not copied more than n bytes, copy the remaining bytes
 * (n – readBytes) or the number of bytes read, whichever is smaller.
 */
/*class Reader4 {
	
	private char[] contents = null;
	private int offset = 0;
	private final int READ_SIZE = 4;

	public int read4(char[] buf) {
		int sz = Math.min(contents.length - offset, READ_SIZE);
		for (int i = 0; i < sz; i++)
			buf[i] = contents[offset + i];
		
		offset += sz;
		return sz;
	}
}
*/
public class Read4 { //extends Reader4{

	public int read4(char[] buf) {
        return (int)(Math.random() * 4);
    }
	
	public int read(char[] buf, int n) {
		boolean eof = false;      // end of file flag
		int total = 0;            // total bytes have read
		char[] tmp = new char[4]; // temp buffer

		while (!eof && total < n) {
			int count = read4(tmp);

			// check if it's the end of the file
			eof = count < 4;

			// get the actual count
			count = Math.min(count, n - total);

			// copy from temp buffer to buf
			for (int i = 0; i < count; i++) 
				buf[total++] = tmp[i];
		}

		return total;
	}

	public static void main(String[] args) {
		Read4 obj = new Read4();
		char[] buf = {'a','c','e','i','h','o','s','u','v'};
		int result = obj.read(buf, buf.length - 6);
		System.out.println("The read time is " + result);
	
	}

}
