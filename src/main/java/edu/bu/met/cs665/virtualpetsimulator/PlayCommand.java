/**
 * Name:Nina SUdheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/03/2024
 * File Name: PlayCommand.java
 * Description:
 * This class implements the Command interface to allow a pet to play.
 * It encapsulates the play action and allows undoing the operation
 * by setting the pet's state back to a bored state.
 */

package edu.bu.met.cs665.virtualpetsimulator;


public class PlayCommand implements Command {
  private Pet pet;

  /**
   * Constructs a PlayCommand object for a given pet.
   *
   * @param pet The pet to play with.
   */
  public PlayCommand(Pet pet) {
    this.pet = pet;
  }

  /**
   * Executes the play action on the pet.
   */
  @Override
  public void execute() {
    pet.play();
  }

  /**
   * Undoes the play action by reverting the pet to a bored state.
   */
  @Override
  public void undo() {
    pet.setState(new BoredomState(pet.getEnergyLevel()));
  }

}

