package stepDefinitions;

public class MyPojo {
    private String test;
    private A a;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public static class A {
        private int b;

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
}
