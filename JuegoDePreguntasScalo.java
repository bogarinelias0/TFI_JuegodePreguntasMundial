package Swing;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

    public class JuegoDePreguntasScalo extends JFrame {
        static String urlBD = "https://docs.google.com/spreadsheets/d/e/2PACX-1vS-NCF_82uIlZQL3idzK7-zjn6yCsPdkzTajfwcltScO_oayu65t89icjq5JXrlz0vx0WoYU18xVVl4/pub?output=tsv";
        static String textoBaseDePreguntas;
        static String[] renglones;
        static int cantidadDePreguntas;
        static String[][] baseDePreguntas;
        String[] preguntaEscogida;
        String pregunta;
        String respuesta;
        String img;
        ArrayList<String> Opciones = new ArrayList();
        int n_pregunta = 0;
        static int cont;
        ActionListener oyenteDeAccion = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        };
        private JButton jButton1;
        private JButton jButton2;
        private JButton jButton3;
        private JButton jButton4;
        private JLabel jLabel1;
        private JLabel jLabel2;
        private JPanel jPanel1;
        private JPanel jPanel2;
        private JPanel jPanel3;

        private void iniciarComponentes() {
            this.jPanel1 = new JPanel();
            this.jPanel2 = new JPanel();
            this.jLabel1 = new JLabel();
            this.jLabel2 = new JLabel();
            this.jPanel3 = new JPanel();
            this.jButton1 = new JButton();
            this.jButton2 = new JButton();
            this.jButton4 = new JButton();
            this.jButton3 = new JButton();
            this.setDefaultCloseOperation(3);
            this.getContentPane().setLayout(new GridLayout());
            this.jPanel1.setLayout(new GridLayout(2, 0));
            this.jPanel2.setBackground(Color.cyan);
            this.jPanel3.setBackground(Color.white);
            this.jLabel1.setFont(new Font("Arial", 1, 20));
            this.jLabel1.setText("Pregunta");
            this.jPanel2.add(this.jLabel1);
            this.jLabel2.setFont(new Font("Comic sans ms", 1, 20));
            this.jLabel2.setText("Imagen");
            this.jPanel2.add(this.jLabel2);
            this.jPanel1.add(this.jPanel2);
            this.jPanel3.setLayout(new GridLayout(0, 2, 30, 30));
            this.jButton1.setFont(new Font("Comic sans ms", 2, 24));
            this.jButton1.setText("Opcion 1");
            this.jButton1.setBackground(Color.white);
            this.jButton1.setFocusable(false);
            this.jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    JuegoDePreguntasScalo.this.jButton1ActionPerformed(evt);
                }
            });
            this.jPanel3.add(this.jButton1);
            this.jButton2.setFont(new Font("Comic sans ms", 2, 24));
            this.jButton2.setText("Opcion 2");
            this.jButton2.setBackground(Color.white);
            this.jButton2.setFocusable(false);
            this.jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    JuegoDePreguntasScalo.this.jButton2ActionPerformed(evt);
                }
            });
            this.jPanel3.add(this.jButton2);
            this.jButton4.setFont(new Font("Comic sans ms", 2, 24));
            this.jButton4.setText("Opcion 3");
            this.jButton4.setBackground(Color.cyan);
            this.jButton4.setFocusable(false);
            this.jButton4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    JuegoDePreguntasScalo.this.jButton4ActionPerformed(evt);
                }
            });
            this.jPanel3.add(this.jButton4);
            this.jButton3.setFont(new Font("Comic sans ms", 2, 24));
            this.jButton3.setText("Opcion 4");
            this.jButton3.setBackground(Color.cyan);
            this.jButton3.setFocusable(false);
            this.jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    JuegoDePreguntasScalo.this.jButton3ActionPerformed(evt);
                }
            });
            this.jPanel3.add(this.jButton3);
            this.jPanel1.add(this.jPanel3);
            this.getContentPane().add(this.jPanel1);
            this.pack();
        }

        public void escogerPregunta(int n) {
            this.preguntaEscogida = baseDePreguntas[n];
            this.pregunta = this.preguntaEscogida[0];
            this.respuesta = this.preguntaEscogida[1];
            if (this.preguntaEscogida.length > 5) {
                this.img = this.preguntaEscogida[5];
            } else {
                this.img = "";
            }

            this.Opciones.clear();

            int i;
            for(i = 1; i < 5; ++i) {
                this.Opciones.add(this.preguntaEscogida[i]);
            }

            for(i = 0; i < 4; ++i) {
                Collections.shuffle(this.Opciones);
            }

        }

        public void mostrarPregunta() {
            this.jLabel1.setText(this.pregunta);
            if (this.img.equals("")) {
                this.jLabel2.setVisible(false);
            } else {
                this.jLabel2.setVisible(true);
                this.jLabel2.setText("");

                try {
                    BufferedImage imagen = ImageIO.read(new URL(this.img));
                    Image imagenEscalada = imagen.getScaledInstance(-350, 350, 1);
                    this.jLabel2.setIcon(new ImageIcon(imagenEscalada));
                } catch (Exception var3) {
                    this.jLabel2.setText("La imagen no se pudo cargar");
                    this.jLabel2.setIcon((Icon)null);
                }
            }

            this.jButton1.setText((String)this.Opciones.get(0));
            this.jButton2.setText((String)this.Opciones.get(1));
            this.jButton4.setText((String)this.Opciones.get(2));
            this.jButton3.setText((String)this.Opciones.get(3));
        }

        void escogerRespuesta(int n) {
            if (((String)this.Opciones.get(n)).equals(this.respuesta)) {
                JOptionPane.showMessageDialog(this, "Su respuesta es correcta", "Muy bien :)", 1);
                JOptionPane.showMessageDialog(this, "Sumaste un punto", "golazooo", 1);
                ++cont;
            } else {
                JOptionPane.showMessageDialog(this, "Su respuesta es incorrecta, la respuesta es: " + this.respuesta, "Que mal :(", 0);
            }
            
            System.out.println("la cantidad de puntos es: " + cont);

            this.jugar();
        }

        public void jugar() {
            if (this.n_pregunta == cantidadDePreguntas) {
                JOptionPane.showMessageDialog(this, "Juego Terminado", "Muy bien :)", -1);
                System.exit(0);
            }

            this.escogerPregunta(this.n_pregunta);
            this.mostrarPregunta();
            ++this.n_pregunta;
        }

        public JuegoDePreguntasScalo() {
            for(int i = 0; i < renglones.length; ++i) {
                String renglon = renglones[i];
                baseDePreguntas[i] = renglon.split("\t");
            }

            this.iniciarComponentes();
            this.setSize(750, 600);
            this.setLocationRelativeTo((Component)null);
            this.setDefaultCloseOperation(3);
            this.setVisible(true);
            this.setTitle("El Juego de la Scaloneta");
            this.jugar();
        }

        public static String LeerArchivo(String ruta) {
            try {
                if (ruta == null) {
                    throw new RuntimeException("Error, la URL de lectura no puede ser nula");
                } else {
                    URL url = new URL(ruta);
                    URLConnection conexion = url.openConnection();
                    InputStreamReader isr = new InputStreamReader(conexion.getInputStream());
                    return LeerArchivo((Reader)isr);
                }
            } catch (Exception var4) {
                System.out.println("No hay conexion a internet, la base de datos no pudo ser cargada");
                System.exit(0);
                return "";
            }
        }

        public static String LeerArchivo(Reader reader) throws Exception {
            BufferedReader br = new BufferedReader(reader);
            String texto = "";

            String linea;
            for(boolean primerRenglon = true; (linea = br.readLine()) != null; texto = texto + linea) {
                if (primerRenglon) {
                    primerRenglon = false;
                } else {
                    texto = texto + "\n";
                }
            }

            reader.close();
            br.close();
            return texto;
        }

        private void jButton1ActionPerformed(ActionEvent evt) {
            this.escogerRespuesta(0);
        }

        private void jButton2ActionPerformed(ActionEvent evt) {
            this.escogerRespuesta(1);
        }

        private void jButton4ActionPerformed(ActionEvent evt) {
            this.escogerRespuesta(2);
        }

        private void jButton3ActionPerformed(ActionEvent evt) {
            this.escogerRespuesta(3);
        }

        public static void main(String[] args) {
            new JuegoDePreguntasScalo();
        }

        static {
            textoBaseDePreguntas = LeerArchivo(urlBD);
            renglones = textoBaseDePreguntas.split("\n");
            cantidadDePreguntas = renglones.length;
            baseDePreguntas = new String[cantidadDePreguntas][renglones.length];
            cont = 0;
        }
    }