public class Vector {

    private double[] components;

    public Vector(double[] c) throws VectorException {
        if (c.length != 2 && c.length != 3) {
            throw new VectorException("Vector must be 2D or 3D.");
        }
        components = c;
    }

    private void checkDimensions(Vector other) throws VectorException {
        if (this.components.length != other.components.length) {
            throw new VectorException("Vectors must have same dimensions.");
        }
    }

    // Addition
    public Vector add(Vector other) throws VectorException {
        checkDimensions(other);
        double[] result = new double[components.length];
        for (int i = 0; i < components.length; i++) {
            result[i] = this.components[i] + other.components[i];
        }
        return new Vector(result);
    }

    // Subtraction
    public Vector subtract(Vector other) throws VectorException {
        checkDimensions(other);
        double[] result = new double[components.length];
        for (int i = 0; i < components.length; i++) {
            result[i] = this.components[i] - other.components[i];
        }
        return new Vector(result);
    }

    // Dot product
    public Vector multiply(double scalar) throws VectorException {
        double[] result = new double[components.length];
        for (int i = 0; i < components.length; i++) {
            result[i] = this.components[i] * scalar;
        }
        return new Vector(result);
    }

    // Dot product
    public double dot(Vector other) throws VectorException {
        checkDimensions(other);
        double sum = 0;
        for (int i = 0; i < components.length; i++) {
            sum += this.components[i] * other.components[i];
        }
        return sum;
    }

    // ToString override
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < components.length; i++) {
            sb.append(components[i]);
            if (i < components.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public double[] getComponents() {
        return components;
    }
    public void displayArray() {
        System.out.print("[ ");
        for (double val : components) {
            System.out.print(val + " ");
        }
        System.out.println("]");
    }


}
