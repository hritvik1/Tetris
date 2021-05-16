// Code Written By ~Hritvik~
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
class Tetris
{
    static Scanner scan = new Scanner(System.in);
    static char board[][] = new char[14][17];
    static char shape_t[][] = new char[3][3];
    static char shape_square[][] = new char[3][3];
    static char shape_l[][] = new char[3][3];
    static char shape_i[][] = new char[3][3];
    static char temp_arr[][] = new char[3][3];
    static int row_start=1, col_start=7,rotations=0,moves=0,points=0,flag_4=0;
    static int rotations_save=0,moves_save=0,points_save=0;
    static char usr_input;
    static String player_name,player_name_save="____";
    public static void game_board()
    {
        int i,j;
        for(char[] Temp_board : board)
        {
            Arrays.fill(Temp_board, ' ');
        }
        for(i=0;i<14;i++)
        {
            board[i][0] = '|';
            board[i][16] = '|';
        }
        for(j=0;j<17;j++)
        {
            board[0][j] = '-';
            board[13][j] = '-';
        }
    }
    public static void startup()
    {
        clr_scr();
        System.out.println("\n\n\n\t\t\t...................................................................................................\n\n");
        System.out.println("\t\t\t\t\t\t\t    WELCOME TO TETRIS GAME v1.06");
        System.out.println("\n\t\t\t\t\t\t\t\tCoded By ~~Hritvik~~");
        System.out.println("\n\n\t\t\t     <<<<<<<<<<      PLEASE MAXIMIZE THE CONSOLE WINDOW FOR PROPER VISUALS.....      >>>>>>>>>>");
        System.out.println("\n\n\tLoading Save Game Files......");
        try
        {
            Thread.sleep(5000);
        }
        catch(Exception ee){}
        try
        {
            FileInputStream fin1 = new FileInputStream("C:\\Games\\Tetris\\Saves\\.tetris_v1.06_saves_rotations.dat");
            FileInputStream fin2 = new FileInputStream("C:\\Games\\Tetris\\Saves\\.tetris_v1.06_saves_moves.dat");
            FileInputStream fin3 = new FileInputStream("C:\\Games\\Tetris\\Saves\\.tetris_v1.06_saves_points.dat");
            BufferedReader bf1 = new BufferedReader(new FileReader("C:\\Games\\Tetris\\Saves\\.tetris_v1.06_saves_player_main.dat"));
            fin1.close();
            fin2.close();
            fin3.close();
            bf1.close();
            System.out.println("\n\tSave Game Loaded Successfully...");
        }
        catch(Exception e)
        {
            System.out.println("\n\tSave Game Not Found!!!!");
        }
        System.out.println("\n\n\n\t\t\t\t\t\t     Redirecting To Main Game In 6 Seconds........");
        try
        {
            Thread.sleep(6000);
        }
        catch(Exception e){}
    }
    public static void instructions()
    {
        System.out.println ("\n\n");
        System.out.println ("     *************************************************************************************************************************************************************\n");
        System.out.println ("\t\t\t\t\t\t\t\t   Welcome To Tetris Game");
        System.out.println ("\t\t\t\t\t\t\t\t     ~By Hritvik Maini\n\n");
        System.out.println ("\t\t\t\t\t\t\t      *** MUST READ BEFORE PLAYING!! ***\n");
        System.out.println ("\t\t\t\t\t\t\t\t\tInstructions");
        System.out.println ("\t\t\t\t This Program Is A Tetris Game (CMD Version). There Are 5 Keys For Controlling Tetrominoes (Shapes):");
        System.out.println ();
        System.out.println ("\t\t\t\t\t\t\t\t\t  S - Down");
        System.out.println ("\t\t\t\t\t\t\t\t\t  D - Right");
        System.out.println ("\t\t\t\t\t\t\t\t\t  A - Left");
        System.out.println ("\t\t\t\t\t\t\t\t\t  Q - Rotate (Anti-Clockwise)");
        System.out.println ("\t\t\t\t\t\t\t\t\t  E - Rotate (Clockwise)");
        System.out.println ("\t\t\t\t\t\t\t\t\t  Z - Quit Game");
        System.out.println ();
        System.out.println ("\t\t\t\t\t\t\t In This Version, Player Have To Move Down The Shape By Itself.");
        System.out.println ("\t\t\t\t\t\t\t Player Can Rotate The Shape Accordingly To Fit In Empty Space.");
        System.out.println ("\t\t\t\t Once The Lowest Line Of Game Board Has Been Completely Filed, It Will Be Automatically Removed & Player Gets A Point.");
        System.out.println ("\t\t\t\t  The Game Will End At That Moment When There Is No Space Left Or Player Reaches The Loation Where Tetrominoes Spawns.");
        System.out.println ("\t\t\t\tAt Last The Total Rotations, Movements & Points With Player Name Is Stored And Updated As Player Makes A New High Score.\n");
        System.out.println ("\t\t\t\t\t\t\t\t\tSo, Let's PLAY!!!\n");
    }
    public static void getname()
    {
        System.out.print("\n\n\t  Enter Player Name: ");
        player_name = scan.nextLine();
        System.out.println();
    }
    public static void greet()
    {
        System.out.println("\n\t\t\t\t\t\t\t\t      Hi " + player_name + "! Let's Start..\n\n");
    }
    public static void game_over_screen()
    {
        System.out.println("\t\t\t\t\t\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\t\t\t\t\t\t\t     GAME OVER!!!");
        System.out.println("\t\t\t\t\t\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~");
    }
    public static void high_score_screen()
    {
        System.out.println("\t\t\t\t\t\t      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\t\t\t\t\t   Congratulations " + player_name + " On Making A New HIGH SCORE!!!");
        System.out.println("\t\t\t\t\t\t      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");  
    }
    public static void score_screen()
    {
        System.out.println("\n\t\t\t\t\t\t\t\t    ..............................\n");
        System.out.println("\t\t\t\t\t\t\t\t\t  Player Name: " + player_name + "\n");
        System.out.println("\t\t\t\t\t\t\t\t\t   Total Points: " + points + "");
        System.out.println("\t\t\t\t\t\t\t\t\t   Total Moves: " + moves + "");
        System.out.println("\t\t\t\t\t\t\t\t\t  Total Rotations: " + rotations);
        System.out.println("\t\t\t\t\t\t\t\t    ..............................\n");
        System.out.println("\n\t\t\t\t\t\t\t\t\t Thanks For Playing....");
        about_game_screen();
    }
    public static void print_board()
    {
        int i,j;
        System.out.println("\t\t\t\t  ...................................................................................................\n");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t      High Score Made By " + player_name_save);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWith " + moves_save + " Moves, " + rotations_save + " Rotations & " + points_save + " Points\n");
        for(i=0;i<14;i++)
        {
            System.out.print("\t\t\t\t\t\t  ");
            for(j=0;j<17;j++)
            {
                System.out.print(board[i][j] + "   ");
            }
            System.out.println("\n");
        }
        System.out.println("\t\t\t\t  ...................................................................................................\n");
    }
    public static void shapes_default()
    {
        shape_t[0][0] = '@';
        shape_t[0][1] = '@';
        shape_t[0][2] = '@';
        shape_t[1][1] = '@';
        shape_t[2][1] = '@';
        shape_t[1][0] = ' ';
        shape_t[2][0] = ' ';
        shape_t[1][2] = ' ';
        shape_t[2][2] = ' ';
        shape_square[0][0] = '@';
        shape_square[0][1] = '@';
        shape_square[0][2] = '@';
        shape_square[1][0] = '@';
        shape_square[1][1] = '@';
        shape_square[1][2] = '@';
        shape_square[2][0] = '@';
        shape_square[2][1] = '@';
        shape_square[2][2] = '@';
        shape_l[0][0] = '@';
        shape_l[1][0] = '@';
        shape_l[2][0] = '@';
        shape_l[2][1] = '@';
        shape_l[2][2] = '@';
        shape_l[0][1] = ' ';
        shape_l[0][2] = ' ';
        shape_l[1][1] = ' ';
        shape_l[1][2] = ' ';
        shape_i[0][1] = '@';
        shape_i[1][1] = '@';
        shape_i[2][1] = '@';
        shape_i[0][0] = '@';
        shape_i[1][0] = ' ';
        shape_i[2][0] = '@';
        shape_i[0][2] = '@';
        shape_i[1][2] = ' ';
        shape_i[2][2] = '@';
    }
    public static void save_high_state()
    {
        try
        {
            FileOutputStream fout1 = new FileOutputStream("C:\\Games\\Tetris\\Saves\\.tetris_v1.06_saves_rotations.dat");
            FileOutputStream fout2 = new FileOutputStream("C:\\Games\\Tetris\\Saves\\.tetris_v1.06_saves_moves.dat");
            FileOutputStream fout3 = new FileOutputStream("C:\\Games\\Tetris\\Saves\\.tetris_v1.06_saves_points.dat");
            BufferedWriter bf1 = new BufferedWriter(new FileWriter("C:\\Games\\Tetris\\Saves\\.tetris_v1.06_saves_player_main.dat"));
            if(points>points_save || moves>moves_save)
            {
                fout1.write(rotations);
                fout2.write(moves);
                fout3.write(points);
                bf1.write(player_name);
                high_score_screen();
            }
            else
            {
                fout1.write(rotations_save);
                fout2.write(moves_save);
                fout3.write(points_save);
                bf1.write(player_name_save);
                game_over_screen();
            }
            fout1.close();
            fout2.close();
            fout3.close();
            bf1.close();
        }
        catch(Exception e)
        {
            clr_scr();
            System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t   I/O Error!!, Pls Launch Game From 'Launch Tetris.bat' File");
            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
            System.exit(0);
        }
    }
    public static void about_game_screen()
    {
        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTetris Game v1.06");
        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCoded By: ~Hritvik Maini");
        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSubmitted To: Manik Sir (CU-HP)");
        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLanguage Used: JAVA (JDK v14.0.1)");
        System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEditor Used: VS Code (v1.46.1)\n\n\n");
    }
    public static void exit_screen()
    {
        char exit_status;
        System.out.println("\t    ..............................................\n");
        System.out.print("\t\tDo You Really Want To Exit (Y or N): ");
        exit_status = scan.nextLine().charAt(0);
        if(exit_status=='y' || exit_status=='Y')
        {
            System.out.println("\n\t    ..............................................\n");
            clr_scr();
            System.out.println("\n\t\t\t\t\t\t\t  .................................................");
            System.out.println("\n\t\t\t\t\t\t\t\t\tThanks For Playing....");
            about_game_screen();
            System.exit(0);
        }
        else if(exit_status=='n' || exit_status=='N')
        {
            clr_scr();
            print_board();
        }
        else
        {
            clr_scr();
            System.out.println("\n\t\t  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t\t    Invalid Input, Try Again!!");
            System.out.println("\t\t  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            exit_screen();
        }
    }
    public static void rotate_shape_anti_clk(char mat[][]) 
    {
        int x,y;
        char temp_1;
        for(x=0;x<3/2;x++)
        {
            for(y=x;y<3-x-1;y++)
            {
                temp_1 = mat[x][y];
                mat[x][y] = mat[y][3-1-x];
                mat[y][3-1-x] = mat[3-1-x][3-1-y];
                mat[3-1-x][3-1-y] = mat[3-1-y][x];
                mat[3-1-y][x] = temp_1;
            } 
        }
    }
    public static void rotate_shape_clk(char mat[][]) 
    {
        int i,j;
        char temp_2;
        for(i=0;i<3/2;i++)
        {
            for(j=i;j<3-i-1;j++)
            {
                temp_2 = mat[i][j];
                mat[i][j] = mat[3-1-j][i];
                mat[3-1-j][i] = mat[3-1-i][3-1-j];
                mat[3-1-i][3-1-j] = mat[j][3-1-i];
                mat[j][3-1-i] = temp_2;
            }
        }
    }
    public static void tetris_main_logic()
    {
        int i,j,k,l,flag_3;
        int flag_a=0,flag_s=0,flag_d=0;
        char rand_shape[][] = random_shape();
        k=0;
        for(i=1;i<4;i++)
        {
            l=0;
            for(j=7;j<10;j++)
            {
                if(board[i][j]==' ')
                {
                    board[i][j] = rand_shape[k][l];
                    l++;
                }
                else
                {
                    flag_4=1;
                    break;
                }
            }
            if(flag_4==1)
            {
                break;
            }
            else
            {
                k++;
            }
        }
        if(flag_4==1)
        {
            clr_scr();
            print_board();
            save_high_state();
            score_screen();
            System.exit(0);
        }
        print_board();
        while(true)
        {
            flag_3=0;
            for(j=1;j<16;j++)
            {
                if(board[12][j]==' ')
                {
                    flag_3=1;
                    break;
                }
            }
            if(flag_3==0)
            {
                clr_scr();
                for(j=1;j<16;j++)
                {
                    board[12][j] = ' ';
                }
                for(i=11;i>=1;i--)
                {
                    for(j=1;j<16;j++)
                    {
                        board[i+1][j] = board[i][j];
                        board[i][j] = ' ';
                    }
                }
                points++;
                break;
            }
            try
            {
                System.out.println("\t......................................................\n");
                System.out.println("\t     Total Points: " + points + "");
                System.out.println("\t     Total Moves: " + moves + "");
                System.out.println("\t     Total Rotations: " + rotations + "\n");
                System.out.print("\t     Enter Your Choise: ");
                usr_input = scan.nextLine().charAt(0);
                System.out.println("\n\t......................................................\n");
            }
            catch(Exception e)
            {
                clr_scr();
                print_board();
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t    No Input, Try Again!!");
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                continue;
            }
            if(usr_input=='A' || usr_input=='a')
            {
                clr_scr();
                for(i=row_start;i<row_start+3;i++)
                {
                    if(board[i][col_start-1]=='@' || board[i][col_start-1]=='|')
                    {
                        flag_a=1;
                    }
                }
                if(flag_a==1)
                {
                    print_board();
                    System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("\t  Invalid Move, Try Again!!");
                    System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                    continue;
                }
                else
                {
                    for(i=row_start;i<row_start+3;i++)
                    {
                        for(j=col_start;j<col_start+3;j++)
                        {
                            board[i][j-1] = board[i][j];
                            board[i][j] = ' ';
                        }
                    }
                    col_start = col_start-1;
                    moves++;
                }
            }
            else if(usr_input=='D' || usr_input=='d')
            {
                clr_scr();
                for(i=row_start;i<row_start+3;i++)
                {
                    if(board[i][col_start+3]=='@' || board[i][col_start+3]=='|')
                    {
                        flag_d=1;
                    }
                }
                if(flag_d==1)
                {
                    print_board();
                    System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("\t  Invalid Move, Try Again!!");
                    System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                    continue;
                }
                else
                {
                    for(i=row_start;i<row_start+3;i++)
                    {
                        for(j=col_start+2;j>=col_start;j--)
                        {
                            board[i][j+1] = board[i][j];
                            board[i][j] = ' ';
                        }
                    }
                    col_start = col_start+1;
                    moves++;
                }
            }
            else if(usr_input=='s' || usr_input=='S')
            {
                clr_scr();
                for(j=col_start;j<col_start+3;j++)
                {
                    if(board[row_start+3][j]=='@' || board[row_start+3][j]=='-')
                    {
                        flag_s=1;
                    }
                }
                if(flag_s==1)
                {
                    break;
                }
                else
                {
                    for(i=row_start+2;i>=row_start;i--)
                    {
                        for(j=col_start;j<col_start+3;j++)
                        {
                            board[i+1][j] = board[i][j];
                            board[i][j] = ' ';
                        }
                    }
                    row_start = row_start+1;
                    moves++;
                }
            }
            else if(usr_input=='q' || usr_input=='Q')
            {
                clr_scr();
                int x=0,y;
                for(i=row_start;i<row_start+3;i++)
                {
                    y=0;
                    for(j=col_start;j<col_start+3;j++)
                    {
                        temp_arr[x][y] = board[i][j];
                        y++;
                    }
                    x++;
                }
                rotate_shape_anti_clk(temp_arr);
                x=0;
                for(i=row_start;i<row_start+3;i++)
                {
                    y=0;
                    for(j=col_start;j<col_start+3;j++)
                    {
                        board[i][j] = temp_arr[x][y];
                        y++;
                    }
                    x++;
                }
                rotations++;
            }
            else if(usr_input=='e' || usr_input=='E')
            {
                clr_scr();
                int x=0,y;
                for(i=row_start;i<row_start+3;i++)
                {
                    y=0;
                    for(j=col_start;j<col_start+3;j++)
                    {
                        temp_arr[x][y] = board[i][j];
                        y++;
                    }
                    x++;
                }
                rotate_shape_clk(temp_arr);
                x=0;
                for(i=row_start;i<row_start+3;i++)
                {
                    y=0;
                    for(j=col_start;j<col_start+3;j++)
                    {
                        board[i][j] = temp_arr[x][y];
                        y++;
                    }
                    x++;
                }
                rotations++;
            }
            else if(usr_input=='z' || usr_input=='Z')
            {
                clr_scr();
                exit_screen();
            }
            else
            {
                clr_scr();
                print_board();
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t  Invalid Input, Try Again!!");
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                continue;
            }
            print_board();
        }
        row_start=1;
        col_start=7;
        tetris_main_logic();
    }
    public static char[][] random_shape()
    {
        int range,min,max,rand;
        min = 1;
        max = 5;
        range = max-min+1;
        rand = (int)(Math.random()*range)+min;
        if(rand==1)
        {
            return shape_t;
        }
        else if(rand==2)
        {
            return shape_square;
        }
        else if(rand==3)
        {
            return shape_l;
        }
        else
        {
            return shape_i;
        }
    }
    public static void clr_scr()
    {   
	    try
        {	
		    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }
        catch(Exception E)
		{
			System.out.println(E);
		}
    }
    public static void main(String args[])
    {
        startup();
        clr_scr();
        try
        {
            FileInputStream fin1 = new FileInputStream("C:\\Games\\Tetris\\Saves\\.tetris_v1.06_saves_rotations.dat");
            FileInputStream fin2 = new FileInputStream("C:\\Games\\Tetris\\Saves\\.tetris_v1.06_saves_moves.dat");
            FileInputStream fin3 = new FileInputStream("C:\\Games\\Tetris\\Saves\\.tetris_v1.06_saves_points.dat");
            BufferedReader bf1 = new BufferedReader(new FileReader("C:\\Games\\Tetris\\Saves\\.tetris_v1.06_saves_player_main.dat"));
            rotations_save = fin1.read();
            moves_save = fin2.read();
            points_save = fin3.read();
            player_name_save = bf1.readLine();
            fin1.close();
            fin2.close();
            fin3.close();
            bf1.close();
        }
        catch(Exception e)
        {
            rotations_save = 0;
            moves_save = 0;
            points_save = 0;
            player_name_save = "____";
        }
        clr_scr();
        instructions();
        getname();
        clr_scr();
        greet();
        shapes_default();
        game_board();
        tetris_main_logic();
    }
}
//Coded By ~~Hritvik~~