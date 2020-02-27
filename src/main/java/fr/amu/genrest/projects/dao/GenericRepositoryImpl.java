/**
 * 
 */
package fr.amu.genrest.projects.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Implémentation de la partie générique de la couche DAO.
 * 
 * @author Fazia
 * @author Bachir
 *
 *@see fr.amu.genrest.projects.dao.GenericRepository
 */
public class GenericRepositoryImpl implements GenericRepository{
	
	/**
	 * Interface utilisée pour intéragir avec le contexte de persistence.
	 */
	@PersistenceContext
	protected EntityManager em;

	/**
	 * Méthode générique de mise-à-jour d'entité dans une base de données. Fusionne
	 * la version de l'entité passée en paramètre avec celle présente dans la base
	 * de données et la supprime si elle existe.
	 * 
	 * @param entity L'entité à mettre à jour.
	 * @return L'entité résultante de la fusion.
	 */
	@Override
	public <T> T update(T entity) {
		entity = em.merge(entity);
		System.err.println("Entity updated.");
		return entity;
	}

}
