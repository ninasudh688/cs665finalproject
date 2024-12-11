/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/7/2024
 * File Name: PetActionInvoker.java
 * Description:
 * This class acts as the invoker in the Command design pattern.
 * It is responsible for executing and undoing commands related to pet actions.
 */

package edu.bu.met.cs665.virtualpetsimulator;


/**
 * PetActionInvoker is the invoker class for managing pet actions.
 * It uses the Command design pattern to encapsulate requests as commands.
 */
public class PetActionInvoker {

  private Command command;

  /**
   * Sets the command to be executed or undone.
   *
   * @param command The command to be executed or undone.
   */
  public void setCommand(Command command) {
    this.command = command;
  }

  /**
   * Executes the currently set command.
   */
  public void executeCommand() {
    command.execute(); // Invoke the command (this is where the action happens)
  }

  /**
   * Undoes the currently set command.
   */
  public void undoCommand() {
    command.undo(); // Undo the command if needed
  }
}
