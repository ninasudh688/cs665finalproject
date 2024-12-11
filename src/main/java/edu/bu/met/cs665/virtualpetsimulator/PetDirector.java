/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/6/2024
 * File Name: PetDirector.java
 * Description:
 * This class directs the construction of a Pet object using a PetBuilder.
 * It provides a method to build a Pet with all necessary attributes.
 */

package edu.bu.met.cs665.virtualpetsimulator;

/**
 * PetDirector is responsible for using a PetBuilder to construct a Pet object.
 * It creates the process of setting the attributes and returning the fully constructed Pet.
 */
public class PetDirector {

  private PetBuilder petBuilder;

  /**
   * Constructor that sets the builder to be used by the director.
   *
   * @param petBuilder The builder that will be used to construct the Pet object.
   */
  public PetDirector(PetBuilder petBuilder) {
    this.petBuilder = petBuilder;
  }

  /**
   * Constructs a Pet object using the provided attributes.
   * The method delegates the task of building the Pet's attributes to the builder.
   *
   * @param name       The name of the pet.
   * @param type       The type of the pet (e.g., dog, cat).
   * @param age        The age of the pet.
   * @param energyLevel The energy level of the pet.
   * @param state      The current state of the pet.
   * @return           The fully constructed Pet object.
   */
  public Pet construct(String name, String type, int age, int energyLevel, State state) {
    petBuilder.buildName(name);
    petBuilder.buildType(type);
    petBuilder.buildAge(age);
    petBuilder.buildEnergyLevel(energyLevel);
    petBuilder.buildState(state);  // Set the state of the pet
    return petBuilder.getResult();  // Return the fully constructed Pet object
  }
}
