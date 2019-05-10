package example.app.usecase;

import java.util.List;
import java.util.Optional;

import example.app.apdaptor.repository.UserRepository;
import example.app.domain.entity.User;

public final class FindUser {

	private final UserRepository repository;

	public FindUser(UserRepository repository) {
		this.repository=repository;
	}

	public Optional<User> findById(final String id) {
		return repository.findById(id);
	}

	public List<User> findAllUsers() {
		return repository.findAllUsers();
	}
}