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
public class MsxLoading extends Activity implements View.OnClickListener  {

    private ImageView mIconView;
    private TextView mBodyView;
    private View mRootView;

    @Override
    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.msx_loading);
        findViews();

        int width = getWindowWidth();
        mRootView.getLayoutParams().width = width;

        Intent intent  = getIntent();
        if (intent != null) {
            Bundle extra = intent.getExtras();
            int icon;
            String msg;
            if (extra.containsKey("icon")) {
                icon = extra.getInt("icon", 0);
                setIcon(icon);
            }

            if (( msg = extra.getString("message")) != null) {
                setBody(msg);
            }
        }
    }

    public void dismiss() {
        finish();
    }
    
    private int getWindowWidth() {
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        return size.x;
    }

    public void setIcon(int i) {
        mIconView.setImageResource(i);
    }

    public void setBody(String b) {
        mBodyView.setText(b);
    }

    private void findViews() {
        mIconView = (ImageView)findViewById(R.id.icon);
        mBodyView = (TextView)findViewById(R.id.body);
        mRootView = findViewById(R.id.root);
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
        private int mIcon;
        private String mMessage;

        public IntentBuilder(Activity act) {
            mAct = act;
        }

        public IntentBuilder withIcon(int i) {
           mIcon = i; 
           return this;
        }

        public IntentBuilder withMessage(String s) {
           mMessage = s; 
           return this;
        }

        public Intent build() {
            Intent intent = new Intent(mAct, MsxLoading.class);
            intent.putExtra("icon", mIcon);
            intent.putExtra("message", mMessage);
            return intent;
        }
    }
}
