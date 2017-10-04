package esof322.a1;

import static java.lang.StrictMath.sqrt;

public class Vector3D {
    public final double x;
    public final double y;
    public final double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D scale(double f) {
        return new Vector3D(f*x, f*y, f*z);
    }

    public Vector3D add(Vector3D v) {
        return new Vector3D(x + v.x, y + v.y, z + v.z);
    }
    
    public Vector3D subtract(Vector3D v) {
        return new Vector3D(x - v.x, y - v.y, z - v.z);
    }
    
    public Vector3D negate() {
        return new Vector3D(x*(-1), y*(-1), z*(-1));
    }
	
	public double dot(Vector3D v) {
		return (x*v.x) + (y*v.y) + (z*v.z);
	}
	
	public double magnitude() {
		return sqrt((x*x) + (y*y) + (z*z));
	}

	public String toString(){
		return "Coordinates are x: " + x + "  y: " + y + "  z: " + z;
	}

	public boolean equals(Vector3D u){
		double tolerance = 0.00001;
		boolean a, b, c = false;
		a = Math.abs(x - u.x) < tolerance;
		b = Math.abs(y - u.y) < tolerance;
		c = Math.abs(z - u.z) < tolerance;

		if(a == true && b == true && c == true){
			return true;
		}else{
			return false;
		}
	}
}
