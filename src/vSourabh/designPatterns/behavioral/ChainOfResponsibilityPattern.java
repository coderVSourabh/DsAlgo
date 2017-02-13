package vSourabh.designPatterns.behavioral;

import java.util.Scanner;

/**
 * @author Sourabh
 *
 * Behavioural design pattern
 * 
 * Chain of responsibility pattern is used to achieve loose coupling in software design 
 * where a request from client is passed to a chain of objects to process them.
 * Example: java.util.logging.Logger#log() and javax.servlet.Filter#doFilter()
 */

class Currency {

	private int amount;
	public Currency(int amt){
		if(amt > 0)
			this.amount = amt;
	}	
	public int getAmount(){
		return this.amount;
	}
}

/**
 *  Base interface should have a method to define the next processor in the chain 
 *  dispense method is used to decide the next Object to be created
 */
interface DispenseChainBase {
	void setNextChain(DispenseChainBase nextChain);	
	void dispense(Currency cur);
}

//Different processor With HAS-A and IS-A relationship
class Dispense$50 implements DispenseChainBase {

	private DispenseChainBase chain;
	
	@Override
	public void setNextChain(DispenseChainBase nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 50) {
			int num = cur.getAmount()/50;
			int remainder = cur.getAmount() % 50;
			System.out.println("Dispensing "+num+" 50 $ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		} else {
			this.chain.dispense(cur);
		}
	}
}

//Different processor With HAS-A and IS-A relationship
class Dispense$20 implements DispenseChainBase{

	private DispenseChainBase chain;
	
	@Override
	public void setNextChain(DispenseChainBase nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 20){
			int num = cur.getAmount()/20;
			int remainder = cur.getAmount() % 20;
			System.out.println("Dispensing "+num+" 20 $ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		} else {
			this.chain.dispense(cur);
		}
	}
}

//Different processor With HAS-A and IS-A relationship
class Dispense$10 implements DispenseChainBase {

	private DispenseChainBase chain;
	
	@Override
	public void setNextChain(DispenseChainBase nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 10){
			int num = cur.getAmount()/10;
			int remainder = cur.getAmount() % 10;
			System.out.println("Dispensing "+num+" 10 $ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		} else {
			this.chain.dispense(cur);
		}
	}
}


public class ChainOfResponsibilityPattern {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		DispenseChainBase c1 = new Dispense$50();
		DispenseChainBase c2 = new Dispense$20();
		DispenseChainBase c3 = new Dispense$10();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);

		while (true) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			
			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
				return;
			}
			c1.dispense(new Currency(amount));
		}
	}
}
