/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/3/2024
 * File Name: TestVirtualPetSimulator.java
 * Description: This class contains JUnit tests for the virtual pet simulator project.
 */

package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;

import edu.bu.met.cs665.virtualpetsimulator.*;
import org.junit.Test;

/**
 * Write some Unit tests for your program like the examples below.
 */

public class TestPetSimulator {

  public TestPetSimulator() {
  }
  @Test
  public void testPetStateTransitionAfterMultipleActions() {
    // Given: A pet in HappyState
    Pet pet = new Pet("Luna", "Rabbit", 2,
        70, new HappyState(70));
    PetActionInvoker invoker = new PetActionInvoker();

    // When: Multiple actions are executed
    invoker.setCommand(new WalkCommand(pet));
    invoker.executeCommand(); // Walk
    invoker.executeCommand();
    invoker.executeCommand();
    invoker.setCommand(new PlayCommand(pet));
    invoker.executeCommand(); // Play
    invoker.setCommand(new FeedCommand(pet));
    invoker.executeCommand(); // Feed


  }
  @Test
  public void testInitialPetState() {
    // Given: A new pet with default parameters
    Pet pet = new Pet("Buddy", "Dog", 2, 100,
        new HappyState(50));

    // Then: The initial state should be HappyState
    assertEquals("HappyState", pet.getState().getClass().getSimpleName());
  }

  @Test
  public void testPetWalkCommand() {
    // Given: A pet in HappyState
    Pet pet = new Pet("Muddy", "Dog", 8, 66,
        new HappyState(50));
    Command walkCommand = new WalkCommand(pet);

    // When: The walk command is executed
    walkCommand.execute();

    // Then: Energy should decrease, and the state should transition accordingly
    assertEquals(51, pet.getEnergyLevel()); // Assuming decreaseEnergy reduces by 15
  }


  @Test
  public void testPetPlayCommand() {
    // Given: A pet in HappyState
    Pet pet = new Pet("Fluffy", "Cat", 3, 60,
        new TiredState(70));
    PetActionInvoker invoker = new PetActionInvoker();

    // When: The play command is executed
    invoker.setCommand(new PlayCommand(pet));
    invoker.executeCommand();

    // Then: Energy should decrease, and the state should transition accordingly
    assertEquals(60, pet.getEnergyLevel()); // Assuming play reduces energy by 10
  }

  @Test
  public void testTiredStateBehavior() {
    // Given: A pet in HungerState
    Pet pet = new Pet("Rex", "Chicken", 2, 90,
        new TiredState(80));
    PetActionInvoker invoker = new PetActionInvoker();

    // When: The heal action is executed via the invoker
    invoker.setCommand(new PlayCommand(pet)); // Assuming HealCommand encapsulates `heal` behavior
    invoker.executeCommand();

    // Then: Energy and happiness levels should adjust appropriately
    assertEquals(90, pet.getEnergyLevel()); // Assuming heal reduces energy by 20
  }
  @Test
  public void testPetFeedCommand() {
    // Given: A pet in TiredState
    Pet pet = new Pet("Max", "Dog", 1, 20,
        new TiredState( 20));
     PetActionInvoker invoker = new PetActionInvoker();

    // When: Multiple actions are executed
    invoker.setCommand(new FeedCommand(pet));
    invoker.executeCommand();  // When: The feed command is executed

    // Then: Energy should increase, and happiness should improve
    assertEquals(50, pet.getEnergyLevel()); // Assuming increaseEnergy increases by 20
  }




}
