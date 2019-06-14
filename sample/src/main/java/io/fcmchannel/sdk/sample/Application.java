package io.fcmchannel.sdk.sample;

import android.support.annotation.ColorRes;
import android.support.v4.content.res.ResourcesCompat;

import io.fcmchannel.sdk.FcmClient;
import io.fcmchannel.sdk.sample.services.PushRegistrationService;
import io.fcmchannel.sdk.ui.ChatUiConfiguration;
import io.fcmchannel.sdk.ui.UiConfiguration;

/**
 * Created by John Cordeiro on 5/10/17.
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ChatUiConfiguration chatUiConfiguration = new ChatUiConfiguration()
                .setReceivedMessageIconRes(R.mipmap.ic_launcher);

        UiConfiguration uiConfiguration = new UiConfiguration()
                .setPermissionMessage("Please give me permission to open floating chat!")
                .setTheme(R.style.AppTheme_Blue)
                .setFloatingChatIconRes(R.mipmap.ic_launcher)
                .setTitleColor(getColorCompat(android.R.color.white))
                .setTitleString("FCM Channel Sample")
                .setChatUiConfiguration(chatUiConfiguration);

        FcmClient.initialize(new FcmClient.Builder(this)
                .setHost(getString(R.string.host))
                .setToken(getString(R.string.token))
                .setChannel(getString(R.string.channel))
                .setRegistrationServiceClass(PushRegistrationService.class)
                .setUiConfiguration(uiConfiguration));
    }

    private int getColorCompat(@ColorRes int colorRes) {
        return ResourcesCompat.getColor(getResources(), colorRes, getTheme());
    }

}
