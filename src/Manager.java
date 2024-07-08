public class Manager extends Staff {
    public Manager(String user, String pass) {
        super(user, pass);
        setManager(true);
    }
}
