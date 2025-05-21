class Solution {
    public boolean solve(char[][] board,boolean[][] rows,boolean[][] cols,boolean[][] boxes){

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){

                if(board[i][j]=='.'){

                    for(char k='1';k<='9';k++){
                        int nums = k - '1';
                        int boxIndex = (i / 3) * 3 + (j / 3);

                        if(!rows[i][nums] && !cols[j][nums] && !boxes[boxIndex][nums]){
                            board[i][j] = k;
                            rows[i][nums] = true;
                            cols[j][nums] = true;
                            boxes[boxIndex][nums] = true;

                            if(solve(board,rows,cols,boxes)==true)
                              return true;
                           
                            board[i][j] = '.';
                            rows[i][nums] = false;
                            cols[j][nums] = false;
                            boxes[boxIndex][nums] = false;

                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] != '.'){
                    int nums = board[i][j] - '1';
                    rows[i][nums] = true;
                    cols[j][nums] = true;
                    boxes[3*(i/3) + j/3][nums] = true;
                }
            }
        }
        solve(board,rows,cols,boxes);
    }
}