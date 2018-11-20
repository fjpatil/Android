package com.example.fjpatil.mockitoexample.login;

/**
 * Created by fjpatil on 18/05/18.
 */
public interface LoginView {
  String getUsername();

  void showUsernameError(int resId);

  String getPassword();

  void showPasswordError(int resId);

  void startMainActivity();

  void showLoginError(int resId);
}
