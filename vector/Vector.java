package vector;

public class Vector {
    private int x;
    private int y;
    private int z;
    
    public Vector() {
        x = 0;
        y = 0;
        z = 0;
    }
    
    public Vector(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getZ() {
        return this.z;
    }
    
    public void setX(int x){
        this.x  = x;
    }
    
    public void setY(int y){
        this.y  = y;
    }
    
    public void setZ(int z) {
        this.z = z;
    }
    
    public double magnitud() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }
    
    public String vectorUnitario() {
        double m = magnitud();
        return "Vector Unitario: (" + x + "/" + m + ", " + y + "/" + m + ", " + x + "/" + m +
                "\nMagnitud del vector unitario: " +
                Math.sqrt(Math.pow(x / m, 2) + Math.pow(y / m, 2) + Math.pow(z / m, 2));
    }
        
    public Vector multiEscalar(int i) {
        return new Vector(x * i, y * i, z * i);
    }
    
    public Vector sumaVectores(Vector v) {
        return new Vector(x + v.getX(), y + v.getY(), z + v.getZ());
    }
    
    public int productoPunto(Vector v) {
        return (x * v.getX()) + (y * v.getY()) + (z * v.getZ());
    }
    
    public Vector productoCruz(Vector v) {
        int xr, yr, zr;
        xr = (y * v.getZ()) - (v.getY() * z);
        yr = -((x * v.getZ()) - (v.getX() * z));
        zr = (x * v.getY()) - (v.getX() * y);
        return new Vector(xr, yr, zr);
    }
    
    public boolean validacion(Vector v) {
        Vector r = new Vector();
        r = sumaVectores(v);
        return (r.magnitud() == 0);
    }
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
