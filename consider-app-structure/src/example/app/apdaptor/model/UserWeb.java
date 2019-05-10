package example.app.apdaptor.model;

import example.app.domain.entity.User;

public class UserWeb {

	private String id;
	private String email;
	private String password;
	private String lastName;
	private String firstName;

	private String viewinfo1;
	private String viewinfo2;
	private String viewinfo3;

	public static UserWeb toUserWeb(User user) {
		return new UserWeb() {
			{
				setId(user.getId());
				setEmail(user.getEmail());
				setPassword(user.getPassword());
				setLastName(user.getLastName());
				setFirstName(user.getFirstName());
				setViewinfo1(null);
				setViewinfo2(null);
				setViewinfo3(null);
			}
		};
	}

	public User toUser() {
		return new User.Builder()//
				.id(id)//
				.email(email)//
				.password(password)//
				.lastName(lastName)//
				.firstName(firstName)//
				.build();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getViewinfo1() {
		return viewinfo1;
	}

	public void setViewinfo1(String viewinfo1) {
		this.viewinfo1 = viewinfo1;
	}

	public String getViewinfo2() {
		return viewinfo2;
	}

	public void setViewinfo2(String viewinfo2) {
		this.viewinfo2 = viewinfo2;
	}

	public String getViewinfo3() {
		return viewinfo3;
	}

	public void setViewinfo3(String viewinfo3) {
		this.viewinfo3 = viewinfo3;
	}

}
