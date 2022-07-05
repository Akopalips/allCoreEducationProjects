package core.practice348;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ComplexNumber kappa = new ComplexNumber(1,2), pogchamp =  new ComplexNumber(1,2), seemsgood = kappa;
        System.out.printf("%b, %b, %b \n",kappa.equals(seemsgood), kappa.equals(pogchamp), pogchamp.equals(seemsgood));
        System.out.printf("%b, %b, %b \n",kappa.equals(seemsgood), kappa.equals(pogchamp), pogchamp.equals(seemsgood));
        System.out.printf("%b, %b, %b \n",kappa.equals(seemsgood), kappa.equals(pogchamp), pogchamp.equals(seemsgood));
        System.out.printf("%d, %d, %d \n", kappa.hashCode(), pogchamp.hashCode(), seemsgood.hashCode());
        System.out.printf("%d, %d, %d \n", kappa.hashCode(), pogchamp.hashCode(), seemsgood.hashCode());
        System.out.printf("%d, %d, %d \n", kappa.hashCode(), pogchamp.hashCode(), seemsgood.hashCode());

    }
    public static class ComplexNumber {
        private double re;//действительная часть
        private double im;//мнимая часть

        public ComplexNumber() {
        }

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            ComplexNumber tmp = (ComplexNumber) o;
            return (Double.compare(this.re, tmp.re) == 0 && Double.compare(this.im, tmp.im) == 0);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.re, this.im);
        }
    }
}