package Swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal {

    static String img = "https://i.imgur.com/nzoV1N9.gif";
    private JFrame framePrincipal;
    private JPanel panelPrincipal1;
    private JPanel panelPrincipal2;
    private JPanel panelPrincipal3;
    private JLabel tituloPrincipal;
    private JButton botonIniciar;
    private JButton botonSalir;

    //Esta accion hace desaparecer los paneles principales y deberia iniciar el juego, pero falta esto ultimo
    private void botonIniciarActionPerformed(ActionEvent evt){
        panelPrincipal1.setVisible(false);
        panelPrincipal2.setVisible(false);
        panelPrincipal3.setVisible(false);
    }

    //Esta accion cierra la ventana
    private void botonSalirActionPerformed(ActionEvent evt){
        framePrincipal.dispose();
    }

    //Se inicializan los componentes
    public MenuPrincipal(){
        initialize();
    }

    public void initialize() {
        framePrincipal = new JFrame();
        panelPrincipal1 = new JPanel();
        panelPrincipal2 = new JPanel();
        panelPrincipal3 = new JPanel();
        tituloPrincipal = new JLabel();
        botonIniciar = new JButton();
        botonSalir = new JButton();

        framePrincipal.setLayout(new BorderLayout());
        framePrincipal.setTitle("Juegaso");

        framePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePrincipal.setSize(900, 600);
        framePrincipal.setMinimumSize(new Dimension(700, 500));
        framePrincipal.setLocationRelativeTo(null);

        panelPrincipal1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panelPrincipal1.setBackground(Color.CYAN);

        panelPrincipal2.setLayout(new BorderLayout(10, 0));
        panelPrincipal2.setBackground(Color.CYAN);

        panelPrincipal3.setLayout(new GridLayout(2, 1, 10, 5));
        panelPrincipal3.setBackground(Color.CYAN);

        tituloPrincipal.setText("<html><body>BIENVENDO AL JUEGO DE LA SCALONETA : <br/><p style='text-align:center;'>LE METEMOS???</p></body></html>");
        tituloPrincipal.setFont(new Font("Comic sans ms", 0, 30));
        tituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
        panelPrincipal1.add(tituloPrincipal);

        JLabel gifCopa = null;
        try {
            ImageIcon gifImage = new ImageIcon(new URL(img));
            gifCopa = new JLabel(gifImage);
        } catch (Exception mue) {
            gifCopa = new JLabel("Error al cargar la imagen");
        } finally{
            panelPrincipal2.add(gifCopa, BorderLayout.CENTER);
        }
        botonIniciar.setText("Empezar juego");
        botonIniciar.setFont(new Font("Comic sans ms", 2, 24));
        botonIniciar.setFocusable(false);
        botonIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonIniciarActionPerformed(evt);
            }
        });
        panelPrincipal3.add(botonIniciar);

        botonSalir.setText("Salir");
        botonSalir.setFont(new Font("Comic sans ms", 2, 24));
        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        panelPrincipal3.add(botonSalir);


        framePrincipal.add(panelPrincipal1, BorderLayout.NORTH);
        framePrincipal.add(panelPrincipal2, BorderLayout.CENTER);
        framePrincipal.add(panelPrincipal3, BorderLayout.SOUTH);

        framePrincipal.setVisible(true);
    }
}