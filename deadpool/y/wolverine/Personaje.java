/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deadpool.y.wolverine;

import java.util.Random;

 public class Personaje {
    String nombre;
    int vida;
    int dañoMin;
    int dañoMax;
    int probabilidadEvasion; 
    boolean aturdido = false;

    public Personaje(String nombre, int vida, int dañoMin, int dañoMax, int probabilidadEvasion) {
        this.nombre = nombre;
        this.vida = vida;
        this.dañoMin = dañoMin;
        this.dañoMax = dañoMax;
        this.probabilidadEvasion = probabilidadEvasion;
    }

    public int calcularAtaque() {
        Random rand = new Random();
        return rand.nextInt((dañoMax - dañoMin) + 1) + dañoMin;
    }

    public boolean esquivaAtaque() {
        Random rand = new Random();
        return rand.nextInt(100) < probabilidadEvasion;
    }
}