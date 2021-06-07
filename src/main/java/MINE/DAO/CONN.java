/**
 * Integrantes:
 * •	Alejandro Josué Zúniga Zelaya     0311-2000-00312
 * •	German David Ordóñez Gómez     0801-2001-21597
 * •	Jhonnys Jesús Cálix Chávez         0801-2001-01321
 * •	Julio Alberto Velásquez Alvarez    0201-2001-00620
 * •	Sofía Raquel Ramírez Rodríguez   0801-1999-07288
 */
package MINE.DAO;


import java.sql.*;
import java.util.ArrayList;

public class CONN {
    
    

    Connection c = null;
    public void obtenerConeccion(){
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:MINECRAFT_GRUPO_3.db");
            String SQLCrearTabla = "CREATE TABLE IF NOT EXISTS MINECRAFT"
                    + " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + " MINECRAFTBLOCKNAME TEXT NOT NULL,"
                    + " MINECRATFTCRAFTRECEIPT TEXT NOT NULL,"
                    + " MINECRAFTATTACK INTEGER NOT NULL,"
                    + " MINECRAFTDEFENSE INTEGER NOT NULL"
                    + ")";
        
            
            
            Statement comandoSQL = c.createStatement();
            comandoSQL.executeUpdate(SQLCrearTabla);
            comandoSQL.close();
            
        } catch ( Exception e) {
            System.err.println(" Error " + e.getMessage());
            System.exit(0);
        }
    }
    
    
     public ArrayList<ENTRADAS> obtenerDatosRegistros(){
        try{
            if (c == null) {
                obtenerConeccion();
            }
            Statement comandoSql = c.createStatement();
            ResultSet pass = comandoSql.executeQuery("SELECT * FROM MINECRAFT;");
            ArrayList<ENTRADAS> todosLosRegistros = new ArrayList<ENTRADAS>();
            while(pass.next()){
                ENTRADAS registroIntegrando = new ENTRADAS();
                registroIntegrando.setID(pass.getInt("ID"));
                registroIntegrando.setMINECRAFTBLOCKNAME(pass.getString("MINECRAFTBLOCKNAME"));
                registroIntegrando.setMINECRATFTCRAFTRECEIPT(pass.getString("MINECRATFTCRAFTRECEIPT"));
                registroIntegrando.setMINECRAFTATTACK(pass.getInt("MINECRAFTATTACK"));
                registroIntegrando.setMINECRAFTDEFENSE(pass.getInt("MINECRAFTDEFENSE"));
                
                todosLosRegistros.add(registroIntegrando);
                
            }
            comandoSql.close();
            return todosLosRegistros;
        } catch( Exception e) {
            System.err.println(" Error " + e.getMessage());
            System.exit(0);
            return null;
        }
    }
    
     
     public void agregarRegistro(ENTRADAS entrada){
         try{
             String instruccionSQL = "INSERT into MINECRAFT (MINECRAFTBLOCKNAME,"
                     + "MINECRATFTCRAFTRECEIPT,"
                     + " MINECRAFTATTACK,"
                     + "MINECRAFTDEFENSE)"
                     + "values ('%s','%s','%s','%s');";
             
             Statement comandoSQL = c.createStatement();
             comandoSQL.executeUpdate(String.format(instruccionSQL,
                     entrada.getMINECRAFTBLOCKNAME(),
                     entrada.getMINECRATFTCRAFTRECEIPT(),
                     entrada.getMINECRAFTATTACK(),
                     entrada.getMINECRAFTDEFENSE()
                     )
             );
             comandoSQL.close();
         }catch(Exception e){
             System.err.println("Error"+ e.getMessage());
             System.exit(0);
         }
     }
     public ENTRADAS obtenerUnDato( int idDato) {
        try{
            String setenciaSql = "SELECT * from MINECRAFT where ID=%d;";
            Statement comandoSql = c.createStatement();
            ResultSet cursorDeDato = comandoSql.executeQuery(
                String.format(setenciaSql, idDato)
            );
            ENTRADAS miRegistro = new ENTRADAS();
            while ( cursorDeDato.next()){
                miRegistro.setID(cursorDeDato.getInt("ID"));
                miRegistro.setMINECRAFTBLOCKNAME(cursorDeDato.getString("MINECRAFTBLOCKNAME"));
                miRegistro.setMINECRATFTCRAFTRECEIPT(cursorDeDato.getString("MINECRATFTCRAFTRECEIPT"));
                miRegistro.setMINECRAFTATTACK(cursorDeDato.getInt("MINECRAFTATTACK"));
                miRegistro.setMINECRAFTDEFENSE(cursorDeDato.getInt("MINECRAFTDEFENSE"));
            }
            comandoSql.close();
            return miRegistro;
        } catch (Exception e) {
            System.err.println(" Error " + e.getMessage());
            System.exit(0);
            return null;
        }
     }
    
    public void eliminarDato(ENTRADAS DatoAEliminar){
        try {
            String sentenciaSQL = "DELETE from MINECRAFT where ID=%d;";
            Statement comandoSQL = c.createStatement();
            comandoSQL.executeUpdate(
                    String.format(
                            sentenciaSQL,
                            DatoAEliminar.getID()
                    )
            );
            comandoSQL.close();
        } catch(Exception ex){
            System.err.println(" Error " + ex.getMessage());
            System.exit(0);
        }
   
    

    }
    
    
}
