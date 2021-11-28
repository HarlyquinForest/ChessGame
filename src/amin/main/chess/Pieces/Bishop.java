package amin.main.chess.Pieces;

import amin.main.chess.gui.Board;
import amin.main.chess.gui.Square;

import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(String icon, PieceColor c) {
        super(icon);
        color = c;
        score = 3;
        name = "Bishop";
    }

    @Override
    public ArrayList<Square> getLegalMoves(Square s, Board b) {
        Square current = s;
        int x = current.getXNum();
        int y = current.getYNum();

        return getDiagonalOccupations(b , x , y);
    }

}
