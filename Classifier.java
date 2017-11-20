/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package pkgfinal.project;

import java.util.Arrays;


/**
 *
 * @author abuks
 */
public class Classifier {
    
    double statics [][];
    double rules [][];
    double randomMatrix[][];
    double rulesFromLearning[];
    double alpha[];
    
    public Classifier(double mat [][]){
        
        statics = new double[mat.length][mat[0].length];
        for (int i = 0; i < statics.length; i++) {
            for (int j = 0; j < statics[0].length; j++) {
                statics[i][j] = mat[i][j];
            }
        }
        rules = new double[70][30];
        /* weights = new double[70];
        for (int i = 0; i < weights.length; i++) {
        weights[i] = (double)1/70;
        }*/
        check_rules();
    }
    
    public void check_rules(){
        
        for (int j = 0; j < statics.length; j++) {
            //rules for points - >114 - >107
            rules[0][j] = (statics[j][0] >= 115 ? 1:-1);
            rules[1][j] = (statics[j][0] >= 114 ? 1:-1);
            rules[2][j] = (statics[j][0] >= 113 ? 1:-1);
            rules[3][j] = (statics[j][0] >= 112 ? 1:-1);
            rules[4][j] = (statics[j][0] >= 111 ? 1:-1);
            rules[5][j] = (statics[j][0] >= 110 ? 1:-1);
            rules[6][j] = (statics[j][0] >= 109 ? 1:-1);
            rules[7][j] = (statics[j][0] >= 108 ? 1:-1);
            rules[8][j] = (statics[j][0] >= 107 ? 1:-1);
            //rules for filed goald - >43 - > 38
            rules[9][j] = (statics[j][1] >= 43 ? 1:-1);
            rules[10][j] = (statics[j][1] >= 42 ? 1:-1);
            rules[11][j] = (statics[j][1] >= 41 ? 1:-1);
            rules[12][j] = (statics[j][1] >= 40 ? 1:-1);
            rules[13][j] = (statics[j][1] >= 39 ? 1:-1);
            rules[14][j] = (statics[j][1] >= 38 ? 1:-1);
            //rules for 3 points made - >13 - > 8
            rules[15][j] = (statics[j][2] >= 13 ? 1:-1);
            rules[16][j] = (statics[j][2] >= 12 ? 1:-1);
            rules[17][j] = (statics[j][2] >= 11 ? 1:-1);
            rules[18][j] = (statics[j][2] >= 10 ? 1:-1);
            rules[19][j] = (statics[j][2] >= 9 ? 1:-1);
            rules[20][j] = (statics[j][2] >= 8 ? 1:-1);
            //rules for free throws made - >20 - > 16
            rules[21][j] = (statics[j][3] >= 20 ? 1:-1);
            rules[22][j] = (statics[j][3] >= 19 ? 1:-1);
            rules[23][j] = (statics[j][3] >= 18 ? 1:-1);
            rules[24][j] = (statics[j][3] >= 17 ? 1:-1);
            rules[25][j] = (statics[j][3] >= 16 ? 1:-1);
            //rules for offensive rebounds - >12 - > 8
            rules[26][j] = (statics[j][4] >= 12 ? 1:-1);
            rules[27][j] = (statics[j][4] >= 11 ? 1:-1);
            rules[28][j] = (statics[j][4] >= 10 ? 1:-1);
            rules[29][j] = (statics[j][4] >= 9 ? 1:-1);
            rules[30][j] = (statics[j][4] >= 8 ? 1:-1);
            //rules for defensive rebound made - >35 - > 32
            rules[31][j] = (statics[j][5] >= 35 ? 1:-1);
            rules[32][j] = (statics[j][5] >= 34 ? 1:-1);
            rules[33][j] = (statics[j][5] >= 33 ? 1:-1);
            rules[34][j] = (statics[j][5] >= 32 ? 1:-1);
            //rules for  rebound - >46 - > 41
            rules[35][j] = (statics[j][6] >= 46 ? 1:-1);
            rules[36][j] = (statics[j][6] >= 45 ? 1:-1);
            rules[37][j] = (statics[j][6] >= 44 ? 1:-1);
            rules[38][j] = (statics[j][6] >= 43 ? 1:-1);
            rules[39][j] = (statics[j][6] >= 42 ? 1:-1);
            rules[40][j] = (statics[j][6] >= 41 ? 1:-1);
            //rules for free assit - >25 - > 19
            rules[41][j] = (statics[j][7] >= 25 ? 1:-1);
            rules[42][j] = (statics[j][7] >= 24 ? 1:-1);
            rules[43][j] = (statics[j][7] >= 23 ? 1:-1);
            rules[44][j] = (statics[j][7] >= 22 ? 1:-1);
            rules[45][j] = (statics[j][7] >= 21 ? 1:-1);
            rules[46][j] = (statics[j][7] >= 20 ? 1:-1);
            rules[47][j] = (statics[j][7] >= 19 ? 1:-1);
            //rules for free rurnovers - <12 - < 15
            rules[48][j] = (statics[j][8] <= 12 ? 1:-1);
            rules[49][j] = (statics[j][8] <= 13 ? 1:-1);
            rules[50][j] = (statics[j][8] <= 14 ? 1:-1);
            rules[51][j] = (statics[j][8] <= 15 ? 1:-1);
            //rules for free steels - >8 - > 7
            rules[52][j] = (statics[j][9] >= 8 ? 1:-1);
            rules[53][j] = (statics[j][9] >= 7 ? 1:-1);
            //rules for free blocks - >6 - > 3.8
            rules[54][j] = (statics[j][10] >= 6 ? 1:-1);
            rules[55][j] = (statics[j][10] >= 5 ? 1:-1);
            rules[56][j] = (statics[j][10] >= 4 ? 1:-1);
            rules[57][j] = (statics[j][10] >= 3.8 ? 1:-1);
            //rules for free personal fouls - <17 - < 23
            rules[58][j] = (statics[j][11] <= 17 ? 1:-1);
            rules[59][j] = (statics[j][11] <= 18 ? 1:-1);
            rules[60][j] = (statics[j][11] <= 19 ? 1:-1);
            rules[61][j] = (statics[j][11] <= 20 ? 1:-1);
            rules[62][j] = (statics[j][11] <= 21 ? 1:-1);
            rules[63][j] = (statics[j][11] <= 22 ? 1:-1);
            rules[64][j] = (statics[j][11] <= 23 ? 1:-1);
            //rules for free personal fouls drown - >22 - > 18
            rules[65][j] = (statics[j][12] >= 22 ? 1:-1);
            rules[66][j] = (statics[j][12] >= 21 ? 1:-1);
            rules[67][j] = (statics[j][12] >= 20 ? 1:-1);
            rules[68][j] = (statics[j][12] >= 19 ? 1:-1);
            rules[69][j] = (statics[j][12] >= 18 ? 1:-1);
            
        }
        
        chooseRandom();
        
    }
    
    public void chooseRandom(){
        
        randomMatrix = new double[70][15];
        int rand [] = {2,3,10,5,29,17,27,12,11,9,15,23,26,8,20};
        
        for (int j = 0; j < randomMatrix[0].length; j++) {
            for (int i = 0; i < randomMatrix.length; i++) {
                randomMatrix[i][j] = rules[i][rand[j]];
            }
        }
        //System.out.println("the random teams is: " + Arrays.toString(rand));
        Learning l = new Learning(randomMatrix, statics);
        alpha = l.getAlpha();
        rulesFromLearning = l.getRule();
    }
    
    
    public double[] getRule(){
        return rulesFromLearning;
    }
    
    public double[] getAlpha(){
        return alpha;
    }
    
    public double [][] getAllRules(){
        return rules;
    }
    
}
