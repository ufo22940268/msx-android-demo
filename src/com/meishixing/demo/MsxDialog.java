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
public class MsxDialog extends Activity implements View.OnClickListener  {

    private TextView mTitleView;
    private TextView mBodyView;

    @Override
    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.msx_dialog);
        findViews();

        Intent intent  = getIntent();
        if (intent != null) {
            Bundle extra = intent.getExtras();
            String title;
            String msg;
            if ((title = extra.getString("title")) != null) {
                setTitle(title);
            }

            if (( msg = extra.getString("message")) != null) {
                setBody(msg);
            }
        }

        findViewById(R.id.cancel).setOnClickListener(this);
        findViewById(R.id.ok).setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                finish();
                break;
            case R.id.ok:
                setResult(RESULT_OK);
                finish();
                break;
        }
    }

    public static class IntentBuilder {

        private Activity mAct;
        private String mTitle;
        private String mMessage;

        public IntentBuilder(Activity act) {
            mAct = act;
        }

        public IntentBuilder withTitle(String s) {
           mTitle = s; 
           return this;
        }

        public IntentBuilder withMessage(String s) {
           mMessage = s; 
           return this;
        }

        public Intent build() {
            Intent intent = new Intent(mAct, MsxDialog.class);
            intent.putExtra("title", mTitle);
            intent.putExtra("message", mMessage);
            return intent;
        }
    }
}
