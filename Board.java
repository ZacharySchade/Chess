import javax.swing.*;
import java.awt.*;
import java.io.*;

//  FALSE == BLACK PIECE, TRUE == WHITE PIECE
//  For now, click the piece, then click the space. We can add drag stuff later. 

public class Board extends JFrame {
    static Container win;
    static Color color1 = Color.decode("#61492f");
    static Color color2 = Color.decode("#d4bca3");

    public Board() {
        super("Chess");
        win = getContentPane();
        win.setLayout(new BorderLayout()); // would gridbaglayout work?

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(8, 8)); 

        win.add(p2, BorderLayout.WEST);
        win.add(p1, BorderLayout.CENTER);

        boolean lastWhite = false; 
        JPanel panel;
        for (int x = 0; x < 64; x++)
        {
            if (x%8==0)
                lastWhite = !lastWhite;
            panel = new JPanel();
            if (game[x] != null)
                panel.add(new JLabel(game[x].getImage()));
            if (lastWhite)
            {
                panel.setBackground(color2);
                lastWhite = false;
            }
            else   
            {
                panel.setBackground(color1);
                lastWhite = true;
            }
            p1.add(panel);
        }

        setSize(800, 800);
        setVisible(true);
    }

    static Piece[] game = Piece.game;
    public static void main(String[] args) {
        setUpBoard();
        new Board();
    }

    // this method initializes the pieces in their correct positions to begin the game
    public static void setUpBoard()
    {
        for(int x=0 ; x < 8; x++) // pawns
        {
            game[x + Piece.down()] = new Pawn(x + Piece.down(), false); // second row filled with black pawns
            game[x + Piece.down(6)] = new Pawn(x + Piece.down(6), true);// seventh row filled with white pawns
        }
        for (int x=0; x<8; x+=7) // rooks
        {
            game[x] = new Rook(x, false); // space 0 and 7 are black rooks
            game[x + Piece.down(7)] = new Rook(x + Piece.down(7), true); // down 7 rows are white rooks
        }
        for(int x = 1; x < 7; x+=5) //knights
        {
            game[x] = new Knight(x, false); // spaces 1 and 6 are black knights
            game[x + Piece.down(7)] = new Knight(x + Piece.down(7), true); // down 7 rows are white knights
        }
        for(int x = 2; x < 6; x+=3) // bishops
        {
            game[x] = new Bishop(x, false); // spaces 2 and 5 are black bishiops
            game[x + Piece.down(7)] = new Bishop(x + Piece.down(7), true); // down 7 rows are white bishops
        }
        //queens
        game[3] = new Queen(3, false); // space 3 is the black queen
        game[3 + Piece.down(7)] = new Queen(3 + Piece.down(7), true); //down 7 rows is the white queen
        //kings
        game[4] = new King(4, false); // space 4 is the black king
        game[4 + Piece.down(7)] = new King(4 + Piece.down(0), true); // down 7 rows is the white king
    }
/* 
    public static void displayPeices() {
        BufferedImage peices = ImageIO.read("pieces.png");
    } */
}