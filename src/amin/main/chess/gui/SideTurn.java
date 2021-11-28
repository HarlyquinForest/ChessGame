package amin.main.chess.gui;

import javax.swing.*;

public class SideTurn extends JPanel {
    private final Game game ;
    private JLabel turnLbl ;
    public SideTurn(Game game){
        this.game = game;
        turnLbl = new JLabel();
        turnLbl.setText(game.getTurnText());
    }
    public void refresh(){
        turnLbl.setText(game.getTurnText());
    }


}
