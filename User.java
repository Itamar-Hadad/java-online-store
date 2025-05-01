package onlinestore;

public class User {
    private String name;
    private String password;

    public User(String name, String password) throws StringEmptyNullException {
        setName(name);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws StringEmptyNullException {
        if (name == null || name.isEmpty()) {
            throw new StringEmptyNullException("name");
        }
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws StringEmptyNullException {
        if (password == null || password.isEmpty()) {
            throw new StringEmptyNullException("Password");
        }
        this.password = password;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof User)) {
            return false;
        }
        User user = (User) other;
        return this.name.equals(user.getName()) && this.password.equals(user.getPassword());
    }

    @Override
    public String toString() {
        return "Username: " + name + "\n password: " + password;
    }
}
