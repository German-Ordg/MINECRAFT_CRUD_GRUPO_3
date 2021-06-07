/**
 * Integrantes:
 * •	Alejandro Josué Zúniga Zelaya     0311-2000-00312
 * •	German David Ordóñez Gómez     0801-2001-21597
 * •	Jhonnys Jesús Cálix Chávez         0801-2001-01321
 * •	Julio Alberto Velásquez Alvarez    0201-2001-00620
 * •	Sofía Raquel Ramírez Rodríguez   0801-1999-07288
 */
package com.unicahiccpmp.minecraft_grupo_3;

import java.util.ArrayList;
import java.util.Scanner;
import MINE.DAO.*;


public class MAIN {
    
    private static String opcion1 = "R";
    private static ArrayList<ENTRADAS> Registros;
    private static CONN conexionBD;
    private static Scanner scan;
    private static String SeparadorLinea; 
    
    public static void main(String args[]){
    conexionBD = new CONN();
    conexionBD.obtenerConeccion();
    scan = new Scanner(System.in);
    SeparadorLinea = new String(new char[125]).replace("\0", "-");
        
        System.out.println(SeparadorLinea);
        System.out.println("Iniciando Proyecto");
        System.out.println(SeparadorLinea);
        
        while (!opcion1.equalsIgnoreCase("Q")) {
            System.out.println();
            switch (opcion1.toUpperCase()) {
                case "R": 
                    
                    break;
                case "N": 
                   nuevoRegistro();
                    break;
                case "U": 
                    
                    break;
                case "D": 
                    eliminarRegistro();
                    
                   
                    break;
            }
            mostrarRegistros();
            mostrarMenu();
    }
    
    }
    
    
    public static void mostrarMenu(){
        System.out.println(SeparadorLinea);
        System.out.println("Menu:");
        System.out.println("Q Salir \t R Recargar \t N Nuevo \t U Actualizar \t D Eliminar \n Presione la opción y Enter: ");
        opcion1 = scan.nextLine();
    }
    
    
    
    public static void mostrarRegistros(){
        Registros = conexionBD.obtenerDatosRegistros();
        
        System.out.println(SeparadorLinea);
        System.out.println(String.format("%s\t%-25s\t%-25s\t%-25s\t%-25s",
                "#","MINECRAFTBLOCKNAME",
                "MINECRATFTCRAFTRECEIPT", 
                "MINECRAFTATTACK", 
                "MINECRAFTDEFENSE"));
        System.out.println(SeparadorLinea);
        for (ENTRADAS registro : Registros) { 
            System.out.println(registro.obtenerTextoConFormato());
        }
      
        System.out.println(SeparadorLinea);
        System.out.println(String.format("Total de Datos en la Base de datos: %d",Registros.size()));
        
    }
    
    
    public static void nuevoRegistro(){
        System.out.println();
        System.out.println("Obtener nuevos datos");
        System.out.println(SeparadorLinea);
        System.out.println("MINECRAFTBLOCKNAME: ");
        String name=scan.nextLine();
        System.out.println("MINECRATFTCRAFTRECEIPT: ");
        String receta=scan.nextLine();
        String ataque;
        do{
        System.out.println("MINECRAFTATTACK: ");
         ataque=scan.nextLine();
        }while(Integer.valueOf(ataque)<0 || Integer.valueOf(ataque)>10);
        String defensa;
        do{
        System.out.println("MINECRAFTDEFENSE: ");
        defensa=scan.nextLine();
        }while(Integer.valueOf(defensa)<0 || Integer.valueOf(defensa)>10);
        ENTRADAS registroNuevo = new ENTRADAS();
        registroNuevo.setMINECRAFTBLOCKNAME(name);
        registroNuevo.setMINECRATFTCRAFTRECEIPT(receta);
        registroNuevo.setMINECRAFTATTACK(Integer.valueOf(ataque));
        registroNuevo.setMINECRAFTDEFENSE(Integer.valueOf(defensa));
        
        
        conexionBD.agregarRegistro(registroNuevo);
        System.out.println();
        
    }
    public static void eliminarRegistro(){
        System.out.println("Escriba el código del dato a eliminar:");
        int idDato = scan.nextInt();
  
        scan.nextLine();
        ENTRADAS DatoAEliminar = conexionBD.obtenerUnDato(idDato);
        if (DatoAEliminar.getID() > 0) {
            System.out.println(SeparadorLinea);
            System.out.println(DatoAEliminar.obtenerTextoConFormato());
            System.out.println(SeparadorLinea);

            System.out.println("¿Desea Eliminar el registro? (S/N):");
            String opcion = scan.nextLine();
            if (opcion.toUpperCase().equals("S")){
                conexionBD.eliminarDato(DatoAEliminar);
                System.out.println("Dato Eliminado. Presione Enter para continuar.");
            } else {
                System.out.println("Operacion cancelada. Presione Enter para continuar.");
            }
        } else {
            System.out.println("No existe ningun Dato con ese ID !!! Presione Enter para Continuar.");
        }
        
        scan.nextLine();
    }

}
