/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch7_7;

/**
 *
 * @author dre's laptop
 */
public class Sales {
    
        //fields
        private final int DIVISIONS = 6;
        private final int QUARTERS = 4;
        public double[][] divisionSales = new double[DIVISIONS][QUARTERS];
        private double[] quarterlyTotal;
        
        
        //SETTERS
        //setting sales array
        public void setSales(int div, int qtr, double amount){
            divisionSales[div][qtr] = amount;
        }
        

        //GETTERS
        //getting array size
        public int rowSize(){
            return divisionSales.length;
        }
        
        //getting number of quarters size
        public int columnSize(){
            return divisionSales[0].length;
        }
        
        //getting total sales per divisions
        public double getSales(int div, int qtr){
            return divisionSales[div][qtr];
        }
        
        //getting quarterly sales per divisions
        public double getQuarterlyIncrease(int div, int qtr){
            return divisionSales[div][qtr];
        }
        
        /*
        //getting company's total for each quarters
        public double totalQuarterSales(int quarter){
            quarterlyTotal = new double[quarter];
            for (int div = 0; div < DIVISIONS; div++) {
                quarterlyTotal[quarter] += getSales(div, quarter);
            }
            return quarterlyTotal[quarter];
        }
        */
    
}
