package amin.test;
import amin.main.chess.Pieces.PieceColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import amin.main.chess.Board.*;

public class PiecesTest {
    Side blackSide ;
    Side whiteSide ;

    @Test
    @DisplayName("Test generating the black side of the game")
    void blackSide(){
        blackSide = new Side();
        System.out.println(blackSide);
    }
    @Test
    @DisplayName("Test generating the white side of the game")
    void whiteSide(){
        whiteSide = new Side(PieceColor.WHITE);
        System.out.println(whiteSide);
    }

}
