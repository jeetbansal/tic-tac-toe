package Piece;

public class PieceImpl implements Piece {

    PieceType pieceType;

    public PieceImpl(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    @Override
    public PieceType getPieceType() {
        return pieceType;
    }
}
