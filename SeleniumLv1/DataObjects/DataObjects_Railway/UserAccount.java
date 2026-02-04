package DataObjects_Railway;

public class UserAccount {
    private String usernameAccount;
    private String passwordAccount;
    private String pidAccount;

    public UserAccount(String usernameAccount, String passwordAccount, String pidAccount) {
        this.usernameAccount = usernameAccount;
        this.passwordAccount = passwordAccount;
        this.pidAccount = pidAccount;
    }

    public String getUsernameAccount() {
        return usernameAccount;
    }

    public void setUsernameAccount(String usernameAccount) {
        this.usernameAccount = usernameAccount;
    }

    public String getPasswordAccount() {
        return passwordAccount;
    }

    public void setPasswordAccount(String passwordAccount) {
        this.passwordAccount = passwordAccount;
    }

    public String getPidAccount() {
        return pidAccount;
    }

    public void setPidAccount(String pidAccount) {
        this.pidAccount = pidAccount;
    }
}