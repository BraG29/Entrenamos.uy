package logica.datatypes;

public class DtUsrKey {
    public final String nickname;
    public final String email;

    public DtUsrKey(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }
}
