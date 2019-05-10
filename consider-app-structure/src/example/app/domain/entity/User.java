package example.app.domain.entity;

public class User {

	private String id;
	private String email;
	private String password;
	private String lastName;
	private String firstName;

	public static class Builder {
		private String id;
		private String email;
		private String password;
		private String lastName;
		private String firstName;

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	private User(Builder builder) {
		this.id = builder.id;
		this.email = builder.email;
		this.password = builder.password;
		this.lastName = builder.lastName;
		this.firstName = builder.firstName;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

}