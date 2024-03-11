/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Emilio Jr
 */
public class Cola {
    public Nodo head;
    public Nodo tail;
    public int size;
    
    public Cola(){
        this.head = this.tail = null;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public String showCola(){
        String string = "";
        Nodo aux = this.head;
        for (int i = 0; i < this.size; i++) {
            string += aux.data.id + " | ";
            aux = aux.getpNext();
        }
        return string;
    }
    
    public void encolar(Character data){
        Nodo nodo = new Nodo(data);
        if (this.isEmpty()){
            head = tail = nodo;
        } else {
            Nodo aux = tail;
            aux.setpNext(nodo);
        }
        tail = nodo;
        size++;
    }
    
    public void desencolar(){
        if (!this.isEmpty()){
            head = head.getpNext();
        }
        if (head == null){
            tail = null;
        }
        size--;
    }
    
    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public Nodo getTail() {
        return tail;
    }

    public void setTail(Nodo tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
