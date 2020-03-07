package fr.amu.genrest.user;

import java.util.Optional;

public interface UserService {
	/**
	 * Fonctionnalité de recherche d'un user via username.
	 * 
	 * @param username
	 */
	Optional<User> findByUsername(String username);
	
	Optional<User> find(String id);
	
	User save(User user);
}
