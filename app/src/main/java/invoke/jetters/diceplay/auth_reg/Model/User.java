package invoke.jetters.diceplay.auth_reg.Model;

public class User {
    private String login;
    private String hashPassword;
    private String userName;

    public User(String login, String hashPassword) {
        this.login = login;
        this.hashPassword = hashPassword;
    }

    public User(String login, String hashPassword, String userName) {
        this.login = login;
        this.hashPassword = hashPassword;
        this.userName = userName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return hashPassword;
    }

    public void setPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }
}
