package edu.washington.ttulga.quizdroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class Quiz extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ArrayList<String> physicsQ = new ArrayList<String>();
        physicsQ.add("Two identical cars collide head on. Each car is traveling at 100 km/h. " +
                "The impact force on each car is the same as hitting a solid wall at: ");
        physicsQ.add("When a vector of a magnitude 6 units is added to a vector of mag 8 units, " +
                "the magnitude of the resultant vector will be: ");
        physicsQ.add("A 5 kg block is suspended by a cord from the ceiling. What is the force " +
                "exerted on the block by the cord almost equal to?");

        ArrayList<String> mathQ = new ArrayList<String>();
        mathQ.add("When x=3 and y=5, by how much does the value of 3x^2 - 2y exceed the value of " +
                "2x^2 - 3y?");
        mathQ.add("What's the square root of 69?");
        mathQ.add("What is 2+2?");

        ArrayList<String> mshQ = new ArrayList<String>();
        mshQ.add("What is Iron Man's real name?");
        mshQ.add("Who was Captain America's sidekick during WWII?");
        mshQ.add("Peter Parker works as a photographer for: ");

        ArrayList<String> physicsA = new ArrayList<>();
        physicsA.add("100 km/h"); //correct answer
        physicsA.add("200 km/h");
        physicsA.add("150 km/h");
        physicsA.add("50 km/h");
        physicsA.add("2 units");
        physicsA.add("14 units");
        physicsA.add("On or between 2 and 14 units"); //correct
        physicsA.add("On or between 0 and 10 units");
        physicsA.add("0 N");
        physicsA.add("25 N");
        physicsA.add("50 N"); //correct
        physicsA.add("100 N");

        ArrayList<String> mathA = new ArrayList<>();
        mathA.add("5");
        mathA.add("14"); //correct
        mathA.add("16");
        mathA.add("20");
        mathA.add("8");
        mathA.add("8 somethin'");
        mathA.add("9");
        mathA.add("~8.3"); //correct
        mathA.add("2");
        mathA.add("4"); //correct
        mathA.add("0");
        mathA.add("Over 9000");

        ArrayList<String> mshA = new ArrayList<>();
        mshA.add("Steve Rogers");
        mshA.add("Tory Spark");
        mshA.add("Steven Rocker");
        mshA.add("Tony Stark"); //correct
        mshA.add("Ducky");
        mshA.add("Billy");
        mshA.add("Bucky"); //correct
        mshA.add("Peggy");
        mshA.add("The Daily Planet");
        mshA.add("The New York Times");
        mshA.add("The Daily Bugle"); //correct
        mshA.add("The Rolling Stone");


        Intent launchedMe = getIntent();
        final String topic = launchedMe.getStringExtra("topic");
        final int count = launchedMe.getIntExtra("count", 0);
        final int num = launchedMe.getIntExtra("num", 0);
        TextView question = (TextView) findViewById(R.id.question);
        TextView answer1 = (TextView) findViewById(R.id.answer1);
        TextView answer2 = (TextView) findViewById(R.id.answer2);
        TextView answer3 = (TextView) findViewById(R.id.answer3);
        TextView answer4 = (TextView) findViewById(R.id.answer4);

        if (topic.equals("Physics")) {
            question.setText(physicsQ.get(count));
            answer1.setText(physicsA.get(4*count));
            answer2.setText(physicsA.get(4*count+1));
            answer3.setText(physicsA.get(4*count+2));
            answer4.setText(physicsA.get(4*count+3));
        } else if (topic.equals("Math")) {
            question.setText(mathQ.get(count));
            answer1.setText(mathA.get(4*count));
            answer2.setText(mathA.get(4*count+1));
            answer3.setText(mathA.get(4*count+2));
            answer4.setText(mathA.get(4*count+3));
        } else if (topic.equals("Marvel Super Heroes")) {
            question.setText(mshQ.get(count));
            answer1.setText(mshA.get(4*count));
            answer2.setText(mshA.get(4*count+1));
            answer3.setText(mshA.get(4*count+2));
            answer4.setText(mshA.get(4*count+3));
        }


        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radio = (RadioGroup) findViewById(R.id.radio);
                int radioId = radio.getCheckedRadioButtonId();
                if (radioId != -1) { //why doesn't this work outside of onClickListener?
                    Intent submitAnswer = new Intent(Quiz.this, Summary.class);
                    TextView checkedButton = (TextView) findViewById(radioId);
                    submitAnswer.putExtra("topic", topic);
                    submitAnswer.putExtra("answer", checkedButton.getText());
                    submitAnswer.putExtra("count", count + 1);
                    submitAnswer.putExtra("num", num);
                    startActivity(submitAnswer);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
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
