
public class Lab1 {
    
    static Object[][] points = { { 1.0, 1.0, 'A' }, { 1.0, 2.0, 'A' }, { 3.0, 3.0, 'A' }, {4.0, 1.0, 'B' }, { 5.0, 2.0, 'B' }, { 4.0, 1.0, 'B' }, { 6.0, 6.0, 'B' } };
    public static void main(String argv[]){


        Classification.points_printer(points);
        Classification.mean_x(points);
        Classification.mean_y(points);
        Classification.b1(points);
        Classification.b0(Classification.x_mean, Classification.y_mean, Classification.b1);
		System.out.println("--------------------------------------------------------- ");
        System.out.println("Mean:		X1 : " + String.format("%.3g",Classification.x_mean) + "	|	Y1 : " + String.format("%.3g",Classification.y_mean) + "	|");
        System.out.println("OffSet:		X2 : " + 0.0 + "	|	Y2 : " + String.format("%.3g",Classification.b0) + "	|");
        System.out.println("---------------------------------------------------------");
        System.out.println("\nEquation of the line: y = " + String.format("%.3g",Classification.b0) + " + " + String.format("%.3g",Classification.b1) + "x");

		//------------------------PERCEPTRON BIT -------------------------------

		System.out.println();
		Perceptron.train_model();
		Perceptron.prediction(Perceptron.weighted_sum);
		System.out.println("------------------ Predictions -----------------------");
		// Printing out the output after training
		for(int i = 0; i < points.length; i++){
			System.out.println("(x,y) = (" + points[i][0] + ", " + points[i][1] + ")" + "	desired: " + points[i][2] + "	predicted: " + Perceptron.predictions[i]);
		}
    }

    
    
}
