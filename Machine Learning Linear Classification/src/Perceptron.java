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

    // it will randomly give a weight to the inputs between -1 to 1 in order to
    // train
    // the model with the exact weights
    public static double[] weight_decision() {
        // This will be the decider for getting the range from -1 to 1
        double bias = 0.0;
        // Math random from -1 to 1 with bias
        for (int i = 0; i < weight.length; i++) {
            bias = Math.random();
            if (bias >= 0.5) {
                weight[i] = Math.random();
            } else {
                weight[i] = (Math.random() * -1);
            }
        }

        return weight;
    }

    // where the weighted sum will be calculated
    public static double[] train_model() {
        weight_decision(); // decomment when need to use when training the model to find the weight

        double x_weight = weight[0]; // decomment in case of training
        double y_weight = weight[1]; // decomment in case of training

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
            if (weight_sum[i] >= threshold) {
                predictions[i] = 'B';
            } else {
                predictions[i] = 'A';
            }
        }

        return predictions;
    }

    public static void epochs() {
        // cicles that the train models makes before getting to the result
        int epochs = 0;
        // the amount of errors it can make
        double errors = 0;
        
        for (int i = 0; i < Lab1.points.length; i++) {
            
            if (Perceptron.predictions[i] != (char) Lab1.points[i][2]) {
                errors++;
                
                if (errors > 1) {
                    train_model();
                    prediction(weighted_sum);
                    i = 0;
                    errors = 0;
                }
                epochs++;
                
            }

        }
        errors = ( Lab1.points.length - errors);
        errors = (errors / Lab1.points.length) * 100; 
        System.out.println("\nTotal Epochs: " + epochs);
        System.out.println("Accuracy percentage = " + String.format("%.3g",errors) + "%");
    }
}
