package example.app.apdaptor.repository;

import java.util.List;
import java.util.Optional;

import example.app.domain.entity.User;

public interface UserRepository {

	User create(User userToSave);

	Optional<User> findById(String id);

	List<User> findAllUsers();

	Optional<User> findByEmail(String email);

}
