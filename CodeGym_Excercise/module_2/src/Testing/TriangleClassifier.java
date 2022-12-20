package Testing;

public class TriangleClassifier {
    public static String triangleClassifier(double a, double b, double c){
if ((a + b) > c && (a +c) > b && (b + c) > a && a > 0 && b > 0 && c > 0){
    if (a == b && b == c){
        return "tam giác đều";
    } else if (a == b || b == c || c ==a) {
        return "tam giác cân";
    }else
        return "tam giác thường";
}else
    return "không phải tam giác";
    }
}
