/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/25/2024
 * File Name: HappyState.java
 * Description:
 * This class is responsible for the methods/attributes of a Happy State.
 * Its concrete state class of the State design pattern a represents the happy state of a pet.
 */

package edu.bu.met.cs665.virtualpetsimulator;

/**
 * HappyState is a concrete state class that implements State interface.
 * This state represents a pet's happy reaction during certain actions.
 */
public class HappyState implements State {
  private int happinessLevel;

  /**
   * Creates a HappyState object with a specified happiness level.
   *
   * @param happinessLevel The level of happiness of the pet as an int.
   */
  public HappyState(int happinessLevel) {
    this.happinessLevel = happinessLevel;

  }

  /**
   * This method reduces the pet's energy while exercising and decreases happiness
   * if energy is low, transitioning to TiredState.
   *
   * @param pet The pet performing the exercise action.
   */
  @Override
  public void walk(Pet pet) {
    System.out.println(pet.getPetName() + " is exercising happily!");

    pet.decreaseEnergy(15); // Reduce energy
    if (pet.getEnergyLevel() < 20) {
      System.out.println(pet.getPetName() + " is getting tired and less happy.");
      happinessLevel -= 10; // Decrease happiness if energy is low
      pet.setState(new TiredState(pet.getEnergyLevel())); // Transition to TiredState
    } else {
      happinessLevel += 5; // Gain happiness if energy is sufficient
      pet.setState(new ActiveState()); // Transition to ActiveState
    }
    System.out.println("Happiness level: " + happinessLevel
        + ", Energy level: " + pet.getEnergyLevel());
  }


  /**
   * This method reduces the pet's energy while playing and decreases
   * happiness if energy is low, transitioning to TiredState.
   *
   * @param pet The pet performing the play action.
   */
  @Override
  public void play(Pet pet) {
    System.out.println(pet.getPetName() + " is playing happily!");
    pet.decreaseEnergy(10); // Reduce energy
    if (pet.getEnergyLevel() < 20) {
      System.out.println(pet.getPetName() + " is getting tired and less happy.");
      happinessLevel -= 10; // Decrease happiness if energy is low
      pet.setState(new TiredState(pet.getEnergyLevel())); // Transition to TiredState
    } else {
      happinessLevel += 5; // Gain happiness if energy is sufficient
      pet.setState(new ActiveState()); // Transition to ActiveState

    }
    System.out.println("Happiness level: " + happinessLevel
        + ", Energy level: " + pet.getEnergyLevel());
  }

  /**
   * This method restores the pet's energy and increases happiness when the pet is fed.
   *
   * @param pet The pet performing the feed action.
   */
  @Override
  public void feed(Pet pet) {
    System.out.println(pet.getPetName() + " eats happily and gains energy!");
    pet.increaseEnergy(20); // Restore energy
    happinessLevel += 10; // Increase happiness
    System.out.println("Happiness level: " + happinessLevel
        + ", Energy level: " + pet.getEnergyLevel());
  }

  /**
   * This method allows the pet to go to the bathroom, maintaining its happiness.
   *
   * @param pet The pet performing the bathroom action.
   */
  @Override
  public void heal(Pet pet) {
    System.out.println(pet.getPetName() + " happily goes to vet.");
  }

  /**
   * This method restores the pet's energy and slightly increases happiness when the pet sleeps.
   *
   * @param pet The pet performing the sleep action.
   */
  @Override
  public void sleep(Pet pet) {
    System.out.println(pet.getPetName() + " enjoys relaxing and regains energy.");
    pet.increaseEnergy(30); // Restore energy
    happinessLevel += 15; // Slight happiness gain
    pet.setState(new TiredState(pet.getEnergyLevel())); // Transition to TiredState

  }

  /**
   * Retrieves the happinessLevel  of the pet.
   *
   * @return The happinessLevel of the pet as a string.
   */
  public int getHappinessLevel() {
    return happinessLevel;
  }
}

