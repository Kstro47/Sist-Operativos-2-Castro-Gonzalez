/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Emilio Jr
 */
public class Nodo {
    public Character data;
    public Nodo pNext;

    public Nodo(Character data){
        this.data = data;
        this.pNext = null;       
    }
    
    public Nodo(Character data, Nodo node){
        this.data = data;
        this.pNext = node;
    }
    
    public Object getData() {
        return data;
    }

    public void setData(Character data) {
        this.data = data;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
    
}
