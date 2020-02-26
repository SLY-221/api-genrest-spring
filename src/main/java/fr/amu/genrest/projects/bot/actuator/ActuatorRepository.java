package fr.amu.genrest.projects.bot.actuator;

import org.springframework.data.repository.CrudRepository;

public interface ActuatorRepository extends CrudRepository<Actuator, Long>, ActuatorServiceCustom {

}
