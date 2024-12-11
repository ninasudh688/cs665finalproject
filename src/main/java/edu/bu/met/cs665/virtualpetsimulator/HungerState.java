/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/25/2024
 * File Name: HungryState.java
 * Description:
 * This class is responsible for the methods/attributes of a Hungry State.
 * Its concrete state class of the State design pattern a represents the hunger state of a pet.
 */

package edu.bu.met.cs665.virtualpetsimulator;

/**
 * HungryState represents the state of a pet when it is hungry.
 * In this state, the pet's behavior for actions such as exercising, feeding,
 * sleeping, and going to the bathroom is defined.
 */
public class HungerState implements State {
  private int hungerLevel;

  /**
   * Creates a HungryState object with the specified hunger level.
   *
   * @param hungerLevel The initial hunger level of the pet.
   */
  public HungerState(int hungerLevel) {

    this.hungerLevel = hungerLevel;
  }

  /**
   * Handles the exercise action when the pet is in the HungryState.
   * The pet is too hungry to exercise in this state.
   *
   * @param pet The pet performing the action.
   */
  @Override
  public void walk(Pet pet) {
    hungerLevel = 50;
    pet.decreaseEnergy(40); // decrease energy when not fed and exercise
    System.out.println("Hunger level: " + hungerLevel + ", Energy level: "
        + pet.getEnergyLevel());
    System.out.println(pet.getPetName() + " is too hungry to walk.");
    pet.setState(new TiredState(pet.getEnergyLevel())); // Transition to TiredState
    System.out.println("Pet is becoming tired...");

  }

  /**
   * Handles the feed action when the pet is in the HungryState.
   * Feeding the pet decreases its hunger level. If the hunger level is sufficiently
   * low, the pet transitions to the HappyState.
   *
   * @param pet The pet performing the action.
   */
  @Override
  public void feed(Pet pet) {
    System.out.println(pet.getPetName() + " needs to eat to satisfy its hunger.");
    pet.increaseEnergy(30); // Increase energy when fed
    hungerLevel = 0; // Hunger is satisfied
    System.out.println("Hunger level: " + hungerLevel + ", Energy level: "
        + pet.getEnergyLevel());
    System.out.println("Pet is being fed!");
    pet.setState(new HappyState(80)); // Transition to HappyState after feeding
  }

  /**
   * Handles the play action when the pet is in the HungryState.
   * The pet is unable to play due to being to _ in this state.
   *
   * @param pet The pet performing the action.
   */
  @Override
  public void play(Pet pet) {
    System.out.println(pet.getPetName() + "  is too hungry to play, becoming bored...");
    pet.setState(new BoredomState(pet.getEnergyLevel())); // Transition to BoredomState
  }

  /**
   * Handles the sleep action when the pet is in the HungryState.
   * The pet is unable to sleep due to hunger in this state.
   *
   * @param pet The pet performing the action.
   */
  @Override
  public void sleep(Pet pet) {
    System.out.println(pet.getPetName() + " tries to sleep but is too hungry!");
    pet.setState(new TiredState(pet.getEnergyLevel())); // Transition to TiredState
  }

  /**
   * Handles the goToBathroom action when the pet is in the HungryState.
   * The pet is too hungry to go to the bathroom in this state.
   *
   * @param pet The pet performing the action.
   */
  @Override
  public void heal(Pet pet) {
    System.out.println(pet.getPetName() + "  is hungry. Cannot heal until fed.");
    pet.setState(new SickState()); // Transition to SickState

  }


}

