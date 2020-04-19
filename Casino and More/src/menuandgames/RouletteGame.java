package menuandgames;

import java.util.Random;

public class RouletteGame {
    private int payout = 0;
    private Random rand = new Random();
    private int winningNumber;
    private int numPlayers;

    public RouletteGame(int numPlayer){
        numPlayers = numPlayer;
        winningNumber = rand.nextInt(37); //winning number
    }

    public RouletteMyButton[][] setButtons(RouletteMyButton[][] buttons)
    {
        for(int j = 0; j < numPlayers; j++){
         //determines payouts for column, row, even/odd, 1-18, 19-36, 1st12, 2nd12, 3rd12 bets
            for(int i = 1; i < 37; i++)
            {
                if(winningNumber == i && i % 3 == 0)
                    buttons[j][145].payoutRate = 2;
                else if(winningNumber == i && i % 3 == 2)
                    buttons[j][146].payoutRate = 2;
                else if(winningNumber == i && i % 3 == 1)
                    buttons[j][147].payoutRate = 2;
                if(winningNumber == i && i < 19)
                {
                    buttons[j][151].payoutRate = 1;
                    if(i < 13)
                        buttons[j][148].payoutRate = 2;
                    if(i > 12)
                        buttons[j][149].payoutRate = 2;
                    if(i % 2 == 0)
                        buttons[j][152].payoutRate = 1;
                    else
                        buttons[j][155].payoutRate = 1;
                }
                if(winningNumber == i && i > 18)
                {
                    buttons[j][156].payoutRate = 1;
                    if(i < 25)
                        buttons[j][149].payoutRate = 2;
                    if(i > 24)
                        buttons[j][150].payoutRate = 2;
                    if(i % 2 == 0)
                        buttons[j][152].payoutRate = 1;
                    else
                        buttons[j][155].payoutRate = 1;
                }
            }
        }

        if(winningNumber == 0)
        {
            for(int j = 0; j < numPlayers; j++){
                buttons[j][0].payoutRate = 35;
                buttons[j][1].payoutRate = 17;
                buttons[j][25].payoutRate = 11;
                buttons[j][49].payoutRate = 17;
                buttons[j][73].payoutRate = 11;
                buttons[j][97].payoutRate = 17;
                buttons[j][121].payoutRate = 6;
            }
        }
        
        if(winningNumber == 1)
        {
            for(int j = 0; j < numPlayers; j++){
                buttons[j][73].payoutRate = 11;
                buttons[j][74].payoutRate = 17;
                buttons[j][75].payoutRate = 8;
                buttons[j][97].payoutRate = 17;
                buttons[j][98].payoutRate = 35;
                buttons[j][99].payoutRate = 17;
                buttons[j][121].payoutRate = 6;
                buttons[j][122].payoutRate = 11;
                buttons[j][123].payoutRate = 5;
                buttons[j][154].payoutRate = 1;
            }
        }

        if(winningNumber == 2)
        {
            for(int j = 0; j < numPlayers; j++){
                buttons[j][25].payoutRate = 11;
                buttons[j][26].payoutRate = 17;
                buttons[j][27].payoutRate = 8;
                buttons[j][49].payoutRate = 17;
                buttons[j][50].payoutRate = 35;
                buttons[j][51].payoutRate = 17;
                buttons[j][121].payoutRate = 6;
                buttons[j][122].payoutRate = 11;
                buttons[j][123].payoutRate = 5;
                buttons[j][153].payoutRate = 1;
                buttons[j][73].payoutRate = 11;
                buttons[j][74].payoutRate = 17;
                buttons[j][75].payoutRate = 8;
            }
        }

        if(winningNumber == 3)
        {
            for(int j = 0; j < numPlayers; j++){
                buttons[j][25].payoutRate = 11;
                buttons[j][26].payoutRate = 17;
                buttons[j][27].payoutRate = 8;
                buttons[j][1].payoutRate = 17;
                buttons[j][2].payoutRate = 35;
                buttons[j][3].payoutRate = 17;
                buttons[j][121].payoutRate = 6;
                buttons[j][122].payoutRate = 11;
                buttons[j][123].payoutRate = 5;
                buttons[j][154].payoutRate = 1;
            }
        }
        //function calls to determine payouts for numbers 4-33
        if(winningNumber == 4)
            buttons = setPayout(buttons, 99,100,101,75,76,77,123,124,125,153);
        if(winningNumber == 5)
            buttons = setPayout(buttons, 51,52,53,27,28,29,123,124,125,75,76,77,154); 
        if(winningNumber == 6)
            buttons = setPayout(buttons, 3,4,5,27,28,29,123,124,125,153);
        if(winningNumber == 7)
            buttons = setPayout(buttons, 101,102,103,77,78,79,125,126,127,154);
        if(winningNumber == 8)
            buttons = setPayout(buttons, 53,54,55,29,30,31,125,126,127,77,78,79,153);
        if(winningNumber == 9)
            buttons = setPayout(buttons, 5,6,7,29,30,31,125,126,127,154);
        if(winningNumber == 10)
            buttons = setPayout(buttons, 103,104,105,79,80,81,127,128,129,153);
        if(winningNumber == 11)
            buttons = setPayout(buttons, 55,56,57,31,32,33,127,128,129,79,80,81,153);
        if(winningNumber == 12)
            buttons = setPayout(buttons, 7,8,9,31,32,33,127,128,129,154);
        if(winningNumber == 13)
            buttons = setPayout(buttons, 105,106,107,81,82,83,129,130,131,153);
        if(winningNumber == 14)
            buttons = setPayout(buttons, 57,58,59,33,34,35,129,130,131,81,82,83,154);
        if(winningNumber == 15)
            buttons = setPayout(buttons, 9,10,11,33,34,35,129,130,131,153);
        if(winningNumber == 16)
            buttons = setPayout(buttons, 107,108,109,83,84,85,131,132,133,154);
        if(winningNumber == 17)
            buttons = setPayout(buttons, 59,60,61,35,36,37,131,132,133,83,84,85,153);
        if(winningNumber == 18)
            buttons = setPayout(buttons, 11,12,13,35,36,37,131,132,133,154);
        if(winningNumber == 19)
            buttons = setPayout(buttons, 109,110,111,85,86,87,133,134,135,154);
        if(winningNumber == 20)
            buttons = setPayout(buttons, 61,62,63,37,38,39,133,134,135,85,86,87,153);
        if(winningNumber == 21)
            buttons = setPayout(buttons, 13,14,15,37,38,39,133,134,135,154);
        if(winningNumber == 22)
            buttons = setPayout(buttons, 111,112,113,87,88,89,135,136,137,153);
        if(winningNumber == 23)
            buttons = setPayout(buttons, 63,64,65,39,40,41,135,136,137,87,88,89,154);
        if(winningNumber == 24)
            buttons = setPayout(buttons, 15,16,17,39,40,41,135,136,137,153);
        if(winningNumber == 25)
            buttons = setPayout(buttons, 113,114,115,89,90,91,137,138,139,154);
        if(winningNumber == 26)
            buttons = setPayout(buttons, 65,66,67,41,42,43,137,138,139,89,90,91,153);
        if(winningNumber == 27)
            buttons = setPayout(buttons, 17,18,19,41,42,43,137,138,139,154);
        if(winningNumber == 28)
            buttons = setPayout(buttons, 115,116,117,91,92,93,139,140,141,153);
        if(winningNumber == 29)
            buttons = setPayout(buttons, 67,68,69,43,44,45,139,140,141,91,92,93,153);
        if(winningNumber == 30)
            buttons = setPayout(buttons, 19,20,21,43,44,45,139,140,141,154);
        if(winningNumber == 31)
            buttons = setPayout(buttons, 117,118,119,93,94,95,141,142,143,153);
        if(winningNumber == 32)
            buttons = setPayout(buttons, 69,70,71,45,46,47,141,142,143,93,94,95,154);
        if(winningNumber == 33)
            buttons = setPayout(buttons, 21,22,23,45,46,47,141,142,143,153);

        if(winningNumber == 34)
        {
            for(int j = 0; j < numPlayers; j++){
                buttons[j][96].payoutRate = 17;
                buttons[j][95].payoutRate = 8;
                buttons[j][120].payoutRate = 35;
                buttons[j][119].payoutRate = 17;
                buttons[j][144].payoutRate = 11;
                buttons[j][143].payoutRate = 5;
                buttons[j][154].payoutRate = 1;
            }
        }

        if(winningNumber == 35)
        {
            for(int j = 0; j < numPlayers; j++){
                buttons[j][48].payoutRate = 17;
                buttons[j][47].payoutRate = 8;
                buttons[j][96].payoutRate = 17;
                buttons[j][95].payoutRate = 8;
                buttons[j][71].payoutRate = 17;
                buttons[j][72].payoutRate = 35;
                buttons[j][144].payoutRate = 11;
                buttons[j][143].payoutRate = 5;
                buttons[j][154].payoutRate = 1;
            }
        }

        if(winningNumber == 36)
        {
            for(int j = 0; j < numPlayers; j++){
                buttons[j][48].payoutRate = 17;
                buttons[j][47].payoutRate = 8;
                buttons[j][23].payoutRate = 17;
                buttons[j][24].payoutRate = 35;
                buttons[j][144].payoutRate = 11;
                buttons[j][143].payoutRate = 5;
                buttons[j][154].payoutRate = 1;
            }
        }
        return buttons;
    }

