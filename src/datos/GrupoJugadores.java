/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import javax.swing.JOptionPane;

/**
 *
 * @author Maria Camila
 */
public class GrupoJugadores {
    public static void main(String[] args) {
        
//        JOptionPane.showMessageDialog(null,"Opciones a escoger: \n1. Digitar jugador \n2. Mostrar datos. \n3. Porcentaje de goleadores con más de 50 goles. \n4. Buscar por nombre. \n5. Promedio de goles \n6. Jugador con más goles. \n7. Eliminar por nombre.");
//        
//        int op = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la opcion que desea: "));
//        do {
//            switch (op) {
//            case 1:
//                capturaDatos(nombres, goles, n);
//                break;
//        }
//        } while(op != 7);
//        
        String nombres[] = new String[100];
        int goles[] = new int[100];
        
        JOptionPane.showMessageDialog(null,"Bienvenido  \n ");
        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de jugadores: "));
        capturaDatos(nombres, goles, n);
       
        String lis = mostrarDatos(nombres, goles, n);
        JOptionPane.showMessageDialog(null, lis);
        
        // Porcentaje de jugadores que pasan los 50 goles
        float porcentaje = porcentaje50(goles, n);
        JOptionPane.showMessageDialog(null, "Porcentaje de goleadores con más de 50 goles: " + porcentaje);
        
        // Buscar un jugador por el nombre
        String nombreBuscar = JOptionPane.showInputDialog("Digite el nombre a buscar: ");
        String data = buscarXnombre(nombres, goles, n, nombreBuscar);
        JOptionPane.showMessageDialog(null, data);
        
        // Promedio de goles
        float promedio = promedio(goles, n);
        JOptionPane.showMessageDialog(null, "El promedio de goles es: " + promedio);
        
        // Jugador con más goles
        String dato = jugadorMasGoles(nombres, goles, n);
        JOptionPane.showMessageDialog(null, "El jugador con más goles es: " + dato);
        
        // Eliminar un jugador por su nombre
        String eliminar = JOptionPane.showInputDialog("Digite el nombre del jugador a eliminar: ");       
             
        String nuevoVectNom[] = new String[100];
        int nuevoVectGol[] = new int[100];
        int pos = 0;
        
        for (int i = 0; i < n; i++) {
            if(nombres[i].equals(eliminar)){
                pos = i;
            }
//            return "No se encuentra el jugador";
        }
        
        for (int i = 0; i < pos; i++) {
            nuevoVectNom[i] = nombres[i];
            nuevoVectGol[i] = goles[i];
        }
        
        for (int j = pos+1; j < n; j++) {
            nuevoVectNom[j-1] = nombres[j];
            nuevoVectGol[j-1] = goles[j];
        }
        
        nombres = nuevoVectNom;
        goles = nuevoVectGol;
        n--;
        
        String datoo = mostrarDatos(nombres, goles, n);
        JOptionPane.showMessageDialog(null, datoo);
        
    
        
    
    }

    private static void capturaDatos(String[] nombres, int[] goles, int n) {
        for (int i = 0; i < n; i++) {
            nombres[i] = JOptionPane.showInputDialog( "Digite el nombre: ");
            goles[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de goles: "));
        }
    }

    private static String mostrarDatos(String[] nombres, int[] goles, int n) {
        String lis = "";
        for (int i = 0; i < n; i++) {
            lis += "Nombre: " + nombres[i] + "      Goles: " + goles[i] + "\n";
        }
        return lis;
    }

    private static float porcentaje50(int[] goles, int n) {
        int porcen = 0;
        for (int i = 0; i < n; i++) {
            if(goles[i] > 50) {
                porcen++;
            }
        }
        return (float)porcen/n*100;
    }

    private static String buscarXnombre(String[] nombres, int[] goles, int n, String nombreBuscar) {
        String lis = "";
        for (int i = 0; i < n; i++) {
            if(nombres[i].equals(nombreBuscar)) {
                return lis = "El jugador encontrado: " + nombres[i];
            }
        }
        return "No se encuentra el jugador";
    }

    private static float promedio(int[] goles, int n) {
        int promedio = 0;
        for (int i = 0; i < n; i++) {
            promedio = promedio + goles[i];
        }
        return (float) promedio/n;
    }

    private static String jugadorMasGoles(String[] nombres, int[] goles, int n) {
        int jugadorMas = goles[0];
        int pos = 0;
        
        for (int i = 0; i < n; i++) {
            if(jugadorMas < goles[i]) {
                jugadorMas = goles[i];
                pos++;
            }
        } 
        return nombres[pos];
    }

    
  
    }
    
    
    
}
