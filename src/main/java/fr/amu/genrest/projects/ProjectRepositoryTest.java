package fr.amu.genrest.projects;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.amu.genrest.projects.bot.building.Address;
import fr.amu.genrest.projects.bot.building.Building;

@Nested
public class ProjectRepositoryTest {
	@Autowired
	ProjectRepository projectRepository;

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
		// Add
		LocalDateTime creationDate = LocalDateTime.of(2018, Month.DECEMBER, 25, 13, 37, 0);
		LocalDateTime changeDate = LocalDateTime.of(2018, Month.DECEMBER, 26, 13, 37, 0);
		int after = (int) projectRepository.count();
		System.out.println("occurence" + after);
		Set<Building> buildings = new HashSet<>();
		Address address = new Address(10, "chemin du bassin", "Marseille", "France");
		Building building = new Building("type3", address);
		buildings.add(building);
		Project project = new Project(null, "Bot", "Architecture", creationDate, changeDate, buildings);
		projectRepository.save(project);
		int befor = after + 1;
		Assert.assertEquals(befor, (int) projectRepository.count());
	}

	// update
	@SuppressWarnings({ "unlikely-arg-type", "unused" })
	@Test
	public void testUpdateEntity() {
		Long id = (long) 1;
		LocalDateTime creationDate = LocalDateTime.of(2018, Month.DECEMBER, 25, 13, 37, 0);
		LocalDateTime changeDate = LocalDateTime.of(2018, Month.DECEMBER, 26, 13, 37, 0);
		// found entity
		Project projectFound = projectRepository.findById(id).orElse(null);
		// update entity
		if (projectFound != null) {
			projectFound.setDomaine("building");
			projectFound.setProjectName("project1");
			projectRepository.save(projectFound);
		}
		Project projectUpdated = projectRepository.findById(id).orElse(null);
		ArrayList<String> recordupdated = new ArrayList<String>();
		ArrayList<String> recordfounded = new ArrayList<String>();
		recordupdated.contains(projectUpdated);
		recordfounded.contains(projectFound);
		Assert.assertEquals(recordfounded, recordupdated);
	}

//delete
	@Test
	public void testDeleteEntity() {
		// delete
		Long id = (long) 9;
		Project project = projectRepository.findById(id).orElse(null);
		if (project != null)
			projectRepository.deleteById(id);
		Project projetdeleted = projectRepository.findById(id).orElse(null);
		System.out.println("projetdeleted" + projetdeleted);
		Assert.assertNull(projetdeleted);

	}
}
