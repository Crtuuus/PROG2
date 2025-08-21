public class Interval {
	
	private Point a;
	
	private Point b;

	public Interval(Point a, Point b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String toString() {
		return (a.closed? "[": "(") + a.value + ", " + b.value + (b.closed? "]": ")");
	}

	public boolean includes(double x) {
		return (x > a.value || x == a.value && a.closed) && (x < b.value || x == b.value && b.closed);
	}
	
	public boolean includes(double[] xs) {
		for (double x: xs)
			if (!includes(x))
				return false;
		return true;
	}
	
	public boolean includes(Interval ab) {
		return ab.a.value >= a.value && (!ab.a.closed || includes(ab.a.value)) && ab.b.value <= b.value && (!ab.b.closed || includes(ab.b.value));
	}
	
	public static Interval merge(Interval fst, Interval snd) {
		Point a = fst.a.value == snd.a.value? new Point(fst.a.value, fst.a.closed || snd.a.closed): fst.a.value < snd.a.value? fst.a: snd.a;
		Point b = fst.b.value == snd.b.value? new Point(fst.b.value, fst.b.closed || snd.b.closed): fst.b.value < snd.b.value? snd.b: fst.b;
		return new Interval(a, b);
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
	
	public double value;
	
	public boolean closed;

	public Point(double value, boolean closed) {
		this.value = value;
		this.closed = closed;
	}
	
}
