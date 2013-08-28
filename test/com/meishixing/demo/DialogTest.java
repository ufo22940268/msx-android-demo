package com.meishixing.demo;

import android.util.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.app.*;
import android.os.*;
import android.database.*;
import android.net.*;
import android.opengl.*;
import android.graphics.*;
import android.view.animation.*;
import android.text.TextUtils;

import java.util.*;

import org.json.*;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.junit.Test;
import org.junit.Before;
import org.robolectric.Robolectric;
import com.meishixing.demo.*;
import org.robolectric.shadows.*;

import static org.robolectric.Robolectric.*;
import static org.fest.assertions.api.ANDROID.assertThat;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;

@RunWith(RobolectricTestRunner.class)
public class DialogTest extends MainActivity {

    private MsxDialog mDialog; 
    private ShadowActivity mShadowDialog;
    private TextView mTitleView;
    private TextView mBodyView;

    @Before
    public void setUp() {
        mDialog = (MsxDialog)Robolectric.buildActivity(MsxDialog.class).create().get();
        mShadowDialog = shadowOf(mDialog);
        mTitleView = (TextView)mDialog.findViewById(R.id.title);
        mBodyView = (TextView)mDialog.findViewById(R.id.body);
    }


    @Test
    public void testCreateDialog() throws Exception {
        Intent intent = new MsxDialog.IntentBuilder(this)
            .withTitle("title")
            .withMessage("message")
            .build();

        MsxDialog act = new MsxDialog();
        act.setIntent(intent);
        act.onCreate(intent.getExtras());
        TextView titleView = (TextView)act.findViewById(R.id.title);
        assertThat(titleView.getText()).isEqualTo("title");
        TextView bodyView = (TextView)act.findViewById(R.id.body);
        assertThat(bodyView.getText()).isEqualTo("message");
    }

    @Test
    public void testClose() throws Exception {
        assertThat(mShadowDialog.isFinishing()).isFalse();
        clickOn(mDialog.findViewById(R.id.cancel));
        mDialog.findViewById(R.id.cancel).performClick();
        assertThat(mShadowDialog.isFinishing()).isTrue();
    }
}
