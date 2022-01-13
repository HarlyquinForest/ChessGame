/*
 * Created by JFormDesigner on Tue Nov 16 18:41:58 IRST 2021
 */
/*TODO
    Turn lbl is not working , currently I did crated a class for it but I couldn't make it work yet
 */
package amin.main.chess.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * @author aminyousefnejad
 */
public class MainLayout{
    JFrame window;
    JLabel sideTurnLbl;
    Game game ;
    public MainLayout() {
        game = new Game();
        window = new JFrame("Simple Chess");

        JPanel centerPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel botPanel = new JPanel();

        BorderLayout mainLayout = new BorderLayout();
        FlowLayout chessBoardLayout = new FlowLayout();
        BoxLayout toolsLayout = new BoxLayout(topPanel , BoxLayout.Y_AXIS);


        centerPanel.setLayout(chessBoardLayout);
        centerPanel.add(game);

        topPanel.setBorder(new EmptyBorder(10,10,10,10));
        topPanel.setLayout(toolsLayout);

        topPanel.add(topPanel());
        topPanel.add(buttons());

        botPanel.setLayout(new FlowLayout());

        window.setLayout(mainLayout);
        window.add(centerPanel , BorderLayout.CENTER);
        window.add(topPanel , BorderLayout.NORTH);
        window.add(botPanel , BorderLayout.SOUTH);
        window.setSize(window.getPreferredSize());
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void turnLbl(String s){
        sideTurnLbl.setText(s);
    }
    private JPanel topPanel(){
        JPanel top = new JPanel();
        top.setSize(600,400);
        top.setMaximumSize(new Dimension(600,400));

        JLabel header = new JLabel("Simple Chess");
        header.setFont(new Font("Zekton",Font.BOLD , 30));
        top.add(header);

        return  top;
    }


    private JPanel buttons() {
        JPanel buttons = new JPanel();
        Font font = new Font("Zekton" , Font.BOLD , 15);

        buttons.setLayout(new GridLayout(1, 3, 10, 10));

        final JButton quit = new JButton("Quit");
        quit.setFont(font);


        final JButton nGame = new JButton("New game");
        nGame.setFont(font);


        final JButton instr = new JButton("How to play");
        instr.setFont(font);

        final JButton about = new JButton(("About"));
        about.setFont(font);

        buttons.add(instr);
        buttons.add(nGame);
        buttons.add(about);
        buttons.add(quit);

        buttons.setPreferredSize(buttons.getMinimumSize());

        return buttons;
    }

}
