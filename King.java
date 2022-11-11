public class King extends Piece {

    public King(int pos, boolean c) {
        super(pos, c);
    }

    public void setLegalMoves() {

        // Cardinal Directions
        try { legalMoves.add(position + forward(1)); } catch (IllegalStateException e) {}
        try { legalMoves.add(position + backward(1));} catch (IllegalStateException e) {}
        try {legalMoves.add(position + left(1)); } catch (IllegalStateException e) {}
        try {legalMoves.add(position + right(1));} catch (IllegalStateException e) {}
        // Diagonal Directions
        try {legalMoves.add(position + forward(1) + right(1));} catch (IllegalStateException e) {}
        try {legalMoves.add(position + forward(1) + left(1));} catch (IllegalStateException e) {}
        try {legalMoves.add(position + backward(1) + right (1));} catch (IllegalStateException e) {}
        try {legalMoves.add(position + backward(1) + left(1));} catch (IllegalStateException e) {}
        cleanMoves();
    }

}
