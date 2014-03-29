package com.superslug.myapplication3.app;

import android.app.Activity;
import android.app.LoaderManager;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Button;
import android.widget.AdapterView;
import 	android.widget.Toast;
import android.view.View;
import android.widget.ArrayAdapter;
import android.app.ListActivity;
import 	java.util.ArrayList;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.content.DialogInterface;
import android.app.DialogFragment;
import android.content.Context;
/**
 * Created by ian on 3/29/14.
 */



public class OrgActivity extends Activity  {
    String tmp = "a";
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    Context ctx = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.org_list);

        ctx = this;

        ListView lv = (ListView)findViewById(R.id.orglist);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
                        .show();
            }
        });

        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        lv.setAdapter(adapter);

        Button add_org_button = (Button) findViewById(R.id.add_org_button);
        add_org_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tmp+=tmp;
                //listItems.add(tmp);
                //adapter.notifyDataSetChanged();
                AlertDialog.Builder alert = new AlertDialog.Builder(ctx);

                alert.setTitle("Join Organization");
                alert.setMessage("");

// Set an EditText view to get user input
                final EditText input = new EditText(ctx);
                alert.setView(input);

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String value = input.getText().toString();
                        listItems.add(value);
                        adapter.notifyDataSetChanged();
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.
                    }
                });

                alert.show();
            }
        });
    }


}
