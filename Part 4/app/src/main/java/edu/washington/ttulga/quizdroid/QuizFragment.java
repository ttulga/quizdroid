package edu.washington.ttulga.quizdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mbmtuvshin on 2/11/15.
 */
public class QuizFragment extends Fragment {

    public QuizFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_quiz, container, false);

        final Intent launchedMe = getActivity().getIntent();
        final String topic = launchedMe.getStringExtra("topic");
        final int count = launchedMe.getIntExtra("count", 0);
        final int num = launchedMe.getIntExtra("num", 0);
        TextView question = (TextView) rootView.findViewById(R.id.question);
        TextView answer1 = (TextView) rootView.findViewById(R.id.answer1);
        TextView answer2 = (TextView) rootView.findViewById(R.id.answer2);
        TextView answer3 = (TextView) rootView.findViewById(R.id.answer3);
        TextView answer4 = (TextView) rootView.findViewById(R.id.answer4);
        ArrayList<Topic> tp = MySingleton.getInstance().getElements();

        if (topic.equals("Physics")) {
            ArrayList<Quiz> qs = tp.get(0).getQuestions();
            String q = qs.get(count).getQuestion();
            String ans1 = qs.get(count).getAns1();
            String ans2 = qs.get(count).getAns2();
            String ans3 = qs.get(count).getAns3();
            String ans4 = qs.get(count).getAns4();
            question.setText(q);
            answer1.setText(ans1);
            answer2.setText(ans2);
            answer3.setText(ans3);
            answer4.setText(ans4);
        } else if (topic.equals("Math")) {
            ArrayList<Quiz> qs = tp.get(1).getQuestions();
            String q = qs.get(count).getQuestion();
            String ans1 = qs.get(count).getAns1();
            String ans2 = qs.get(count).getAns2();
            String ans3 = qs.get(count).getAns3();
            String ans4 = qs.get(count).getAns4();
            question.setText(q);
            answer1.setText(ans1);
            answer2.setText(ans2);
            answer3.setText(ans3);
            answer4.setText(ans4);
        } else if (topic.equals("Marvel Super Heroes")) {
            ArrayList<Quiz> qs = tp.get(2).getQuestions();
            String q = qs.get(count).getQuestion();
            String ans1 = qs.get(count).getAns1();
            String ans2 = qs.get(count).getAns2();
            String ans3 = qs.get(count).getAns3();
            String ans4 = qs.get(count).getAns4();
            question.setText(q);
            answer1.setText(ans1);
            answer2.setText(ans2);
            answer3.setText(ans3);
            answer4.setText(ans4);
        }


        Button submit = (Button) rootView.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radio = (RadioGroup) rootView.findViewById(R.id.radio);
                int radioId = radio.getCheckedRadioButtonId();
                int id = 0;

                switch (radioId) {
                    case R.id.answer1:
                        id = 1;
                        break;
                    case R.id.answer2:
                        id = 2;
                        break;
                    case R.id.answer3:
                        id = 3;
                        break;
                    case R.id.answer4:
                        id = 4;
                        break;
                }

                if (radioId != -1) { //why doesn't this work outside of onClickListener?
                    TextView checkedButton = (TextView) rootView.findViewById(radioId);
                    launchedMe.putExtra("topic", topic);
                    launchedMe.putExtra("answer", checkedButton.getText());
                    launchedMe.putExtra("answerID", id);
                    launchedMe.putExtra("count", count + 1);
                    launchedMe.putExtra("num", num);

                    getFragmentManager().beginTransaction()
                            .replace(R.id.container, new SummaryFragment())
                            .commit();
                }
            }
        });

        return rootView;
    }
}