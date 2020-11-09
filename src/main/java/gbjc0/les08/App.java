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
                        //ОТКРЫТЬ ВСЕ ПОЛЯ С БОМБАМИ
                        System.out.println("ii = " + ii + ", jj = " + jj);
                        for (int k = 0; k < SIZE; k++) {
                            for (int l = 0; l < SIZE; l++) {
                                if (!bombs[k][l]) {
                                    buttons[k][l].setText("VVV");
                                } else {
                                    if ((k==ii) && (l==jj)) {
                                        System.out.println("Текущая кнопка");
                                    }
                                    System.out.println("else ");
                                    buttons[k][l].setText("\u2620");
                                    buttons[k][l].setFont(button.getFont().deriveFont(38.F));
                                    buttons[k][l].setBackground(Color.DARK_GRAY);
                                    buttons[k][l].setForeground(Color.WHITE);
                                }
                            }
                            // установку красной бомбы ставим в конец, чтобы не затерлась другим цветом
                            button.setText("\u2620");
                            button.setFont(button.getFont().deriveFont(42.F));
                            button.setBackground(Color.RED);
                            button.setForeground(Color.WHITE);
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
            System.out.println("ii+1 = " + (ii + 1) + ", j = " + jj + ", бомба снизу = " + bombs[ii+1][jj] + ", bombs.length = " + bombs.length);
            countBombs++;
        } else System.out.println("ii+1 = " + (ii + 1) + ", j = " + jj + ", бомбы снизу нет (или поле снизу закончилось)");

        // проверка верхнего поля
        if (((ii-1) >= 0) && (bombs[ii-1][jj])) {
            System.out.println("ii-1 = " + (ii - 1) + ", j = " + jj + ", бомба сверху = " + bombs[ii-1][jj] + ", bombs.length = " + bombs.length);
            countBombs++;
        } else System.out.println("ii-1 = " + (ii - 1) + ", j = " + jj + ", бомбы сверху нет (или поле сверху закончено)");

        // проверка правого поля
        if (((jj+1) < bombs.length) && (bombs[ii][jj+1])) {
            System.out.println("ii = " + ii + ", jj+1 = " + (jj+1) + ", бомба справа = " + bombs[ii][jj+1] + ", bombs.length = " + bombs.length);
            countBombs++;
        } else System.out.println("ii = " + ii + ", jj+1 = " + (jj+1) + ", бомбы справа нет (или поле справа закончилось)");

        // проверка левого поля
        if (((jj-1) >= 0) && (bombs[ii][jj-1])) {
            System.out.println("ii = " + ii + ", jj-1 = " + (jj-1) +
                    ", бомба слева = " + bombs[ii][jj-1] + ", bombs.length = " + bombs.length);
            countBombs++;
        } else System.out.println("ii = " + ii + ", jj-1 = " + (jj-1) + ", бомбы слева нет (или поле справа закончилось)");

        // проверка нижней левой диагонали
        if (((ii+1) < bombs.length) && ((jj-1) >= 0) && (bombs[ii+1][jj-1])) {
            System.out.println("ii+1 = " + (ii + 1) + ", jj-1 = " + (jj-1) +
                    ", бомба в нижней левой диагонали = " + bombs[ii+1][jj-1] + ", bombs.length = " + bombs.length);
            countBombs++;
        } else System.out.println("ii+1 = " + (ii + 1) + ", jj-1 = " + (jj-1) + ", бомбы в нижней левой диагонали нет(или поле снизу закончилось)");

        // проверка верхней левой диагонали
        if (((ii-1) >= 0) && ((jj-1) >= 0) && (bombs[ii-1][jj-1])) {
            System.out.println("ii-1 = " + (ii - 1) + ", jj-1 = " + (jj-1) +
                    ", бомба в верхней левой диагонали = " + bombs[ii-1][jj-1] + ", bombs.length = " + bombs.length);
            countBombs++;
        } else System.out.println("ii-1 = " + (ii - 1) + ", jj-1 = " + (jj-1) + ", бомбы в верхней левой диагонали нет(или поле снизу закончилось)");

        // проверка нижней правой диагонали
        if (((ii+1) < bombs.length) && ((jj+1) < bombs.length) && (bombs[ii+1][jj+1])) {
            System.out.println("ii+1 = " + (ii + 1) + ", jj+1 = " + (jj+1) +
                    ", бомба в нижней правой диагонали = " + bombs[ii+1][jj+1] + ", bombs.length = " + bombs.length);
            countBombs++;
        } else System.out.println("ii+1 = " + (ii + 1) + ", jj+1 = " + (jj+1) + ", бомбы в нижней правой диагонали нет(или поле снизу закончилось)");

        // проверка верхней правой диагонали
        if (((ii-1) >= 0) && ((jj+1) < bombs.length) && (bombs[ii-1][jj+1])) {
            System.out.println("ii-1 = " + (ii - 1) + ", jj+1 = " + (jj+1) +
                        ", бомба в верхней правой диагонали = " + bombs[ii-1][jj+1] + ", bombs.length = " + bombs.length);
            countBombs++;
        } else System.out.println("ii-1 = " + (ii - 1) + ", jj+1 = " + (jj+1) + ", бомбы в верхней правой диагонали нет(или поле снизу закончилось)");

        return String.valueOf(countBombs);
    }
}