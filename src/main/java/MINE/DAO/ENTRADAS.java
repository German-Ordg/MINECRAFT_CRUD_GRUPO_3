/**
 * Integrantes:
   •	Alejandro Josué Zúniga Zelaya      0311-2000-00312
   •	German David Ordóñez Gómez         0801-2001-21597
   •	Jhonnys Jesús Cálix Chávez         0801-2001-01321
   •	Julio Alberto Velásquez Alvarez    0201-2001-00620
   •	Sofía Raquel Ramírez Rodríguez     0801-1999-07288
 */
package MINE.DAO;


public class ENTRADAS {

    
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the MINECRAFTBLOCKNAME
     */
    public String getMINECRAFTBLOCKNAME() {
        return MINECRAFTBLOCKNAME;
    }

    /**
     * @param MINECRAFTBLOCKNAME the MINECRAFTBLOCKNAME to set
     */
    public void setMINECRAFTBLOCKNAME(String MINECRAFTBLOCKNAME) {
        this.MINECRAFTBLOCKNAME = MINECRAFTBLOCKNAME;
    }

    /**
     * @return the MINECRATFTCRAFTRECEIPT
     */
    public String getMINECRATFTCRAFTRECEIPT() {
        return MINECRATFTCRAFTRECEIPT;
    }

    /**
     * @param MINECRATFTCRAFTRECEIPT the MINECRATFTCRAFTRECEIPT to set
     */
    public void setMINECRATFTCRAFTRECEIPT(String MINECRATFTCRAFTRECEIPT) {
        this.MINECRATFTCRAFTRECEIPT = MINECRATFTCRAFTRECEIPT;
    }

    /**
     * @return the MINECRAFTATTACK
     */
    public int getMINECRAFTATTACK() {
        return MINECRAFTATTACK;
    }

    /**
     * @param MINECRAFTATTACK the MINECRAFTATTACK to set
     */
    public void setMINECRAFTATTACK(int MINECRAFTATTACK) {
        this.MINECRAFTATTACK = MINECRAFTATTACK;
    }

    /**
     * @return the MINECRAFTDEFENSE
     */
    public int getMINECRAFTDEFENSE() {
        return MINECRAFTDEFENSE;
    }

    /**
     * @param MINECRAFTDEFENSE the MINECRAFTDEFENSE to set
     */
    public void setMINECRAFTDEFENSE(int MINECRAFTDEFENSE) {
        this.MINECRAFTDEFENSE = MINECRAFTDEFENSE;
    }
    
   /*ENCAPSULAMIENTO HECHO POR ALEJANDRO ZÚNIGA*/
    private int ID;
    private String MINECRAFTBLOCKNAME;
    private String MINECRATFTCRAFTRECEIPT;
    private int MINECRAFTATTACK;
    private int MINECRAFTDEFENSE;
    
    
    /*METODO CREADO POR GERMAN ORDOÑEZ*/
    public String obtenerTextoConFormato(){
        return String.format(
                "%d\t%-25s\t%-25s\t%-25d\t%-25d",
                ID,
                MINECRAFTBLOCKNAME,
                MINECRATFTCRAFTRECEIPT,
                MINECRAFTATTACK,
                MINECRAFTDEFENSE
        );
    }

   
}
