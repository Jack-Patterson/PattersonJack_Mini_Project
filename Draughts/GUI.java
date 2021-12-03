package Draughts;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {

    private JMenu fileMenu;
    private JMenuItem item=null;
    private final File file = new File("Draughts/GUI.data");
    private JFrame frame = new JFrame();
    public static Piece selectedPiece=null;
    ArrayList<Piece> allPieces = new ArrayList<Piece>();
    Point point = new Point();
    ArrayList <Player> allPlayers = new ArrayList<Player>();
    int isBlack;
    Player pl1 = new Player();
    Player pl2 = new Player();
    Player player = new Player();


    // GUI won't do exactly as I want in regards to things such as not moving if it's an invalid move, so I've implemented methods
    // where I can and have set up code how I think it would go if it worked.
    public GUI(){
        //Piece.getAllPieces(allPieces); //commented out by JB to prevent logical errors in drawing of board
        createFileMenu();

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Icon
        ImageIcon icon = new ImageIcon("Draughts/Images/Draughts.jpg");
        frame.setIconImage(icon.getImage());

        // Set Frame Basics
        frame.setBounds(10, 10, 525, 570);
        frame.setTitle("Draughts Game - Jack Patterson Mini Project");



        //frame.setVisible(true); //code moved by JB to end of constructor to ensure game board can
        //be seen on startup

            /* Making Draughts Board
        Title of Program: Chess Board
        Author: Screen Works/Khouiled
        Date Written: 6/3/21
        Source Version: V2 (Unknown exactly as V2 was uploaded on Google Drive, only V1 is on Github)
        Licence: The Unlicense (Given to public domain)
        Availability: https://www.youtube.com/watch?v=LivX1XKpSQA
                      V1: https://github.com/Khald64/ChessGame/
                      V2: https://drive.google.com/file/d/1W7QNxTbXuhz5D-MgQpRIiwK90R7by9B4/view
        Date Accessed: 29/11/21
        Modifications by Student:
        - Adjusted some  calculations for the new code to allow it to place the pieces correctly due to my different logic
        - Adjusted the mouse movements myself to allow it to pick it up correctly as their one did not work in my code.
        - Implemented multiple of my own methods into the sections.
        - Implemented some exceptions to avoid the program crashing.
        */

        initialisePieces(); //added by JB to prevent logical errors in drawing of board

        JPanel pn = new JPanel(){
            public void paint(Graphics g) {
                boolean white=true;


                // Creating Board
                for(int y= 0;y<8;y++){
                    for(int x= 0;x<8;x++){
                        if(white){
                            g.setColor(new Color(235,235, 208));
                        }
                        else{
                            g.setColor(new Color(165,42,42));
                        }
                        g.fillRect(x*64, y*64, 64, 64);
                        white=!white;
                    }
                    white=!white;
                }

                // Creating Pieces
                Image imgs[]=new Image[12];

                int ind = 0;
                try {
                    BufferedImage image = ImageIO.read(new File("Draughts/Images/blackdraught.png"));
                    imgs[0] = image;

                    BufferedImage image2 = ImageIO.read(new File("Draughts/Images/browndraught.png"));
                    imgs[1] = image2;
                }
                catch (IOException e) {
                }

                //Piece.getAllPieces(allPieces); //commented out by JB to prevent logical issue in drawing of board
                for(Piece p: allPieces){
                    if(p.getColour().equalsIgnoreCase("black")){
                        ind=0;
                    }
                    if(p.getColour().equalsIgnoreCase("brown")){
                        ind=1;
                    }
                    g.drawImage(imgs[ind], (p.getX() * 64)-64, (p.getY() * 64)-64, this);
                }
                /*try {
                    if (Piece.paintKing(selectedPiece) == true) {
                        if (selectedPiece.getColour().equalsIgnoreCase("Black")) {
                            BufferedImage imageKingB = ImageIO.read(new File("Draughts/Images/blackdraughtking.png"));
                            g.drawImage(imageKingB, (selectedPiece.getX() * 64) - 64, (selectedPiece.getY() * 64) - 64, this);
                        }
                        else if (selectedPiece.getColour().equalsIgnoreCase("Brown")) {
                            BufferedImage imageKingB = ImageIO.read(new File("Draughts/Images/browndraughtking.png"));
                            g.drawImage(imageKingB, (selectedPiece.getX() * 64) - 64, (selectedPiece.getY() * 64) - 64, this);
                        }
                    }
                }
                catch (IOException e){

                }*/
            }
        };

        frame.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                //if(selectedPiece!=null){
                try {
                    selectedPiece.x = e.getX() - 32;
                    selectedPiece.y = e.getY() - 32;
                    frame.repaint();
                }
                catch (NullPointerException npe){

                }
                //}
            }

            public void mouseMoved(MouseEvent e) {
            }
        });
        frame.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                try {
                    selectedPiece = Piece.getPiece(e.getX(),e.getY(),allPieces);
                    point = Point.lastPosition(e.getX(),e.getY());}
                catch (NullPointerException npe){

                }
            }

            public void mouseReleased(MouseEvent e) {
                try {
                    // Will give output but since I can't figure out how to make it jump back it's commented out.
                    // Validator.isValidMove(selectedPiece);
                    selectedPiece.move((e.getX()+64)/64, e.getY()/64, allPieces, allPlayers);
                }
                catch (NullPointerException npe){

                }
                    frame.repaint();
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
        // End

        frame.add(pn);
        frame.setVisible(true);
        frame.setResizable(false);

        if (!file.exists()) {
            saveFile();
        }
        else {
            openFile();
        }
    }

    //added by JB - takes the code from getPieces() to initialise each piece on the board
    //there was a logical issue with getPieces() as it was resetting the state of each piece to
    //their initial values each time it got called

    public void initialisePieces() {
        Piece pbr1 = new Piece(2, 1, "brown", false, false, true);
        Piece pbr2 = new Piece(2, 3, "brown", false, false, true);
        Piece pbr3 = new Piece(1, 2, "brown", false, false, true);
        Piece pbr4 = new Piece(4, 1, "brown", false, false, true);
        Piece pbr5 = new Piece(4, 3, "brown", false, false, true);
        Piece pbr6 = new Piece(3, 2, "brown", false, false, true);
        Piece pbr7 = new Piece(6, 1, "brown", false, false, true);
        Piece pbr8 = new Piece(6, 3, "brown", false, false, true);
        Piece pbr9 = new Piece(5, 2, "brown", false, false, true);
        Piece pbr10 = new Piece(8, 1, "brown", false, false, true);
        Piece pbr11 = new Piece(8, 3, "brown", false, false, true);
        Piece pbr12 = new Piece(7, 2, "brown", false, false, true);
        Piece pbl1 = new Piece(2, 7,  "black", false, false, true);
        Piece pbl2 = new Piece(1, 8,  "black", false, false, true);
        Piece pbl3 = new Piece(1, 6,  "black", false, false, true);
        Piece pbl4 = new Piece(4, 7,  "black", false, false, true);
        Piece pbl5 = new Piece(3, 8,  "black", false, false, true);
        Piece pbl6 = new Piece(3, 6,  "black", false, false, true);
        Piece pbl7 = new Piece(6, 7,  "black", false, false, true);
        Piece pbl8 = new Piece(5, 6,  "black", false, false, true);
        Piece pbl9 = new Piece(5, 8,  "black", false, false, true);
        Piece pbl10 = new Piece(8, 7, "black", false, false, true);
        Piece pbl11 = new Piece(7, 6, "black", false, false, true);
        Piece pbl12 = new Piece(7, 8, "black", false, false, true);
        allPieces.add(pbl1);
        allPieces.add(pbl2);
        allPieces.add(pbl3);
        allPieces.add(pbl4);
        allPieces.add(pbl5);
        allPieces.add(pbl6);
        allPieces.add(pbl7);
        allPieces.add(pbl8);
        allPieces.add(pbl9);
        allPieces.add(pbl10);
        allPieces.add(pbl11);
        allPieces.add(pbl12);
        allPieces.add(pbr1);
        allPieces.add(pbr2);
        allPieces.add(pbr3);
        allPieces.add(pbr4);
        allPieces.add(pbr5);
        allPieces.add(pbr6);
        allPieces.add(pbr7);
        allPieces.add(pbr8);
        allPieces.add(pbr9);
        allPieces.add(pbr10);
        allPieces.add(pbr11);
        allPieces.add(pbr12);
    }

    public static void main( String[] args ) {
        GUI gui = new GUI();
    }

    private void createFileMenu(){

        fileMenu = new JMenu("Game");

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
                //JB commented out the FileOutputStream stuff here and replaced with a call
                //to createNewFile() instead as a FilNotFoundException was being thrown at
                //startup time when no file yet existed

                //FileOutputStream fileOutputStream = new FileOutputStream(file);
                file.createNewFile();

                JOptionPane.showMessageDialog(null, "Created a new file to store the game details!",
                        "New File", JOptionPane.INFORMATION_MESSAGE);
                //fileOutputStream.close();
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

                String PlayerData="";

                if(allPlayers!=null)
                    for(Player pl: allPlayers) {
                        PlayerData += pl + "\n";
                        /*if (pl.isPlayerTurn() == true){
                            player.setPlayerName(player.getPlayerName());
                        }*/
                    }

                objectInputStream.close();

                JOptionPane.showMessageDialog(null, "Details of players read from file are:\n\n" + PlayerData + "\n"/* +
                        "The current players turn is: " + player.getPlayerName()*/,
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
            int isBlack;
            String colour = "";

            name = JOptionPane.showInputDialog("Please enter the name of player 1.");
            Validator.isValidName(name);
            if (Validator.isValidName(name) == false){
                while (!Validator.isValidName(name) == false){
                    name = JOptionPane.showInputDialog("Please enter the name of player 1.");
                }
            }
            isBlack = JOptionPane.showConfirmDialog(null,"Would player 1 like to be the colour black?\n(If YES Player 2 will be brown.)");
            if (isBlack == JOptionPane.YES_OPTION){
                colour = "black";
            }
            else if (isBlack == JOptionPane.NO_OPTION) {
                colour = "brown";
            }
            else {
                while (isBlack != JOptionPane.YES_OPTION || isBlack != JOptionPane.NO_OPTION){
                    isBlack = JOptionPane.showConfirmDialog(null,"Would player 1 like to be the colour black?\n(If YES Player 2 will be brown.)");
                    if (isBlack == JOptionPane.YES_OPTION){
                        colour = "black";
                    }
                    else if (isBlack == JOptionPane.NO_OPTION) {
                        colour = "brown";
                    }
                }
            }
            Player pl1 = new Player(name,colour);
            name = JOptionPane.showInputDialog("Please enter the name of player 2.");
            Validator.isValidName(name);
            if (Validator.isValidName(name) == false){
                while (!Validator.isValidName(name) == false){
                    name = JOptionPane.showInputDialog("Please enter the name of player 2.");
                }
            }
            if (isBlack == JOptionPane.YES_OPTION){
                colour = "brown";
            }
            else if (isBlack == JOptionPane.NO_OPTION) {
                colour = "black";
            }
            Player pl2 = new Player(name,colour);
            allPlayers.add(pl1);
            allPlayers.add(pl2);
            objectOutputStream.writeObject(allPlayers);

            ArrayList<Piece> allBlackPieces = new ArrayList<>();
            ArrayList<Piece> allBrownPieces = new ArrayList<>();
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