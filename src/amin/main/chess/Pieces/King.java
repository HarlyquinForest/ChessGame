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
        ArrayList<Square> legalMoves = new ArrayList<>();
        int x = s.getXNum();
        int[] xs = new int[]{x - 1, x + 1, x};
        int y = s.getYNum();
        int[] ys = new int[]{y, y - 1, y + 1};
        for (int xx : xs) {
            for (int yy : ys) {
                if (validXY(xx, yy))
                    if (!isSameColorOnTheWay(b.getSquare(xx, yy)))
                        legalMoves.add(b.getSquare(xx, yy));
            }
        }
        return legalMoves;
    }

    private boolean validXY(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}
