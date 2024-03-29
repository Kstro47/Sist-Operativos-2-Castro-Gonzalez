/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import javax.swing.JOptionPane;

/**
 *
 * @author Emilio Jr
 */
public class Lista<T> {

    private Nodo pFirst;
    private Nodo pLast;
    private int size;

    public Lista() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public Nodo getpLast() {
        return pLast;
    }

    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean IsEmpty() {
        return this.pFirst == null;
    }
   
    public void append(Character data) {
        Nodo node = new Nodo(data);
        if (IsEmpty()) {
            this.pFirst = node;
            this.pLast = node;
        } else {
            Nodo aux = pLast;
            aux.setpNext(node);
            pLast = node;
        }
        size += 1;
    }

    public void Print() {
        if (!IsEmpty()) {
            Nodo aux = pFirst;
            for (int i = 0; i < size; i++) {
                System.out.println(aux.getData() + " ");
                aux = aux.getpNext();
            }
        } else {
            System.out.println("La lista está vacía.");
        }
    }

    public void DeleteStart() {
        if (!IsEmpty()) {
            pFirst = pFirst.getpNext();
            size = size - 1;
        }
    }
    
    public void DeleteFinal() {
        Nodo aux = pFirst;
        for (int i = 0; i < size - 2 ; i++) {
            aux = aux.getpNext();
        }
        aux.setpNext(null);
        size -= 1;
    }

    public void Delete(int num){
        if (num > size){
            JOptionPane.showMessageDialog(null, "Error, el número excede el tamaño de la lista.");
        } else if (num == 0){
            pFirst = pFirst.getpNext();
            size -= 1;
        } else if (num == size){
            Nodo aux = pFirst;
            for (int i = 0; i < size - 2 ; i++) {
            aux = aux.getpNext();
            }
            aux.setpNext(null);
            size -= 1;
        } else if (!IsEmpty()){
            Nodo aux = pFirst;
            for (int i = 0; i < num - 1 ; i++) {
                aux = aux.getpNext();
            }
            Nodo next = aux.getpNext().getpNext();
            aux.setpNext(next);
            size -= 1;

        }
    }
}
