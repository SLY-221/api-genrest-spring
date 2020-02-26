/**
 * 
 */
package fr.amu.genrest.projects.dao;

/**Interface regroupant les prototypes des fonctions génériques de la couche DAO.
 * Cette interface se veut réutilisable et permet des opérations via JPA telles que la création,
 * la mise à jour, la suppression ou la lecture de beans.
 * 
 * @author Fazia, 
 * @author Bachir
 *
 */
public interface GenericRepository {
	
	/**
	 * Méthode générique de mise-à-jour d'entité dans une base de données.
	 * Fusionne la version de l'entité passée en paramètre avec celle présente dans la base de données.
	 * 
	 * @param entity L'entité à mettre à jour.
	 * @return L'entité résultante de la fusion.
	 */
	public <T> T update(T entity);
}
