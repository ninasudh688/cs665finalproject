/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/22/2024
 * File Name: Pet.java
 * Description:
 * This class is responsible for the methods/attributes of a pet.
 * * It allows the pet to perform actions such as exercising, playing, feeding,
 * * going to the bathroom, and sleeping, based on its current state.
 * Its context class of the State design pattern and receiver class of the Command pattern.
 */

package edu.bu.met.cs665.virtualpetsimulator;

/**
 * This is the Pet class, a context/Model class.
 * This class is responsible for representing a Pet with a name and a current state.
 * The pet can perform various actions depending on its current state.
 */
public class Pet {

  private String petName;
  private String petType;
  private State currentState;
  private int energyLevel;
  private int age;

  /**
   * Create a PET object using pet's name.
   *
   * @param petName name of the pet as a string.
   * @param petType type of the pet as a string.
   */
  public Pet(String petName, String petType, int age,int energyLevel, State currentState) {
    this.petName = petName;
    this.petType = petType;
    this.currentState = currentState; //set by builder
    this.age = age;
    this.energyLevel = energyLevel; // Default energy level
  }


  /**
   * gets the current state of the pet.
   *
   * @return currentState The state to which the pet's current state should be set.
   */
  public State getState() {
    return currentState;
  }

  /**
   * Sets the current state of the pet.
   *
   * @param state The state to which the pet's current state should be set.
   */
  public void setState(State state) {
    this.currentState = state;
  }

  /**
   * Retrieves the name of the pet.
   *
   * @return The name of the pet as a string.
   */
  public String getPetName() {
    return petName;
  }

  /**
   * Retrieves the type  of the pet.(e.g dog cat)
   *
   * @return The type of the pet as a string.
   */
  public String getPetType() {
    return petType;
  }

  /**
   * Sets the name of the pet.
   *
   * @param petName The name of the pet as a string.
   */
  public void setPetName(String petName) {
    this.petName = petName;
  }

  /**
   * Sets the type  of the pet.(e.g dog cat)
   *
   * @param petType The type of the pet as a string.
   */
  public void setPetType(String petType) {
    this.petType = petType;
  }

  /**
   * gets the age  of the pet. in years
   *
   * @return  age The age of the pet as a int.
   */
  public int getAge() {
    return age;
  }

  /**
   * Sets the age  of the pet. in years
   *
   * @param age The age of the pet as a int.
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * Retrieves the current energy level of the pet.
   *
   * @return The current energy level of the pet as an integer.
   */
  public int getEnergyLevel() {
    return energyLevel;
  }

  /**
   * Sets the energy level of the pet, ensuring it stays within the range of 0 to 100.
   *
   * @param energyLevel The desired energy level to set.
   */
  public void setEnergyLevel(int energyLevel) {
    this.energyLevel = Math.max(0, Math.min(energyLevel, 100));
  }

  /**
   * Decreases the energy level of the pet by a specified amount.
   * The energy level is updated to ensure it remains within the valid 0 -100.
   *
   * @param amount The amount to decrease the pet's energy level by.
   */
  public void decreaseEnergy(int amount) {
    setEnergyLevel(this.energyLevel - amount);
  }

  /**
   * Increases the energy level of the pet by a specified amount.
   * The energy level is updated to ensure it remains within the valid 0 -100.
   *
   * @param amount The amount to increase the pet's energy level by.
   */
  public void increaseEnergy(int amount) {
    setEnergyLevel(this.energyLevel + amount);
  }

  // Action methods that delegate to the current state

  /**
   * Makes the pet exercise based on its current state.
   */
  public void walk() {
    currentState.walk(this);
  }

  /**
   * Makes the pet play based on its current state.
   */
  public void play() {
    currentState.play(this);
  }

  /**
   * Makes the pet feed based on its current state.
   */
  public void feed() {
    currentState.feed(this);
  }

  /**
   * Makes the pet go  heal based on its current state.
   */
  public void heal() {
    currentState.heal(this);
  }

  /**
   * Makes the pet sleep based on its current state.
   */
  public void sleep() {
    currentState.sleep(this);
  }


}

