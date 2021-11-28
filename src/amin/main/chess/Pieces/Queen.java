package amin.main.chess.Pieces;

import amin.main.chess.gui.Board;
import amin.main.chess.gui.Square;

import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(String icon, PieceColor c) {
        super(icon);
        color = c;
        score = 9;
        name = "Queen";
    }

    @Override
    public ArrayList<Square> getLegalMoves(Square s, Board b) {
        ArrayList<Square> legalMoves = new ArrayList<>();
        Square current = s;
        int x = current.getXNum();
        int y = current.getYNum();

        legalMoves.addAll(getLinearOccupations(b,x,y));
        legalMoves.addAll(getDiagonalOccupations(b,x,y));

        return legalMoves;
    }
}
