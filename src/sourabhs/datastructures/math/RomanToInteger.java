package sourabhs.datastructures.math;

/**
 * @author Sourabh
 *
 */
public class RomanToInteger {

	/**
	 * Given a roman numeral, convert it to an integer.
	 * Input is guaranteed to be within the range from 1 to 3999.
	 */
	public int romanToInt(String s) {
		int sum=0;
		if(s.indexOf("IV") != -1){sum-=2;}
		if(s.indexOf("IX") != -1){sum-=2;}
		if(s.indexOf("XL") != -1){sum-=20;}
		if(s.indexOf("XC") != -1){sum-=20;}
		if(s.indexOf("CD") != -1){sum-=200;}
		if(s.indexOf("CM") != -1){sum-=200;}

		char c[]=s.toCharArray();

		for(int count=0; count<=s.length()-1; count++){
			if(c[count]=='M') sum+=1000;
			if(c[count]=='D') sum+=500;
			if(c[count]=='C') sum+=100;
			if(c[count]=='L') sum+=50;
			if(c[count]=='X') sum+=10;
			if(c[count]=='V') sum+=5;
			if(c[count]=='I') sum+=1;
		}
		return sum;
	}

	public static void main(String[] args) {
		RomanToInteger obj = new RomanToInteger();
		int num = obj.romanToInt("XIV");
		System.out.println("The Integer Number is "+ num);
	}

}
