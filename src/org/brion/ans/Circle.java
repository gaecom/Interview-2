package org.brion.ans;

public class Circle extends Point {
	private int radix;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + radix;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (radix != other.radix)
			return false;
		return true;
	}

	public Circle(double x, double y, int radix) {
		super(x, y);
		this.radix = radix;
	}
	
	
}
