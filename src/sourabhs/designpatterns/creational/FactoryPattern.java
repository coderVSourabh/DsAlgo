package sourabhs.designpatterns.creational;

/**
 * @author Sourabh
 *
 * Creational pattern
 * 
 * Factory design pattern is used when we have a super class with multiple sub-classes 
 * and based on input, we need to return one of the sub-class. This pattern take out the
 *  responsibility of instantiation of a class from client program to the factory class.
 */

// Super class
abstract class Phone {
	
	public abstract String getRAM();
	public abstract String getMemory();
	
	@Override
	public String toString(){
		return "RAM: "+this.getRAM()+", Memory: "+this.getMemory();
	}
}

// Sub-Class
class Nokia extends Phone {

	private String ram, memory;
	
	public Nokia(String ram, String drive){
		this.ram = ram;
		this.memory = drive;
	}
	
	@Override
	public String getRAM() {
		return this.ram;
	}
	
	@Override
	public String getMemory() {
		return this.memory;
	}
}

//Sub-Class
class IPhone extends Phone {

	private String ram, memory;
	
	public IPhone(String ram, String drive){
		this.ram = ram;
		this.memory = drive;
	}
	
	@Override
	public String getRAM() {
		return this.ram;
	}
	
	@Override
	public String getMemory() {
		return this.memory;
	}
}

// Factory class to create the object of Sub-class based on type	
class PhoneFactory {

	public static Phone getPhone(String type, String ram, String drive) {
		if("Nokia".equalsIgnoreCase(type)) return new Nokia(ram, drive);
		else if("iPhone".equalsIgnoreCase(type)) return new IPhone(ram, drive);
		return null;
	}
}

public class FactoryPattern {

	public static void main(String[] args) {
		Phone nokia = PhoneFactory.getPhone("nokia","6 GB","128 GB");
		Phone apple = PhoneFactory.getPhone("IPhone", "2 GB", "64 GB");
		System.out.println("Factory Nokia Config::\n" + nokia);
		System.out.println("Factory apple Config::\n" + apple);
	}
}
