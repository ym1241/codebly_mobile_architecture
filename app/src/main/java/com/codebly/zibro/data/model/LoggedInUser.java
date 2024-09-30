package com.codebly.zibro.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {
// 로그인된 사용자의 정보를 나타내는 데이터 클래스입니다.
    // 이 클래스는 로그인 후 서버로부터 받은 사용자 데이터를 저장하는 역할을 합니다.
    //사용자 아이디(userId)와 사용자 이름(displayName)을 저장하고, getter 메서드를 제공합니다.
    private String userId;
    private String displayName;

    public LoggedInUser(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }
}