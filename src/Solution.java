public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        boolean [][] matrix = new boolean [s.length()+1][p.length()+1];
        matrix[0][0] = true;

        for (int i = 2; i < p.length()+1; i++) {
            if(p.charAt(i-1) == '*' && matrix[0][i-2])
                matrix[0][i] = true;
        }

        for (int i = 1; i < s.length()+1 ; i++) {
            for (int j = 1; j < p.length()+1; j++) {

                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    matrix[i][j] = matrix[i-1][j-1];
                }

                if(p.charAt(j-1) == '*'){
                    matrix[i][j] = matrix[i][j-2] || (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && matrix[i-1][j];
                }
            }
        }
        return matrix[s.length()][p.length()];
    }
}
