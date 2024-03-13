/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Random;

/**
 *
 * @author Andrés Castro
 */
public class BattleSimulation extends Thread{
    public AI ai;
    public Administrator admin;
    public Studio StudioNK;
    public Studio StudioCN;
    
    
    public BattleSimulation(AI ai, Administrator admin){
        this.ai = ai;
        this.admin = admin;
        this.StudioCN = admin.StudioCN;
        this.StudioNK = admin.StudioNK; 
                
    }
    
    public void createQueue(Studio studio){      
        for (int i = 0; i < 20; i++) {
            Character aux = studio.createCharacter();
            switch (aux.priority) {
                case 1 -> studio.cola1.encolar(aux);
                case 2 -> studio.cola2.encolar(aux);
                case 3 -> studio.cola3.encolar(aux);
                default -> {
                }
            }
        }
    }
    
    @Override
    public void run(){
        this.createQueue(this.StudioNK);
        this.createQueue(this.StudioCN);
        
        System.out.println(this.StudioCN.cola1.head.data.charImage);
        
        while (true){
            this.admin.chooseCharacter(this.ai);
            int num = this.ai.work(this.StudioNK, this.StudioCN);
            System.out.println(num);
            this.ai.state = "Esperando";
            this.admin.update(this.StudioNK);
            this.admin.update(this.StudioCN);
            
            this.admin.desencolarChar(this.StudioNK, this.StudioCN, this.ai, num);
            
            if (this.admin.counter == 2) {
                Random random = new Random();
                int randomNum = random.nextInt(101);
        
                if (randomNum > 20) {
                    this.admin.addCharacter(StudioNK);
                    this.admin.addCharacter(StudioCN);
                }
                
                this.admin.counter = 0;
            }
        }
        
    }
}
