package fr.amu.genrest.projects.bot.actuator;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Fazia 
 * @author Bachir
 *
 */
@Nested 
public class ActuatorRepositoryTest {
	@Autowired
	ActuatorRepository actuatorRepository;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("test commence");
	}
	@After
	public void tearDown() throws Exception {
		System.out.println("test fini ");
	}
		
	// add

	@Test
	public void testAddEntity() {
		//Add
		int after = (int) actuatorRepository.count();
		System.out.println("occurence"+after);
		Actuator actuator = new Actuator(); // 1,1,"model","actuator3"
		actuator.setLatitude(28.5);
		actuator.setLongitude(35.5);
		actuator.setModel("ACT001");
		actuator.setName("Actuator001");
		actuatorRepository.save(actuator);
		System.out.println("good1" +actuator);
		int befor = after +1 ;
		Assert.assertEquals(befor ,(int)actuatorRepository.count());
	}
	
	//update
		@SuppressWarnings("unlikely-arg-type")
		@Test
		public void testUpdateEntity() {
		Long id = (long)1;
		//found entity
	    Actuator actuatorFound = actuatorRepository.findById(id).orElse(null);
		//update entity
		if (actuatorFound != null) {
		actuatorFound.setModel("mod121");
		actuatorFound.setName("actssss");
		actuatorRepository.save(actuatorFound);
		}
		
	    Actuator actuatorUpdated = actuatorRepository.findById(id).orElse(null);
	    ArrayList<String> recordupdated = new ArrayList<String>();
	    ArrayList<String> recordfounded = new ArrayList<String>();
	    recordupdated.contains(actuatorUpdated);
	    recordfounded.contains(actuatorFound);
	    //boolean res = actuatorFound.equals(actuatorUpdated);
		Assert.assertEquals(recordfounded, recordupdated);
		}
		
		@Test
		public void testDeleteEntity() {
		//delete
		Long id = (long) 9;
		Actuator actuator = actuatorRepository.findById(id).orElse(null);
		if (actuator != null)
		actuatorRepository.deleteById(id);
		Actuator actuatordeleted = actuatorRepository.findById(id).orElse(null);
		System.out.println(" ID deleted "+actuatordeleted);
		Assert.assertNull(actuatordeleted);
		
	}
}
