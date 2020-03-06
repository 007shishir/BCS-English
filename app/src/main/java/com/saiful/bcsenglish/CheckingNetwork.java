package com.saiful.bcsenglish;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.saiful.bcsenglish.interFace.NetworkCheck;



class CheckingNetwork implements NetworkCheck {
    private Context context;

    CheckingNetwork(Context context) {
        this.context = context;
    }

    @Override
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void notifyUser(boolean connectNetwork) {
        if (connectNetwork){
            Toast.makeText(context, "Network Available!", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(context, "Network Not Available!", Toast.LENGTH_SHORT).show();
    }

}
