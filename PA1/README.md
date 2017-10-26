# ESOF 322 Team 11
This is the repository for Team 11 for ESOF 322 at Montana State University. I used IntelliJ IDEA to work on this, but you can use and IDE you want. I've added a .gitignore file to ignore your IDE files. Please double check to make sure they do not get commited with your work to avoid unnecissary merge conflicts.

## Directory Structure
At the root level there are 3 important folder:
- `lib` - Compiled libraries are stored in here (.jar files). Currently it contains JUnit and it's dependencies to run unit tests on all the assignments.
- `src` - All source files belong in here for each assignment. Make sure to keep a proper package structure.
- `test` - Test files for all source classes are stored here. The test files should match the structure of `src` files. Each class should have a test class that matches it's name (ie. `ClassName` and `ClassNameTest`.
## A1
Implement class `Vector3D`, that provides common vector arithmetic on 3D vectors. This class is intentionally easy to write, since the emphasis of this assignment is the environment, JUnit, and test-first development.
- Instances of `Vector3D` should be immutable. This means that there will be no way to modify an instance of `Vector3D`; all of `Vector3D`'s methods will return new instances
- Provide the following operations/methods:
  - a constructor that takes the x, y, and z coordinates, which should be doubles.
  - `Vector3D scale(double	f)`; which should multiply x, y, and z by a common factor f.
  - `Vector3D add(Vector3D	v)`; which takes one `Vector3D` as an argument adds the corresponding coordinates to its own and produces a new `Vector3D ( {x0, y0, z0} + {x1, y1, z1} = {x0+x1, y0+y1, z0+z1}`, where `x0`, `y0`, and `z0` are "this" object's coordinates and `x1`, `y1`, and `z1` are the argument `v`'s coordinates).
  - `Vector3D subtract(Vector3D v)`; Like add except you subtract argument `v`'s coordinates from the corresponding coordinates in "this" producing a new `Vector3D` object.
  - `Vector3D negate()`; This is shorthand for scale by -1.
  - `double dot(Vector3D v)`; Produce the dot product of "this" Vector3D and argument `Vector3D v ( {x0, y0, z0} dot {x1, y1, z1} = x0*x1 + y0*y1 + z0*z1 )`.
  - `double magnitude()`; returns the magnitude of a `Vector3D` ( `sqrt(x*x + y*y + z*z)`).
  - Provide a `toString` method for reasonable output.
  - Provide an implementation of `equals`. Remember that float and double arithmetic is not exact. Thus, you must allow for a tolerance.
