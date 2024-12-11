/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/26/2024
 * File Name: Command.java
 * Description:This interface is responsible for the methods/attributes of a Command for pet action.
 * Its Command interface of the command pattern
 */

package edu.bu.met.cs665.virtualpetsimulator;

/**
 * Command interface defines methods for the different commands a Pet do in its virtual life.
 * it defines execute method to execute each command
 */
public interface Command {
  /**
   * Executes the command associated with a specific action.
   */
  void execute();

  /**
   * Undoes the command, reversing the action performed.
   */
  void undo();

}
