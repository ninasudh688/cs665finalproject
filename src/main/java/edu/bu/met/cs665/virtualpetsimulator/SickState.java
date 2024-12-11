/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2024
 * File Name: SickState.java
 * Description:
 * This class represents the state of a pet when it is sick.
 * It defines the behavior of a sick pet.
 */

package edu.bu.met.cs665.virtualpetsimulator;

/**
 * SickState represents the state of a pet when it is sick.
 * In this state, the pet is too sick to play or walk but can be fed or healed.
 */
public class SickState implements State {

  /**
   * Constructs a SickState object.
   * The SickState class doesn't need any parameters acuz its general sick condition for the pet.
   */
  public SickState() {

  }

  /**
   * Handles the feed action when the pet is sick.
   * Feeding the pet might help it recover and transition to a HappyState.
   *
   * @param pet The pet object to which the action applies.
   */
  @Override
  public void feed(Pet pet) {
    System.out.println("Pet is sick, but feeding might help it recover.");
    pet.setState(new HappyState(pet.getEnergyLevel())); // Transition to HappyState after healing
  }

  /**
   * Handles the play action when the pet is sick.
   * The pet is too sick to play, and the action has no effect.
   *
   * @param pet The pet object to which the action applies.
   */
  @Override
  public void play(Pet pet) {
    System.out.println("Pet is too sick to play.");
  }

  /**
   * Handles the sleep action when the pet is sick.
   * The pet needs sleep to recover and transitions to a TiredState after resting.
   *
   * @param pet The pet object to which the action applies.
   */
  @Override
  public void sleep(Pet pet) {
    System.out.println("Pet needs sleep to recover.");
    pet.setState(new TiredState(pet.getEnergyLevel())); // Transition to TiredState after sleep
  }

  /**
   * Handles the heal action when the pet is sick.
   * Healing helps the pet recover and transitions it to a HappyState.
   *
   * @param pet The pet object to which the action applies.
   */
  @Override
  public void heal(Pet pet) {
    System.out.println("Pet is healing and getting better.");
    pet.setState(new HappyState(pet.getEnergyLevel())); // Transition to HappyState after healing
  }

  /**
   * Handles the walk action when the pet is sick.
   * The pet is too sick to walk, and the action has no effect.
   *
   * @param pet The pet object to which the action applies.
   */
  @Override
  public void walk(Pet pet) {
    System.out.println("Pet is too sick to walk.");
  }
}
