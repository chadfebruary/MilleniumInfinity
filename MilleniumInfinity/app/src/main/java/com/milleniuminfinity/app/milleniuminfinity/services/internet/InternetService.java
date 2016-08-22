package com.milleniuminfinity.app.milleniuminfinity.services.internet;

import android.content.Context;

import com.milleniuminfinity.app.milleniuminfinity.domain.internet.Internet;


/**
 * Created by Chad on 5/8/2016.
 */
public interface InternetService {
    void addInternet(Context context, Internet internet);
    void updateInternet(Context context, Internet internet);
}
