/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/26/2024
 * File Name: Main.java
 * Description:
 * This class is responsible as Main class to test outside of junits
 */


package edu.bu.met.cs665;

import edu.bu.met.cs665.virtualpetsimulator.ActiveState;
import edu.bu.met.cs665.virtualpetsimulator.BoredomState;
import edu.bu.met.cs665.virtualpetsimulator.Command;
import edu.bu.met.cs665.virtualpetsimulator.FeedCommand;
import edu.bu.met.cs665.virtualpetsimulator.HappyState;
import edu.bu.met.cs665.virtualpetsimulator.HealCommand;
import edu.bu.met.cs665.virtualpetsimulator.HungerState;
import edu.bu.met.cs665.virtualpetsimulator.Pet;
import edu.bu.met.cs665.virtualpetsimulator.PetActionInvoker;
import edu.bu.met.cs665.virtualpetsimulator.PetBuilder;
import edu.bu.met.cs665.virtualpetsimulator.PetDirector;
import edu.bu.met.cs665.virtualpetsimulator.PlayCommand;
import edu.bu.met.cs665.virtualpetsimulator.SickState;
import edu.bu.met.cs665.virtualpetsimulator.SleepCommand;
import edu.bu.met.cs665.virtualpetsimulator.StandardPetBuilder;
import edu.bu.met.cs665.virtualpetsimulator.WalkCommand;

/**
 * This is the Main class.
 */
public class Main {

  /**
   * A main method to run examples.
   * You may use this method for development purposes as you start building your
   * assignments/final project.  This could prove convenient to test as you are developing.
   * However, please note that every assignment/final projects requires JUnit tests.
   */
  public static void main(String[] args) {
    System.out.println("This is a test message from the Main class (Main.java file)");
    // Create PetBuilder and PetDirector for constructing individual pets
    PetBuilder petBuilder = new StandardPetBuilder();
    PetDirector director = new PetDirector(petBuilder);

    // Construct Pet 1 (Buddy)
    Pet pet1 = director.construct("Buddy", "Dog", 1, 80,
        new HappyState(90));  // Set specific state for pet1

    // Construct Pet 2 (Fluffy)
    Pet pet2 = director.construct("Fluffy", "Cat", 5, 60,
        new HappyState(50));

    // Output the details of both pets
    System.out.println("Pet 1: " + pet1.getPetName() + ", " + pet1.getPetType()
        + ", State: " + pet1.getState().getClass().getSimpleName());
    System.out.println("Pet 2: " + pet2.getPetName() + ", " + pet2.getPetType()
        + ", State: " + pet2.getState().getClass().getSimpleName());

    // Create Invoker instance (shared for both pets)
    PetActionInvoker invoker = new PetActionInvoker();

    // Commands for Pet 1 (Buddy)
    Command walkCommandForPet1 = new WalkCommand(pet1);


    // Testing actions for Pet 1 (Buddy)
    System.out.println("\nTesting actions for " + pet1.getPetName() + ":");
    invoker.setCommand(walkCommandForPet1);
    invoker.executeCommand();  // Execute walk command for pet1
    System.out.println(pet1.getPetName() + "'s energy level: " + pet1.getEnergyLevel());
    System.out.println("Current state: " + pet1.getState().getClass().getSimpleName());

    Command playCommandForPet1 = new PlayCommand(pet1);
    invoker.setCommand(playCommandForPet1);
    invoker.executeCommand();  // Execute play command for pet1
    System.out.println(pet1.getPetName() + "'s energy level: " + pet1.getEnergyLevel());
    System.out.println("Current state: " + pet1.getState().getClass().getSimpleName());

    Command feedCommandForPet1 = new FeedCommand(pet1);
    invoker.setCommand(feedCommandForPet1);
    invoker.executeCommand();  // Execute feed command for pet1
    System.out.println(pet1.getPetName() + "'s energy level: " + pet1.getEnergyLevel());
    System.out.println("Current state: " + pet1.getState().getClass().getSimpleName());

    // Commands for Pet 2 (Fluffy)
    Command walkCommandForPet2 = new WalkCommand(pet2);


    // Testing actions for Pet 2 (Fluffy)
    System.out.println("\nTesting actions for " + pet2.getPetName() + ":");
    invoker.setCommand(walkCommandForPet2);
    invoker.executeCommand();  // Execute walk command for pet2
    System.out.println(pet2.getPetName() + "'s energy level: " + pet2.getEnergyLevel());
    System.out.println("Current state: " + pet2.getState().getClass().getSimpleName());

    Command playCommandForPet2 = new PlayCommand(pet2);
    invoker.setCommand(playCommandForPet2);
    invoker.executeCommand();  // Execute play command for pet2
    System.out.println(pet2.getPetName() + "'s energy level: " + pet2.getEnergyLevel());
    System.out.println("Current state: " + pet2.getState().getClass().getSimpleName());

    Command feedCommandForPet2 = new FeedCommand(pet2);
    invoker.setCommand(feedCommandForPet2);
    invoker.executeCommand();  // Execute feed command for pet2
    System.out.println(pet2.getPetName() + "'s energy level: " + pet2.getEnergyLevel());
    System.out.println("Current state: " + pet2.getState().getClass().getSimpleName());

    // Repeat actions for Pet 1 (Buddy)
    System.out.println("\nRepeating actions for " + pet1.getPetName() + ":");
    invoker.setCommand(walkCommandForPet1);
    invoker.executeCommand();
    invoker.setCommand(playCommandForPet1);
    invoker.executeCommand();
    invoker.setCommand(feedCommandForPet1);
    invoker.executeCommand();
    System.out.println(pet1.getPetName() + "'s energy level: " + pet1.getEnergyLevel());
    System.out.println("Current state: " + pet1.getState().getClass().getSimpleName());


  }

}
