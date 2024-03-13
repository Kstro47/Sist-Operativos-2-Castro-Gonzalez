/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;


import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrés Castro
 */
public class AI{
    
    public Character CharA;
    public Character CharB;
    public String state;
    public int stateInt;
    public Lista winners;
    public int time = 10;
    public String startText = "";
    public String announceText = "";
    public String finalText = "";
    
    public AI(){
        this.winners = new Lista();
    }
    
    
    public int decideResult(){
        Random random = new Random();
        int randomNum = random.nextInt(101);
        if (randomNum < 41) {
            while (CharA.health > 0 && CharB.health > 0){       
                    if (CharA.agility > CharB.agility) {
                        if (CharA.skill > 60){
                            if (CharA.strength > 50) {
                                this.finalText = CharA.name + " le hizo oneshot a " + CharB.name + ", no hay counterplay.";
                                CharB.health = 0;
                                this.winners.append(CharA);
                                return 0;
                            }
                            this.announceText += CharA.name + " le lanzó unos podere a " + CharB.name + " quitándole " + CharA.skill + "hp" + "\n";
                            CharB.health -= CharA.skill;
                        } else if (CharA.strength > 50) {
                            this.announceText += CharA.name + " le metió un pepaso de "+ CharA.strength + "hp a " + CharB.name+ "\n";
                            CharB.health -= CharA.strength;
                        } else {
                            this.announceText += CharA.name + " hizo todo lo que pudo contra " + CharB.name + " " + "quitándole " + (CharA.strength+CharA.skill) + "hp"+ "\n";
                            CharB.health -= CharA.strength+CharA.skill;
                        }
                        
                        
                        if (CharB.skill > 60 && CharB.health > 0){
                            if (CharB.strength > 50) {
                                this.finalText = CharB.name + " le hizo oneshot a " + CharA.name + ", no hay counterplay.";
                                CharA.health = 0;
                                this.winners.append(CharB);
                                return 0;
                            }
                            this.announceText += CharB.name + " le lanzó unos podere a " + CharA.name + " quitándole " + CharB.skill + "hp"+ "\n";
                            CharA.health -= CharB.skill;
                        } else if (CharB.strength > 50) {
                            this.announceText += CharB.name + " le metió un pepaso de "+ CharB.strength + "hp a " + CharA.name+ "\n";
                            CharA.health -= CharB.strength;
                        } else {
                            this.announceText += CharB.name + " hizo todo lo que pudo contra " + CharA.name + " " + "quitándole " + (CharB.strength+CharB.skill) + "hp"+ "\n";
                            CharA.health -= CharB.strength+CharB.skill;
                        }
                        



                    } else {
                        if (CharB.skill > 60){
                            if (CharB.strength > 50) {
                                this.finalText = CharB.name + " le hizo oneshot a " + CharA.name + ", no hay counterplay.";
                                CharA.health = 0;
                                this.winners.append(CharB);
                                return 0;
                            }
                            this.announceText += CharB.name + " le lanzó unos podere a " + CharA.name + " quitándole " + CharB.skill + "hp"+ "\n";
                            CharA.health -= CharB.skill;
                        }else if (CharB.strength > 50) {
                            this.announceText += CharB.name + " le metió un pepaso de "+ CharB.strength + "hp a " + CharA.name+ "\n";
                            CharA.health -= CharB.strength;
                        } else {
                            this.announceText += CharB.name + " hizo todo lo que pudo contra " + CharA.name + " " + "quitándole " + (CharB.strength+CharB.skill) + "hp"+ "\n";
                            CharA.health -= CharB.strength+CharB.skill;
                        }
                        

                        if (CharA.skill > 60 && CharA.health > 0){
                            if (CharA.strength > 50) {
                                this.finalText = CharA.name + " le hizo oneshot a " + CharB.name + ", no hay counterplay.";
                                CharB.health = 0;
                                this.winners.append(CharA);
                                return 0;
                            }
                            this.announceText += CharA.name + " le lanzó unos podere a " + CharB.name + " quitándole " + CharA.skill + "hp"+ "\n";
                            CharB.health -= CharA.skill;
                        } else if (CharA.strength > 50) {
                            this.announceText += CharA.name + " le metió un pepaso de "+ CharA.strength + "hp a " + CharB.name+ "\n";
                            CharB.health -= CharA.strength;
                        } else {
                            this.announceText += CharA.name + " hizo todo lo que pudo contra " + CharB.name + " " + "quitándole " + (CharA.strength+CharA.skill) + "hp"+ "\n";
                            CharB.health -= CharA.strength+CharA.skill;
                        }
                        
                    }
            }
            if (CharA.health < 1) {
                this.finalText = CharB.name + " desfiguró a " + CharA.name + " y ganó.";
                this.winners.append(CharB);
            } else {
                this.finalText = CharA.name + " le partió el tórax a " + CharB.name + " y ganó.";
                this.winners.append(CharA);
            }
            return 0;       
        } else if (randomNum > 40 && randomNum < 68){
            this.finalText = "Ha ocurrido un empate entre ambos luchadores.";
            return 1;
        } else {
            this.finalText = "Ambos tenian furbo, nunca pelearon.";
            return 2;
        }         
    }
    
           
        
    

    public int work(){
            int num = 0;
            try { 
                this.startText = "Empieza la pelea entre "+ CharA.name + " vs " + CharB.name;
                this.state = "Decidiendo resultado";
                this.stateInt = 1;
                sleep(this.time*1000);
                num = this.decideResult();
                this.state = "Anunciando resultado";
                this.stateInt = 1;
                sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
            }
            return num;
        }
}
