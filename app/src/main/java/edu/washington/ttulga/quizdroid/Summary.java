package edu.washington.ttulga.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Summary extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent launchedMe = getIntent();
        final String topic = launchedMe.getStringExtra("topic");
        String answer = launchedMe.getStringExtra("answer");
        final int count = launchedMe.getIntExtra("count", 0);
        int num = launchedMe.getIntExtra("num", 0);

        TextView summary = (TextView) findViewById(R.id.summary);
        TextView chosenAnswer = (TextView) findViewById(R.id.chosenAnswer);
        TextView correctAnswer = (TextView) findViewById(R.id.correctAnswer);
        TextView numCorrect = (TextView) findViewById(R.id.numCorrect);

        summary.setText(topic);
        chosenAnswer.setText("Your answer was: " + answer);

        if (topic.equals("Physics")) {
            if (count == 1) {
                correctAnswer.setText("The correct answer was: 100 km/h");
            } else if (count == 2) {
                correctAnswer.setText("The correct answer was: On or between 2 and 14 units");
            } else if (count == 3) {
                correctAnswer.setText("The correct answer was: 50 N");
            }

            if (answer.equals("100 km/h") || answer.equals("On or between 2 and 14 units") ||
                    answer.equals("50 N")) {
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

            if (answer.equals("14") || answer.equals("~8.3") || answer.equals("4")) {
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

            if (answer.equals("Tony Stark") || answer.equals("Bucky") ||
                    answer.equals("The Daily Bugle")) {
                num++;
            }
        }

        numCorrect.setText("You have " + num + " out of " + count + " correct");
        final int number = num;

        Button next = (Button) findViewById(R.id.next);
        if (count == 3) {
            next.setText("Finish");
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent restart = new Intent(Summary.this, TopicList.class);
                    startActivity(restart);
                }
            });
        } else {
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent next = new Intent(Summary.this, Quiz.class);
                    next.putExtra("topic", topic);
                    next.putExtra("count", count);
                    next.putExtra("num", number);
                    startActivity(next);
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_summary, menu);
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
