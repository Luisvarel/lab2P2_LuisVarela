/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2_luisvarela;

import java.awt.Color;

/**
 *
 * @author Luis Andres Varela
 */
public class carro {

    private String marca = "";
    private String modelo = "";
    private Color color;
    private int precio = 0;
    private int[] mejora = {0, 0, 0, 0, 0};
    /*
    spoiler posicion 0 precio de la mejora 3500
    side skirts 1 precio de la mejora 1800
    front bumper 2 precio de la mejora 2000
    back bumper 3 precio de la mejora 1500
    esta mejora solo esta disponible en autos reconstruido
    super 4 precio de la mejora 8800
     */
    private boolean agencia = true;

    /*
    agencia=true
    reconstruido=false
     */
    public carro(String marca, String modelo, Color color, int precio, boolean agencia) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        String agencia1 = "";
        if (agencia == true) {
            agencia1 = "agencia";
        } else {
            agencia1 = "reconstruido";
        }
        String mejoras = "";
        if (mejora[0] == 1) {
            mejoras += "Spoiler\n";
        }
        if (mejora[1] == 1) {
            mejoras += "Side skirts\n";
        }
        if (mejora[2] == 1) {
            mejoras += "Front Bumper\n";
        }
        if (mejora[3] == 1) {
            mejoras += "Back Bumper\n";
        }
        if (mejora[4] == 1) {
            mejoras += "Super builds\n";
        }
        return "Marca: " + marca + "\nModelo: " + modelo + "\ncolor: " + color + "\nprecio: " + precio + "\n" + agencia1+"\nMejoras:\n"+mejoras;
    }

    public carro() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int[] getMejora() {
        return mejora;
    }

    public void setMejora(int[] mejora) {
        this.mejora = mejora;
    }

    public boolean isAgencia() {
        return agencia;
    }

    public void setAgencia(boolean agencia) {
        this.agencia = agencia;
    }

}
