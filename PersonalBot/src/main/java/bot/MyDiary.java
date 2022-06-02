package bot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class MyDiary {

    // diary constructor
    public MyDiary(Date dateTaken, String aboutToday, String lessons) {
        //diary attributes
    }

    // Made a non-argument constructor so the class could be instantiated in another class without parameters
    public MyDiary() {
    }
    //some constant that is needed across board
    static String storedAbout;
    static String storedLesson;

    public static String talk() {
        System.out.println("Saheed, Are you ready to fill in your daily dairy? To begin take a deep breath, go through your day. Now sit and type.");
        Scanner about = new Scanner(System.in);
        String aboutt = about.nextLine();
        storedAbout = aboutt;
        return aboutt;
    }

    public static String lesson() {
        System.out.println("Now you have written about your day, what are the lesson learnt ? Huh??");
        Scanner lessonLearned = new Scanner(System.in);
        String lesson = lessonLearned.nextLine();
        storedLesson = lesson;
        return lesson;
    }

    //method to take input & store in array then print to .txt file
    public void diary() throws IOException {

        String a = talk();
        String b = lesson();

        //An array to dairy's information
        MyDiary[] diary = {new MyDiary(Calendar.getInstance().getTime(), a, b)};

        for (int counter = 0; counter < diary.length; counter++) {
            diary[counter] = new MyDiary(Calendar.getInstance().getTime(), a, b);
        }

        try{
                BufferedWriter writer = new BufferedWriter(new FileWriter("Dairy.txt", true));
                for (int i = 0; i < diary.length; i++) {
                    writer.write(diary[i].toString());
                    writer.newLine();
                }
                writer.flush();
                System.out.println("Your dairy for " + (Calendar.getInstance().getTime()) + " has been saved successfully");

        }catch(Exception e){
            System.out.println("Error: "+e);
        }

    }

    @Override
    public String toString() {
        String out = "Date: " + Calendar.getInstance().getTime() + "." + "\n"+"About Today: "+ storedAbout + "." + "\n"+ "Lesson Learnt Today: "+ storedLesson + "\n" + "------------------------------------------------------------------------------------";
        return out;
    }
}
