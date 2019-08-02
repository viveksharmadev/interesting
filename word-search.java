// https://leetcode.com/problems/word-search/
class word-search {
    // tc -> m*n*4^L, sc-> m*n
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(doesWordExist(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean doesWordExist(char[][] board, String word, int row, int col, int index){
        if(index==word.length()) return true;
        if(row<0 || row>board.length-1 || col<0 || col>board[0].length-1 
           || board[row][col]!=word.charAt(index))
            return false;
        board[row][col] = '*';
        boolean doesExist = doesWordExist(board, word, row+1, col, index+1)
            || doesWordExist(board, word, row-1, col, index+1)
            || doesWordExist(board, word, row, col+1, index+1)
            || doesWordExist(board, word, row, col-1, index+1);
        board[row][col] = word.charAt(index);
        return doesExist;
    }
}
