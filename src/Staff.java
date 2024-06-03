public class Staff {
    private String username;
    private String password;
    private String type;
    public Staff(String type, String user, String pass) {
        setUsername(user);
        setPassword(pass);
        setType(type);
    }
    public void setUsername(String username) { this.username = username; }
    public String getUsername() { return username; }
    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return password; }
    public void setType(String type) { this.type = type; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return String.format("%s %5s %5s",
                getUsername(),
                getPassword(),
                getType()
        );
    }
}