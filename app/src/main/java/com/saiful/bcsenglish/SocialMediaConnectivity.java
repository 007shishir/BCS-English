package com.saiful.bcsenglish;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.util.Objects;

public class SocialMediaConnectivity {

    public SocialMediaConnectivity() {
    }

    public Intent fb_group(Context context){
        String fb_GROUP_Url = "https://www.facebook.com/groups/353790045198315/";
        return newFacebookIntent(Objects.requireNonNull(context).getPackageManager(), fb_GROUP_Url);
    }

    public Intent fb_page(Context context){
        String fb_PAGE_Url = "https://www.facebook.com/AVTutorial/";
        return newFacebookIntent(Objects.requireNonNull(context).getPackageManager(), fb_PAGE_Url);
    }

    //This method is for opening facebook in app or in browser!
    private static Intent newFacebookIntent(PackageManager pm, String url) {
        Uri uri = Uri.parse(url);
        try {
            ApplicationInfo applicationInfo = pm.getApplicationInfo("com.facebook.katana", 0);
            if (applicationInfo.enabled) {
                uri = Uri.parse("fb://facewebmodal/f?href=" + url);
            }
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return new Intent(Intent.ACTION_VIEW, uri);
    }
}
