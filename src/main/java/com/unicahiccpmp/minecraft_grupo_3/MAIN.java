/**
 * Integrantes:
   •	Alejandro Josué Zúniga Zelaya     0311-2000-00312
   •	German David Ordóñez Gómez        0801-2001-21597
   •	Jhonnys Jesús Cálix Chávez        0801-2001-01321
   •	Julio Alberto Velásquez Alvarez   0201-2001-00620
   •	Sofía Raquel Ramírez Rodríguez    0801-1999-07288
   •	Erick Sebastian Moncada Rubi      0801-2000-17208
 */
package com.unicahiccpmp.minecraft_grupo_3;

import java.util.ArrayList;
import java.util.Scanner;
import MINE.DAO.*;

/*CODIGO DEL METODO MAIN CREADO POR JHONNYS CALIX JUNTO A ALEJANDRO ZÚNIGA*/
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
                    actualizarRegistro();
                    break;
                case "D": 
                    eliminarRegistro();
                    
                   
                    break;
            }
            mostrarRegistros();
            mostrarMenu();
    }
    
    }
    
   /*METODO CREADO POR JULIO VELÁSQUEZ*/ 
    public static void mostrarMenu(){
        System.out.println(SeparadorLinea);
        System.out.println("Menu:");
        System.out.println("Q Salir \t R Recargar \t N Nuevo \t U Actualizar \t D Eliminar \n Presione la opción y Enter: ");
        opcion1 = scan.nextLine();
    }
    
    
    /*METODO CREADO POR GERMAN ORDOÑEZ*/
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
    
    /*METODO CREADO POR JHONNYS CALIX*/
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
    
    /*METODO CREADO POR ALEJANDRO ZÚNIGA*/
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

    /*METODO CREADO POR SOFÍA RAMIREZ JUNTO A JULIO VELÁSQUEZ*/
    public static void actualizarRegistro(){
        System.out.println("Escriba el codigo del dato que desea Actualizar: ");
        int idDato = scan.nextInt();
        
        
        scan.nextLine();
        
        ENTRADAS registroActualizar = conexionBD.obtenerUnDato(idDato);
        
        if(registroActualizar.getID() > 0)
        {
            System.out.println(SeparadorLinea);
            System.out.println(registroActualizar.obtenerTextoConFormato());
            System.out.println(SeparadorLinea);
            System.out.println("MINECRAFTBLOCKNAME ("+registroActualizar.getMINECRAFTBLOCKNAME()+"):");
            String MINECRAFTBLOCKNAME = scan.nextLine();
            if(!MINECRAFTBLOCKNAME.isEmpty() && !MINECRAFTBLOCKNAME.equals(registroActualizar.getMINECRAFTBLOCKNAME()))
            {
                registroActualizar.setMINECRAFTBLOCKNAME(MINECRAFTBLOCKNAME);
            }
            
            System.out.println("MINECRATFTCRAFTRECEIPT ("+ registroActualizar.getMINECRATFTCRAFTRECEIPT()+"):");
            String MINECRATFTCRAFTRECEIPT =scan.nextLine();
            if(!MINECRATFTCRAFTRECEIPT.isEmpty() && !MINECRATFTCRAFTRECEIPT.equals(registroActualizar.getMINECRATFTCRAFTRECEIPT()))
            {
                registroActualizar.setMINECRATFTCRAFTRECEIPT(MINECRATFTCRAFTRECEIPT);
            }
            
            System.out.println("MINECRAFTATTACK ("+ registroActualizar.getMINECRAFTATTACK()+"):");
            String MINECRAFTATTACK  =scan.nextLine();
            if(!MINECRAFTATTACK.isEmpty() && !MINECRAFTATTACK.equals(registroActualizar.getMINECRAFTATTACK()))
            {
                registroActualizar.setMINECRAFTATTACK(Integer.valueOf(MINECRAFTATTACK));
            }
            
            System.out.println("MINECRAFTDEFENSE ("+ registroActualizar.getMINECRAFTDEFENSE()+"):");
            String MINECRAFTDEFENSE=scan.nextLine();
            if(!MINECRAFTDEFENSE.isEmpty() && !MINECRAFTDEFENSE.equals(registroActualizar.getMINECRAFTDEFENSE()))
            {
                registroActualizar.setMINECRAFTDEFENSE(Integer.valueOf(MINECRAFTDEFENSE));
            }
            
            System.out.println(registroActualizar.obtenerTextoConFormato());
            conexionBD.actualizarRegistro(registroActualizar);
            System.out.println("Registro Actualizado!!! Presione ENTER para continuar.");
            
        }
        else{
            System.out.println("No existe Registro!!! Presione Enter para continuar.");
        }
        
        scan.nextLine();
    }
}
