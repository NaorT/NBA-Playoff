/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package pkgfinal.project;


/**
 *
 * @author abuks
 */
public class Learning {
    
    double mat[][];
    double stats[][];
    double weight[];
    double alpha[];
    double ruleFromBF[];
            
    public Learning(double mat [][], double stat[][]){
        
        this.mat = new double[mat.length][mat[0].length];
        this.stats = new double[stat.length][stat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                this.mat[i][j] = mat[i][j];
            }
        }
        for (int i = 0; i < stats.length; i++) {
            for (int j = 0; j < stats[0].length; j++) {
                stats[i][j] = stat[i][j];
            }
        }
        AdaBoost();
    }
    
    public void AdaBoost(){
        
        //initialize components
        weight = new double[70];
        for (int i = 0; i < weight.length; i++) {
            weight[i] = (double)1/70;
        }
        double epsilon [] = new double[20];
        alpha = new double[20];
        ruleFromBF = new double[20];
        double lastWeight [] = new double[weight.length];
        for (int i = 0; i < lastWeight.length; i++) {
            lastWeight[i] = weight[i];
        }
        //how many rules we want?
        //make the AdaBoost Algorithm
        for (int i = 0; i < 20; i++) {
            double  [] rules = bruteForce(weight);
            ruleFromBF[i] = rules[0];
            epsilon[i] = rules[1];
            alpha[i] = (double)0.5*Math.log((1-epsilon[i])/epsilon[i]);
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[(int)ruleFromBF[i]][j] != stats[j][13]){
                    weight[(int)ruleFromBF[i]] = (double)lastWeight[i]*Math.exp(alpha[i]);
                }else
                    weight[(int)ruleFromBF[i]] = (double)lastWeight[i]*Math.exp(-1*alpha[i]);
            }
            lastWeight = weight;
            normalize(weight);
        }
    }
    
    public double[] normalize(double arr []){
        
        double sum = 0;
        double ans [] = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sum += (double)Math.sqrt(arr[i]*arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (double)arr[i]/sum;
        }
        return ans;
    }
    
    
    
    public double[] bruteForce(double [] weight){
        
        double bestRule_epsilon [] = new double[2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] != stats[j][13]){
                    weight[i] += (double)1/70;
                }
            }
        }
        bestRule_epsilon = findMin(weight);
        return bestRule_epsilon;
    }
    
    public double[] findMin(double arr []){
        
        double ans [] = new double[2];
        int index = 0;
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min){
                min = (double)arr[i];
                index = i;
            }
        }
        ans[0] = index;
        ans[1] = (double)min;
        return ans;
    }
    
    public double[] getRule(){
        return ruleFromBF;
    }
    
    public double[] getAlpha(){
        return alpha;
    }
    
}
