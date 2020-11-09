package gbjc0.les08;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

    public class App extends JFrame {
    protected boolean isAlive = true;

    public App(final int SIZE) {
        setTitle("Bombs and Deaths");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        boolean[][] bombs = new boolean[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                bombs[i][j] = Math.random() <= 0.25;
            }
        }

        JButton[][] buttons = new JButton[SIZE][SIZE];

        setLayout(new GridLayout(SIZE, SIZE));
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton button = new JButton();
                buttons[i][j] = button;
                button.setText("???");
                int ii = i;
                int jj = j;
                button.addActionListener(actionEvent -> {
                    if (!isAlive) return;
                    if (bombs[ii][jj]) {
                        button.setText("\u2620");
                        button.setFont(button.getFont().deriveFont(42.F));
                        button.setBackground(Color.RED);
                        button.setForeground(Color.WHITE);

                        //ОТКРЫТЬ ВСЕ ПОЛЯ С БОМБАМИ
                        for (int k = 0; k < SIZE; k++) {
                            for (int l = 0; l < SIZE; l++) {
                                if (!bombs[k][l]) {
                                    buttons[k][l].setText("VVV");
                                } else {
                                    if ((k==ii) && (l==jj)) {
                                        continue;
//                                        System.out.println("Текущая кнопка");
                                    }
                                    buttons[k][l].setText("\u2620");
                                    buttons[k][l].setFont(button.getFont().deriveFont(38.F));
                                    buttons[k][l].setBackground(Color.DARK_GRAY);
                                    buttons[k][l].setForeground(Color.WHITE);
                                }
                            }
                        }
                        isAlive = false;
                    } else {
                        button.setText(countBombs(bombs, ii, jj));
                        button.setBackground(Color.GREEN);
                    }
                });
                add(button);
            }
        }

        setVisible(true);
    }

    // Проверяем и подсчитываем количество бомб рядом
    public String countBombs(boolean[][] bombs, int ii, int jj) {
        int countBombs = 0;

        // проверка нижнего поля
        if (((ii+1) < bombs.length) && (bombs[ii+1][jj])) {
            countBombs++;
        }

        // проверка верхнего поля
        if (((ii-1) >= 0) && (bombs[ii-1][jj])) {
            countBombs++;
        }

        // проверка правого поля
        if (((jj+1) < bombs.length) && (bombs[ii][jj+1])) {
            countBombs++;
        }

        // проверка левого поля
        if (((jj-1) >= 0) && (bombs[ii][jj-1])) {
            countBombs++;
        }

        // проверка нижней левой диагонали
        if (((ii+1) < bombs.length) && ((jj-1) >= 0) && (bombs[ii+1][jj-1])) {
            countBombs++;
        }

        // проверка верхней левой диагонали
        if (((ii-1) >= 0) && ((jj-1) >= 0) && (bombs[ii-1][jj-1])) {
            countBombs++;
        }

        // проверка нижней правой диагонали
        if (((ii+1) < bombs.length) && ((jj+1) < bombs.length) && (bombs[ii+1][jj+1])) {
            countBombs++;
        }

        // проверка верхней правой диагонали
        if (((ii-1) >= 0) && ((jj+1) < bombs.length) && (bombs[ii-1][jj+1])) {
            countBombs++;
        }
        return String.valueOf(countBombs);
    }
}