package vSourabh.designPatterns.Others;

/**
 * @author Sourabh
 * 
 * J2EE (Java EE) design pattern
 * 
 * Business Delegate Pattern is used to decouple presentation tier and business tier.
 *  It is basically use to reduce communication or remote lookup functionality to business 
 *  tier code in presentation tier code. 
 *
 */

// Super class for business services
interface BusinessService {
	public void doProcessing();
}

//sub-class
class EJBService implements BusinessService {

	@Override
	public void doProcessing() {
		System.out.println("Processing task by invoking EJB Service");
	}
}

//Sub-class
class JMSService implements BusinessService {

	@Override
	public void doProcessing() {
		System.out.println("Processing task by invoking JMS Service");
	}
}

// Used to get the business service implementation 
class BusinessLookUp {
	
	public BusinessService getBusinessService(String serviceType) {

		if (serviceType.equalsIgnoreCase("EJB")) 
			return new EJBService();
		else if(serviceType.equalsIgnoreCase("JMS"))
			return new JMSService();
		
		return null;
	}
}

// point class for client entities to provide access to Business Service methods
class BusinessDelegate {
	private BusinessLookUp lookupService = new BusinessLookUp();
	private BusinessService businessService;
	private String serviceType;

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public void doTask() {
		businessService = lookupService.getBusinessService(serviceType);
		businessService.doProcessing();
	}
}

//Client class which used BusinessDelegate to access service methods
class Client {

	BusinessDelegate businessService;
	public Client(BusinessDelegate businessService) {
		this.businessService = businessService;
	}
	public void doTask() {
		businessService.doTask();
	}
}

public class BusinessDelegatePattern {

	public static void main(String[] args) {
		BusinessDelegate businessDelegate = new BusinessDelegate();
		businessDelegate.setServiceType("EJB");

		Client client = new Client(businessDelegate);
		client.doTask();

		businessDelegate.setServiceType("JMS");
		client.doTask();
	}
}
