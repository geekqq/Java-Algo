package OODAdv;

//Builder Design Pattern

public class User {
    private String userName; //required fields
    private String password; //required fields
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String email;

    private User(UserBuilder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
        this.address = builder.address;
        this.email = builder.email;
    }
    @Override
    public String toString() {
        return userName + ", " + password + ", " + firstName + ", " + lastName
                + ", " + phone + ". " + address + ", " + email;
    }

    public static class UserBuilder {
        private String userName; //required;
        private String password; //required;
        private String firstName;
        private String lastName;
        private String phone;
        private String address;
        private String email;

        public UserBuilder(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
