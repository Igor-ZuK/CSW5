package models;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private int id;

    private String FIO;

    private String code;

    private String passportId;

    private String mail;

    private String mobileNumber;

    private String login;

    private String passwordHash;

    private int isAdmin;


    public User() {
        
    }

    public User(String FIO, String code, String passportId, String mail,
                  String mobileNumber, String login, String passwordHash, int isAdmin) {
        this.FIO = FIO;
        this.code = code;
        this.passportId = passportId;
        this.mail = mail;
        this.mobileNumber = mobileNumber;
        this.login = login;
        this.passwordHash = passwordHash;
        this.isAdmin = isAdmin;
    }

    public String getFIO() {
        return FIO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getClientCode() {
        return code;
    }

    public void setClientCode(String code) {
        this.code = code;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return passwordHash;
    }

    public void setPassword(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public int getFlag() {
        return isAdmin;
    }

    public void setFlag(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User client = (User) o;
        return isAdmin == client.isAdmin
                && Objects.equals(FIO, client.FIO)
                && Objects.equals(code, client.code)
                && Objects.equals(passportId, client.passportId)
                && Objects.equals(mail, client.mail)
                && Objects.equals(mobileNumber, client.mobileNumber)
                && Objects.equals(login, client.login)
                && Objects.equals(passwordHash, client.passwordHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIO, code, passportId, mail, mobileNumber, login, passwordHash, isAdmin);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", FIO='" + FIO + '\'' +
                ", code='" + code + '\'' +
                ", passportId='" + passportId + '\'' +
                ", mail='" + mail + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", login='" + login + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
    
}