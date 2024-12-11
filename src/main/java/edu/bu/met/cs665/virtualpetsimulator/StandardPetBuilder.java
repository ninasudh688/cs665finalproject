/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2024
 * File Name: StandardPetBuilder.java
 * Description:
 * This class is a concrete implementation of the PetBuilder interface.
 * It is responsible for constructing a pet with specifics.
 * The builder follows the Builder Design Pattern to provide constructing complex pet objects.
 */

package edu.bu.met.cs665.virtualpetsimulator;

/**
 * StandardPetBuilder is a concrete version of the PetBuilder interface.
 * It provides methods to build and set different attributes of a Pet object.
 */
public class StandardPetBuilder implements PetBuilder {
  private String name = "Default";  // Default value for the pet's name
  private String type = "Unknown";  // Default value for the pet's type
  private int age = 1;  // Default value for the pet's age
  private int energyLevel = 100;  // Default value for the pet's energy level
  private State state;  // State of the pet (could be any valid state)

  /**
   * Sets the name of the pet.
   *
   * @param name The name to set for the pet.
   */
  @Override
  public void buildName(String name) {
    this.name = name;  // Set the pet's name
  }

  /**
   * Sets the type of the pet.
   *
   * @param type The type of the pet (e.g., dog, cat).
   */
  @Override
  public void buildType(String type) {
    this.type = type;  // Set the pet's type
  }

  /**
   * Sets the age of the pet.
   *
   * @param age The age of the pet in years.
   */
  @Override
  public void buildAge(int age) {
    this.age = age;  // Set the pet's age
  }

  /**
   * Sets the energy level of the pet.
   *
   * @param energyLevel The energy level of the pet (typically between 0-100).
   */
  @Override
  public void buildEnergyLevel(int energyLevel) {
    this.energyLevel = energyLevel;  // Set the pet's energy level
  }

  /**
   * Sets the state of the pet.
   *
   * @param state The current state of the pet (e.g., HappyState, SickState).
   */
  @Override
  public void buildState(State state) {
    this.state = state;  // Set the pet's state
  }

  /**
   * Returns the constructed Pet object with the specified attributes.
   *
   * @return A Pet object constructed using the builder's attributes.
   */
  @Override
  public Pet getResult() {
    // Return a new Pet object with all the built attributes
    return new Pet(name, type, age, energyLevel, state);
  }
}
