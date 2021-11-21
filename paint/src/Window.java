import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Window extends JFrame {
    private Drawing draw;
    public Window(String Title,int x,int y){
        super(Title);
        this.setSize(x,y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container contentPanel = this.getContentPane() ;
        JPanel southPanel = new JPanel();
        contentPanel.add(southPanel,"South");


        JPanel color = new JPanel();
        color.setLayout(new GridLayout(2,4));
        JButton noir= new JButton("Noir");
        noir.setBackground(Color.black);
        noir.setForeground(Color.white);
        JButton rouge= new JButton("Rouge");
        rouge.setBackground(Color.red);
        JButton vert= new JButton("Vert");
        vert.setBackground(Color.green);
        JButton bleu= new JButton("Bleu");
        bleu.setBackground(Color.blue);
        bleu.setForeground(Color.white);
        JButton jaune= new JButton("Jaune");
        jaune.setBackground(Color.yellow);
        JButton rose= new JButton("Rose");
        rose.setBackground(Color.pink);
        JButton magenta= new JButton("Magenta");
        magenta.setBackground(Color.magenta);
        JButton orange= new JButton("Orange");
        orange.setBackground(Color.orange);
        color.add(noir);
        noir.addActionListener(this::actionPerformed);
        color.add(rouge);
        rouge.addActionListener(this::actionPerformed);
        color.add(vert);
        vert.addActionListener(this::actionPerformed);
        color.add(bleu);
        bleu.addActionListener(this::actionPerformed);
        color.add(jaune);
        jaune.addActionListener(this::actionPerformed);
        color.add(rose);
        rose.addActionListener(this::actionPerformed);
        color.add(magenta);
        magenta.addActionListener(this::actionPerformed);
        color.add(orange);
        orange.addActionListener(this::actionPerformed);

        JPanel figure = new JPanel();
        figure.setLayout(new GridLayout(2,3));
        JButton ellipse= new JButton("Ellipse");
        JButton cercle= new JButton("Cercle");
        JButton rectangle= new JButton("Rectangle");
        JButton carre= new JButton("Carré");
        JButton rempli= new JButton("Rempli");
        rempli.setBackground(Color.black);
        rempli.setForeground(Color.white);
        JButton vide= new JButton("Vide");
        vide.setBackground(Color.black);
        vide.setForeground(Color.white);
        figure.add(ellipse);
        ellipse.addActionListener(this::actionPerformed);
        figure.add(cercle);
        cercle.addActionListener(this::actionPerformed);
        figure.add(rempli);
        rempli.addActionListener(this::actionPerformed);
        figure.add(rectangle);
        rectangle.addActionListener(this::actionPerformed);
        figure.add(carre);
        carre.addActionListener(this::actionPerformed);
        figure.add(vide);
        vide.addActionListener(this::actionPerformed);

        southPanel.add(color,"West");
        this.setVisible(true);
        southPanel.add(figure,"East");
        this.setVisible(true);


        JMenuBar m= new JMenuBar();

        JMenu menu1= new JMenu("File");
        JMenuItem open = new JMenuItem("Open") ;
        JMenuItem nw = new JMenuItem(("New"));
        JMenuItem save = new JMenuItem(("Save"));
        JMenuItem undo = new JMenuItem(("Undo"));
        JMenuItem quit = new JMenuItem(("Quit"));
        menu1.add(nw);
        undo.addActionListener(this::actionPerformed);
        menu1.add(undo);
        nw.addActionListener(this::actionPerformed);
        menu1.add(open);
        open.addActionListener(this::actionPerformed);
        menu1.add(save);
        save.addActionListener(this::actionPerformed);
        menu1.add(quit);
        quit.addActionListener(this::actionPerformed);
        m.add(menu1);
        JMenu menu2=new JMenu("A propos");
        JMenuItem author=new JMenuItem("Author");
        menu2.add(author);
        author.addActionListener(this::actionPerformed);
        m.add(menu2);
        menu2.addActionListener(this::actionPerformed);
        this.setJMenuBar(m);
        this.setVisible(true);
        draw=new Drawing();
        contentPanel.add(draw);
    }
    JOptionPane info = new JOptionPane();

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Author" -> JOptionPane.showInternalMessageDialog( info, "Author : Thibaut LEFEBVRE",
                    "information",JOptionPane.INFORMATION_MESSAGE);
            case "Quit" -> System.exit(0);
            case "New" -> {
                this.setVisible(false);
                new Window("Paint",800,600);
            }
            case "Undo" -> draw.undo();
            case "Save" -> draw.saveDrawing();
            case "Open" -> draw.recallDrawing();
            case "Ellipse" -> Drawing.setNameFigure("Ellipse");
            case "Rectangle" -> Drawing.setNameFigure("Rectangle");
            case "Carré" -> Drawing.setNameFigure("Carre");
            case "Cercle" -> Drawing.setNameFigure("Circle");
            case "Rempli" -> Figure.setFilled(1);
            case "Vide" -> Figure.setFilled(0);
            case "Bleu" -> Drawing.setColor(Color.blue);
            case "Noir" -> Drawing.setColor(Color.black);
            case "Rouge" -> Drawing.setColor(Color.red);
            case "Jaune" -> Drawing.setColor(Color.yellow);
            case "Vert" -> Drawing.setColor(Color.green);
            case "Orange" -> Drawing.setColor(Color.orange);
            case "Rose" -> Drawing.setColor(Color.pink);
            case "Magenta" -> Drawing.setColor(Color.magenta);
        }
    }
}