import java.util.*;

public class pQ {
    static class Triplet implements Comparable<Triplet>{
        double hval;
        double x;
        double y;
         
        public Triplet(double hval, double x, double y){
            this.hval = hval;
            this.x = x;
            this.y = y;
        }
         
        public String toString(){
            return "[" + hval + ", " + "("+ x + "," + y + ")" + "]";
        }
 
        @Override
        public int compareTo(Triplet trip) {
            return this.hval - tup.hval;
        }
}

