/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/9/2024
 * File Name: ActiveState.java
 * Description:
 * This class is responsible for the methods/attributes of the Active State.
 * It represents a state where the pet is energetic and ready to interact.
 * This is a concrete state class in the State design pattern.
 */

package edu.bu.met.cs665.virtualpetsimulator;

/**
 * ActiveState represents the state of a pet when it is full of energy and actively engaging.
 * In this state, the pet is responsive to various actions like playing, walking, and feeding.
 */
public class ActiveState implements State {

  /**
   * Creates an ActiveState object.
   * This constructor initializes an instance of the ActiveState.
   */
  public ActiveState() {
  }

  /**
   * Handles the feed action when the pet is in the ActiveState.
   * Feeding the pet transitions it to the HungerState if needed.
   *
   * @param pet The pet object performing the action.
   */
  @Override
  public void feed(Pet pet) {
    System.out.println("Pet is well-fed and still active, but will take treats.");
    pet.setState(new HungerState(pet.getEnergyLevel())); // Transition to HungerState
  }

  /**
   * Handles the play action when the pet is in the ActiveState.
   * Playing with the pet transitions it to the HappyState.
   *
   * @param pet The pet object performing the action.
   */
  @Override
  public void play(Pet pet) {
    System.out.println("Pet is playing energetically!");
    pet.setState(new HappyState(pet.getEnergyLevel())); // Transition to HappyState
  }

  /**
   * Handles the sleep action when the pet is in the ActiveState.
   * After sleeping, the pet transitions to the TiredState.
   *
   * @param pet The pet object performing the action.
   */
  @Override
  public void sleep(Pet pet) {
    System.out.println("Pet is tired after playing, going to sleep.");
    pet.setState(new TiredState(pet.getEnergyLevel())); // Transition to TiredState
  }

  /**
   * Handles the heal action when the pet is in the ActiveState.
   * Since the pet is healthy, no state transition occurs.
   *
   * @param pet The pet object performing the action.
   */
  @Override
  public void heal(Pet pet) {
    System.out.println("Pet is healthy and doesn't need healing.");
  }

  /**
   * Handles the walk action when the pet is in the ActiveState.
   * Walking makes the pet happy and then transitions it to the TiredState.
   *
   * @param pet The pet object performing the action.
   */
  @Override
  public void walk(Pet pet) {
    System.out.println("Pet is enjoying a walk!");
    pet.setState(new HappyState(pet.getEnergyLevel())); // Transition to HappyState
    System.out.println("Pet is happy from walk.");
    pet.decreaseEnergy(15); // Energy decreases due to walking
    pet.setState(new TiredState(pet.getEnergyLevel())); // Transition to TiredState
  }
}
