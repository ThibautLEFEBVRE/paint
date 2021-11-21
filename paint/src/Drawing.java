import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.util.ArrayList;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener {
    public static Color c;
    public static String nameFigure;
    public int x;
    public int y;
    public ArrayList<Figure> list= new ArrayList<Figure>();

    public static void setColor(Color color) {
        c = color;
    }

    public static void setNameFigure(String figure) {
        nameFigure=figure;
    }

    public ArrayList<Figure> getList() {
        return list;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Figure f : list){
            f.draw(g);
        }
    }
    public Drawing(){
        addMouseListener(this);
        this.setBackground(Color.white);
        nameFigure = "Rectangle";
        c = Color.BLACK;
        x = 0;
        y = 0;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x= e.getX();
        y=e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent ev) {
        int mouseX=ev.getX();
        int mouseY=ev.getY();
        Point start =new Point();
        if(x<mouseX & y<mouseY) {
            start= new Point(x, y);
        }
        if(x<mouseX & y>mouseY) {
            start = new Point(x, mouseY);
        }
        if(x>mouseX & y<mouseY) {
            start = new Point(mouseX, y);
        }
        if(x>mouseX & y>mouseY) {
            start = new Point(mouseX, mouseY);
        }
        paintComponent(getGraphics());
        switch(nameFigure) {
            case "Rectangle" -> {
                Rectangle r = new Rectangle(start, c);
                r.setBoundingBox(Math.abs(mouseX - x), Math.abs(mouseY - y));
                r.draw(getGraphics());
                list.add(r);
            }
            case "Ellipse" -> {
                Ellipse e = new Ellipse(start,c);
                e.setBoundingBox(Math.abs(mouseX - x), Math.abs(mouseY - y));
                e.draw(getGraphics());
                list.add(e);
            }
            case "Carre" -> {
                Square s = new Square(start,c);
                s.setBoundingBox(Math.abs(mouseX - x), Math.abs(mouseY - y));
                s.draw(getGraphics());
                list.add(s);
            }
            case "Circle" -> {
                Circle ci = new Circle(start,c);
                ci.setBoundingBox(Math.abs(mouseX - x), Math.abs(mouseY - y));
                ci.draw(getGraphics());
                list.add(ci);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void reset() {
        this.getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void recallDrawing(){
        try {
            JFileChooser dialogue = new JFileChooser(new File(".").getCanonicalFile());
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".des", "des");
            dialogue.setFileFilter(filter);
            dialogue.addChoosableFileFilter(filter);
            dialogue.setAcceptAllFileFilterUsed(false);
            dialogue.showOpenDialog(null);
            if(dialogue.getSelectedFile() == null)
                return;
            File file = dialogue.getSelectedFile();
            list.clear();
            InputStream inputStream = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(inputStream);

            int size = input.readInt();
            for(int i=0;i<size;i++){
                list.add((Figure)input.readObject());
            }
            input.close();
            reset();
            paintComponent(getGraphics());
        } catch(Exception e) {
            JOptionPane info = new JOptionPane();
            JOptionPane.showMessageDialog(info, "Problème lors de la lecture du fichier", "Error", JOptionPane.OK_OPTION);
        }
    }
    public void saveDrawing() {
            try {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File(".").getCanonicalFile());
                int retrieval = chooser.showSaveDialog(null);
                File file = new File("");
                boolean flag = false;

                if (retrieval == JFileChooser.APPROVE_OPTION) {
                    if(chooser.getSelectedFile().getName().length() > 3) {
                        String c = chooser.getSelectedFile().getName();
                        int i = c.length();
                        if(c.substring(i-4, i).compareTo(".des") == 0) {
                            file = new File(c);
                            flag = true;
                        }
                    }
                }
                if(!flag) {
                    file = new File(chooser.getSelectedFile()+".des");
                }

                if(!file.exists()) {
                    file.createNewFile();
                } else {
                    JOptionPane info = new JOptionPane();
                    if(JOptionPane.showInternalConfirmDialog(info, "Superior l'ancien fichier ?", "Attention", JOptionPane.YES_NO_OPTION) == 1) {
                        return;
                    }
                }
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeInt(list.size());
            for(Figure f : list)
                oos.writeObject(f);
            oos.close();
        } catch (Exception e) {
            JOptionPane info = new JOptionPane();
            JOptionPane.showMessageDialog(info, "Problem", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void undo(){
        if(list.size() == 0) return;
        list.remove(list.size()-1);
        reset();
        paintComponent(getGraphics());
    }


    @Override
    public void mouseDragged(MouseEvent ev) {
        int mouseX=ev.getX();
        int mouseY=ev.getY();
        Point start =new Point();
        if(x<mouseX & y<mouseY) {
            start= new Point(x, y);
        }
        if(x<mouseX & y>mouseY) {
            start = new Point(x, mouseY);
        }
        if(x>mouseX & y<mouseY) {
            start = new Point(mouseX, y);
        }
        if(x>mouseX & y>mouseY) {
            start = new Point(mouseX, mouseY);
        }
        paintComponent(getGraphics());
        switch(nameFigure) {
            case "Rectangle" -> {
                Rectangle r = new Rectangle(start, c);
                r.setBoundingBox(Math.abs(mouseX - x), Math.abs(mouseY - y));
                r.draw(getGraphics());
                list.add(r);
            }
            case "Ellipse" -> {
                Ellipse e = new Ellipse(start,c);
                e.setBoundingBox(Math.abs(mouseX - x), Math.abs(mouseY - y));
                e.draw(getGraphics());
                list.add(e);
            }
            case "Carre" -> {
                Square s = new Square(start,c);
                s.setBoundingBox(Math.abs(mouseX - x), Math.abs(mouseY - y));
                s.draw(getGraphics());
                list.add(s);
            }
            case "Circle" -> {
                Circle ci = new Circle(start,c);
                ci.setBoundingBox(Math.abs(mouseX - x), Math.abs(mouseY - y));
                ci.draw(getGraphics());
                list.add(ci);
            }
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent ev) {
    }



}