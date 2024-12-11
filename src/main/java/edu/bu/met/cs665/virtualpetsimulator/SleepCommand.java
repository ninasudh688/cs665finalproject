/**
 * Name: NIna SUdheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/5/2024
 * File Name: SleepCommand.java
 * Description:
 * This class implements the Command interface to allow a pet to sleep.
 * It encapsulates the sleep action and allows undoing the operation
 * by setting the pet's state back to a tired state.
 */

package edu.bu.met.cs665.virtualpetsimulator;

public class SleepCommand implements Command {
  private Pet pet;

  /**
   * Constructs a SleepCommand object for a given pet.
   *
   * @param pet The pet to put to sleep.
   */
  public SleepCommand(Pet pet) {
    this.pet = pet;
  }

  /**
   * Executes the sleep action on the pet.
   */
  @Override
  public void execute() {
    pet.sleep();
  }

  /**
   * Undoes the sleep action by reverting the pet to a tired state.
   */
  @Override
  public void undo() {
    pet.setState(new TiredState(pet.getEnergyLevel()));
  }
}