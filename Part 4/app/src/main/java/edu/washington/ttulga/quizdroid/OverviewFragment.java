package edu.washington.ttulga.quizdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mbmtuvshin on 2/11/15.
 */
public class OverviewFragment extends Fragment {

    public OverviewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_topic_overview, container, false);

        final Intent launchedMe = getActivity().getIntent();
        final String topic = launchedMe.getStringExtra("topic");
        final String description = launchedMe.getStringExtra("desc");
        TextView title = (TextView) rootView.findViewById(R.id.title);
        TextView desc = (TextView) rootView.findViewById(R.id.desc);
        TextView num = (TextView) rootView.findViewById(R.id.num);

        title.setText(topic);
        desc.setText(description);
        num.setText("Total number of questions: 3");

        Button begin = (Button) rootView.findViewById(R.id.begin);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchedMe.putExtra("topic", topic);
                launchedMe.putExtra("count", 0);
                launchedMe.putExtra("num", 0);

                getFragmentManager().beginTransaction()
                        .replace(R.id.container, new QuizFragment())
                        .commit();
            }
        });

        return rootView;
    }
}