package vSourabh.designPatterns.structural;

/**
 * @author Sourabh
 * 
 * Structural design pattern 
 * 
 * Decorator design pattern is used to modify the functionality of an object 
 * at runtime. At the same time other instances of the same class will not be 
 * affected by this, so individual object gets the modified behaviour. 
 *
 * Decorator class is having IS-A and HAS-A relationship with component
 * 
 * http://www.newthinktank.com/2012/09/decorator-design-pattern-tutorial/
 */

// Component Interface
interface Pizza {
	
	public String getDescription();
	public int getCost();
}

//Implementation of the component
class PanPizza implements Pizza {

	public PanPizza() {}

	@Override
	public String getDescription() {
		return "Pan Pizza";
	}

	@Override
	public int getCost() {
		return 5;
	}
}

//Implementation of the component
class ThinCrust implements Pizza {

	public ThinCrust() {}

	@Override
	public String getDescription() {
		return "Thin Crust Pizza";
	}

	@Override
	public int getCost() {
		return 7;
	}
}

//Decorator Implements the component and also Has-A relationship with component
abstract class PizzaDecorator implements Pizza {

	protected Pizza pizza;

	public PizzaDecorator(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		return pizza.getDescription();
	}

	@Override
	public int getCost() {
		return pizza.getCost();
	}
}

//Decorator Class extension 
class ToppingsBlackPepper extends PizzaDecorator {

	public ToppingsBlackPepper(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + " + Black Pepper";
	}

	@Override
	public int getCost() {
		return pizza.getCost() + 4;
	}
}

//Decorator Class extension 
class ToppingsOlives extends PizzaDecorator {

	public ToppingsOlives(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + " + Olives";
	}

	@Override
	public int getCost() {
		return pizza.getCost() + 3;
	}
}

//Decorator Class extension 
class ToppingsOnions extends PizzaDecorator {

	public ToppingsOnions(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + " + Onions";
	}

	@Override
	public int getCost() {
		return pizza.getCost() + 2;
	}
}

//Decorator Pattern test class
public class DecoratorPattern {

	public static void main(String[] args) {
		Pizza p1 = new PanPizza();
		System.out.println(p1.getDescription() + "=" + p1.getCost());

		Pizza p2 = new ToppingsOnions(p1);
		System.out.println(p2.getDescription() + "=" + p2.getCost());

		Pizza p3 = new ToppingsOlives(p2);
		System.out.println(p3.getDescription() + "=" + p3.getCost());

		Pizza pp1 = new ThinCrust();
		System.out.println(pp1.getDescription() + "=" + pp1.getCost());

		Pizza pp2 = new ToppingsOnions(pp1);
		System.out.println(p2.getDescription() + "=" + pp2.getCost());

		Pizza pp3 = new ToppingsBlackPepper(pp2);
		System.out.println(pp3.getDescription() + "=" + pp3.getCost());
	}
}
