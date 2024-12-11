/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2024
 * File Name: PetBuilder.java
 * Description:
 * This interface defines the methods for building a pet object using the Builder design pattern.
 * It includes methods to set the pet's attributes and build the final Pet object.
 */

package edu.bu.met.cs665.virtualpetsimulator;

/**
 * PetBuilder is the builder interface used to construct a Pet object.
 * It provides methods for setting the pet's name, type, age, energy level, and state.
 */
public interface PetBuilder {

  /**
   * Constructs the pet's name.
   *
   * @param name The name of the pet.
   */
  void buildName(String name);

  /**
   * Constructs the pet's type (e.g., dog, cat).
   *
   * @param type The type of the pet.
   */
  void buildType(String type);

  /**
   * Constructs the pet's age.
   *
   * @param age The age of the pet.
   */
  void buildAge(int age);

  /**
   * Constructs the pet's energy level.
   *
   * @param energyLevel The energy level of the pet.
   */
  void buildEnergyLevel(int energyLevel);

  /**
   * Constructs the pet's state.
   *
   * @param state The state of the pet.
   */
  void buildState(State state); // Sets the current state of the pet

  /**
   * Returns the fully constructed Pet object.
   * After all necessary attributes are set, this method should be called to get the result.
   */
  Pet getResult();
}
