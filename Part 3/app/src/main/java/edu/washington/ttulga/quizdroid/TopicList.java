package edu.washington.ttulga.quizdroid;

import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.AdapterView;

import java.util.ArrayList;


public class TopicList extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_list);

        String[] values = new String[] {"Physics", "Math", "Marvel Super Heroes"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, values);
        final ListView listview = (ListView) findViewById(R.id.topicList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent topicOverview = new Intent(TopicList.this, Fragments.class);
                String topic = MySingleton.getInstance().getElements().get(position).getTitle();
                String longDesc = MySingleton.getInstance().getElements().get(position).getLongDesc();
                topicOverview.putExtra("topic", topic);
                topicOverview.putExtra("desc", longDesc);
                startActivity(topicOverview);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_topic_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
