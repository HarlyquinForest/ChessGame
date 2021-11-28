package amin.main.chess.Pieces;

import amin.main.chess.gui.Board;
import amin.main.chess.gui.Square;

import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(String icon , PieceColor c){
        super(icon);
        color = c;
        score = 5 ;
        name = "Rook";
    }

    @Override
    public ArrayList<Square> getLegalMoves(Square s ,Board b) {
        Square current =s;
        int x = current.getXNum();
        int y = current.getYNum();

        return getLinearOccupations(b,x,y);
    }
}
