package amin.main.chess.gui;

import amin.main.chess.Board.Side;
import amin.main.chess.Pieces.Piece;
import amin.main.chess.Pieces.PieceColor;

public class Game {
    private final Side blackSide ;
    private final Side whiteSide ;
    private String turnText = "White Turn";

    public Game(){
        blackSide = new Side(PieceColor.BLACK);
        whiteSide = new Side(PieceColor.WHITE);
        whiteSide.setTurn();
    }

    public void initialBoard(Square[][] board){
        putBlackPieces(board);
        putWhitePieces(board);
    }
    public void changeTurn(){
        if(blackSide.isTurn()) {
            whiteSide.setTurn();
            blackSide.unsetTurn();
            turnText = "White Turn";
        }
        else{
            blackSide.setTurn();
            whiteSide.unsetTurn();
            turnText = "Black Turn";
        }
    }

    public Side whichSideTurn(){
        if(blackSide.isTurn())
            return blackSide;
        return whiteSide;
    }
    private void putBlackPieces(Square[][] board){
        board[7][0].setOccupyingPiece(blackSide.getLeftRook());
        board[7][7].setOccupyingPiece(blackSide.getRightRook());
        board[7][1].setOccupyingPiece(blackSide.getLeftKnight());
        board[7][6].setOccupyingPiece(blackSide.getRightKnight());
        board[7][2].setOccupyingPiece(blackSide.getLeftBishop());
        board[7][5].setOccupyingPiece(blackSide.getRightBishop());
        board[7][3].setOccupyingPiece(blackSide.getKing());
        board[7][4].setOccupyingPiece(blackSide.getQueen());
        int c = 0;
        Piece[] pawns = blackSide.getPawns();
        for(int i = 0 ; i < 8 ; i++)
        {
            board[6][c].setOccupyingPiece(pawns[i]);
            c++;
        }

    }
    private void putWhitePieces(Square[][] board){
        board[0][7].setOccupyingPiece(whiteSide.getRightRook());
        board[0][0].setOccupyingPiece(whiteSide.getLeftRook());
        board[0][1].setOccupyingPiece(whiteSide.getLeftKnight());
        board[0][6].setOccupyingPiece(whiteSide.getRightKnight());
        board[0][2].setOccupyingPiece(whiteSide.getLeftBishop());
        board[0][5].setOccupyingPiece(whiteSide.getRightBishop());
        board[0][3].setOccupyingPiece(whiteSide.getKing());
        board[0][4].setOccupyingPiece(whiteSide.getQueen());
        int c = 0;
        Piece[] pawns = whiteSide.getPawns();
        for(int i = 0 ; i < 8 ; i++)
        {
            board[1][c].setOccupyingPiece(pawns[i]);
            c++;
        }
    }

    public String getTurnText() {
        return turnText;
    }
}
