package clean_code_refactoring.baiatp;

public class TennisGame {

    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        String score = "";
        int tempScore = 0;
        if (m_score1 == m_score2) {
            score = checkResult(m_score1);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = checkWin(m_score1, m_score2);
        } else {
            score = checkScore(m_score1, m_score2, score);
        }
        return score;
    }

    private static String checkResult(int m_score1) {
        String score;
        switch (m_score1) {
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

    private static String checkScore(int m_score1, int m_score2, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = m_score1;
            else {
                score += "-";
                tempScore = m_score2;
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

    private static String checkWin(int m_score1, int m_score2) {
        String score;
        int minusResult = m_score1 - m_score2;
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

