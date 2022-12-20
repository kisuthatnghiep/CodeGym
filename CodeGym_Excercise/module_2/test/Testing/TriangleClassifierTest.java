package Testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    void triangleClassifierTest1() {
        int a = 2;
        int b = 2;
        int c = 2;
        String expected = "tam giác đều";
        String result = TriangleClassifier.triangleClassifier(a,b,c);
        assertEquals(expected,result);
    }

    @Test
    void triangleClassifierTest2() {
        int a = 2;
        int b = 2;
        int c = 3;
        String expected = "tam giác cân";
        String result = TriangleClassifier.triangleClassifier(a,b,c);
        assertEquals(expected,result);
    }

    @Test
    void triangleClassifierTest3() {
        int a = 3;
        int b = 4;
        int c = 5;
        String expected = "tam giác thường";
        String result = TriangleClassifier.triangleClassifier(a,b,c);
        assertEquals(expected,result);
    }

    @Test
    void triangleClassifierTest4() {
        int a = 8;
        int b = 2;
        int c = 3;
        String expected = "không phải tam giác";
        String result = TriangleClassifier.triangleClassifier(a,b,c);
        assertEquals(expected,result);
    }

    @Test
    void triangleClassifierTest5() {
        int a = -1;
        int b = 2;
        int c = 1;
        String expected = "không phải tam giác";
        String result = TriangleClassifier.triangleClassifier(a,b,c);
        assertEquals(expected,result);
    }

    @Test
    void triangleClassifierTest6() {
        int a = 0;
        int b = 1;
        int c = 1;
        String expected = "không phải tam giác";
        String result = TriangleClassifier.triangleClassifier(a,b,c);
        assertEquals(expected,result);
    }

}