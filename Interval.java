package izpit;

public class Interval {
    private Point a; // levo krajišče intervala
    private Point b; // desno krajišče intervala

    public Interval(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        // izberemo začetni oklepaj glede na a.closed
        char left  = a.closed ? '[' : '(';
        // izberemo končni oklepaj glede na b.closed
        char right = b.closed ? ']' : ')';
        // sestavimo niz oblike "[a,b)" ali "(a,b]"
        return String.format(
            "%c%.2f, %.2f%c",
            left,
            a.value,
            b.value,
            right
        );
    }
    public boolean includes(double x) {
    	if (a.value < x && b.value > x) {
    		return true;
    	}
    	if (x == a.value && a.closed) {
    			return true;
    }
    	if (x == b.value && b.closed){
			return true;
}
    	else
			return false;
}
    public boolean includes(double[] xs) {
        for (double x : xs) {
            if (!includes(x)) {
                return false;
            }
        }
        return true;
    }
    public boolean includes(Interval ab) {
    	if (this.a.value > ab.a.value) {
    		return false;
    	}
    	if (this.b.value < ab.b.value){
    		return false;
    	}
    	if ((this.a.value == ab.a.value) && (ab.a.closed && !this.a.closed)) {
    		return false;
    	}
    	if ((this.b.value == ab.b.value) && (ab.b.closed && !this.b.closed)) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    public static Interval merge(Interval fst, Interval snd) {
    	double leva_vrednost;
    	boolean leva_odprtost;
    	double desna_vrednost;
    	boolean desna_odprtost;
    	if ((fst.a.value == snd.a.value)&&(fst.a.closed == !snd.a.closed)) {
    		 leva_odprtost = true;
    		 leva_vrednost = fst.a.value;
    	}
    	else if (fst.a.value < snd.a.value) {
    		 leva_odprtost = fst.a.closed;
    		 leva_vrednost = fst.a.value;
    	}
    	else {
    		 leva_odprtost = snd.a.closed;
    		 leva_vrednost = snd.a.value;
    	}
    	if ((fst.b.value == snd.b.value)&&(fst.b.closed == !snd.b.closed)) {
    		 desna_odprtost = true;
    		 desna_vrednost = fst.a.value;
    	}
    	else if (fst.b.value > snd.b.value) {
    		 desna_odprtost = fst.b.closed;
    		 desna_vrednost = fst.b.value;
    	}
    	else {
    		 desna_odprtost = snd.b.closed;
    		 desna_vrednost = snd.b.value;
    	}
    	return new Interval(new Point(leva_vrednost, leva_odprtost), new Point(desna_vrednost,desna_odprtost));
    }
    public static void main(String[] args) {
    	Point a = new Point(0.0, true);
    	Point b = new Point(5.0, false);
    	Point c = new Point(5.0, true);
    	Point d = new Point(7.0, false);
    	Interval ab = new Interval(a, b);
    	System.out.println(ab);
    	System.out.println(ab.includes(5.0));
    	System.out.println(ab.includes(new double[] {0.0, 3.0}));
    	System.out.println(ab.includes(new Interval(a, c)));
    	System.out.println(Interval.merge(ab, new Interval(c, d)));
    }
    
}

class Point {
    public double value;   // vrednost krajišča
    public boolean closed; // zaprto krajišče?

    public Point(double value, boolean closed) {
        this.value  = value;
        this.closed = closed;
    }
}
