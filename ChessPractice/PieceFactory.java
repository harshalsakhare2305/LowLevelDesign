package ChessPractice;

import ChessPractice.Pieces.*;

public class PieceFactory {

    public static Piece createPiece(String type ,boolean isWhite){
        if(type.equalsIgnoreCase("King"))return  new King(isWhite);
        else if(type.equalsIgnoreCase("Queen"))return new Queen(isWhite);
        else if(type.equalsIgnoreCase("bishop"))return  new Bishop(isWhite);
        else if(type.equalsIgnoreCase("knight"))return  new Knight(isWhite);
        else if(type.equalsIgnoreCase("rook"))return  new Rook(isWhite);
        else if(type.equalsIgnoreCase("pawn"))return  new Pawn(isWhite);
        else return null;

    }
}
