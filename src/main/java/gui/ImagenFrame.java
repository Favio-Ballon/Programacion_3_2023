package gui;

import obj.ComandoFiltro;
import obj.Imagen;
import obj.filtros.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class ImagenFrame extends JFrame {
    private static Logger logger = LogManager.getRootLogger();
    private Imagen modelo;
    public ImagenFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Imagen(600,400);
        ImagenPanel panel = new ImagenPanel(modelo);
        modelo.addObserver(panel);
        this.getContentPane().add(panel, BorderLayout.CENTER);

        menu();

        Dimension screeSize = Toolkit.getDefaultToolkit().getScreenSize();
        setMaximumSize(screeSize);
        this.pack();
        this.setVisible(true);
    }

    private void menu() {
        JMenuBar bar = new JMenuBar();
        //Menu para seleccionar imagen
        JMenu menu = new JMenu("Archivo");

        //se elige imagen
        JMenuItem item = new JMenuItem("Abrir");
        item.addActionListener(e -> {
            menuArchivoItemAbrir();
        });
        menu.add(item);

        menu.addSeparator();

        //Se quita la imagen
        item = new JMenuItem("Reset imagen");
        item.addActionListener(e -> {
            logger.info("El usuario quita la imagen");
            modelo.resetImagen();
        });
        menu.add(item);

        //Se sale del programa
        item = new JMenuItem("Salir");
        item.addActionListener(e -> {
            logger.info("El usuario sale del programa");
            System.exit(0);
        });
        menu.add(item);

        bar.add(menu);

        //Menu de Imagen
        menu = new JMenu("Imagen");

        //Se quita el filtro a la imagen
        item = new JMenuItem("Reset filtro");
        item.addActionListener(e -> {
            logger.info("El usuario quita el filtro a la imagen");
            modelo.resetFiltro();
        });
        menu.add(item);
        menu.addSeparator();

        //Filtro  Flip Horizontal
        item = new JMenuItem("Flip Horizontal");
        item.addActionListener(e -> {
            logger.info("El usuario invierte la imagen horizontalmente");
            ComandoFiltro cmd = new FlipHorizontal(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        //Filtro  Flip Vertical
        item = new JMenuItem("Flip Vertical");
        item.addActionListener(e -> {
            logger.info("El usuario invierte la imagen verticalmente");
            ComandoFiltro cmd = new FlipVertical(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        //Filtro Floyd steinberg
        item = new JMenuItem("Floyd Steinberg");
        item.addActionListener(e -> {
            logger.info("El usuario Convierte la imagen a floyd steinberg");
            ComandoFiltro cmd = new FloydSteinberg(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        //Filtro Gris
        item = new JMenuItem("Gris");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen a escala de grises");
            ComandoFiltro cmd = new Gris(modelo);
            cmd.ejecutar();
        });
        menu.add(item);


        //Filtro Rojo
        item = new JMenuItem("rojo");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen a escala de rojo");
            ComandoFiltro cmd = new Rojo(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        //Filtro Verde
        item = new JMenuItem("Verde");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen a escala de Verde");
            ComandoFiltro cmd = new Verde(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        //Filtro Azul
        item = new JMenuItem("Azul");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen a escala de azul");
            ComandoFiltro cmd = new Azul(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        //Filtro Ruido sal y pimienta
        item = new JMenuItem("Ruido");
        item.addActionListener(e -> {
            logger.info("El usuario le agrega ruido a la imagen");
            ComandoFiltro cmd = new Ruido(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        bar.add(menu);

        this.setJMenuBar(bar);
    }

    private void menuArchivoItemAbrir() {
        logger.info("Abrimos el file chooser para escoger un archivo");
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            logger.info(chooser.getSelectedFile().getAbsolutePath());
            modelo.leer(chooser.getSelectedFile());
        }
        this.pack();
    }

    public static void main(String[] args) {
        ImagenFrame obj = new ImagenFrame();
    }
}
