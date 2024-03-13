/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.util.Random;
/**
 *
 * @author Emilio Jr
 */
public class Studio {
    public String studioID;
    public int charNum = 0;
    
    public Lista winners;
    
    public Cola cola1;
    public Cola cola2;
    public Cola cola3;
    public Cola colaR;
    
    public String[][] charArray;
    
    public Studio(String studioID){
        this.winners = new Lista();
        
        this.cola1 = new Cola();
        this.cola2 = new Cola();
        this.cola3 = new Cola();
        this.colaR = new Cola();
        this.studioID = studioID;
        
        if ("NK".equals(studioID)) {
            this.charArray = new String[][]{
                {"Aang", "src/Images/Avatar/Aang.png"},
                {"Appa", "src/Images/Avatar/Appa.png"},
                {"Avatar_Aang", "src/Images/Avatar/Avatar_Aang.png"},
                {"Iroh", "src/Images/Avatar/Iroh.png"},
                {"Azula", "src/Images/Avatar/Azula.png"},
                {"Katara", "src/Images/Avatar/Katara.png"},
                {"Momo", "src/Images/Avatar/Momo.png"},
                {"Ozai", "src/Images/Avatar/Ozai.png"},
                {"Sokka", "src/Images/Avatar/Sokka.png"},
                {"Toph", "src/Images/Avatar/Toph.png"},
                {"Zuko", "src/Images/Avatar/Zuko.png"},  
            };        
        } else {
            this.charArray = new String[][]{
                {"Anti_Papaleta", "src/Images/RegularShow/Anti_Papaleta.png"},
                {"Benson", "src/Images/RegularShow/Benson.png"},
                {"El_Martillo", "src/Images/RegularShow/El_Martillo.png"},
                {"Fantasmano", "src/Images/RegularShow/Fantasmano.png"},
                {"La_Muerte", "src/Images/RegularShow/La_Muerte.png"},
                {"Mordecai", "src/Images/RegularShow/Mordecai.png"},
                {"Musculoso", "src/Images/RegularShow/Musculoso.png"},
                {"Papaleta", "src/Images/RegularShow/Papaleta.png"},
                {"Patos_Bebe", "src/Images/RegularShow/Patos_Bebe.png"},
                {"Rigby", "src/Images/RegularShow/Rigby.png"},
                {"Skips", "src/Images/RegularShow/Skips.png"},
                
            };
        }       
    }
    
    public Character createCharacter(){
        this.charNum += 1;
        Random random = new Random();
        int strength = random.nextInt(101);
        int skill = random.nextInt(101);
        int health = random.nextInt(101);
        int agility = random.nextInt(101);
        int quality = 4;
        
        if (skill > 40) {
            quality -= 1;
        }
        if (health > 30) {
            quality -= 1;
        }
        if (strength > 50) {
            quality -= 1;
        }
        if (agility > 60) {
            quality -= 1;
        }
        
        if (quality == 4) {
            quality = 3;
        }
        if (quality == 0) {
            quality = 1;
        }
                
        return new Character(this.studioID + this.charNum, quality, strength, skill, health, agility, imageSelection());
    }
    
    public String[] imageSelection(){
        Random random = new Random();
        return this.charArray[random.nextInt(this.charArray.length)];
    }
}
