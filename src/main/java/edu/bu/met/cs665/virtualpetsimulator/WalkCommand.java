/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/3/2024
 * File Name: WalkCommand.java
 * Description:
 * This class implements the Command interface to allow walking a pet.

 */

package edu.bu.met.cs665.virtualpetsimulator;

/**

  * It encapsulates the walk action and allows undoing the operation
 * by setting the pet's state back to an active state.
 */
public class WalkCommand implements Command {
  private Pet pet;

  /**
   * Constructs a WalkCommand object for a given pet.
   *
   * @param pet The pet to walk.
   */
  public WalkCommand(Pet pet) {
    this.pet = pet;
  }

  /**
   * Executes the walk action on the pet.
   */
  @Override
  public void execute() {
    pet.walk();
  }

  /**
   * Undoes the walk action by reverting the pet to an active state.
   */
  @Override
  public void undo() {
    pet.setState(new ActiveState()); // Reverts to active state if undone
  }
}
