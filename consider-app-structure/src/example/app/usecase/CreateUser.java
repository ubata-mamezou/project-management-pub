package example.app.usecase;

import example.app.apdaptor.encoder.PasswordEncoder;
import example.app.apdaptor.idgenerator.IdGenerator;
import example.app.apdaptor.repository.UserRepository;
import example.app.domain.entity.User;
import example.app.domain.exception.UserAlreadyExistsException;
import example.app.usecase.validator.UserValidator;

public final class CreateUser {

	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final IdGenerator idGenerator;

	public CreateUser(UserRepository repository, PasswordEncoder passwordEncoder, IdGenerator idGenerator) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.idGenerator = idGenerator;
	}

	public User create(final User user) {
		UserValidator.validateCreateUser(user);

		if (repository.findByEmail(user.getEmail()).isPresent()) {
			throw new UserAlreadyExistsException(user.getEmail());
		}

		var userToSave = new User.Builder()//
				.id(idGenerator.generate())//
				.email(user.getEmail())//
				.password(passwordEncoder.encode(user.getEmail() + user.getPassword()))//
				.lastName(user.getLastName())//
				.firstName(user.getFirstName())//
				.build();
		return repository.create(userToSave);
	}
}