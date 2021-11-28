package amin.main.chess.Pieces;

import amin.main.chess.gui.Board;
import amin.main.chess.gui.Square;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(String icon, PieceColor c) {
        super(icon);
        color = c;
        score = 3;
        name = "Knight";
    }

    @Override
    public ArrayList<Square> getLegalMoves(Square s, Board b) {
        ArrayList<Square> legalMoves = new ArrayList<>();
        Square current = s;
        int x = current.getXNum();
        int y = current.getYNum();

        int xTopRight = x - 2;
        int yTopRight = y + 1;

        int xTopLeft = x - 2;
        int yTopLeft = y - 1;

        int xBotRight = x + 2;
        int yBotRight = y + 1;

        int xBotLeft = x + 2;
        int yBotLeft = y - 1;

        if (validXY(xTopLeft,yTopLeft))
            if(!isSameColorOnTheWay(b.getSquare(xTopLeft, yTopLeft)))
                legalMoves.add(b.getSquare(xTopLeft, yTopLeft));
        if (validXY(xTopRight ,yTopRight))
            if(!isSameColorOnTheWay(b.getSquare(xTopRight, yTopRight)))
                legalMoves.add(b.getSquare(xTopRight, yTopRight));
        if (validXY(xBotLeft,yBotLeft))
            if(!isSameColorOnTheWay(b.getSquare(xBotLeft, yBotLeft)))
                legalMoves.add(b.getSquare(xBotLeft, yBotLeft));
        if (validXY(xBotRight,yBotRight))
            if(!isSameColorOnTheWay(b.getSquare(xBotRight, yBotRight)))
                legalMoves.add(b.getSquare(xBotRight, yBotRight));


        return legalMoves;
    }
    private boolean validXY(int x , int y){
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
