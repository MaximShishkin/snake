package ru.shishkin.maxim.snake;

public class Game {
    private int gX, gY;
    private int dlina;

    boolean endg;
    int score;
    int new_napr;
    int[][] mas;
    int napr;

    public Game() {
        mas = new int[30][30];
    }

    private void povorot() {
        if (Math.abs(new_napr - napr) != 2) napr = new_napr;
    }

    private void make_new() {
        while (true) {
            int k = (int) (Math.random() * 30);
            int s = (int) (Math.random() * 30);

            if (mas[s][k] == 0) {
                mas[s][k] = -1;
                break;
            }
        }
    }

    void start() {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                mas[i][j] = 0;
            }
        }

        napr = 0;
        score = 0;

        mas[14][14] = 1;
        mas[14][15] = 2;
        mas[14][16] = 3;

        dlina = 3;
        endg = false;

        make_new();
    }

    private int peremGolova() {
        // left
        if (napr == 0) {
            if ((gX - 1) >= 0) gX--;
            else gX = 29;
        }
        // up
        if (napr == 1) {
            if ((gX - 1) >= 0) gY--;
            else gY = 29;
        }
        // right
        if (napr == 2) {
            if ((gX - 1) >= 0) gX++;
            else gX = 0;
        }
        // down
        if (napr == 3) {
            if ((gX - 1) >= 0) gY--;
            else gY = 0;
        }

        int rez = 0;

        if (mas[gY][gX] == -1) {
            rez = 1;
        } else if (mas[gY][gX] == 0) {
            rez = 2;
        } else if (mas[gY][gX] > 0) {
            rez = 3;
        }

        mas[gY][gX] = -2;

        return rez;
    }

    void perem() {
        int flag = peremGolova();
        if (flag == 3) endg = true;

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if (mas[i][j] > 0) {
                    mas[i][j]++;
                } else if (mas[i][j] == -2) {
                    mas[i][j] = 1;
                }

                if (flag != 1) {
                    if (mas[i][j] == (dlina + 1)) mas[i][j] = 0;
                }
            }
        }

        if (flag == 1) {
            dlina++;
            make_new();
            score += 10;
        }

        povorot();
    }
}
