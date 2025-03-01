package Piece;

public enum PieceType {

    X,
    O,
    N;

    public static char printForPiece(PieceType pieceType) {
        if (pieceType == null) {
            return ' ';
        }
        if (pieceType.equals(PieceType.X)) {
            return 'x';
        }
        else if (pieceType.equals(PieceType.O)) {
            return 'o';
        }
        else {
            return 'n';
        }
    }
}
