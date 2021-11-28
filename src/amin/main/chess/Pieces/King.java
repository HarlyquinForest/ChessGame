package amin.main.chess.Pieces;

import amin.main.chess.gui.Board;
import amin.main.chess.gui.Square;
import java.util.ArrayList;

public class King extends Piece{
    public King(String icon , PieceColor c){
        super(icon);
        color = c;
        score = 10;
        name = "King";
    }

    @Override
    public ArrayList<Square> getLegalMoves(Square s ,Board b) {
        return null;
    }
}
