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
public class Administrator extends Thread{
    public Studio StudioNK;
    public Studio StudioCN;
    public int counter;
    
    
    public Administrator(Studio StudioNK, Studio StudioCN){
        this.StudioNK = StudioNK;
        this.StudioCN = StudioCN;        
    }
    
    public void update(Studio studio){
        this.updateCounter(studio);
        this.updateQueue(studio);
    }
    
    public void desencolarChar(Studio studio1, Studio studio2, AI ai, int num){
        
        switch (num) {
            case 0 -> {
                switch (ai.CharA.priority) {
                    case 1 -> studio1.cola1.desencolar();
                    case 2 -> studio1.cola2.desencolar();
                    case 3 -> studio1.cola3.desencolar();
                    default -> {
                    }
                }   
                switch (ai.CharB.priority) {
                    case 1 -> studio2.cola1.desencolar();
                    case 2 -> studio2.cola2.desencolar();
                    case 3 -> studio2.cola3.desencolar();
                    default -> {
                    }
                }
            }
            case 1 -> {
                switch (ai.CharA.priority) {
                    case 1 -> {
                        studio1.cola1.encolar(ai.CharA);
                        studio1.cola1.desencolar();
                    }
                    case 2 -> {
                        studio1.cola2.encolar(ai.CharA);
                        studio1.cola2.desencolar();
                    }
                    case 3 -> {
                        studio1.cola3.encolar(ai.CharA);
                        studio1.cola3.desencolar();
                    }
                    default -> {
                    }
                }   
                switch (ai.CharB.priority) {
                    case 1 -> {
                        studio2.cola1.encolar(ai.CharB);
                        studio2.cola1.desencolar();
                    }
                    case 2 -> {
                        studio2.cola2.encolar(ai.CharB);
                        studio2.cola2.desencolar();
                    }
                    case 3 -> {
                        studio2.cola3.encolar(ai.CharB);
                        studio2.cola3.desencolar();
                    }
                    default -> {
                    }
                }
            }
            case 2 -> {
                switch (ai.CharA.priority) {
                    case 1 -> {
                        studio1.colaR.encolar(ai.CharA);
                        studio1.cola1.desencolar();
                    }
                    case 2 -> {
                        studio1.colaR.encolar(ai.CharA);
                        studio1.cola2.desencolar();
                    }
                    case 3 -> {
                        studio1.colaR.encolar(ai.CharA);
                        studio1.cola3.desencolar();
                    }
                    default -> {
                    }
                }   
                switch (ai.CharB.priority) {
                    case 1 -> {
                        studio2.colaR.encolar(ai.CharB);
                        studio2.cola1.desencolar();
                    }
                    case 2 -> {
                        studio2.colaR.encolar(ai.CharB);
                        studio2.cola2.desencolar();
                    }
                    case 3 -> {
                        studio2.colaR.encolar(ai.CharB);
                        studio2.cola3.desencolar();
                    }
                    default -> {
                    }
                }
            }
            default -> {
            }
        }
        
    }
    
    public void updateCounter(Studio studio){
        Nodo aux = studio.cola3.head;
        for (int i = 0; i < studio.cola3.size; i++) {
            if (aux.data.counter < 8) {
                aux.data.counter += 1;
                aux = aux.pNext;
            } else{
                aux.data.counter = 0;
                aux.data.priority = 2;
            }
            
        }
        aux = studio.cola2.head;
        for (int i = 0; i < studio.cola2.size; i++) {
            if (aux.data.counter < 8) {
                aux.data.counter += 1;
                aux = aux.pNext;
            } else {
                aux.data.counter = 0;
                aux.data.priority = 1;
            }   
        }
    }
    
    
    public void updateQueue(Studio studio){
        Nodo aux = studio.cola3.head;
        for (int i = 0; i < studio.cola3.size; i++) {
            if (aux.data.priority == 2) {
                studio.cola3.desencolar();
                studio.cola2.encolar(aux.data);
            }
            aux = aux.getpNext();
        }
        aux = studio.cola2.head;
        for (int i = 0; i < studio.cola2.size; i++) {
            if (aux.data.priority == 1) {
                studio.cola2.desencolar();
                studio.cola1.encolar(aux.data);
            }
            aux = aux.getpNext();
        }
        
        Random random = new Random();
        int randomNum = random.nextInt(101);
        if (randomNum > 40) {
            if (!studio.colaR.isEmpty()){
                studio.cola1.encolar(studio.colaR.head.data);
                studio.colaR.desencolar();
            }   
        } else {
            if (!studio.colaR.isEmpty()){
                studio.colaR.encolar(studio.colaR.head.data);
                studio.colaR.desencolar();
            }
        }
        
        this.counter += 1;
    }
       
    public void chooseCharacter(AI ai){
        if (!this.StudioNK.cola1.isEmpty()) {
            ai.CharA = this.StudioNK.cola1.head.data;
            System.out.println(ai.CharA.name);
            System.out.println(ai.CharA.id);
            System.out.println(ai.CharA.priority);
            
        } else if (!this.StudioNK.cola2.isEmpty()){
            ai.CharA = this.StudioNK.cola2.head.data;
            
        } else if (!this.StudioNK.cola3.isEmpty()){
            ai.CharA = this.StudioNK.cola3.head.data;
            
        } else if (!this.StudioNK.colaR.isEmpty()){
            ai.CharA = this.StudioNK.colaR.head.data;
        }
        
        if (!this.StudioCN.cola1.isEmpty()) {
            ai.CharB = this.StudioCN.cola1.head.data;
            System.out.println(ai.CharB.name);
            System.out.println(ai.CharB.id);
            System.out.println(ai.CharB.priority);
            
        } else if (!this.StudioCN.cola2.isEmpty()){
            ai.CharB = this.StudioCN.cola2.head.data;
            
        } else if (!this.StudioCN.cola3.isEmpty()){
            ai.CharB = this.StudioCN.cola3.head.data;
            
        } else if (!this.StudioCN.colaR.isEmpty()){
            ai.CharB = this.StudioCN.colaR.head.data;
        }   
    }
    
    public void addCharacter(Studio studio){
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
