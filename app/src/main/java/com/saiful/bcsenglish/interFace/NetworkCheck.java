package com.saiful.bcsenglish.interFace;

public interface NetworkCheck {
    boolean isNetworkAvailable();
    void notifyUser(boolean connectNetwork);
}
