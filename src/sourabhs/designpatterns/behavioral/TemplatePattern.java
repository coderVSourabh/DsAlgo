package sourabhs.designpatterns.behavioral;

/**
 * Behavioural  design pattern
 * 
 * used to create a method stub and deferring some of the steps of implementation 
 * to the subclasses. Template method defines the steps to execute an algorithm 
 * and it can provide default implementation that might be common for all or some of the subclasses.
 * 
 * @author Sourabh
 *
 */

//Template Super class with template methods
abstract class BuildVehicleTemplate {
	
	//Template method, final so subclasses can't override
	public final void buildVehicle(){
		buildStructure();
		attachTyres();
		attachEngine();
		paintVehicle();
		System.out.println("Vehicle is built.");
	}

	//Default implementation for some of the function
	protected void paintVehicle() {
		System.out.println("Painting Red ");
	}

	//methods to be implemented by subclasses
	public abstract void attachEngine();
	public abstract void attachTyres();

	protected void buildStructure() {
		System.out.println("Building Vehicle structures");
	}
}

class car extends BuildVehicleTemplate {

	@Override
	public void attachEngine() {
		System.out.println("Building Mercedez Engine");
	}

	@Override
	public void attachTyres() {
		System.out.println("Attach Perili tyre ");
	}
	
}

class bike extends BuildVehicleTemplate {

	@Override
	public void attachEngine() {
		System.out.println("Building Bullet Engine");
	}
	
	@Override
	public void paintVehicle() {
		System.out.println("Painting Black");
	}

	@Override
	public void attachTyres() {
		System.out.println("Attach MRF tyres");
	}
	
}

public class TemplatePattern {

	public static void main(String[] args) {
		BuildVehicleTemplate house = new car();
		house.buildVehicle();
		System.out.println("****************************");
		house = new bike();
		house.buildVehicle();

	}

}
