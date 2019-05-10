package example.app.apdaptor.controller;

import java.util.List;
import java.util.stream.Collectors;

import example.app.apdaptor.model.UserWeb;
import example.app.usecase.CreateUser;
import example.app.usecase.FindUser;
import example.app.usecase.LoginUser;
import example.patch.annotation.Autowired;
import example.patch.annotation.PathVariable;
import example.patch.annotation.RequestBody;
import example.patch.annotation.RequestMapping;
import example.patch.annotation.RequestParam;
import example.patch.annotation.RestController;
import example.patch.constant.RequestMethod;

@RestController
public class UserController {
	private final CreateUser createUser;
	private final FindUser findUser;
	private final LoginUser loginUser;

	@Autowired
	public UserController(CreateUser createUser, FindUser findUser, LoginUser loginUser) {
		this.createUser = createUser;
		this.findUser = findUser;
		this.loginUser = loginUser;
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public UserWeb createUser(@RequestBody final UserWeb userWeb) {
		var user = userWeb.toUser();
		return UserWeb.toUserWeb(createUser.create(user));
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public UserWeb login(@RequestParam("email") final String email, @RequestParam("password") final String password) {
		return UserWeb.toUserWeb(loginUser.login(email, password));
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public UserWeb getUser(@PathVariable("userId") final String userId) {
		return UserWeb.toUserWeb(findUser.findById(userId).orElseThrow(() -> new RuntimeException("user not found")));
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserWeb> allUsers() {
		return findUser.findAllUsers().stream().map(UserWeb::toUserWeb).collect(Collectors.toList());
	}
}