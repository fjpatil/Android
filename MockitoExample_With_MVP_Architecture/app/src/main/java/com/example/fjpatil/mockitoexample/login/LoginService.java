package com.example.fjpatil.mockitoexample.login;

public class LoginService {
  public boolean login(String username, String password) {
    return "fj".equals(username) && "patil".equals(password);
  }
}
