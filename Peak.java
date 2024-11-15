import java.util.ArrayList;
import java.util.List;

// setter -> private
// getter -> public
// final
// 

public class Peak {
    public static void main(String[] args) {
        ImmutablePeak immutablePeak = new ImmutablePeak(10, 20);
        ImmutablePeak immutablePeak_2 = new ImmutablePeak(10, 20);
    }
}

public class ImmutablePeak {
    public final int num;
        public final int str;

        // private void setNum() {
            
        // }

        // private void setStr() {

        // }

        public int getNum() {
            return 0;
        }

        public int getStr() {
            return str;
        }

        get(int num, int str) {
            this.num = num;
            this.str = num;
        }
}


