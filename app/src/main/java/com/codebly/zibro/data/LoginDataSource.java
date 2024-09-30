package com.codebly.zibro.data;

import com.codebly.zibro.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {
//login() 메서드는 주어진 아이디와 비밀번호로 로그인 요청을 보내고,
//결과에 따라 로그인 성공(Result.Success) 또는 실패(Result.Error)를 반환합니다.
        try {
            // TODO: handle loggedInUser authentication
            // TODO : 하는중에 Jane Doe라는 이름을 사용자이름으로 나와야함.
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        //로그아웃 처리를 담당합니다.
        // TODO: revoke authentication
    }
}