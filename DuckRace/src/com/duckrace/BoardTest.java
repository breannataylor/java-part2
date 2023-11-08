package com.duckrace;
import static com.duckrace.Reward.*;

class BoardTest {
    public static void main(String[] args) {
        Board board = new Board();
        //board.dumpStudentIdMap();

        board.update(4, DEBIT_CARD);
        board.update(4, DEBIT_CARD);
        board.update(14, DEBIT_CARD);
        board.update(14, PRIZES);
        board.update(7, PRIZES);
        board.update(18, PRIZES);
        board.update(12, DEBIT_CARD);
        board.update(14, PRIZES);
        board.show();
    }
}