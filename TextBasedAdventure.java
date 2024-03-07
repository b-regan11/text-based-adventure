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
        if((int)(Math.random() * 50) + 1 == 1) {
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
            System.out.println("You opened the door using the key. You wonder what inside");
        } else{
            System.out.println("Door is locked. Might need to look around first");
            start();
        }
    }
    public void fight() {
        if (hasSword) {
            System.out.println("You steal the giant's treasure.");
            System.out.println("You defeat the giant with your sword and run out of the cave!");
        } else {
            if (random.nextInt(100) + 1 == 1) {
                System.out.println("You CONQUERED the beast and run out of the cave!");
            } else {
                System.out.println("You get stomped by the giant and red stuff goes everywhere.");
            }
        }
    }

    public static void main(String[] args) {
        new TextBasedAdventure().execute();
    }
}