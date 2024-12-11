/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/27/2024
 * File Name: TiredState.java
 * Description:
 * This class is responsible for the methods/attributes of a Tired State.
 * Its concrete state class of the State design pattern a represents the tired state of a pet.
 */

package edu.bu.met.cs665.virtualpetsimulator;

/**
 * TiredState represents the state of a pet when it is too tired.
 * In this state, the pet is unable to exercise or play, but can regain energy by eating or sleep.
 */
public class TiredState implements State {
  private int energyLevel;


  /**
   * Creates a TiredState object with the specified energy level.
   *
   * @param energyLevel The initial energy level of the pet.
   *
   */
  public TiredState(int energyLevel) {
    this.energyLevel = energyLevel;
  }

  /**
   * Handles the exercise action when the pet is in the TiredState.
   * The pet is too tired to exercise in this state.
   *
   */
  @Override
  public void walk(Pet pet) {
    System.out.println(pet.getPetName() + " is too tired to walk.");
  }

  /**
   * Handles the play action when the pet is in the TiredState.
   * The pet is too tired to play in this state.
   *
   */
  @Override
  public void play(Pet pet) {
    System.out.println(pet.getPetName() + " is too tired to play.");
  }

  /**
   * Handles the feed action when the pet is in the TiredState.
   * Feeding the pet restores energy, and if the energy level exceeds a certain threshold,
   * the pet transitions to a HappyState.
   *
   */
  @Override
  public void feed(Pet pet) {
    System.out.println(pet.getPetName() + " eats and regains energy!");
    pet.increaseEnergy(30); // Restore energy
    if (pet.getEnergyLevel() > 50) {
      pet.setState(new HappyState(70)); // Transition to HappyState
      System.out.println(pet.getPetName() + " is now happy and energized!");
    }
  }

  /**
   * Handles the goToBathroom action when the pet is in the TiredState.
   * The pet is too tired to go to the bathroom.
   *
   */
  @Override
  public void heal(Pet pet) {
    pet.setState(new SickState()); // Transition to SickState if healing is needed
    System.out.println(pet.getPetName() + " wants to sleep to heal.");
    System.out.println("Pet is healing while resting.");
  }

  /**
   * Handles the sleep action when the pet is in the TiredState.
   * The pet sleeps to regain energy and transition to a HappyState.
   *
   */
  @Override
  public void sleep(Pet pet) {
    System.out.println(pet.getPetName() + " is sleeping to regain energy.");
    pet.setEnergyLevel(100); // Fully restore energy
    pet.setState(new HappyState(80)); // Transition to HappyState
    System.out.println(pet.getPetName() + " is now rested and happy!");
  }


}

