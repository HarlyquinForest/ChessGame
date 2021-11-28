package amin.main.chess.Pieces;

import amin.main.Main;
import amin.main.chess.gui.Board;
import amin.main.chess.gui.Square;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Piece {
    BufferedImage icon ;
    String name ;
    int[] moves ;
    int score ;
    int place ;
    public PieceColor color ;

    public Piece(String img)
    {
        img = "../resources/"+img;
        try{
            icon = ImageIO.read(getClass().getResource(img));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public abstract ArrayList<Square> getLegalMoves(Square s , Board b);

    public void draw(Graphics g){
        int x = 10 ;
        int y = 5 ;
        g.drawImage(this.icon , x , y , 80,80,null , null);
    }

    public ArrayList<Square> getDiagonalOccupations(Board b , int x , int y){
        ArrayList<Square> legalMoves = new ArrayList<>();
        int xNW = x - 1;
        int xNE = x - 1;
        int xSW = x + 1;
        int xSE = x + 1;
        int yNW = y - 1;
        int yNE = y + 1;
        int ySW = y - 1;
        int ySE = y + 1;

        while (xNW >= 0 && yNW >= 0) {
            if(isSameColorOnTheWay(b.getSquare(xNW,yNW)))
                break;
            legalMoves.add(b.getSquare(xNW, yNW));
            if(isOtherColorOnTheWay(b.getSquare(xNW,yNW)))
                break;
            xNW--;
            yNW--;
        }
        while (xNE >= 0 && yNE < 8) {
            if(isSameColorOnTheWay(b.getSquare(xNE,yNE)))
                break;
            legalMoves.add(b.getSquare(xNE, yNE));
            if(isOtherColorOnTheWay(b.getSquare(xNE,yNE)))
                break;
            xNE--;
            yNE++;
        }
        while (xSW < 8 && ySW >= 0) {
            if(isSameColorOnTheWay(b.getSquare(xSW,ySW)))
                break;
            legalMoves.add(b.getSquare(xSW, ySW));
            if(isOtherColorOnTheWay(b.getSquare(xSW,ySW)))
                break;
            xSW++;
            ySW--;
        }
        while (xSE < 8 && ySE < 8) {
            if(isSameColorOnTheWay(b.getSquare(xSE,ySE)))
                break;
            legalMoves.add(b.getSquare(xSE, ySE));
            if(isOtherColorOnTheWay(b.getSquare(xSE,ySE)))
                break;
            xSE++;
            ySE++;
        }
        return legalMoves;
    }

    boolean isSameColorOnTheWay(Square s){
        if(s.isOccupied())
            return s.getOccupyingPiece().getColor() == this.getColor();
        return false;
    }
    boolean isOtherColorOnTheWay(Square s){
        if(s.isOccupied())
            return s.getOccupyingPiece().getColor() != this.getColor();
        return false;
    }

    public ArrayList<Square> getLinearOccupations(Board b , int x, int y ){
        int lastXright = 7;
        int lastXleft = 0 ;
        int lastYabove = 0 ;
        int lastYbelow = 7 ;
        ArrayList<Square> legal = new ArrayList<>();

        //vertical
        for(int i = x ; i >= lastYabove ; i--) {
            if (i == x)
                continue;
            if(isSameColorOnTheWay(b.getSquare(i,y)))
                break;
            legal.add(b.getSquare(i, y));
            if(isOtherColorOnTheWay(b.getSquare(i,y)))
                break;
        }
        for(int i = x ; i < lastYbelow ; i++) {
            if (i == x)
                continue;
            if(isSameColorOnTheWay(b.getSquare(i,y)))
                break;
            legal.add(b.getSquare(i, y));
            if(isOtherColorOnTheWay(b.getSquare(i,y)))
                break;
        }
        //horizontal
        for(int i = y ; i <= lastXright; i++) {
            if (i == y)
                continue;
            if(isSameColorOnTheWay(b.getSquare(x,i)))
                break;
            legal.add(b.getSquare(x, i));
            if(isOtherColorOnTheWay(b.getSquare(x,i)))
                break;
        }
        for(int i = y ; i >= lastXleft ; i--) {
            if (i == y)
                continue;
            if(isSameColorOnTheWay(b.getSquare(x,i)))
                break;
            legal.add(b.getSquare(x, i));
            if(isOtherColorOnTheWay(b.getSquare(x,i)))
                break;
        }

        return legal;
    }

    public PieceColor getColor(){
        return color;
    }

    boolean canMove(){
        return true;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "  name=" + name +
                ", score=" + score +
                ", color=" + color +
                "}\n";
    }
}
