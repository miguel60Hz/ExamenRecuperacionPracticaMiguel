/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deadpool.y.wolverine;

import java.util.Scanner;


public class BatallaEpicaMutante extends Personaje {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- DEADPOOL VS WOLVERINE ---");
        System.out.print("Digita su vida inicial: ");
        int vidaInicial = sc.nextInt();

        Personaje deadpool = new Personaje("Deadpool", vidaInicial, 10, 100, 25);
        Personaje wolverine = new Personaje("Wolverine", vidaInicial, 10, 120, 20);

        int turno = 1;

        while (deadpool.vida > 0 && wolverine.vida > 0) {
            System.out.println("TURNO " + turno + "");
            
            ejecutarTurno(deadpool, wolverine);
            
            if (wolverine.vida > 0) {
                ejecutarTurno(wolverine, deadpool);
            }

            System.out.println("ESTADO: Deadpool [" + Math.max(0, deadpool.vida) + "] | Wolverine [" + Math.max(0, wolverine.vida) + "]");
            
            turno++;
            Thread.sleep(1000);
        }

        System.out.println("--------------------------------");
        if (deadpool.vida <= 0) {
            System.out.println(" Wolverine Gana");
        } else {
            System.out.println("Deadpool Gana");
        }
        System.out.println("----------------------------------");
        
        sc.close();
    }

    public static void ejecutarTurno(Personaje atacante, Personaje defensor) {
        if (atacante.aturdido) {
            System.out.println("" + atacante.nombre + " esta regenerandose");
            return;
        }

        if (defensor.esquivaAtaque()) {
            System.out.println("" + defensor.nombre + " se esquivo el ataque de " + atacante.nombre + "!");
        } else {
            int daño = atacante.calcularAtaque();
            defensor.vida -= daño;
            System.out.println(atacante.nombre + " golpea a " + defensor.nombre + " con " + daño + " de dano.");
            }
        }

    public BatallaEpicaMutante(String nombre, int vida, int dañoMin, int dañoMax, int probabilidadEvasion) {
        super(nombre, vida, dañoMin, dañoMax, probabilidadEvasion);
    }
    }

