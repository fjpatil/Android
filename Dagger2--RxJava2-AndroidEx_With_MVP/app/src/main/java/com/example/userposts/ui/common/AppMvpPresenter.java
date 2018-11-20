package com.example.userposts.ui.common;

/**
 * Interface to provide callback to views
 * @author fjpatil
 */

public interface AppMvpPresenter<V> {
    void attachView(V view);
    void detachView();

}