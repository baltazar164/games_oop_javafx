package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int deltaX = dest.getX() - position.getX();
        int deltaY = dest.getY() - position.getY();
        int size = Math.abs(deltaX);
        Cell[] steps = new Cell[size];
        int xSign = deltaX > 0 ? 1 : -1;
        int ySign = deltaY > 0 ? 1 : -1;
        for (int i = 0, x = 1, y = 1; i < size; i++, x++, y++) {
            int xCell = position().getX() + x * xSign;
            int yCell = position().getY() + y * ySign;
            steps[i] = Cell.findBy(xCell, yCell);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(position.getX() - dest.getX()) == Math.abs(position.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
