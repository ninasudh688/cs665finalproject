/**
 * Name: [Your Name]
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2024
 * File Name: HealCommand.java
 * Description:
 * This class implements the Command interface to allow healing a pet.

 */

package edu.bu.met.cs665.virtualpetsimulator;

/*
*
* It encapsulates the heal action and allows undoing the operation
 * by setting the pet's state back to a sick state.
*/
public class HealCommand implements Command {
  private Pet pet;

  /**
   * Constructs a HealCommand object for a given pet.
   *
   * @param pet The pet to heal.
   */
  public HealCommand(Pet pet) {
    this.pet = pet;
  }

  /**
   * Executes the heal action on the pet.
   */
  @Override
  public void execute() {
    pet.heal();
  }

  /**
   * Undoes the heal action by reverting the pet to a sick state.
   */
  @Override
  public void undo() {
    pet.setState(new SickState());
  }
}