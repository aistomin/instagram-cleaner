package com.github.aistomin.incleaner;

/**
 * Created by aistomin on 06.03.18.
 */
public interface AuthenticationListener {

    void onCodeReceived(String auth_token);
}
