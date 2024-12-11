/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/22/2024
 * File Name: State.java
 * Description:This interface is responsible for the methods/attributes of a States of a pet.
 * Its State interface of the state pattern
 */

package edu.bu.met.cs665.virtualpetsimulator;

import edu.bu.met.cs665.virtualpetsimulator.Pet;

/**
 * State interface defines methods for the different states a Pet can be in its virtual life.
 * Each state defines actions/behavior that a Pet can do. .
 */
public interface State {

  /**
   * Defines the walk action for the Pet in its current state.
   *
   */
  void walk(Pet pet);

  /**
   * Defines the play action for the Pet in its current state.
   *
   */
  void play(Pet pet);

  /**
   * Defines the feed action for the Pet in its current state.
   *
   */
  void feed(Pet pet);

  /**
   * Defines the heal action for the Pet in its current state.
   *
   */
  void heal(Pet pet);


  /**
   * Defines the sleep action for the Pet in its current state.
   *
   */
  void sleep(Pet pet);


}
