package Recursive Functions;

import java.util.Scanner;

class Bomb {
    int x, y, r, exploded;

    public Bomb(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.exploded = 0;
    }
}

public class BombSimulation {
    static Bomb[] bombs;
    static int n, k;

    static double dist2(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    static void explode(int k) {
        bombs[k].exploded = 1;
        for (int i = 1; i <= n; i++) {
            if (bombs[i].exploded == 0 && dist2(bombs[k].x, bombs[k].y, bombs[i].x, bombs[i].y) <= bombs[k].r * bombs[k].r) {
                explode(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        k = scanner.nextInt();

        bombs = new Bomb[n + 1];
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int r = scanner.nextInt();
            bombs[i] = new Bomb(x, y, r);
        }

        explode(k);

        int remaining = 0;
        for (int i = 1; i <= n; i++) {
            if (bombs[i].exploded == 0) {
                remaining++;
            }
        }

        System.out.println(remaining);

        scanner.close();
    }
}

