/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Emilio Jr
 */
public class Character {
    public String name;
    public int priority;
    public String id;
    public int strength;
    public int skill;
    public int health;
    public int agility;
    public String charImage;
    
    public int counter = 0;
    
    public Character(String id, int priority, int strength, int skill, int health, int agility, String[] image){
        this.id = id;
        this.priority = priority;
        this.strength = strength;
        this.skill = skill;
        this.health = health;
        this.agility = agility;
        
        this.name = image[0];
        this.charImage = image[1];
    } 
}
