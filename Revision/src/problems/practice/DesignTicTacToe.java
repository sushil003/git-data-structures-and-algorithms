package problems.practice;
/**
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Example:
Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|
 * @author Sushil
 *
 */
public class DesignTicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 
    int[] rows;
    int[] cols;
    int diagonal;
    int target;
    int antidiagonal;

    /** Initialize your data structure here. */
    public DesignTicTacToe(int n) {
        
        rows=new int[n];
        cols=new int[n];
        diagonal=0;
        antidiagonal=0;
        target=n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int sign = player==1 ? 1 : -1;
        int res =sign*target;
        rows[row]+=sign;
        cols[col]+=sign;
        if(row==col){
            diagonal+=sign;
        }
        
        if(row==target-1-col){
           antidiagonal+=sign; 
        }
        
        if(rows[row]==res || cols[col]==res || diagonal==res || antidiagonal==res){
            return player;
        }else {
            return 0;
        }
        
    }
}
