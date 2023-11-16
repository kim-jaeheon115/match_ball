package com.example.matchball;

/*
사용자 계정 정보 모델 클래스
*/
public class UserAccount {

    private String idToken; //firebase Uid (고유 토큰정보)
    private String emailId;  //이메일 아이디
    private  String password; // 비밀번호 +닉네임 , 유저메세지 , 토큰등 구현하면됨
    private String phonenumber;
    private String nickname;


    //아래는 게터세터 생성자 생성
    public UserAccount() {
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserAccount(String nickname) {
        this.nickname = nickname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
