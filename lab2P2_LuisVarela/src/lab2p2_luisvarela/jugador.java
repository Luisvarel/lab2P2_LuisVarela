/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2_luisvarela;

import java.util.ArrayList;

/**
 *
 * @author Luis Andres Varela
 */
public class jugador {
    String nombre="";
    ArrayList<carro>carro=new ArrayList();
    int repu=0;
    int dinero=0;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRepu() {
        return repu;
    }

    public void setRepu(int repu) {
        this.repu = repu;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    
    public jugador(String nombre,int repu,int dinero){
        this.nombre=nombre;
        this.repu=repu;
        this.dinero=dinero;
    }
    public jugador(String nombre,int repu,int dinero,carro c){
        this.nombre=nombre;
        this.repu=repu;
        this.dinero=dinero;
        carro.add(c);
    }
    public jugador(){
    }

    public ArrayList<carro> getCarro() {
        return carro;
    }

    public void setCarro(ArrayList<carro> carro) {
        this.carro = carro;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+"\nReputacion: "+repu+"\nDinero: "+dinero+"\nCantidad de carros:"+carro.size()+"\n";
    }
    
    
    
}
