package minesweeper;

public class MinesweeperSetter {

    /**
     * 판의 크기를 기준으로 랜덤 좌표값 생성
     * @param mineCheckArray 지뢰 유무 표시를 위한 2차원 배열
     * @param mineNumberArray 지뢰 주변 숫자 표시를 위한 2차원 배열
     * @return
     */
    public void setMinePoint(boolean[][] mineCheckArray, int[][] mineNumberArray) {
        int xlength = mineCheckArray.length;
        int ylength = mineCheckArray[0].length;

        // 지뢰찾기 판의 크기를 기준으로 랜덤 좌표값 생성
        int xPoint = (int) (Math.random() * xlength);
        int yPoint = (int) (Math.random() * ylength);

        setMine(mineCheckArray, mineNumberArray, xPoint, yPoint);
    }

    /**
     * 랜덤하게 받은 좌표를 중복체크하고 2차원 배열에 지뢰 적용
     * @param mineCheckArray 지뢰 유무 표시를 위한 2차원 배열
     * @param mineNumberArray 지뢰 주변 숫자 표시를 위한 2차원 배열
     * @param xPoint 지뢰의 x좌표
     * @param yPoint 지뢰의 y좌표
     * @return
     */
    private void setMine(boolean[][] mineCheckArray, int[][] mineNumberArray, int xPoint, int yPoint) {

        if (mineCheckArray[xPoint][yPoint]) {
            // 이미 지뢰가 생성된 좌표는 다시 좌표를 받아온다.
            setMinePoint(mineCheckArray, mineNumberArray);
        } else {
            // 해당 좌표에 지뢰 표시
            mineCheckArray[xPoint][yPoint] = true;
            setMineAroundNumber(mineNumberArray, xPoint, yPoint);
        }
    }

    /**
     * 지뢰 좌표를 기준으로 주위 숫자를 변경
     * @param mineNumberArray 지뢰 주변 숫자 표시를 위한 2차원 배열
     * @param xPoint 지뢰의 x좌표
     * @param yPoint 지뢰의 y좌표
     * @return
     */
    private void setMineAroundNumber(int[][] mineNumberArray, int xPoint, int yPoint) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                    // 지뢰 표시 가능
                } else {
                    // 지뢰의 좌표를 기준으로 주위 좌표를 가져온다.
                    int targetX = xPoint + j;
                    int targetY = yPoint + i;

                    // 좌표 값이 판을 벗어나면 Skip
                    if (targetX < 0 || targetX > 9 || targetY < 0 || targetY > 9) {
                        continue;
                    } else {
                        // 해당 좌표의 숫자 1 추가한다.
                        mineNumberArray[targetX][targetY] = mineNumberArray[targetX][targetY] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        MinesweeperSetter gameSetter = new MinesweeperSetter();

        // 가로 x 세로 10의 게임 생성
        boolean[][] mineCheckArray = new boolean[10][10];
        int[][] mineNumberArray = new int[10][10];

        // 10개의 지뢰 추가
        for (int i = 0; i < 10; i++) {
            gameSetter.setMinePoint(mineCheckArray, mineNumberArray);
        }

        // 숫자 판 출력
        for (int i = 0; i < mineNumberArray.length; i++) {
            for (int j = 0; j < mineNumberArray[0].length; j++) {
                System.out.print(mineNumberArray[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("-------------------");

        // 지뢰 표시 판 출력
        for (int i = 0; i < mineCheckArray.length; i++) {
            for (int j = 0; j < mineCheckArray[0].length; j++) {
                if (mineCheckArray[i][j]) {
                    System.out.print("X\t");
                } else {
                    System.out.print("O\t");
                }
            }
            System.out.println();
        }
    }

}
