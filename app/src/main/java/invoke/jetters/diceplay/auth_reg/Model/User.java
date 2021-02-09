package invoke.jetters.diceplay.auth_reg.Model;

public class User {
    private String login;
    private int password;
    private String userName;

    public User(String login, int password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, int password, String userName) {
        this.login = login;
        this.password = password;
        this.userName = userName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
