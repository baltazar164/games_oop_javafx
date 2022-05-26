package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishop = new BishopBlack(Cell.A2);
        assertThat(bishop.position(), is(Cell.A2));
    }

    @Test
    public void copy() {
        BishopBlack bishop = new BishopBlack(Cell.A2);
        Figure bishopCopy = bishop.copy(Cell.A4);
        assertThat(bishopCopy.position(), is(Cell.A4));
    }

    @Test
    public void wayC1ToG5() {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] actual = bishop.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(actual, is(expected));
    }

    @Test
    public void wayD8ToA5() {
        Figure bishop = new BishopBlack(Cell.D8);
        Cell[] actual = bishop.way(Cell.A5);
        Cell[] expected = {Cell.C7, Cell.B6, Cell.A5};
        assertThat(actual, is(expected));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void ImpossibleMoveException() {
        new BishopBlack(Cell.C6).way(Cell.A6);
    }
}