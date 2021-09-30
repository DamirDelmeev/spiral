package com.epam.rd.autotasks;

class Spiral {
    public static void main(String[] args) {
        int[][] spiral = Spiral.spiral(4, 3);
        for (int[] ints : spiral) {
            for (int j = 0; j < ints.length; j++) {
                System.out.printf("%4s", ints[j]);
            }
            System.out.println();
        }
    }

    static int[][] spiral(int rows, int columns) {
        int[][] resultMatrix = new int[rows][columns];
        int direction = 0;
        int counterMax = rows * columns;
        int round = 0;
        for (int counter = 0; counter < counterMax; ) {
            switch (direction) {
                case 0:
                    done0:
                    for (int i = round; i < resultMatrix.length; i++) {
                        for (int j = round; j < resultMatrix[i].length; j++) {
                            if (j == columns - round) {
                                direction++;
                                break done0;
                            }
                            counter++;
                            resultMatrix[i][j] = counter;
                            if (counter == columns | counter == counterMax) {
                                direction++;
                                break done0;
                            }
                        }
                    }
                    break;
                case 1:
                    done1:
                    for (int i = columns - 1 - round; ; ) {
                        for (int j = 1 + round; j < rows; j++) {
                            if (j == rows - round) {
                                direction++;
                                break done1;
                            }
                            counter++;
                            resultMatrix[j][i] = counter;
                            if (counter == rows + i | counter == counterMax) {
                                direction++;
                                break done1;
                            }
                        }
                    }
                    break;
                case 2:
                    done2:
                    for (int i = rows - 1 - round; ; ) {
                        for (int j = columns - 2 - round; j >= 0; j--) {
                            if (j == 0 & round != 0) {
                                direction++;
                                break done2;
                            }
                            counter++;
                            resultMatrix[i][j] = counter;
                            if (counter == rows + columns + (columns - 2) | counter == counterMax) {
                                direction++;
                                break done2;
                            }
                        }
                        break;
                    }
                    break;
                case 3:
                    done3:
                    for (int i = round; ; ) {
                        for (int j = rows - 2 - round; j != 0; j--) {
                            if (j == round) {
                                direction = 0;
                                round++;
                                break done3;
                            }
                            counter++;
                            resultMatrix[j][i] = counter;
                            if (counter == columns + (rows - 1) + (columns - 1) + (rows - 2) | counter == counterMax) {
                                direction = 0;
                                round++;
                                break done3;
                            }
                        }
                    }
                    break;
            }
        }
        return resultMatrix;
    }
}
