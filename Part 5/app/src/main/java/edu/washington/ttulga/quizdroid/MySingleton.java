package edu.washington.ttulga.quizdroid;

import java.util.ArrayList;

/**
 * Created by mbmtuvshin on 2/16/15.
 */
public class MySingleton implements TopicRepository {
    public ArrayList<Topic> topics;
    private static MySingleton instance;

    public String customVar;

    public static void initInstance()
    {
        if (instance == null)
        {
            // Create the instance
            instance = new MySingleton();
        }
    }

    public static MySingleton getInstance()
    {
        // Return the instance
        return instance;
    }

    private MySingleton()
    {
        // Constructor hidden because this is a singleton
    }

    public void customSingletonMethod()
    {
        // Custom method
    }

    public ArrayList<Topic> getElements() {
        topics = new ArrayList<>();

        Topic physics = new Topic();
        Topic math = new Topic();
        Topic msh = new Topic();

        Quiz physicsQ1 = new Quiz();
        Quiz physicsQ2 = new Quiz();
        Quiz physicsQ3 = new Quiz();

        Quiz mathQ1 = new Quiz();
        Quiz mathQ2 = new Quiz();
        Quiz mathQ3 = new Quiz();

        Quiz mshQ1 = new Quiz();
        Quiz mshQ2 = new Quiz();
        Quiz mshQ3 = new Quiz();

        // physics
        physicsQ1.setQuestion("Two identical cars collide head on. Each car is traveling at " +
                "100 km/h. The impact force on each car is the same as hitting a solid wall at: ");
        physicsQ2.setQuestion("When a vector of a magnitude 6 units is added to a vector of mag 8 "+
                "units, the magnitude of the resultant vector will be: ");
        physicsQ3.setQuestion("A 5 kg block is suspended by a cord from the ceiling. What is the " +
                "force exerted on the block by the cord almost equal to");

        physicsQ1.setAns1("100 km/h");
        physicsQ1.setAns2("200 km/h");
        physicsQ1.setAns3("150 km/h");
        physicsQ1.setAns4("50 km/h");
        physicsQ1.setIndexOfCorrect(1);

        physicsQ2.setAns1("2 units");
        physicsQ2.setAns2("14 units");
        physicsQ2.setAns3("On or between 2 and 14 units");
        physicsQ2.setAns4("On or between 0 and 10 units");
        physicsQ2.setIndexOfCorrect(3);

        physicsQ3.setAns1("0 N");
        physicsQ3.setAns2("25 N");
        physicsQ3.setAns3("50 N");
        physicsQ3.setAns4("100 N");
        physicsQ3.setIndexOfCorrect(3);

        ArrayList<Quiz> physicsQs = new ArrayList<>();
        physicsQs.add(physicsQ1);
        physicsQs.add(physicsQ2);
        physicsQs.add(physicsQ3);
        physics.setQuestions(physicsQs);

        physics.setTitle("Physics");
        physics.setShortDesc("This is a short quiz on the topic of Physics");
        physics.setLongDesc("Physics is the natural science that involves the study of matter " +
                "and its motion through space and time. This brief quiz will test you on your " +
                "knowledge of physics.");

        // math
        mathQ1.setQuestion("When x=3 and y=5, by how much does the value of 3x^2 - 2y exceed the " +
                "value of 2x^2 - 3y?");
        mathQ2.setQuestion("What's the square root of 69?");
        mathQ3.setQuestion("What is 2+2?");

        mathQ1.setAns1("5");
        mathQ1.setAns2("14");
        mathQ1.setAns3("16");
        mathQ1.setAns4("20");
        mathQ1.setIndexOfCorrect(2);

        mathQ2.setAns1("8");
        mathQ2.setAns2("8 somethin'");
        mathQ2.setAns3("9");
        mathQ2.setAns4("~8.3");
        mathQ2.setIndexOfCorrect(4);

        mathQ3.setAns1("2");
        mathQ3.setAns2("4");
        mathQ3.setAns3("0");
        mathQ3.setAns4("Over 9000");
        mathQ3.setIndexOfCorrect(2);

        ArrayList<Quiz> mathQs = new ArrayList<>();
        mathQs.add(mathQ1);
        mathQs.add(mathQ2);
        mathQs.add(mathQ3);
        math.setQuestions(mathQs);

        math.setTitle("Math");
        math.setShortDesc("This is a short quiz on the topic of Math");
        math.setLongDesc("Mathematics is the study of topics such as quantity, structure, space, " +
                "and change. This brief quiz will test you on your knowledge of math.");

        // marvel super heroes
        mshQ1.setQuestion("What is Iron Man's real name?");
        mshQ2.setQuestion("Who was Captain America's sidekick during WWII?");
        mshQ3.setQuestion("Peter Parker works as a photographer for: ");

        mshQ1.setAns1("Steve Rogers");
        mshQ1.setAns2("Tory Spark");
        mshQ1.setAns3("Steven Rocker");
        mshQ1.setAns4("Tony Stark"); //
        mshQ1.setIndexOfCorrect(4);

        mshQ2.setAns1("Ducky");
        mshQ2.setAns2("Billy");
        mshQ2.setAns3("Bucky"); //
        mshQ2.setAns4("Peggy");
        mshQ2.setIndexOfCorrect(3);

        mshQ3.setAns1("The Daily Planet");
        mshQ3.setAns2("The New York Times");
        mshQ3.setAns3("The Daily Bugle"); //
        mshQ3.setAns4("The Rolling Stone");
        mshQ3.setIndexOfCorrect(3);

        ArrayList<Quiz> mshQs = new ArrayList<>();
        mshQs.add(mshQ1);
        mshQs.add(mshQ2);
        mshQs.add(mshQ3);
        msh.setQuestions(mshQs);

        msh.setTitle("Marvel Super Heroes");
        msh.setShortDesc("This is a short quiz on the topic of Marvel Super Heroes");
        msh.setLongDesc("Marvel Super Heroes is a topic on the fictional characters from the " +
                "Marvel universe. This brief quiz will test you on your knowledge of some of " +
                "these characters.");

        topics.add(0, physics);
        topics.add(1, math);
        topics.add(2, msh);

        return topics;
    }
}
