package laura.gotarra.tabmyscores;

public class User {
    private String name, surname, nickname, password, about;
    private int songs;

    public User(String name, String surname, String nickname, String password){
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.password = password;
        about = "Write something hear";
        songs = 0;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public void setAboutUser(String about){
        this.about = about;
    }

    public String getNickname(){
        return nickname;
    }

    public String getAboutUser(){
        return about;
    }

    public int getSongs(){
        return songs;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public void upSong(){
        songs++;
    }
}
