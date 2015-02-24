package edu.washington.ttulga.quizdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mbmtuvshin on 2/12/15.
 */
public class SummaryFragment  extends Fragment {

    public SummaryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_summary, container, false);

        final Intent launchedMe = getActivity().getIntent();
        final String topic = launchedMe.getStringExtra("topic");
        String answer = launchedMe.getStringExtra("answer");
        int answerID = launchedMe.getIntExtra("answerID", 0);
        final int count = launchedMe.getIntExtra("count", 0);
        int num = launchedMe.getIntExtra("num", 0);

        TextView summary = (TextView) rootView.findViewById(R.id.summary);
        TextView chosenAnswer = (TextView) rootView.findViewById(R.id.chosenAnswer);
        TextView correctAnswer = (TextView) rootView.findViewById(R.id.correctAnswer);
        TextView numCorrect = (TextView) rootView.findViewById(R.id.numCorrect);

        summary.setText(topic);
        chosenAnswer.setText("Your answer was: " + answer);

        ArrayList<Topic> tp = MySingleton.getInstance().getElements();

        if (topic.equals("Physics")) {
            if (count == 1) {
                correctAnswer.setText("The correct answer was: 100 km/h");
            } else if (count == 2) {
                correctAnswer.setText("The correct answer was: On or between 2 and 14 units");
            } else if (count == 3) {
                correctAnswer.setText("The correct answer was: 50 N");
            }
            ArrayList<Quiz> qs = tp.get(0).getQuestions();
            int correct = qs.get(count - 1).getIndexOfCorrect();
            if (answerID == correct) {
                num++;
            }
        } else if (topic.equals("Math")) {
            if (count == 1) {
                correctAnswer.setText("The correct answer was: 14");
            } else if (count == 2) {
                correctAnswer.setText("The correct answer was: ~8.3");
            } else if (count == 3) {
                correctAnswer.setText("The correct answer was: 4");
            }
            ArrayList<Quiz> qs = tp.get(1).getQuestions();
            int correct = qs.get(count - 1).getIndexOfCorrect();
            if (answerID == correct) {
                num++;
            }
        } else if (topic.equals("Marvel Super Heroes")) {
            if (count == 1) {
                correctAnswer.setText("The correct answer was: Tony Stark");
            } else if (count == 2) {
                correctAnswer.setText("The correct answer was: Bucky");
            } else if (count == 3) {
                correctAnswer.setText("The correct answer was: The Daily Bugle");
            }
            ArrayList<Quiz> qs = tp.get(2).getQuestions();
            int correct = qs.get(count - 1).getIndexOfCorrect();
            if (answerID == correct) {
                num++;
            }
        }

        numCorrect.setText("You have " + num + " out of " + count + " correct");
        final int number = num;

        Button next = (Button) rootView.findViewById(R.id.next);
        if (count == 3) {
            next.setText("Finish");
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent restart = new Intent(getActivity(), TopicList.class);
                    startActivity(restart);
                }
            });
        } else {
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    launchedMe.putExtra("topic", topic);
                    launchedMe.putExtra("count", count);
                    launchedMe.putExtra("num", number);

                    getFragmentManager().beginTransaction()
                            .replace(R.id.container, new QuizFragment())
                            .commit();
                }
            });
        }

        return rootView;
    }
}