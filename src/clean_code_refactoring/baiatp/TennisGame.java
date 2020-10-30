package clean_code_refactoring.baiatp;

public class TennisGame {

    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public static String getScore(String player1Name, String player2Name, int player1Score, int palyer2Score) {
        String score = "";
        int tempScore = 0;
        if (player1Score == palyer2Score) {
            score = checkResult(player1Score);
        } else if (player1Score >= 4 || palyer2Score >= 4) {
            score = checkWin(player1Score, palyer2Score);
        } else {
            score = checkScore(player1Score, palyer2Score, score);
        }
        return score;
    }

    private static String checkResult(int player1Score) {
        String score;
        switch (player1Score) {
            case LOVE:
                score = "Love-All";
                break;
            case FIFTEEN:
                score = "Fifteen-All";
                break;
            case THIRTY:
                score = "Thirty-All";
                break;
            case FORTY:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    private static String checkScore(int player1Score, int player2Score, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                score += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }

    private static String checkWin(int player1Score, int player2Score) {
        String score;
        int minusResult = player1Score - player2Score;
        boolean checkAdvantagePlayer1 = minusResult == 1;
        boolean checkAdvantagePlayer2 = minusResult == -1;
        boolean checkWinPlayer1 = minusResult >= 2;
        if (checkAdvantagePlayer1) {
            score = "Advantage player1";
        } else if (checkAdvantagePlayer2) {
            score = "Advantage player2";
        } else if (checkWinPlayer1) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }
}

