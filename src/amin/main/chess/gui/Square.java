package amin.main.chess.gui;

import amin.main.chess.Pieces.Piece;
import amin.main.chess.Pieces.PieceColor;

import javax.swing.*;
import java.awt.*;

public class Square extends JComponent {
    private Piece occupyingPiece ;
    private boolean displayPiece ;
    private final PieceColor pieceColor ;
    private Color color ;
    private final Color defaultColor;
    private boolean selected ;
    private final String name;

    private final int XLocation;
    private final int YLocation;

    public Square(PieceColor c , int x , int y , String name ){
        pieceColor = c ;
        if(pieceColor == PieceColor.BLACK)
            color = Colors.WHITE;
        else
            color = Colors.BLACK;
        defaultColor = color;
        XLocation = x;
        YLocation = y;
        this.name = name ;
        this.setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.setFont(new Font("Monospace" , Font.BOLD , 20));
        g.setColor(color);
        g.fillRect(0 , 0 , this.getWidth() , this.getHeight());
        if(name != "") {
            g.setColor(new Color(208, 208, 208, 203));
            if(XLocation == 7)
                g.drawString(name, 5, 85);
            else if(YLocation == 7)
                g.drawString(name, 85, 85);
        }
        if(occupyingPiece != null && displayPiece)
            occupyingPiece.draw(g);
    }

    @Override
    public String toString() {
        return "Selected Square{" +
                "color="+color+"} "+
                "occupyingPiece=" + occupyingPiece.toString() +
                '}';
    }

    public Piece getOccupyingPiece() {
        return occupyingPiece;
    }

    public void setOccupyingPiece(Piece occupyingPiece) {
        this.occupyingPiece = occupyingPiece;
        setDisplayPiece(true);
    }

    public boolean isDisplayPiece() {
        return displayPiece;
    }
    public boolean isOccupied(){
        return isDisplayPiece() && getOccupyingPiece() != null;
    }

    public void setDisplayPiece(boolean displayPiece) {
        this.displayPiece = displayPiece;
    }

    public PieceColor getColor() {
        return pieceColor;
    }

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }
    public int getXNum(){
        return XLocation;
    }
    public int getYNum(){
        return YLocation;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected() {
        this.selected = true;
        this.color = Colors.SELECTED;
        repaint();

    }
    public void unsetSelected(){
        this.selected = false;
        if(pieceColor == PieceColor.BLACK)
            this.color = Colors.WHITE;
        else
            this.color = Colors.BLACK;
        repaint();
    }

    public Color getDefaultColor() {
        return defaultColor;
    }
}
