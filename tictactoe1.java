import java.util.Scanner;
class tictactoe
{
   static char[][] board; //making character array
    public tictactoe()
    {
        board =new char [3][3]; // the size of the character array
       initboard();//for initialising the board 
    }
void initboard()
{
    for (int i=0;i<board.length;i++)// the loop for making the indexes in the board as empty
    {
        for (int j=0;j<board[i].length;j++)//2-d array it is so inner loop 
        
        {
            board[i][j]=' ';

        }
    }
}
static void dispboard()//for how to diplay board 
{
    System.out.println("------------------");//above boundary
    for(int i=0;i<board.length;i++)//
    {
        System.out.print("| ");
        for(int j=0;j<board[i].length;j++)
        {
            System.out.print(board[i][j]+"  |  ");

        }
        System.out.println();
        System.out.println("------------------");

    }
}
static void placeMark(int row,int col,char mark)
{
    if(row>=0 && row<=2 && col>=0 && col<=2)
    {
        board[row][col]=mark;

    }
    else
    {
        System.out.println("invalid position");
    }
}
    static  boolean checkColwin()//for coloumn winning 
{
    for(int j=0; j<=2; j++)
    {
        if(board[0][j] != ' '     &&   board[0][j] == board[1][j] && board[1][j] == board[2][j])
        {
            return true;
        }
    }
    return false;
}
 static boolean checkRoWin()//for row winning
 {
    for(int i=0;i<=2;i++)
    {
        if ( board[i][0] != ' ' &&      board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
            return true ;
            
        }
    }
    return false;

 }
  static boolean checkDiagWin()//for diagonal winning 
 {
    if  (  board[0][0]!= ' ' &&  board[0][0]== board[1][1] && board[1][1] == board[2][2] || board[0][2] != ' ' && board[0][2] == board [1][1] && board[1][1] == board [2][0])
    {
           return true;
    }
    else {
        return false;
    }
 }
}

class HumanPlayer
{
    String name ;
    char mark;

    HumanPlayer(String name, char mark)//for the naming of player and the marker they will play as x or o
    {
        this.name = name ;//initialise the instance 
        this.mark = mark ;//initialise the instance 
    }
    void makeMove()
    {int row ;
        int col;
       Scanner scanner= new Scanner(System.in);
      do {
        System.out.println("Enter the row and col");//to enter the rows and coloumns to play 
         row =scanner.nextInt();
         col = scanner.nextInt();
      } while (!isValidMove(row, col));//check if the move made by the user is valid or not 
    
      tictactoe.placeMark(row, col, mark);
     }
     
     
     boolean isValidMove(int row , int col)//the part to check whether the move is valid or not 
        {
            if(row>= 0 && row <=2 && col >=0 && col <=2)
            {
                if(tictactoe.board[row][col]==' ')
                {
                    return true;
                }
            }
            return false;

        }
    
}
public class tictactoe1 //main class
{
    public static void main(String[]args)
    {
       tictactoe t=new tictactoe();
       HumanPlayer p1=new HumanPlayer("player1",'X');
       HumanPlayer p2= new HumanPlayer("Player2",'O' );

       HumanPlayer cp;
       cp = p1;

      while(true)
      {
        System.out.println(cp.name + " turn");
        cp.makeMove();
        tictactoe.dispboard();
        if(tictactoe.checkColwin() || tictactoe.checkRoWin() || tictactoe.checkDiagWin())
        {
         System.out.println(cp.name + " has won ");
         break;
        }
        else
        {
         if (cp==p1) {
             cp =  p2;
             
         }
         else 
         {
             cp = p1;
         }
        }
      }
       
      
    }
    
}
