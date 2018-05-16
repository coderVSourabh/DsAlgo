package sourabhs.designpatterns.structural;

/**
 * @author Sourabh
 * 
 * Structural design pattern
 * 
 * Adapter design pattern is one of the structural design pattern and
 *  its used so that two unrelated interfaces can work together. 
 *  The object that joins these unrelated interface is called an Adapter
 *  Adapter can be achieved by
 *  	Class Adapter : IS-A relation or inheritance
 *  	Object Adapter: HAS-A relation or composition 
 *  
 *  Proxy Pattern
 *     
 *     Structural Design pattern
 *     
 *     It is used when we want to provide controlled access of a functionality.
 *     It is achieved by making the interface visible to client but not the 
 *     class which implement the interface. Structure same as Adapter in main purpose
 *     to hide the functionality using interface 
 *  
 *  Bridge Pattern 
 *  
 *     Structural Design Pattern
 *     
 *     Bridge design pattern can be used when both abstraction and implementation can 
 *     have different hierarchies independently and we want to hide the implementation 
 *     from the client application.
 *
 */
// Class volt to measure Voltage
class Volt {

	private int volts;
	public Volt(int v){
		this.volts=v;
	}
	public int getVolts() {
		return volts;
	}
	public void setVolts(int volts) {
		this.volts = volts;
	}
}

//Class to add the voltage in the socket
class Socket {

	public Volt getVolt(){
		return new Volt(120);
	}
}


interface SocketAdapter {

	public Volt get120Volt();		
	public Volt get12Volt();
	public Volt get3Volt();
}

//Class Adapter: implements Socket has a super class
class SocketClassAdapterImpl extends Socket implements SocketAdapter{

	@Override
	public Volt get120Volt() {
		return getVolt();
	}

	@Override
	public Volt get12Volt() {
		Volt v= getVolt();
		return convertVolt(v,10);
	}

	@Override
	public Volt get3Volt() {
		Volt v= getVolt();
		return convertVolt(v,40);
	}
	
	private Volt convertVolt(Volt v, int i) {
		return new Volt(v.getVolts()/i);
	}
}

//Object Adapter:  Socket is a member of this class
class SocketObjectAdapterImpl implements SocketAdapter{

	private Socket sock = new Socket();
	
	@Override
	public Volt get120Volt() {
		return sock.getVolt();
	}

	@Override
	public Volt get12Volt() {
		Volt v= sock.getVolt();
		return convertVolt(v,10);
	}

	@Override
	public Volt get3Volt() {
		Volt v= sock.getVolt();
		return convertVolt(v,40);
	}
	
	private Volt convertVolt(Volt v, int i) {
		return new Volt(v.getVolts()/i);
	}
}

public class AdapterPattern {

	public static void main(String[] args) {
		System.out.println("*********Object Adapter*********");
		SocketAdapter adapterObj = new SocketObjectAdapterImpl();
		Volt voltA = getVolt(adapterObj,3);
		Volt voltB = getVolt(adapterObj,12);
		Volt voltC = getVolt(adapterObj,120);
		System.out.println("v3 volts using Object Adapter="  + voltA.getVolts());
		System.out.println("v12 volts using Object Adapter=" + voltB.getVolts());
		System.out.println("v120 volts using Object Adapter="+ voltC.getVolts());
		
		System.out.println("*********class Adapter*********");
		SocketAdapter adapterClass = new SocketClassAdapterImpl();
		voltA = getVolt(adapterClass,3);
		voltB = getVolt(adapterClass,12);
		voltC = getVolt(adapterClass,120);
		System.out.println("v 3 volts using Class Adapter=" + voltA.getVolts());
		System.out.println("v12 volts using Class Adapter=" + voltB.getVolts());
		System.out.println("v120 volts using Class Adapter="+ voltC.getVolts());
		
	}

	private static Volt getVolt(SocketAdapter sockAdapter, int i) {
		switch (i){
		case 3: return sockAdapter.get3Volt();
		case 12: return sockAdapter.get12Volt();
		case 120: return sockAdapter.get120Volt();
		default: return sockAdapter.get120Volt();
		}
	}

}
