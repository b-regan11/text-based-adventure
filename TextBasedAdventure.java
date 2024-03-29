import java.util.Random;
import java.util.Scanner;

public class TextBasedAdventure {
    boolean hasSword = false;
    boolean hasKey = false;
    Scanner keyboardInput = new Scanner(System.in);
    Random random = new Random();

    public void execute() {
        System.out.println("Welcome to Escape from the Cave! Press enter when you are ready to start...");
        keyboardInput.nextLine();
        System.out.println("You are trapped in a cave!");

        //Small chance to turn around and see the exit
        if((int)(Math.random() * 60) + 1 == 1) {
            System.out.println("You turn around and realize the exit was behind you! Don't you feel dumb.");

        }
        else {
            start();
        }
    }

    public void start() {
        System.out.println("You find yourself in a large room. What would you like to do?\n1. Go left \n2. Go right\n3. Go to House");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            goLeft();
        }
        else if (input == 2) {
            goRight();
        } else if (input ==3){
            goToHouse();
        }
    }

    public void goLeft() {
        System.out.println("Oh no! You ran into a huge ugly Giant! Fight or flight?\n1. Fight \n2. Flight");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            fight();
        }
        else if (input == 2) {
            start();
        }  
    }

    public void goRight() {
        if (!hasSword) {
            System.out.println("You find a sword on the ground!");
            hasSword = true;
        }
        else {
            System.out.println("You found a key. This might be able to open the house.");
            hasKey = true;
        }
        start();
    }

    public void goToHouse(){
        if(hasKey){
            System.out.println("You opened the door using the key and enter.");
            System.out.println("You walk around and hear faint voices around you.");
            System.out.println("Eventually, you run into a ghost and they lead you to the exit.");
            System.out.println("THE END!");
        } else{
            System.out.println("Door is locked. Might need to look around first");
            start();
        }
    }


    public void fight() {
        if (hasSword) {
            System.out.println("You steal the giant's treasure.");
            System.out.println("You defeat the giant with your sword. Would you like to\n1.Exit cave\n2.Go deeper for more treasure?");
            int decision = keyboardInput.nextInt();
            if(decision == 2){
                System.out.println("You go deeper and find even more riches, but wonder how much money will ever fill the gaping hole in your heart.");
            } else{
                System.out.println(("You leave the cave contemplating your life choices."));
            }
        } else {
            if (random.nextInt(100) + 1 == 1) {
                System.out.println("You Killed the Beast and run out of the cave!");
            } else {
                System.out.println("The Giant ate you and you are eaten to death");
            }
        }
    }
    public void leatherFace() {
        System.out.println("Oh no! You're in the Texas Chainsaw Massacre House!");
        if (random.nextInt(100) + 1 == 1) {
            System.out.println("The house is empty so you call 911 and leave");
        } else {
            System.out.println(" Leatherface is HERE !!!");
            System.out.println(" Fight or flight?\n1. Fight \n2. Flight");
            int input_LF = keyboardInput.nextInt();
            if (input_LF == 1) {
                System.out.println("** Hacked to Death **");
            }
            else if (input_LF == 2) {
                System.out.println("** Running and Screaming **");
            }
        }
    
    }

    public static void main(String[] args) {
        new TextBasedAdventure().execute();
    }
}