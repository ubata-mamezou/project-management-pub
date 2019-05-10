package example.app.usecase;

import example.app.apdaptor.encoder.PasswordEncoder;
import example.app.apdaptor.repository.UserRepository;
import example.app.domain.entity.User;
import example.app.domain.exception.UserAlreadyExistsException;

public class LoginUser {
	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;

	public LoginUser(UserRepository repository, PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}

	public User login(String email, String password) {
//		Optional<User> user = repository.findByEmail(email);

		if (repository.findByEmail(email).isPresent()) {
			throw new UserAlreadyExistsException(email);
		}

		return new User.Builder()//
				.id("id")//
				.email(email)//
				.password(password)//
				.lastName("lastName")//
				.firstName("firstName")//
				.build();
	}

}
