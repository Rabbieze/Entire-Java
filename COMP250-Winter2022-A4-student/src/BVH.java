import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BVH implements Iterable<Circle>{
    Box boundingBox;

    BVH child1;
    BVH child2;

    Circle containedCircle;

    // todo for students
    public BVH(ArrayList<Circle> circles) {

    }

    public void draw(Graphics2D g2) {
        this.boundingBox.draw(g2);
        if (this.child1 != null) {
            this.child1.draw(g2);
        }
        if (this.child2 != null) {
            this.child2.draw(g2);
        }
    }

    // todo for students
    public static ArrayList<Circle>[] split(ArrayList<Circle> circles, Box boundingBox) {
        return null;
    }

    // returns the smallest possible box which fully encloses every circle in circles
    public static Box buildTightBoundingBox(ArrayList<Circle> circles) {
        Vector2 bottomLeft = new Vector2(Float.POSITIVE_INFINITY);
        Vector2 topRight = new Vector2(Float.NEGATIVE_INFINITY);

        for (Circle c : circles) {
            bottomLeft = Vector2.min(bottomLeft, c.getBoundingBox().bottomLeft);
            topRight = Vector2.max(topRight, c.getBoundingBox().topRight);
        }

        return new Box(bottomLeft, topRight);
    }

    @Override
    public Iterator<Circle> iterator() {
        return null;
    }

    public class BVHIterator implements Iterator<Circle> {

        // todo for students
        public BVHIterator(BVH bvh) {

        }

        // todo for students
        @Override
        public boolean hasNext() {
            return false;
        }

        // todo for students
        @Override
        public Circle next() {
            return null;
        }
    }
}