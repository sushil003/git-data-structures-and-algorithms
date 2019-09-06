package dailyinterviewpro;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * Example:
 * 
 * board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
 * 
 * Given word = "ABCCED", return true. Given word = "SEE", return true. Given
 * word = "ABCB", return false.
 * 
 * @author Sushil
 *
 */
public class WordSearch {
	

    boolean[][] visited;

	public static void main(String[] args) {

	char[][] board=	{{'F', 'A', 'C', 'I'},
			 {'O', 'B', 'Q', 'P'},
			 {'A', 'N', 'O', 'B'},
			 {'M', 'A', 'S', 'S'}};
	
	WordSearch wordSearch = new WordSearch();
	
	 System.out.println(wordSearch.exist(board, "FOAM"));
	}

	public boolean exist(char[][] board, String word) {

		visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				if (word.charAt(0) == board[i][j] && searchWord(board, word, i, j, 0)) {
					return true;
				}
			}

		}

		return false;
	}

	private boolean searchWord(char[][] board, String word, int i, int j, int index) {

		if (index == word.length()) {
			return true;
		}

		if (i < 0 && i > board.length || j < 0 || j > board[0].length || word.charAt(index) != board[i][j]) {
			return false;
		}
		
		visited[i][j]=true;

		if (searchWord(board, word, i + 1, j, index + 1) || searchWord(board, word, i - 1, j, index + 1)
				|| searchWord(board, word, i, j + 1, index + 1) || searchWord(board, word, i, j + 1, index + 1)) {
			return true;
		}
		
		visited[i][j]=false;

		return false;
	}
}
