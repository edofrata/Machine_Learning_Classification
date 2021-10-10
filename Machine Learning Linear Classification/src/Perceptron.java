public class Perceptron {

    // weight which will define our output
    static double[] weight = new double[2];
    // threshold to overcome whil will determine the prediction
    static final double threshold = 1;
    // weighted sum to compare with the threshold
    static double[] weighted_sum = new double[Lab1.points.length];
    // it will hold the prediction made
    static char[] predictions = new char[Lab1.points.length];

    public Perceptron() {
    }

    // it will randomly give a weight to the inputs between 0 to 1 in order to train the model with the exact weights
    public static double[] weight_decision() {

        for (int i = 0; i < weight.length; i++) {
            weight[i] = Math.random();
        }

        int i = 0;
        for (double data : weight) {
            System.out.println("W" + i + " = " + data);
            i++;
        }
        return weight;
    }

    // where the weighted sum will be calculated
    public static double[] train_model() {
         //weight_decision(); //decomment when need to use when training the model to find the weight

        double x_weight = 0.32833; // it will store the value for the weight for x
        double y_weight = 0.001; // it will store the value or the weight for y
        // double x_weight = weight[0]; //decomment in case of training
        // double y_weight = weight[1]; //decomment in case of training
        System.out.println("Weight_x = " + x_weight);
        System.out.println("Weight_y = " + y_weight);
        // Weighted sum formula
        for (int i = 0; i < weighted_sum.length; i++) {
            double xw_sum = 0.0; // x * X weight
            double yw_sum = 0.0; // y * Y weight
            xw_sum = (double) Lab1.points[i][0] * x_weight;
            yw_sum = (double) Lab1.points[i][1] * y_weight;

            weighted_sum[i] = xw_sum + yw_sum;
        }
        
        return weighted_sum;
    }

    // this function will mfill the array with the predictions made
    public static char[] prediction(double[] weight_sum) {

        // if weighted sum >= 1then 'A' else 'B'
        for (int i = 0; i < Lab1.points.length; i++) {
            // System.out.println("Weighted Sum: " + i + " ----> "  + weight_sum[i]); 
            if (weight_sum[i] >= threshold) {
                predictions[i] = 'B';
            } else {
                predictions[i] = 'A';
            }
        }

        return predictions;
    }
}
