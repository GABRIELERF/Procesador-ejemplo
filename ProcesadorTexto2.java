/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos.Proyectos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.ToolBar;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Gabriel
 */
public class ProcesadorTexto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MarcoProcesador2 marco_procesador2 = new MarcoProcesador2();
        marco_procesador2.paintAll(marco_procesador2.getGraphics());

    }

}

class MarcoProcesador2 extends JFrame {

    public MarcoProcesador2() {

        setBounds(500, 300, 550, 400);
        setTitle("Procesador de texto 2");
        add(new PanelProcesador2());
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
//CLASE PARA QUE CREA EL PANEL QUE VA DENTRO DEL MARCO Y CREA LOS MENUS

class PanelProcesador2 extends JPanel {
    // Crea los atributos 

    JTextPane area_trabajo;
    JMenu fuente, estilo, tamagno;
    Font letras;
    JButton negrita_barra, cursiva_barra, subrayado_barra, rojo_barra, azul_barra, verde_barra, izquierda_barra, centrado_barra, derecha_barra, justificado_barra;
    JToolBar barra_procesador;

    //CONTRUCTOR DE LA CLASE PANELPROCESADOR2
    public PanelProcesador2() {

        setLayout(new BorderLayout());
        JPanel PanelMenu = new JPanel();

        JMenuBar barra = new JMenuBar();
        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamagno = new JMenu("Tamaño");

        barra.add(fuente);
        barra.add(estilo);
        barra.add(tamagno);
        PanelMenu.add(barra);
        add(PanelMenu, BorderLayout.NORTH);
        //Crea botones de fuente
        configuraMenu("Arial", "fuente", "Arial", 9, 10);
        configuraMenu("Calibri", "fuente", "Calibri", 9, 10);
        configuraMenu("Verdana", "fuente", "Verdana", 9, 10);
        //Crea los botoens de estilo
        //configuraMenu("Negrita", "estilo", "", Font.BOLD, 1);
        //configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1);
        //configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1);
        JMenuItem negrita = new JMenuItem("Negrita");
        JMenuItem cursiva = new JMenuItem("Cursivva");

        negrita.addActionListener(new StyledEditorKit.BoldAction());
        cursiva.addActionListener(new StyledEditorKit.ItalicAction());

        estilo.add(negrita);
        estilo.add(cursiva);

        //crea los botones de tamaño
        ButtonGroup tam_letra = new ButtonGroup();
        JRadioButton tam12 = new JRadioButton("12");
        JRadioButton tam14 = new JRadioButton("14");
        JRadioButton tam16 = new JRadioButton("16");
        JRadioButton tam18 = new JRadioButton("18");

        tam_letra.add(tam12);
        tam_letra.add(tam14);
        tam_letra.add(tam16);
        tam_letra.add(tam18);

        tam12.addActionListener(new StyledEditorKit.FontSizeAction("cambiatamaño", 12));
        tam14.addActionListener(new StyledEditorKit.FontSizeAction("cambiatamaño", 14));
        tam16.addActionListener(new StyledEditorKit.FontSizeAction("cambiatamaño", 16));
        tam18.addActionListener(new StyledEditorKit.FontSizeAction("cambiatamaño", 18));

        tamagno.add(tam12);
        tamagno.add(tam14);
        tamagno.add(tam16);
        tamagno.add(tam18);
        area_trabajo = new JTextPane();
        add(area_trabajo, BorderLayout.CENTER);

        JPopupMenu emergente = new JPopupMenu();
        JMenuItem negritra_e = new JMenuItem("Negrita");
        JMenuItem cursiva_e = new JMenuItem("Cursiva");

        negritra_e.addActionListener(new StyledEditorKit.BoldAction());
        cursiva_e.addActionListener(new StyledEditorKit.ItalicAction());
        emergente.add(negritra_e);
        emergente.add(cursiva_e);

        area_trabajo.setComponentPopupMenu(emergente);
        barra_procesador = new JToolBar();
        //Agrega los botones de estilos
        configuraToolBar("N").addActionListener(new StyledEditorKit.BoldAction());
        configuraToolBar("K").addActionListener(new StyledEditorKit.ItalicAction());
        configuraToolBar("S").addActionListener(new StyledEditorKit.UnderlineAction());
        
        //Separador
        barra_procesador.addSeparator();
        //Configura los botones de alineacion
        configuraToolBar(" I").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
        configuraToolBar("C").addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
        configuraToolBar("D").addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
        configuraToolBar("J").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 3));

        barra_procesador.setOrientation(1);
        add(barra_procesador, BorderLayout.WEST);

    }

    //CREA LOS BOTONES DE LA BARRA PRINCIPAL
    public void configuraMenu(String rotulo, String menu, String tipo_letra, int estilos, int tam) {

        JMenuItem elem_menu = new JMenuItem(rotulo);
        if (menu == "fuente") {
            fuente.add(elem_menu);
            elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambialetra", tipo_letra));

        }

    }

    public JButton configuraToolBar(String nombre) {

        JButton boton = new JButton(nombre);
        barra_procesador.add(boton);

        return boton;
    }
}
