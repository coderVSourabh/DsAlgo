package vSourabh.designPatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sourabh
 *
 * Behavioural Design Patter
 * 
 * Also known as Policy Pattern
 * It is used when we have multiple algorithm for a specific task 
 * and client decides the actual implementation to be used at runtime
 * Example :  Collections.sort() 
 * 
 *   State Design Pattern almost same as Strategy pattern
 *   
 *    Behavioural design pattern
 *    
 *    If we have to change the behaviour of an object based on its state,
 *     we can have a state variable in the Object. Then use if-else condition 
 *     block to perform different actions based on the state. State design 
 *     pattern is used to provide a systematic and loosely coupled way to 
 *     achieve this through Context and State implementations.
 *     
 *  Visitor Pattern
 *  
 *    Behavioural design pattern
 *    
 *    Visitor pattern is used when we have to perform an operation on a group of similar 
 *    kind of Objects. With the help of visitor pattern, we can move the operational logic 
 *    from the objects to another class
 */

// Interface with the specific task defined
interface PaymentPolicy {
	public void pay(int amount);
}

///Implements the specific task of super class
class CreditCardStrategy implements PaymentPolicy {

	private String name, cardNumber, cvv, dateOfExpiry;
	
	public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate){
		this.name=nm;
		this.cardNumber=ccNum;
		this.cvv=cvv;
		this.dateOfExpiry=expiryDate;
	}
	@Override
	public void pay(int amount) {
		System.out.println(amount +" paid with credit/debit card");
	}
	@Override
	public String toString() {
		return "CreditCard Details Name:" + name + ", cardNumber:" + cardNumber + ", cvv:" + cvv 
				+ ", dateOfExpiry:" + dateOfExpiry;
	}
}


///Implements the specific task of super class
class PaypalStrategy implements PaymentPolicy {

	private String emailId, password;
	
	public PaypalStrategy(String email, String pwd){
		this.emailId=email;
		this.password=pwd;
	}
	
	@Override
	public String toString() {
		return "Paypal Details emailId:" + emailId + ", password:" + password.substring(0, 2) + "******";
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid using Paypal.");
	}
}

// General class
class Item {
	
	private String upcCode;
	private int price;
	
	public Item(String upc, int cost){
		this.upcCode=upc;
		this.price=cost;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public int getPrice() {
		return price;
	}	
}

// Use the Super or interface  specific task
class ShoppingCart {

	List<Item> items;
	
	public ShoppingCart(){
		this.items=new ArrayList<>();
	}
	
	public void addItem(Item item){
		this.items.add(item);
	}
	
	public void removeItem(Item item){
		this.items.remove(item);
	}
	
	//Visitor pattern like the caluclation of total price done here
	public int calculateTotal(){
		int total = 0;
		for(Item item : items){
			total += item.getPrice();
		}
		return total;
	}
	
	public void pay(PaymentPolicy paymentMethod){
		int amount = calculateTotal();
		paymentMethod.pay(amount);
	}
}


public class StrategyPattern {
	public static void main (String vmArgs[]) {
		
		ShoppingCart cart = new ShoppingCart();
		Item item1 = new Item("1234",10);
		Item item2 = new Item("5678",40);
		
		cart.addItem(item1);
		cart.addItem(item2);
		
		cart.pay(new PaypalStrategy("myEmail@mail.com", "mypwd"));
		cart.pay(new CreditCardStrategy("Pankaj Kumar", "1234567890123456", "786", "12/15"));
	}

}
