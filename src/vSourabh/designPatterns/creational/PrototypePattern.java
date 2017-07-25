package vsourabh.designpatterns.creational;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * @author Sourabh
 * 
 * Creational  pattern
 *
 * Prototype design pattern is used when the Object creation is a 
 * costly affair and requires a lot of time and resources and you 
 * have a similar object already existing.It uses cloning to copy
 * the objects.
 * 
 * Fly-weight design pattern
 * 
 * 	Structural design pattern 
 * 
 *  Fly-weight design pattern is used when we need to create a lot of Objects of a class. 
 *  Fly-weight design pattern can be applied to reduce the load on memory by sharing objects.
 */

// Super class or component clone the object
abstract class GeneralPerson implements Cloneable {

	private List<String> personList;
	protected String countryLiving;
	
	public GeneralPerson() {
		personList = new ArrayList<>();
	}

	public abstract void loadData();
	
	public List<String> getPersons() {
		return personList;
	}

	@Override
	public abstract Object clone() throws CloneNotSupportedException;
}

// Sub-class implements the Super and also add clone method for cloning 
// i.e. for prototype pattern
class IndiaPersons extends GeneralPerson {

	public IndiaPersons() {
		countryLiving = "India";
	}
	
	public IndiaPersons(List<String> list) {
		this();
		super.getPersons().addAll(list);
	}
	
	@Override
	public void loadData() {
		super.getPersons().add("Showvik");
		super.getPersons().add("Sourabh");
		super.getPersons().add("Deb");
		super.getPersons().add("Vivek");
	}
	@Override
	public Object clone() {
		List<String> temp = new ArrayList<String>();
		for(String name : this.getPersons()){
			temp.add(name);
		}
		return new IndiaPersons(temp);	
	}
}


//Sub-class implements the Super and also add clone method for cloning 
//i.e. for prototype pattern
class UsaPersons extends GeneralPerson {

	public UsaPersons() {
		countryLiving = "USA";
	}
	
	public UsaPersons(List<String> list) {
		this();
		super.getPersons().addAll(list);
	}
	
	@Override
	public void loadData() {
		super.getPersons().add("Prithvi");
		super.getPersons().add("Saswat");
		super.getPersons().add("Amaan");
		super.getPersons().add("Tussar");
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<String>();
		for(String name : this.getPersons()){
			temp.add(name);
		}
		return new UsaPersons(temp);
	}
}

/**
 * @author Sourabh
 * 
 * Create cache of the objects created to re-use them to create new objects
 * This uses fly-weight design pattern
 *
 */
class PersonCacheFlyWeight {
	private static Map<String, GeneralPerson> personMap  = new Hashtable<>();
	
	//Use Fly-weight pattern checks if objects are present if not then creates a new Object
	public static GeneralPerson getPerson(String shapeId) throws CloneNotSupportedException {
		GeneralPerson cache = personMap.get(shapeId);
		if(cache == null) {
			if(shapeId.equalsIgnoreCase("India")) {
				IndiaPersons personInd = new IndiaPersons();
				personInd.loadData();
				personMap.put(personInd.countryLiving, personInd);
				cache = personInd;
			} else if(shapeId.equalsIgnoreCase("Usa")) {
				UsaPersons personUsa = new UsaPersons();
			    personUsa.loadData();
			    personMap.put(personUsa.countryLiving, personUsa);
			    cache = personUsa;
			}
		}
		return (GeneralPerson) cache.clone();
   }
	
   static void loadCache() {
	   IndiaPersons personInd = new IndiaPersons();
	   personInd.loadData();
	   personMap.put(personInd.countryLiving, personInd);

      UsaPersons personUsa = new UsaPersons();
      personUsa.loadData();
      personMap.put(personUsa.countryLiving, personUsa);
   }
}

public class PrototypePattern {

	public static void main(String[] args) throws CloneNotSupportedException {
	
		GeneralPerson personA = (GeneralPerson) PersonCacheFlyWeight.getPerson("India");
		GeneralPerson personB = (GeneralPerson) PersonCacheFlyWeight.getPerson("USA");
		GeneralPerson personC = (GeneralPerson) PersonCacheFlyWeight.getPerson("India");
		List<String> listA = personA.getPersons();
		listA.add("Prat");
		List<String> listB = personB.getPersons();
		listB.remove("Tussar");
		List<String> listC = personC.getPersons();
		listC.add("Vicky");
		listC.remove("Sourabh");
		
		
		System.out.println("personA List: " + listA);
		System.out.println("personB List: " + listB);
		System.out.println("personC List: " + listC);
	}

}
