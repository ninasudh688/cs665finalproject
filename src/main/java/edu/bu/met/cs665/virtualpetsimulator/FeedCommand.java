/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/3/2024
 * File Name: FeedCommand.java
 * Description:
 * This class implements the Command interface to allow feeding a pet.
 */

package edu.bu.met.cs665.virtualpetsimulator;

/**
 * It encapsulates the feed action and allows undoing the operation
 * by setting the pet's state back to a hungry state.
 *
 * @param pet The pet to feed.
 */
public class FeedCommand implements Command {
  private Pet pet;

  /**
   * Constructs a FeedCommand object for a given pet.
   *
   * @param pet The pet to feed.
   */
  public FeedCommand(Pet pet) {
    this.pet = pet;
  }

  /**
   * Executes the feed action on the pet.
   */
  @Override
  public void execute() {
    pet.feed();
  }

  /**
   * Undoes the feed action by reverting the pet to a hungry state.
   */
  @Override
  public void undo() {
    pet.setState(new HungerState(pet.getEnergyLevel()));
  }
}

