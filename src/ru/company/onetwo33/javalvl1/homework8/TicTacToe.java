package ru.company.onetwo33.javalvl1.homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JFrame {
    private static final int SIZE = 5;
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final int DOTS_TO_WIN = 4;

    private static final String DRAW_X = "DRAW_X";
    private static final String DRAW_O = "DRAW_O";
    private static char turn = DOT_X;

    public TicTacToe() {
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 500, 600, 600);
        setVisible(true);

        JButton[][] jbs = new JButton[SIZE][SIZE];
        setLayout(new GridLayout(SIZE, SIZE));
        for (int i = 0; i < jbs.length; i++) {
            for (int j = 0; j < jbs[i].length; j++) {
                jbs[i][j] = createButton();
                jbs[i][j].setName(i + " " + j);
                jbs[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        // HumanTurn
                        if (turn == DOT_X && ((JButton)e.getSource()).getText().isEmpty()) {
                            ((JButton)e.getSource()).setActionCommand(DRAW_X);
                            Graphics g = getGraphics();
                            ((JButton)e.getSource()).paint(g);
                            ((JButton)e.getSource()).setText(String.valueOf(DOT_X));
                            System.out.println(((JButton)e.getSource()).getText());
                            if (checkWin(DOT_X)) {
                                ((JButton)e.getSource()).getParent().removeAll();
                                JButton jb = new JButton("Победил человек!");
                                setLayout(new BorderLayout());
                                add(jb, BorderLayout.CENTER);
                            }
                        }

                        // Проверка на ничью
                        if (isMapFull()) {
                            ((JButton)e.getSource()).getParent().removeAll();
                            JButton jb = new JButton("Ничья!");
                            setLayout(new BorderLayout());
                            add(jb, BorderLayout.CENTER);
                            return;
                        }

                        // ComputerTurn
                        int[] cell = getNextCellToWin(DOT_O);
                        if (cell == null) {
                            cell = getNextCellToWin(DOT_X);
                            if (cell == null) {
                                cell = getRandomEmptyCell();
                            }
                        }
                        int rowIndex1 = cell[0];
                        int colIndex1 = cell[1];

                        setCell(rowIndex1, colIndex1, DOT_O);

                        jbs[rowIndex1][colIndex1].setActionCommand(DRAW_O);
                        Graphics g = getGraphics();
                        jbs[rowIndex1][colIndex1].paint(g);
                        System.out.println(jbs[rowIndex1][colIndex1].getText());
                        if (checkWin(DOT_O)) {
                            ((JButton)e.getSource()).getParent().removeAll();
                            JButton jb = new JButton("Победил компьютер!");
                            setLayout(new BorderLayout());
                            add(jb, BorderLayout.CENTER);
                        } else  {
                            turn = DOT_X;
                        }
                    }

                    private boolean isMapFull() {
                        for (JButton[] btns : jbs) {
                            for (JButton btn : btns) {
                                if (btn.getText().isEmpty()) {
                                    return false;
                                }
                            }
                        }

                        return true;
                    }

                    private int[] getRandomEmptyCell() {
                        int rowIndex, colIndex;
                        Random rand = new Random();
                        do {
                            rowIndex = rand.nextInt(SIZE);
                            colIndex = rand.nextInt(SIZE);
                        } while (!isValidCell(rowIndex, colIndex));

                        return new int[]{rowIndex, colIndex};
                    }

                    private boolean isValidCell(int rowIndex, int colIndex) {
                        return jbs[rowIndex][colIndex].getText().isEmpty();
                    }

                    private int[] getNextCellToWin(char symbol) {
                        for (int rowIndex = 0; rowIndex < jbs.length; rowIndex++) {
                            for (int colIndex = 0; colIndex < jbs[rowIndex].length; colIndex++) {
                                if (jbs[rowIndex][colIndex].getText().isEmpty() && isGameMoveWinning(rowIndex, colIndex, symbol)) {
                                    return new int[]{rowIndex, colIndex};
                                }
                            }
                        }
                        return null;
                    }

                    private boolean isGameMoveWinning(int rowIndex, int colIndex, char symbol) {
                        setCell(rowIndex, colIndex, symbol);
                        boolean result = checkWin(symbol);
                        setCell(rowIndex, colIndex);
                        return result;
                    }

                    private boolean checkWin(char symbol) {
                        if (checkRowsAndCols(symbol)) return true;
                        return checkDiagonals(symbol);
                    }

                    private boolean checkDiagonals(char symbol) {
                        int mainDiagCounter = 0;
                        int sideDiagCounter = 0;
                        for (int i = 0; i < SIZE; i++) {
                            mainDiagCounter = (jbs[i][i].getText().equals(String.valueOf(symbol))) ? mainDiagCounter + 1 : 0;
                            sideDiagCounter = (jbs[i][jbs.length - 1 - i].getText().equals(String.valueOf(symbol))) ? sideDiagCounter + 1 : 0;
                            if (mainDiagCounter >= DOTS_TO_WIN || sideDiagCounter >= DOTS_TO_WIN) {
                                return true;
                            }
                        }
                        return false;
                    }

                    private boolean checkRowsAndCols(char symbol) {
                        for (int i = 0; i < SIZE; i++) {
                            int rowCounter = 0;
                            int colCounter = 0;
                            for (int j = 0; j < SIZE; j++) {
                                rowCounter = (jbs[i][j].getText().equals(String.valueOf(symbol))) ? rowCounter + 1 : 0;
                                colCounter = (jbs[j][i].getText().equals(String.valueOf(symbol))) ? colCounter + 1 : 0;
                                if (rowCounter >= DOTS_TO_WIN || colCounter >= DOTS_TO_WIN) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }

                    private void setCell(int rowIndex, int colIndex, char symbol) {
                        jbs[rowIndex][colIndex].setText(String.valueOf(symbol));
                    }

                    private void setCell(int rowIndex, int colIndex) {
                        jbs[rowIndex][colIndex].setText("");
                    }
                });

                add(jbs[i][j]);
            }
        }

    }

    private JButton createButton() {
        return new JButton() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);

                if (getActionCommand().equals(DRAW_O)) {
                    g.drawOval(0, 0, getWidth(), getWidth());
                    g.setColor(Color.RED);
                    g.fillOval(0, 0, getWidth(), getWidth());
                } else if (getActionCommand().equals(DRAW_X)) {
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(new BasicStroke(10));
                    g2d.setColor(Color.BLUE);
                    g2d.drawLine(0, 0, this.getWidth(), this.getHeight());
                    g2d.drawLine(this.getWidth(), 0, 0, this.getHeight());
                }
            }
        };
    }
}
