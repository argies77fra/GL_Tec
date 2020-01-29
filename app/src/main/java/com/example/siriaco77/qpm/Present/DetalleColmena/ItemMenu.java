package com.example.siriaco77.qpm.Present.DetalleColmena;

public class ItemMenu {

    private String nombre;
    // static List<ItemMenu> persons_2 = new ArrayList<>();

    public ItemMenu(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }



    public int getId() {
        return nombre.hashCode();
    }

    public ItemMenu(){

    }



 /*   public  static ItemMenu[] ITEMS = {
            new ItemMenu("0"),
            new ItemMenu("1"),
            /*new ItemMenu("2"),
            new ItemMenu("3"),
            new ItemMenu("4"),
            new ItemMenu("5"),
            new ItemMenu("6")*/

    // };*/

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Coche
     */
 /*   public static ItemMenu getItem(int id) {
        for (ItemMenu item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }*/
}
