package Draughts;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {

    JMenu fileMenu;
    JMenuItem item=null;
    private final File file = new File("Draughts/PlayerFiles/GUI.data");

    public GUI(){
        super("Draughts");

        Container pane = getContentPane();
        pane.setBackground(new Color(255, 255, 255));

        createFileMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);

        ImageIcon icon = new ImageIcon("Draughts/Draughts.jpg");
        setIconImage(icon.getImage());

        setSize(800,800 );
        setVisible(true);
    }

    public static void main( String[] args ) {
        GUI frame = new GUI();
    }

    private void createFileMenu(){

        fileMenu = new JMenu("File");

        String itemNames[] = {"New Game","Open Game","Save Game","Quit Game"};

        for(int i=0;i<itemNames.length;i++){
            item = new JMenuItem(itemNames[i]);
            item.addActionListener(this);

            if(i==3)
                fileMenu.addSeparator();

            fileMenu.add(item);
        }
    }


    public void actionPerformed(ActionEvent e) {

        int choice;

        if(e.getActionCommand().equals("New Game")) {
            createFile();
        }
        else if(e.getActionCommand().equals("Open Game")) {
            openFile();
        }
        else if(e.getActionCommand().equals("Save Game")) {
            saveFile();
        }
        else if(e.getActionCommand().equals("Quit Game")) {
            choice = JOptionPane.showConfirmDialog(null, "Are you sure you wish to quit the game?",
                    "Exiting Application", JOptionPane.YES_NO_CANCEL_OPTION);

            if(choice==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null,"Saving the file that stores the game details before terminating",
                        "Saving File",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

        }
    }

    public void createFile() {

        if(!file.exists()) //if the file doesn't already exist, create it
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                JOptionPane.showMessageDialog(null, "Created a new file to store the game details!",
                        "New File", JOptionPane.INFORMATION_MESSAGE);
                fileOutputStream.close();
            } catch (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
                JOptionPane.showMessageDialog(null, "File could not be found!",
                        "Problem Finding File!", JOptionPane.ERROR_MESSAGE);
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null, "File could not be opened!",
                        "Problem Opening the File!", JOptionPane.ERROR_MESSAGE);
            }

        else
            JOptionPane.showMessageDialog(null, "File to store the game details already exists!",
                    "New File", JOptionPane.WARNING_MESSAGE);
    }

    public void openFile() {

        ObjectInputStream objectInputStream=null;

        if(!file.exists())
            createFile();
        else {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);

                if(file.length()!= 0){
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    JOptionPane.showMessageDialog(null, "Opened the file that stores the game details",
                            "Opened File", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null, "Can't read file as it is empty!",
                            "Empty File", JOptionPane.ERROR_MESSAGE);
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null, "File could not be opened!",
                        "Problem Opening the File!", JOptionPane.ERROR_MESSAGE);
            }

            if(objectInputStream==null)
                return;

            try{
                ArrayList<Player> allPlayers = null;

                allPlayers = (ArrayList<Player>) objectInputStream.readObject();

                System.out.println(allPlayers);

                String bikeData="";

                if(allPlayers!=null)
                    for(Player bike: allPlayers)
                        bikeData+=bike + "\n";

                objectInputStream.close();

                JOptionPane.showMessageDialog(null, "Details of players read from file are:\n\n" + bikeData,
                        "Opened File", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null, "File could not be read!",
                        "Problem Reading From File!", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
                JOptionPane.showMessageDialog(null, "Could not find the appropriate class!",
                        "Problem Finding the Class!", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void saveFile() {
        if (!file.exists())
            createFile();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            String name = "";

            name = JOptionPane.showInputDialog("Please enter the name of player 1.");
            Validator.isValidName(name);
            if (Validator.isValidName(name) == false){
                while (!Validator.isValidName(name) == false){
                    name = JOptionPane.showInputDialog("Please enter the name of player 1.");
                }
            }
            Player pl1 = new Player(name,"black", false);
            name = JOptionPane.showInputDialog("Please enter the name of player 2.");
            Validator.isValidName(name);
            if (Validator.isValidName(name) == false){
                while (!Validator.isValidName(name) == false){
                    name = JOptionPane.showInputDialog("Please enter the name of player 2.");
                }
            }
            Player pl2 = new Player(name,"black", false);
            ArrayList<Player> allPlayers = new ArrayList<>();
            allPlayers.add(pl1);
            allPlayers.add(pl2);
            objectOutputStream.writeObject(allPlayers);

            ArrayList<Piece> allPieces = new ArrayList<>();
            ArrayList<Piece> allBlackPieces = new ArrayList<>();
            ArrayList<Piece> allBrownPieces = new ArrayList<>();
            Piece.getAllPieces(allPieces);
            Piece.getAllBlackPieces(allBlackPieces);
            Piece.getAllBrownPieces(allBrownPieces);
            objectOutputStream.writeObject(allPieces);
            objectOutputStream.writeObject(allBlackPieces);
            objectOutputStream.writeObject(allBrownPieces);

            objectOutputStream.close();
            JOptionPane.showMessageDialog(null, "Saved the file that stores game details",
                    "Saved File", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getStackTrace());
            JOptionPane.showMessageDialog(null, "File could not be found!",
                    "Problem Finding File!", JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException ioe) {
            System.out.println(ioe.getStackTrace());
            JOptionPane.showMessageDialog(null, "File could not be written!",
                    "Problem Writing to File!", JOptionPane.ERROR_MESSAGE);
        }
    }

}
