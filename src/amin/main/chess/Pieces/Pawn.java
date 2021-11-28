package amin.main.chess.Pieces;

import amin.main.chess.gui.Board;
import amin.main.chess.gui.Square;
import java.util.ArrayList;

public class Pawn extends Piece {
    public Pawn(String icon, PieceColor c) {
        super(icon);
        color = c;
        score = 1;
        name = "Pawn";
    }

    @Override
    public ArrayList<Square> getLegalMoves(Square s, Board b) {
        ArrayList<Square> legalMoves = new ArrayList<>();
        int x = s.getXNum();
        int y = s.getYNum();

        int xOneStep ,xTwoStep ,yLeftHit , yRightHit;

        if(s.getOccupyingPiece().getColor() == PieceColor.BLACK)
        {
            xOneStep = x - 1;
            xTwoStep = x - 2;
            yLeftHit = y - 1;
            yRightHit = y + 1;
        }else{
            xOneStep = x + 1;
            xTwoStep = x + 2;
            yLeftHit = y + 1;
            yRightHit = y - 1;
        }

        if(validMove(xOneStep) && !isSameColorOnTheWay(b.getSquare(xOneStep , y)) && !isOtherColorOnTheWay(b.getSquare(xOneStep,y)))
            legalMoves.add(b.getSquare(xOneStep,y));
        if(validMove(xTwoStep) && (x == 6 || x == 1) && !isSameColorOnTheWay(b.getSquare(xTwoStep , y)) && !isOtherColorOnTheWay(b.getSquare(xTwoStep , y)))
            legalMoves.add(b.getSquare(xTwoStep , y));
        if(validMove(xOneStep) && validMove(yLeftHit))
            if(isOtherColorOnTheWay(b.getSquare(xOneStep , yLeftHit)))
                legalMoves.add(b.getSquare(xOneStep , yLeftHit));
        if(validMove(xOneStep) && validMove(yRightHit))
            if(isOtherColorOnTheWay(b.getSquare(xOneStep , yRightHit)))
                legalMoves.add(b.getSquare(xOneStep , yRightHit));
        return legalMoves;
    }

    private boolean validMove(int x) {
        return x >= 0 && x < 8 ;
    }

}
