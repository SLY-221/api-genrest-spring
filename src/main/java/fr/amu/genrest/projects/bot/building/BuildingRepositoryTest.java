/**
 * 
 */
package fr.amu.genrest.projects.bot.building;

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
public class BuildingRepositoryTest {
	@Autowired
	BuildingRepository buildingRepository;
	
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
		int after = (int) buildingRepository.count();
		System.out.println("occurence"+after);
		Address address = new Address(10, "chemin du bassin", "Marseille", "France");
		Building building = new Building("type1",address);
		buildingRepository.save(building);
		System.out.println("good1" +building);
		int befor = after +1 ;
		Assert.assertEquals(befor ,(int)buildingRepository.count());
	}
	//update
			@SuppressWarnings("unlikely-arg-type")
			@Test
			public void testUpdateEntity() {
			Long id = (long)1;
			Address address = new Address(10, "chemin du bassin", "Marseille", "France");
			//found entity
			Building buildingFound = buildingRepository.findById(id).orElse(null);
			//update entity
			if (buildingFound != null) {
			buildingFound.setAddress(address);
			buildingFound.setType("type12");
			buildingRepository.save(buildingFound);
			}
		    Building buildingUpdated = buildingRepository.findById(id).orElse(null);
		    ArrayList<String> recordupdated =new ArrayList<String>();
		    ArrayList<String> recordfounded =new ArrayList<String>();
		    recordupdated.contains(buildingUpdated);
		    recordfounded.contains(buildingFound);
			Assert.assertEquals(recordfounded, recordupdated);
			}
			

			@Test
			public void testDeleteEntity() {
			//delete
			Long id = (long) 9;
			Building building = buildingRepository.findById(id).orElse(null);
			if (building != null)
				buildingRepository.deleteById(id);
			Building buildingdeleted = buildingRepository.findById(id).orElse(null);
			System.out.println("iddeleted"+buildingdeleted);
			Assert.assertNull(buildingdeleted);
			
		}
	

}
