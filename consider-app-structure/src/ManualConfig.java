import example.app.apdaptor.encoder.PasswordEncoder;
import example.app.apdaptor.encoder.Sha256PasswordEncoder;
import example.app.apdaptor.idgenerator.IdGenerator;
import example.app.apdaptor.idgenerator.JugIdGenerator;
import example.app.apdaptor.repository.InMemoryUserRepository;
import example.app.apdaptor.repository.UserRepository;
import example.app.usecase.CreateUser;
import example.app.usecase.FindUser;
import example.app.usecase.LoginUser;

public class ManualConfig {

	private final UserRepository userRepository = new InMemoryUserRepository();
	private final IdGenerator idGenerator = new JugIdGenerator();
	private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

	public CreateUser createUser() {
		return new CreateUser(userRepository, passwordEncoder, idGenerator);
	}
	
  	public FindUser findUser() {
		return new FindUser(userRepository);
	}
	
	public LoginUser loginUser() {
		return new LoginUser(userRepository, passwordEncoder);
	}
}