    //function to set top and bottom rows for payout
    public RouletteMyButton[][] setPayout(RouletteMyButton[][] buttons, int a, int b, int c, int d, int e, int f, int g, int h, int i, int j)
    {
        for(int k = 0; k < numPlayers; k++){
            buttons[k][a].payoutRate = 17;
            buttons[k][b].payoutRate = 35;
            buttons[k][c].payoutRate = 17;
            buttons[k][d].payoutRate = 8;
            buttons[k][e].payoutRate = 17;
            buttons[k][f].payoutRate = 8;
            buttons[k][g].payoutRate = 5;
            buttons[k][h].payoutRate = 11;
            buttons[k][i].payoutRate = 5;
            buttons[k][j].payoutRate = 1;
        }
            return buttons;
    }

    //function to set middle rows for payout
    public RouletteMyButton[][] setPayout(RouletteMyButton[][] buttons, int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, int m)
    {
        for(int n = 0; n < numPlayers; n++){
            buttons[n][a].payoutRate = 17;
            buttons[n][b].payoutRate = 35;
            buttons[n][c].payoutRate = 17;
            buttons[n][d].payoutRate = 8;
            buttons[n][e].payoutRate = 17;
            buttons[n][f].payoutRate = 8;
            buttons[n][g].payoutRate = 5;
            buttons[n][h].payoutRate = 11;
            buttons[n][i].payoutRate = 5;
            buttons[n][j].payoutRate = 8;
            buttons[n][k].payoutRate = 17;
            buttons[n][l].payoutRate = 8;
            buttons[n][m].payoutRate = 1;
        }
        return buttons;
    }

    //return payout for selected player
    public int getPayout(RouletteMyButton buttons[][], int numOfPlayer)
    {
        payout = 0;
            for(int i = 0; i < buttons[0].length; i++)
            {
                if(buttons[numOfPlayer][i].payoutRate != 0){
                    payout += (((buttons[numOfPlayer][i].payoutRate + 1) * buttons[numOfPlayer][i].currentBet));
                }
            }
        return payout;
    }

    public int getWinningNumber(){
        return winningNumber;
    }

}