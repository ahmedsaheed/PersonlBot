package com.company;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Bot {
    MyDiary myDiary = new MyDiary();
    Jobs jobs = new Jobs();
    URLs url = new URLs();

    int urlOpened = 0;

    String[] cmd = {"email", "em", "mails",
                    "school", "sch", "griffith",
                    "learn", "learning", "study"};


    //iterate through the url array and open each link with appropriate timing
    public void open_url(String[] urls) throws URISyntaxException, IOException, InterruptedException {
        for(String i : urls){
            urlOpened +=1;
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(i));
            }
            TimeUnit.SECONDS.sleep(45);
        }
    }
    //open all my school related links
    public void school() throws IOException, InterruptedException, URISyntaxException {
        open_url(url.school);

    }
    //opens all my emails
    public void emails() throws IOException, URISyntaxException, InterruptedException {
        open_url(url.email);

    }
    //opens all my learning platforms
    public void learn() throws IOException, InterruptedException, URISyntaxException {
        open_url(url.learn);
    }
    public void parse_cmdEmail() throws IOException, URISyntaxException, InterruptedException {

            System.out.println("Please input a key phrase");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            if(input.equals("email") || input.equals("em") || input.equals("mails")){
                emails();
            }else if(input.equals("school") || input.equals("sch") || input.equals("griffith")){
                school();
            }else if(input.equals("learn") || input.equals("learning") || input.equals("study")){
                learn();
            }else if(input.equals("diary")){
                myDiary.diary();
            }else if(input.equals("jobs")){
                jobs.applyForJob();
            } else{
                System.out.println("You have inputted an invalid key phrase");
                System.out.println("These are your key phrases");
                System.out.println(Arrays.toString(cmd));

            }

    }



}
