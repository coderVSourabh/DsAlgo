package vSourabh.designPatterns.creational;

/**
 * Only one object is created for this Class
 * 
 * Creational Design Pattern
 * 
 * Types of Singleton
 * Eager initialisation : One instance created during load
 * Static Block initialisation :same as eager except the static block
 * lazy initialisation : Created once client needs it
 * Thread safe : Object access global method is synchronised  
 *  etc like Bill Pugh, serialised, reflection ...
 *  
 * @author Sourabh
 *
 */
class SingletonEager {
	
	private SingletonEager() {}
	private static final SingletonEager instance = new SingletonEager();
	
	public static SingletonEager getInstance(){
        return instance;
    }
}

class SingletonStaticBlock {
	
	private SingletonStaticBlock() {}
	private static final SingletonStaticBlock instance;
	static{
        try{
            instance = new SingletonStaticBlock();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
	
	public static SingletonStaticBlock getInstance(){
        return instance;
    }
}

class SingletonLazy {
	
	private SingletonLazy() {}
	private static SingletonLazy instance;
	public static SingletonLazy getInstance() {
		 if(instance == null)
			 instance = new SingletonLazy();
		 return instance;
	 }
}


class SingletonThreadSafe {
	private SingletonThreadSafe() {}
	private static SingletonThreadSafe instance;

	public static SingletonThreadSafe getInstance() {
		 if(instance == null) {
		        synchronized (SingletonThreadSafe.class) {
		            if(instance == null)
		                instance = new SingletonThreadSafe();
		        }
		 }       
		 return instance;
	 }
}

class SingletonPattern {

	public static void main(String[] args) {
		System.out.println("Singleton Patterns");
	}
	
}
