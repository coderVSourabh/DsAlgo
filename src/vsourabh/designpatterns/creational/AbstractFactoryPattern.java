package vsourabh.designpatterns.creational;

/**
 * Creational Patterns
 * 
 * Factory design pattern is used when we have a super class with multiple sub-classes 
 * and based on input, we need to return one of the sub-class. This pattern take out the
 * responsibility of instantiation of a class from client program to the factory class
 * 
 *  In Factory Pattern sub-classes are returned based on if-else or switch statement 
 *  but in Abstract Factory is based on the input factory
 *  
 * @author Sourabh
 *
 */

// Super class 
abstract class Computer {
	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getProcessor();
	@Override
	public String toString() {
		return "RAM: " + getRAM() + ", HDD: " + getHDD() + ", Processor: " + getProcessor();
	}	
}

// Sub-class Dell
class DellLaptop extends Computer {

	@Override
	public String getRAM() {
		return "16 GB";
	}

	@Override
	public String getHDD() {
		return "256 GB";
	}

	@Override
	public String getProcessor() {
		return "Intel I7";
	}
}

//Sub-Class AppleMac
class AppleMac extends Computer {

	private String ram, hdd, processor;
	
	public AppleMac(String ram, String hdd, String processor) {
		this.ram = ram;
		this.hdd = hdd;
		this.processor = processor;
	}
	
	@Override
	public String getRAM() {
		return this.ram;
	}

	@Override
	public String getHDD() {
		return this.hdd;
	}

	@Override
	public String getProcessor() {
		return this.processor;
	}
	
}

//Abstract Factory to create Object of Sub-class
interface ComputerAbstractFactory {
	public Computer createComputer();
}

// Creates Dell Subclass object
class DellFactory implements ComputerAbstractFactory {
	
	@Override
	public Computer createComputer() {
		return new DellLaptop();
	}
}

//Creates Apple Subclass object
class AppleFactory implements ComputerAbstractFactory {

	private String ram, hdd, processor;
	public AppleFactory(String ram, String hdd, String processor) {
		this.ram = ram;
		this.hdd = hdd;
		this.processor = processor;
	}
	
	@Override
	public Computer createComputer() {
		return new AppleMac(ram, hdd, processor);
	}	
}

// Used to Create object by client using AbstractFactory class
class ComputerFactory {
	public static Computer getComputer(ComputerAbstractFactory factory){
		return factory.createComputer();
	}
}

public class AbstractFactoryPattern {

	public static void main(String[] args) {
		Computer dell = ComputerFactory.getComputer(new DellFactory());
		Computer mac  = ComputerFactory.getComputer(new AppleFactory("12 GB","512 GB","Apple A9"));
		System.out.println("Abstract-Factory DELL Config:: \n" +  dell);
		System.out.println("Abstract-Factory APPLE Config:: \n" + mac);
	}
}
