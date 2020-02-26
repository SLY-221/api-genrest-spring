package fr.amu.genrest.projects.bot.actuator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;


public class ActuatorServiceCustomImpl implements ActuatorServiceCustom {

	@PersistenceContext()
	private EntityManager em;

	@Override
	@Transactional
	public Actuator updateById(Actuator actuator) {
		return em.merge(actuator);

	}

}
