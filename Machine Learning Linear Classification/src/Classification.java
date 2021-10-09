public class Classification {

    static double x_mean = 0.0;
    static double y_mean = 0.0;
    static double b0 = 0.0;
    static double b1 = 0.0;

    static double xmean_sum = 0.0; // x - mean of x
    static double sumX_Y = 0.0; // sum x - mean of x times sum of y - mean of y

    public Classification() {
    }

    // Printing all the variables
    public static void points_printer(Object[][] x_y) {

        System.out.println("Points: ");
        System.out.println("-------------");
        for (Object[] x : x_y) {

            for (Object y : x) {
                System.out.print(y + " " + "|");
            }

            System.out.println();
        }

        System.out.println("-------------");

    }

    // Calculating the line for classification by regression

    // calculating the mean for x
    public static double mean_x(Object[][] array_x) {

        for (int i = 0; i < array_x.length; i++) {

            x_mean += (double) array_x[i][0];

        }
        x_mean /= array_x.length;

        return x_mean;
    }

    // calculating mean of y
    public static double mean_y(Object[][] array_y) {

        for (int i = 0; i < array_y.length; i++) {

            y_mean += (double) array_y[i][1];
        }
        y_mean /= array_y.length;

        return y_mean;
    }

    // b1 working out
    public static double b1(Object[][] array) {
        double[] xmean = new double[array.length]; // x - mean of x
        double[] ymean = new double[array.length]; // y - mean of y
        // x - x mean working out
        for (int i = 0; i < array.length; i++) {
            xmean[i] = (double) array[i][0] - x_mean;
        }
        // y - y mean working out
        for (int j = 0; j < array.length; j++) {
            ymean[j] = (double) array[j][1] - y_mean;
        }
        // sum of the two arrays
        for (int k = 0; k < array.length; k++) {
            sumX_Y += (xmean[k] * ymean[k]);
        }
        // sum of x - mean of x squared
        for (int z = 0; z < array.length; z++) {

            xmean[z] = Math.pow(xmean[z], 2);
            xmean_sum += xmean[z];
        }

        b1 = sumX_Y / xmean_sum;

        return b1;
    }

    // b0 working out
    public static double b0(double x_mean, double y_mean, double b1) {
        b0 = (y_mean - (b1 * x_mean));
        return b0;
    }

}
