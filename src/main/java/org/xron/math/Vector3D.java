package org.xron.math;

/**
 * @author ben
 */
public class Vector3D {

  public double x;
  public double y;
  public double z;

  public Vector3D() {
    this.x = 0;
    this.y = 0;
    this.z = 0;
  }

  public Vector3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public void set(int newX, int newY, int newZ) {
    this.x = newX;
    this.y = newY;
    this.z = newZ;
  }

  public double magnitude() {
    return Math.sqrt(x * x + y * y + z * z);
  }

  public void normalize() {
    double magnitude = magnitude();
    this.x /= magnitude;
    this.y /= magnitude;
    this.z /= magnitude;
  }

  public void add(double x, double y, double z) {
    this.x += x;
    this.y += y;
    this.z += z;
  }

  public void add(Vector3D v) {
    this.add(v.x, v.y, v.z);
  }


  public void rotate(Vector3D up, int rads) {
    //TODO: Check parameters for errors

    //TODO: See below!
    throw new UnsupportedOperationException("Not yet implemented");
  }
  // Below is some C# code that I need to port
//            /// <summary>
//        /// Rotates the vector around an arbitrary axis.
//        /// </summary>
//        /// <param name="rotationAxis">A Vector3D representing the axis to rotate around.</param>
//        /// <param name="rotationAngle">The angle, in radians, to rotate the vector.</param>
//        /// <returns>A rotated vector.</returns>
//        /// <remarks>
//        /// If you have the book "3D Math Primer for Graphics and Game Development", it might be useful
//        /// to look at figure 8.12 on page 110 for a visual of what we're actually doing in this method.
//        /// Here's a translation between the variable names in this method and the variable names
//        /// in the diagram:
//        ///
//        /// this = v
//        /// rotationAxis = n
//        /// parallelVector = v[parallel]
//        /// perpendicularVector = v[perpendicular]
//        /// mutuallyPerpendicularVector = w
//        /// rotatedPerpendicularVector = v'[perpendicular]
//        /// rotatedVector = v'
//        ///
//        /// </remarks>
//        /// <see>
//        /// 3D Math Primer for Graphics and Game Development
//        /// by Fletcher Dunn and Ian Parberry
//        /// pp. 109-111
//        /// </see>
//        public Vector3D Rotate(Vector3D rotationAxis, double rotationAngle)
//        {
//            if (double.IsInfinity(rotationAngle) || double.IsNaN(rotationAngle))
//                throw new ArgumentException("Rotation angle cannot be Infinity or NaN.", "rotationAngle.");
//
//            if (rotationAxis == Vector3D.Zero)
//                throw new ArgumentException("You can't rotate around a zero vector.", "rotationAxis");
//
//            // Make sure our rotation axis is a unit vector.
//            rotationAxis = rotationAxis.Normalize();
//
//            // Project this vector onto the rotation axis using the dot product
//            // of this vector and the rotation axis.
//            Vector3D parallelVector = (this * rotationAxis) * rotationAxis;
//
//            // Project this vector onto the plane perpendicular to the rotation axis by subtracting the
//            // parallel vector from the original vector.
//            Vector3D perpendicularVector = this - parallelVector;
//
//            // Calculate a vector that is mutually perpendicular to parallelVector and perpendicularVector.
//            // We can do this with a cross product.
//            Vector3D mutuallyPerpendicularVector = rotationAxis.CrossProduct(perpendicularVector);
//
//            // Calculate the vector that represents the portion of our rotated vector that is perpendicular
//            // to our rotation vector.
//            Vector3D rotatedPerpendicularVector =
//                (Math.Cos(rotationAngle) * perpendicularVector)
//                + (Math.Sin(rotationAngle) * mutuallyPerpendicularVector);
//
//            // Now we finish up by calculating the completely rotated vector.
//            Vector3D rotatedVector = rotatedPerpendicularVector + parallelVector;
//
//            return rotatedVector;
//        }
}
