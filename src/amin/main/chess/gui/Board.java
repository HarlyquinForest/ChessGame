package amin.main.chess.gui;

import amin.main.chess.Board.Side;
import amin.main.chess.Pieces.Piece;
import amin.main.chess.Pieces.PieceColor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Board extends JPanel implements MouseListener , MouseMotionListener {

    private  Square[][] board ;
    private Square selectedSquare ;
    private final Game game ;
    private final char[] alphabet = new char[]{'a','b','c','d','e','f','g','h'};
    public Board(Game g){
        board = new Square[8][8];
        game = g;
        setLayout(new GridLayout(8,8,0,0));
        setBorder(BorderFactory.createEmptyBorder(50,10,10,10));

        addMouseListener(this);
        addMouseMotionListener(this);

        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0 ; j < 8; j++){
                int xMod = i % 2 ;
                int yMOd = j % 2 ;
                if(colorChoosingCondition(xMod , yMOd)){
                    board[i][j] = createSquare(i , j ,PieceColor.WHITE);
                    add(board[i][j]);
                    continue;
                }
                board[i][j] = createSquare(i , j ,PieceColor.BLACK);
                add(board[i][j]);
            }
        }
        loadNewGamePieces();
        Dimension d = new Dimension(800,800);
        setPreferredSize(d);
        setMaximumSize(d);
        setSize(d);
    }

    private Square createSquare(int i , int j , PieceColor c){
        if(i == 7)
            return new Square(c , i , j , alphabet[j]+"");
        else if(j == 7)
            return new Square(c , i,j, (8-i)+"");
        return new Square(c,i,j,"");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void loadNewGamePieces(){
        game.initialBoard(board);
    }

    private boolean colorChoosingCondition(int x , int y ){
        return (x == 0 && y == 0) || (x == 1 && y == 1);
    }

    public Square[][] getBoard(){
        return board;
    }
    public void setBoard(Square[][] board){
        this.board = board;
    }
    private void setSelectedSquare(Square s){
        if(selectedSquare != null)
            selectedSquare.unsetSelected();
        selectedSquare = s;
        s.setSelected();

    }
    public Square getSquare(int i , int j ){
        return board[i][j];
    }
    public void displayLegalMoves(ArrayList<Square> legals){
        for(Square p:legals){
            p.setColor(Colors.POSSIBLE);
            if(p.isOccupied())
                if(p.getOccupyingPiece().getColor() != selectedSquare.getOccupyingPiece().getColor())
                    p.setColor(Colors.HIT);
        }
    }
    private void clearLegalMoves(){
        for(Square[] p:board)
            for(Square a:p)
            a.setColor(a.getDefaultColor());
    }
    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        ArrayList<Square> leg;
        Point clickPoint = e.getPoint();
        Square s = (Square) getComponentAt(clickPoint);
        if(!s.isOccupied()) {
            leg = selectedSquare.getOccupyingPiece().getLegalMoves(selectedSquare , this);
            if(selectedSquare != null  && isSquareInLegalMoves(leg , s)) {
                s.setOccupyingPiece(selectedSquare.getOccupyingPiece());
                selectedSquare.setOccupyingPiece(null);
                game.changeTurn();
            }
        }
        clearLegalMoves();
        if(s.isOccupied())
        {
            if(s.getOccupyingPiece().getColor() != game.whichSideTurn().getColor())
                return;
            setSelectedSquare(s);
            Piece p = s.getOccupyingPiece();
            leg = p.getLegalMoves(s , this);
            displayLegalMoves(leg);
        }
    }
    private boolean isSquareInLegalMoves(ArrayList<Square> s , Square ss){
        for(Square p:s)
            if(p.equals(ss))
                return true;
        return false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

