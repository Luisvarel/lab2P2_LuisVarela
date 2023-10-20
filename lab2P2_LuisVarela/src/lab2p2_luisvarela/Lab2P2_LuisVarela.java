/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2p2_luisvarela;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JColorChooser;

public class Lab2P2_LuisVarela {

    public static Scanner lea = new Scanner(System.in);
    public static Scanner lea1 = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<jugador> j = new ArrayList();
        ArrayList<carro> gc = new ArrayList();
        boolean seguir = true;
        while (seguir) {
            System.out.println("1.Jugador");
            System.out.println("2.Carro");
            System.out.println("3.Compra y Venta de Carros");
            System.out.println("4.Modificar carro");
            System.out.println("5.Salir");
            int opcion = lea.nextInt();
            switch (opcion) {
                case 1 -> {
                    boolean seguir1 = true;
                    while (seguir1) {
                        int opcion1 = menu_jugador();
                        switch (opcion1) {
                            case 1 -> {
                                jugador ju = crear_j();
                                j.add(ju);
                            }
                            case 2 -> {
                                listar_j(j);
                            }
                            case 3 -> {
                                if (j.size() != 0) {
                                    listar_j(j);
                                    int posicion = 0;
                                    do {
                                        System.out.println("Ingrese el numero del jugador");
                                        posicion = lea.nextInt();
                                    } while (posicion <= 0 || posicion >= j.size());
                                    String[] tempo = modificar_j();
                                    posicion--;
                                    j.get(posicion).setNombre(tempo[0]);
                                    int repu = Integer.parseInt(tempo[1]);
                                    j.get(posicion).setRepu(repu);
                                    int dinero = Integer.parseInt(tempo[2]);
                                    j.get(posicion).setDinero(dinero);
                                } else {
                                    System.out.println("La cantidad de jugadores es 0");
                                }

                            }
                            case 4 -> {
                                if (j.size() != 0) {
                                    listar_j(j);
                                    int posicion = 0;
                                    do {
                                        System.out.println("Ingrese el numero del jugador");
                                        posicion = lea.nextInt();
                                    } while (posicion <= 0 || posicion >= j.size());
                                    posicion--;
                                    j.remove(posicion);
                                } else {
                                    System.out.println("La cantidad de jugadores es 0");
                                }

                            }
                            case 5 -> {
                                seguir1 = false;

                            }
                            default -> {
                                System.out.println("Error");
                            }
                        }

                    }
                }
                case 2 -> {
                    boolean seguir2 = true;
                    while (seguir2) {
                        int opcion2 = menu_carro();
                        switch (opcion2) {
                            case 1 -> {
                                carro nuevo = crear_c();
                                gc.add(nuevo);
                            }
                            case 2 -> {
                                listar_p_j(j);
                            }
                            case 3 -> {
                                listar_gc(gc);
                                int posicion = 0;
                                do {
                                    System.out.println("Ingrese el numero del carro");
                                    posicion = lea.nextInt();
                                } while (posicion <= 0 || posicion >= j.size());
                                posicion--;
                                gc.remove(posicion);
                            }
                            case 4 -> {
                                seguir2 = false;
                            }
                            default -> {

                            }
                        }
                    }
                }
                case 3 -> {
                    boolean seguir3 = true;
                    while (seguir3) {
                        System.out.println("1.Compra de un carro");
                        System.out.println("2.venta de un carro");
                        System.out.println("3.Salir");
                        int opcion3 = lea.nextInt();
                        switch (opcion3) {
                            case 1 -> {
                                if (j.size() != 0 || gc.size() != 0) {
                                    listar_j(j);
                                    int posicion = 0;
                                    do {
                                        System.out.println("Ingrese el numero del jugador");
                                        posicion = lea.nextInt();
                                    } while (posicion <= 0 || posicion > j.size());
                                    posicion--;
                                    listar_gc(gc);
                                    int posicion1 = 0;
                                    do {
                                        System.out.println("Ingrese el numero del carro");
                                        posicion1 = lea.nextInt();
                                    } while (posicion1 <= 0 || posicion1 > j.size());
                                    posicion1--;
                                    if (j.get(posicion).getDinero() >= gc.get(posicion1).getPrecio()) {
                                        j.get(posicion).carro.add(gc.get(posicion1));
                                        int dinero = j.get(posicion).getDinero();
                                        dinero -= gc.get(posicion1).getPrecio();
                                        j.get(posicion).setDinero(dinero);
                                        gc.remove(posicion1);
                                        System.out.println("El carro fue comprado exitosamente");
                                    }
                                }
                            }
                            case 2 -> {
                                if (j.size() != 0 || gc.size() != 0) {
                                    listar_j(j);
                                    int posicion = 0;
                                    do {
                                        System.out.println("Ingrese el numero del jugador");
                                        posicion = lea.nextInt();
                                    } while (posicion <= 0 || posicion > j.size());
                                    posicion--;
                                    listar_p_j(j);
                                    int posicion1 = 0;
                                    do {
                                        System.out.println("Ingrese el numero del carro");
                                        posicion1 = lea.nextInt();
                                    } while (posicion1 <= 0 || posicion1 > j.size());
                                    posicion1--;
                                    int precio = j.get(posicion).carro.get(posicion1).getPrecio();
                                    int dinero = j.get(posicion).getDinero();
                                    dinero += precio;
                                    j.get(posicion).setDinero(dinero);
                                    j.get(posicion).carro.remove(posicion1);
                                    System.out.println("El carro fue vendido");
                                }

                            }
                            case 3 -> {
                                seguir3 = false;
                            }
                            default -> {
                                System.out.println("Error");
                            }
                        }
                    }
                }
                case 4 -> {
                    if (j.size() != 0 || gc.size() != 0) {
                        listar_j(j);
                        int posicion = 0;
                        do {
                            System.out.println("Ingrese el numero del jugador");
                            posicion = lea.nextInt();
                        } while (posicion <= 0 || posicion > j.size());
                        posicion--;
                        listar_p_j(j);
                        int posicion1 = 0;
                        do {
                            System.out.println("Ingrese el numero del carro");
                            posicion1 = lea.nextInt();
                        } while (posicion1 <= 0 || posicion1 > j.size());
                        posicion1--;
                        boolean seguir4 = true;
                        while (seguir4) {
                            System.out.println("1.Spoiler");
                            System.out.println("2.Side skirts");
                            System.out.println("3.Front Bumper");
                            System.out.println("4.Back Bumper");
                            if (j.get(posicion).getCarro().get(posicion1).isAgencia()) {
                            } else {
                                System.out.println("5.Super builds");
                            }
                            System.out.println("6.Salir");
                            int opcion4 = lea.nextInt();
                            switch (opcion4) {
                                case 1 -> {
                                    if (j.get(posicion).carro.get(posicion1).getMejora()[0] != 1) {
                                        if (j.get(posicion).getDinero() >= 3500) {
                                            int dinero = j.get(posicion).getDinero();
                                            dinero -= 3500;
                                            j.get(posicion).setDinero(dinero);
                                            int[] temp = j.get(posicion).carro.get(posicion1).getMejora();
                                            temp[0] = 1;
                                            j.get(posicion).carro.get(posicion1).setMejora(temp);
                                        } else {
                                            System.out.println("No tiene suficiente dinero");
                                        }
                                    } else {
                                        System.out.println("ya tiene esta mejora");
                                    }
                                }
                                case 2 -> {
                                    if (j.get(posicion).carro.get(posicion1).getMejora()[1] != 1) {
                                        if (j.get(posicion).getDinero() >= 1800) {
                                            int dinero = j.get(posicion).getDinero();
                                            dinero -= 1800;
                                            j.get(posicion).setDinero(dinero);
                                            int[] temp = j.get(posicion).carro.get(posicion1).getMejora();
                                            temp[1] = 1;
                                            j.get(posicion).carro.get(posicion1).setMejora(temp);
                                        } else {
                                            System.out.println("No tiene suficiente dinero");
                                        }
                                    } else {
                                        System.out.println("ya tiene esta mejora");
                                    }
                                }
                                case 3 -> {
                                    if (j.get(posicion).carro.get(posicion1).getMejora()[2] != 1) {
                                        if (j.get(posicion).getDinero() >= 2000) {
                                            int dinero = j.get(posicion).getDinero();
                                            dinero -= 2000;
                                            j.get(posicion).setDinero(dinero);
                                            int[] temp = j.get(posicion).carro.get(posicion1).getMejora();
                                            temp[2] = 1;
                                            j.get(posicion).carro.get(posicion1).setMejora(temp);
                                        } else {
                                            System.out.println("No tiene suficiente dinero");
                                        }
                                    } else {
                                        System.out.println("ya tiene esta mejora");
                                    }
                                }
                                case 4 -> {
                                    if (j.get(posicion).carro.get(posicion1).getMejora()[3] != 1) {
                                        if (j.get(posicion).getDinero() >= 1500) {
                                            int dinero = j.get(posicion).getDinero();
                                            dinero -= 1500;
                                            j.get(posicion).setDinero(dinero);
                                            int[] temp = j.get(posicion).carro.get(posicion1).getMejora();
                                            temp[3] = 1;
                                            j.get(posicion).carro.get(posicion1).setMejora(temp);
                                        } else {
                                            System.out.println("No tiene suficiente dinero");
                                        }
                                    } else {
                                        System.out.println("ya tiene esta mejora");
                                    }
                                }
                                case 5 -> {
                                    if (j.get(posicion).getCarro().get(posicion1).isAgencia()) {
                                        System.out.println("Error");
                                    } else {
                                        if (j.get(posicion).carro.get(posicion1).getMejora()[4] != 1) {
                                            if (j.get(posicion).getDinero() >= 8800) {
                                                int dinero = j.get(posicion).getDinero();
                                                dinero -= 8800;
                                                j.get(posicion).setDinero(dinero);
                                                int[] temp = j.get(posicion).carro.get(posicion1).getMejora();
                                                temp[4] = 1;
                                                j.get(posicion).carro.get(posicion1).setMejora(temp);
                                            } else {
                                                System.out.println("No tiene suficiente dinero");
                                            }
                                        } else {
                                            System.out.println("ya tiene esta mejora");
                                        }
                                    }
                                }
                                case 6 -> {
                                    seguir4 = false;
                                }
                                default -> {
                                    System.out.println("Error");
                                }
                            }
                        }
                    }
                }

                case 5 -> {
                    seguir = false;
                }
                default -> {
                    System.out.println("Error");
                }
            }
        }
    }

    public static void listar_gc(ArrayList<carro> gc) {
        for (carro object : gc) {
            System.out.println("Carro " + (gc.indexOf(object) + 1));
            System.out.println(object);
        }
    }

    public static jugador crear_j() {
        String nombre = "";
        do {
            System.out.println("Ingrese un nombre:");
            nombre = lea1.nextLine();
        } while (nombre.length() == 0);
        int repu = 0;
        do {
            System.out.println("Ingrese su reputacion:");
            repu = lea.nextInt();
        } while (repu < 0);
        int dinero = 0;
        do {
            System.out.println("Ingrese la cantidad de dinero:");
            dinero = lea.nextInt();
        } while (dinero < 0);
        return new jugador(nombre, repu, dinero);
    }

    public static void listar_j(ArrayList<jugador> j) {
        for (jugador object : j) {
            System.out.println("Jugador " + (j.indexOf(object) + 1));
            System.out.println(object);
        }
    }

    public static String[] modificar_j() {
        boolean seguir = true;
        String nombre = "";
        int repu = 0;
        int dinero = 0;
        while (seguir) {
            System.out.println("1.Modificar nombre");
            System.out.println("2.Modificar reputacion");
            System.out.println("3.Modificar dinero");
            System.out.println("4.Salir");
            int opcion = lea.nextInt();
            switch (opcion) {
                case 1 -> {
                    do {
                        System.out.println("Ingrese un nombre:");
                        nombre = lea1.nextLine();
                    } while (nombre.length() == 0);
                }
                case 2 -> {
                    do {
                        System.out.println("Ingrese su reputacion:");
                        repu = lea.nextInt();
                    } while (repu < 0);
                }
                case 3 -> {
                    do {
                        System.out.println("Ingrese la cantidad de dinero:");
                        dinero = lea.nextInt();
                    } while (dinero < 0);
                }
                case 4 -> {
                    seguir = false;
                }
                default -> {
                    System.out.println("Error");
                }
            }
        }
        String[] tempo = new String[3];
        tempo[0] = nombre;
        tempo[1] = "" + repu;
        tempo[2] = "" + dinero;
        return tempo;
    }

    public static int menu_jugador() {
        System.out.println("1.Crear jugador");
        System.out.println("2.Listar jugadores");
        System.out.println("3.Modificar jugador");
        System.out.println("4.Eliminar jugador");
        System.out.println("5.Salir");
        int opcion1 = lea.nextInt();
        return opcion1;
    }

    public static carro crear_c() {
        String marca = "";
        do {
            System.out.println("Ingrese la marca:");
            marca = lea1.next();
        } while (marca.length() == 0);
        String modelo = "";
        do {
            System.out.println("Ingrese el modelo:");
            modelo = lea1.next();
        } while (modelo.length() == 0);
        Color color = JColorChooser.showDialog(null, "Seleccione un color", Color.green);
        int precio = 0;
        do {
            System.out.println("Ingrese el precio:");
            precio = lea.nextInt();
        } while (precio <= 0);
        boolean agencia = true;
        int opcion = 0;
        while (opcion <= 0 || opcion >= 3) {
            System.out.println("1.Carro de agencia");
            System.out.println("2.Carro reconstruido");
            opcion = lea.nextInt();
        }
        if (opcion == 1) {
            agencia = true;
        } else {
            agencia = false;
        }
        return new carro(marca, modelo, color, precio, agencia);
    }

    public static void listar_p_j(ArrayList<jugador> j) {
        for (int i = 0; i < j.size(); i++) {
            System.out.println("Jugador " + (j.indexOf(j.get(i)) + 1));
            System.out.println("Nombre: " + j.get(i).getNombre());
            if (j.get(i).carro.size() != 0) {
                for (int k = 0; k < j.get(i).carro.size(); k++) {
                    System.out.println(j.get(i).carro.get(k));
                }
            }
        }
    }

    public static int menu_carro() {
        System.out.println("1.Crear carro");
        System.out.println("2.Listar carro por jugador");
        System.out.println("3.Eliminar carro");
        System.out.println("4.Salir");
        int opcion2 = lea.nextInt();
        return opcion2;
    }

//    switch (opcion2) {
//                            case 1->{
//                                
//                            }
//                            case 2->{
//                                
//                            }
//                            case 3->{
//                                
//                            }
//                            case 4->{
//                                
//                            }
//                            case 5->{
//                                
//                            }
//                            default->{
//                                
//                            }
//                        }
}
