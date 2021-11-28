package amin.main.chess.Board;

import amin.main.chess.Pieces.*;

import java.util.Arrays;

public class Side {
    Piece[] pieces ;
    PieceColor color ;
    private boolean turn;

    public Side(){
        this(PieceColor.WHITE);
    }
    public Side(PieceColor color){
        this.color = color;
        pieces = new Piece[16];
        initialPieces();
    }
    private void initialPieces(){
        String colorPrefix = "wt";
        if(color == PieceColor.BLACK)
            colorPrefix = "bk";
        pieces[0] = new King("king-"+colorPrefix+".png" , color);
        pieces[1] = new Queen("queen-"+colorPrefix+".png" , color);
        pieces[2] = new Knight("knight-"+colorPrefix+".png" , color);
        pieces[3] = new Knight("knight-"+colorPrefix+".png" , color);
        pieces[4] = new Bishop("bishop-"+colorPrefix+".png" , color);
        pieces[5] = new Bishop("bishop-"+colorPrefix+".png" , color);
        pieces[6] = new Rook("rook-"+colorPrefix+".png" , color);
        pieces[7] = new Rook("rook-"+colorPrefix+".png" , color);
        for(int i = 8 ; i < 16 ; i++)
            pieces[i] = new Pawn("pawn-"+colorPrefix+".png" , color);
    }
    public Piece getKing(){
        return pieces[0];
    }
    public Piece getQueen(){
        return pieces[1];
    }
    public Piece getLeftBishop(){
        return pieces[4];
    }
    public Piece getRightBishop(){
        return pieces[5];
    }
    public Piece getLeftKnight(){
        return  pieces[2];
    }
    public Piece getRightKnight(){
        return  pieces[3];
    }
    public Piece getLeftRook(){
        return pieces[6];
    }
    public Piece getRightRook(){
        return pieces[7];
    }
    public Piece[] getPawns(){
        return Arrays.copyOfRange(pieces , 8,16);
    }
    public Piece[] getPieces(){
        return pieces;
    }
    public PieceColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        String out = "";
        for (Piece p :pieces) {
            out += p.toString();
        }
        return out;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn() {
        this.turn = true;
    }
    public void unsetTurn(){
        this.turn = false;
    }
}
