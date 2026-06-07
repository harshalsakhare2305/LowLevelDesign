package Chess;

public class PieceFactory {

    public static Piece createPiece(String type,boolean isWhite){
        if(type.equalsIgnoreCase("Pawn"))return new Pawn(isWhite);
        else if(type.equalsIgnoreCase("King"))return new King(isWhite);
        else if(type.equalsIgnoreCase("Queen"))return new Queen(isWhite);
        else if(type.equalsIgnoreCase("Bishop"))return new Bishop(isWhite);
        else if(type.equalsIgnoreCase("Knight"))return new Knight(isWhite);
        else  if(type.equalsIgnoreCase("Rook"))return new Rook(isWhite);
        else return new Null(isWhite);
    }
}
