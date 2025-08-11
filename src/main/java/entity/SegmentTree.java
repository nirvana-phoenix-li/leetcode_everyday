package entity;

public class SegmentTree {

    int[]  point;
    SegmentTree left;
    SegmentTree right;

    public SegmentTree(int[] point, SegmentTree left, SegmentTree right) {
        this.point = point;
        this.left = left;
        this.right = right;
    }

    public SegmentTree() {
    }
}
