package com.example.fjpatil.mockitoexample;

import com.example.fjpatil.mockitoexample.login.LoginPresenter;
import com.example.fjpatil.mockitoexample.login.LoginService;
import com.example.fjpatil.mockitoexample.login.LoginView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by fjpatil on 18/05/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
  @Mock
  private LoginView view;
  @Mock
  private LoginService service;
  private LoginPresenter presenter;

  @Before
  public void setUp() throws Exception {
    presenter = new LoginPresenter(view, service);
  }

  @Test
  public void shouldShowErrorMessageWhenUsernameIsEmpty() throws Exception {
    when(view.getUsername()).thenReturn("");
    presenter.onLoginClicked();

    verify(view).showUsernameError(R.string.username_error);
  }

  @Test
  public void shouldShowErrorMessageWhenPasswordIsEmpty() throws Exception {
    when(view.getUsername()).thenReturn("fj");
    when(view.getPassword()).thenReturn("");
    presenter.onLoginClicked();

    verify(view).showPasswordError(R.string.password_error);
  }

  @Test
  public void shouldStartMainActivityWhenUsernameAndPasswordAreCorrect() throws Exception {
    when(view.getUsername()).thenReturn("fj");
    when(view.getPassword()).thenReturn("patil");
    when(service.login("fj", "patil")).thenReturn(true);
    presenter.onLoginClicked();

    verify(view).startMainActivity();
  }

  @Test
  public void shouldShowLoginErrorWhenUsernameAndPasswordAreInvalid() throws Exception {
    when(view.getUsername()).thenReturn("fj");
    when(view.getPassword()).thenReturn("patil");
    when(service.login("fj", "patil")).thenReturn(false);
    presenter.onLoginClicked();

    verify(view).showLoginError(R.string.login_failed);
  }
}