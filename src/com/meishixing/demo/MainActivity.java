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

public class MainActivity extends ListActivity {

    static public final int DIALOG_POS = 0;
    static public final int LOADING_POS = 2;

    private String[] DEMO_NAMES = {
        "dialog",
        "swicher",
        "loading"
    };

    private Class[] DEMO_CLASSES = {
        MsxDialog.class,
        MsxSwitcher.class,
        MsxLoading.class,
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        int[] viewIds = new int[DEMO_NAMES.length];
        List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < DEMO_NAMES.length; i ++) {
            viewIds[i] = android.R.id.text1;
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("title", DEMO_NAMES[i]);
            map.put("class", DEMO_CLASSES[i]);
            datas.add(map);
        }

        setListAdapter(new SimpleAdapter(this, datas, android.R.layout.simple_list_item_1, new String[]{"title"}, new int[]{android.R.id.text1}));
    }

    @Override
    protected void onListItemClick(ListView parent, View view, int pos, long id) {
        Map<String, Object> map = (Map<String, Object>)parent.getItemAtPosition(pos);
        Class des = (Class)map.get("class");
        Intent intent;
        if (pos == DIALOG_POS) {
            intent = new MsxDialog.IntentBuilder(this)
                .withTitle("title")
                .withMessage("message")
                .build();
        } else if (pos == LOADING_POS) {
            intent = new MsxLoading.IntentBuilder(this)
                .withIcon(R.drawable.ic_launcher)
                .withMessage("message")
                .build();
        } else {
            intent = new Intent(this, des);
        }
        startActivity(intent);
    }
}
