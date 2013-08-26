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
public class MsxDialog extends Activity  {

    private TextView mTitleView;
    private TextView mBodyView;

    @Override
    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.msx_dialog);
        findViews();

        setTitle("title");
        setBody("vim.1045645.n5.nabble.com/Console-version-of-MacVim-td3");
    }

    public void setTitle(String t) {
        mTitleView.setText(t);
    }

    public void setBody(String b) {
        mBodyView.setText(b);
    }

    private void findViews() {
        mTitleView = (TextView)findViewById(R.id.title);
        mBodyView = (TextView)findViewById(R.id.body);
    }
}
