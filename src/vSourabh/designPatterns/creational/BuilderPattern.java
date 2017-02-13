package vSourabh.designPatterns.creational;

/**
 * Creational pattern
 * 
 * Used to solve the problems from Factory and Abstract Factory patterns
 * Problems like
 * 		- many parameters to pass
 * 		- no optional parameters 
 * 		- creating is complex because of many classes involved
 * 
 * This is solve by providing different constructors and setter methods
 * 
 * @author Sourabh
 *
 */

// Super class
class Laptop {
	//required parameters
	private String HDD;
	private String RAM;
	
	//optional parameters
	private boolean isGraphicsCardEnabled;
	private boolean isTypeC_Present;
	
	public String getHDD() {
		return HDD;
	}

	public String getRAM() {
		return RAM;
	}

	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}
	
	public boolean isType_C() {
		return isTypeC_Present;
	}
	
	private Laptop(LaptopBuilder builder) {
		this.HDD=builder.HDD;
		this.RAM=builder.RAM;
		this.isGraphicsCardEnabled=builder.isGraphicsCardEnabled;
		this.isTypeC_Present = builder.isType_C;
	}
	
	@Override
	public String toString() {
		return "HDD: " + HDD + ", RAM: " + RAM + ", isGraphicsCardEnabled: " + isGraphicsCardEnabled
				+ ", isTypeC_Present: " + isTypeC_Present;
	}

	//Builder Class
	public static class LaptopBuilder{

		// required parameters
		private String HDD;
		private String RAM;

		// optional parameters
		private boolean isGraphicsCardEnabled;
		private boolean isType_C;
		
		public LaptopBuilder(String hdd, String ram){
			this.HDD=hdd;
			this.RAM=ram;
		}

		public LaptopBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}
		
		public LaptopBuilder setTypeC(boolean isType_C) {
			this.isType_C = isType_C;
			return this;
		}
		
		public Laptop build(){
			return new Laptop(this);
		}
	}
}


public class BuilderPattern {

	public static void main(String[] args) {
		//Using builder to get the object in a single line of code
		Laptop lappy = new Laptop.LaptopBuilder("500 GB", "2 GB").setGraphicsCardEnabled(true).setTypeC(true).build();
		System.out.println(lappy.toString());
	}

}
