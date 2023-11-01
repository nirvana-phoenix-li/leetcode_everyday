package everyday.march;

public class ConvertTemperature2469 {
    public static void main(String[] args) {

    }

    public double[] convertTemperature(double celsius) {
        double v = celsius + 273.15;
        double b = celsius*1.8 + 32;
        return new double[]{v,b};
    }
}
