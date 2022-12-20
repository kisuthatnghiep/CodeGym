package Refactor;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {
        StringBuilder score = new StringBuilder();
        int tempScore;
        boolean deuce = scorePlayer1 == scorePlayer2;
        if (deuce)
        {
            switch (scorePlayer1)
            {
                case 0:
                    score = new StringBuilder("Love-All");
                    break;
                case 1:
                    score = new StringBuilder("Fifteen-All");
                    break;
                case 2:
                    score = new StringBuilder("Thirty-All");
                    break;
                case 3:
                    score = new StringBuilder("Forty-All");
                    break;
                default:
                    score = new StringBuilder("Deuce");
                    break;

            }
        }
        else if (scorePlayer1 >= 4 || scorePlayer2 >= 4)
        {
            int minusResult = scorePlayer1 - scorePlayer2;
            if ( minusResult == 1) score = new StringBuilder("Advantage player 1");
            else if (minusResult == -1)
                score = new StringBuilder("Advantage player 2");
            else if (minusResult >= 2)
                score = new StringBuilder("Win for player 1");
            else
                score = new StringBuilder("Win for player 2");
        } else {
            for (int playerNumber = 1; playerNumber <= 2; playerNumber++)
            {
                if (playerNumber == 1)
                    tempScore = scorePlayer1;
                else {
                    score.append("-");
                    tempScore = scorePlayer2;
                }

                switch(tempScore)
                {
                    case 0:
                        score.append("Love");
                        break;
                    case 1:
                        score.append("Fifteen");
                        break;
                    case 2:
                        score.append("Thirty");
                        break;
                    case 3:
                        score.append("Forty");
                        break;
                }
            }
        }
        return score.toString();
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println(TennisGame.getScore("thanh","lam",2,3)) ;
    }
}