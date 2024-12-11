/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: BoredomState.java
 * Description:
 * This class is responsible for the methods/attributes of a bored State.
 * Its concrete state class of the State design pattern a represents the bored sad state of a pet.
 */

package edu.bu.met.cs665.virtualpetsimulator;

/**
 * BoredomState represents the state of a pet when it is upset.
 * In this state, the pet is reluctant to exercise, play, or go to the bathroom.
 */
public class BoredomState implements State {
  private int boredomLevel;


  /**
   * Creates an UpsetState object with the specified upset level.
   *
   * @param boredomLevel The initial upset level of the pet.
   */
  public BoredomState(int boredomLevel) {

    this.boredomLevel = boredomLevel;
  }

  /**
   * Handles the exercise action when the pet is in the UpsetState.
   * The pet is too upset to exercise, and the upset level increases.
   */
  @Override
  public void walk(Pet pet) {
    System.out.println(pet.getPetName() + " is bored and doesn't want to exercise.");
    boredomLevel += 20;

    if (boredomLevel > 50) {
      pet.decreaseEnergy(20);
      pet.setState(new TiredState(pet.getEnergyLevel()));
      System.out.println(pet.getPetName() + " is now too tired from being bored.");
    } else {
      System.out.println(pet.getPetName() + " wants to walk to overcome boredom.");
      pet.setState(new ActiveState());
    }
  }

  /**
   * Handles the play action when the pet is in the UpsetState.
   * The pet is too upset to play, and the upset level increases.
   */
  @Override
  public void play(Pet pet) {
    boredomLevel -= 15; // Increase upset level
    System.out.println(pet.getPetName() + "Pet is now playing and no longer bored!");
    if (boredomLevel > 45) {
      pet.setState(new TiredState(pet.getEnergyLevel())); // Transition to TiredState
      System.out.println(pet.getPetName() + " is now too tired to play.");
    } else {
      pet.setState(new ActiveState());// Transition to ActiveState after playing
    }
  }

  /**
   * Handles the feed action when the pet is in the UpsetState.
   * Feeding the pet restores some energy and decreases the upset level.
   * If the upset level reaches zero, the pet transitions to a HappyState.
   */
  @Override
  public void feed(Pet pet) {
    System.out.println(pet.getPetName() + " is bored, but will want treats");
    pet.increaseEnergy(15); // Restore some energy
    boredomLevel -= 18; // Decrease upset level
    System.out.println("Feeding the pet to make it happy.");

    if (boredomLevel <= 5) {
      pet.setState(new HappyState(pet.getEnergyLevel())); // Transition to HappyState
      System.out.println(pet.getPetName() + " is now happy and calm!");
    }
  }

  /**
   * Handles the goToBathroom action when the pet is in the UpsetState.
   * The pet is too upset to go to the bathroom.
   */
  @Override
  public void heal(Pet pet) {
    System.out.println(pet.getPetName() + " is not sick just bored. but give attention ");
  }

  /**
   * Handles the sleep action when the pet is in the UpsetState.
   * The pet is upset but tries to sleep, which slightly reduces the upset level.
   */
  @Override
  public void sleep(Pet pet) {
    System.out.println(pet.getPetName() + " is tired from being bored and needs rest.");
    pet.decreaseEnergy(10); // Energy decreases due to upset emotions
    boredomLevel -= 5; // Slight reduction in upset level after sleeping
    System.out.println("Pet ");
    pet.setState(new TiredState(pet.getEnergyLevel())); // Transition to TiredState
  }
}

