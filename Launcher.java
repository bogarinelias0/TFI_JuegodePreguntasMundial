package Swing;

import javax.swing.SwingUtilities;

public class Launcher {
    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){

                MenuPrincipal frame = new MenuPrincipal();
            }
        });
    }
}
