package amin.main.chess.gui;

import amin.main.chess.Board.Side;
import amin.main.chess.Pieces.Piece;
import amin.main.chess.Pieces.PieceColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Game extends JPanel implements MouseListener, MouseMotionListener {
    private final Side blackSide;
    private final Side whiteSide;
    private final Board gameBoard = new Board();
    private JLabel sideTurn = new JLabel();
    private Square[][] board;
    private String turnText = "White Turn";

    public Game() {
        blackSide = new Side(PieceColor.BLACK);
        whiteSide = new Side(PieceColor.WHITE);
        whiteSide.setTurn();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        addMouseListener(this);
        addMouseMotionListener(this);

        sideTurn.setText(turnText);
        sideTurn.setFont(new Font("Monospace", Font.BOLD, 20));

        board = gameBoard.getBoard();
        gameBoard.setAlignmentX(Component.CENTER_ALIGNMENT);
        sideTurn.setAlignmentX(Component.CENTER_ALIGNMENT);
        initialBoard();
        add(Box.createVerticalGlue());
        add(sideTurn);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(gameBoard);
        Dimension d = new Dimension(800, 800);
        setPreferredSize(d);

    }

    public void initialBoard() {
        putBlackPieces();
        putWhitePieces();
    }

    public void changeTurn() {
        if (blackSide.isTurn()) {
            whiteSide.setTurn();
            blackSide.unsetTurn();
            turnText = "White Turn";
        } else {
            blackSide.setTurn();
            whiteSide.unsetTurn();
            turnText = "Black Turn";
        }
        sideTurn.setText(turnText);
    }

    public Side whichSideTurn() {
        if (blackSide.isTurn())
            return blackSide;
        return whiteSide;
    }

    private void putBlackPieces() {
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
        for (int i = 0; i < 8; i++) {
            board[6][c].setOccupyingPiece(pawns[i]);
            c++;
        }

    }

    private void putWhitePieces() {
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
        for (int i = 0; i < 8; i++) {
            board[1][c].setOccupyingPiece(pawns[i]);
            c++;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        ArrayList<Square> leg;
        Point clickPoint = e.getPoint();
        Square s = gameBoard.getSquareAt(clickPoint);
        if (!s.isOccupied()) {
            leg = gameBoard.getSelectedSquare().getOccupyingPiece().getLegalMoves(gameBoard.getSelectedSquare(), gameBoard);
            if (gameBoard.getSelectedSquare() != null && isSquareInLegalMoves(leg, s)) {
                s.setOccupyingPiece(gameBoard.getSelectedSquare().getOccupyingPiece());
                gameBoard.getSelectedSquare().setOccupyingPiece(null);
                changeTurn();
            }
        }
        gameBoard.clearLegalMoves();
        if (s.isOccupied()) {
            Piece p = s.getOccupyingPiece();
            if (p.getColor() != whichSideTurn().getColor())
                return;
            gameBoard.setSelectedSquare(s);
            leg = p.getLegalMoves(s, gameBoard);
            gameBoard.displayLegalMoves(leg);
        }
    }

    private boolean isSquareInLegalMoves(ArrayList<Square> s, Square ss) {
        for (Square p : s)
            if (p.equals(ss))
                return true;
        return false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
