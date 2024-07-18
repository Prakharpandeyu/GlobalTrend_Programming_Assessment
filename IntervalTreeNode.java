import java.util.ArrayList;
import java.util.List;

class Interval {
    int low;
    int high;

    public Interval(int low, int high) {
        this.low = low;
        this.high = high;
    }
}

class IntervalTreeNode {
    Interval interval;
    int maxHigh;
    IntervalTreeNode left;
    IntervalTreeNode right;
}

class IntervalTree {
    private IntervalTreeNode root;

    public void insertInterval(int start, int end) {
        root = insert(root, new Interval(start, end));
    }

    private IntervalTreeNode insert(IntervalTreeNode node, Interval interval) {
        if (node == null) {
            IntervalTreeNode newNode = new IntervalTreeNode();
            newNode.interval = interval;
            newNode.maxHigh = interval.high;
            return newNode;
        }

        if (interval.low < node.interval.low) {
            node.left = insert(node.left, interval);
        } else {
            node.right = insert(node.right, interval);
        }

        // Update maxHigh value
        node.maxHigh = Math.max(node.interval.high, Math.max(getMaxHigh(node.left), getMaxHigh(node.right)));
        return node;
    }

    public void deleteInterval(int start, int end) {
        root = delete(root, new Interval(start, end));
    }

    private IntervalTreeNode delete(IntervalTreeNode node, Interval interval) {
        // Implement deletion logic (similar to regular BST deletion)
        // ...
        // Update maxHigh values after deletion
        // ...
        return node;
    }

    public List<Interval> findOverlappingIntervals(int start, int end) {
        List<Interval> result = new ArrayList<>();
        findOverlappingIntervals(root, start, end, result);
        return result;
    }

    private void findOverlappingIntervals(IntervalTreeNode node, int start, int end, List<Interval> result) {
        if (node == null)
            return;

        if (node.interval.low <= end && node.interval.high >= start)
            result.add(node.interval);

        if (node.left != null && node.left.maxHigh >= start)
            findOverlappingIntervals(node.left, start, end, result);

        if (node.right != null)
            findOverlappingIntervals(node.right, start, end, result);
    }

    private int getMaxHigh(IntervalTreeNode node) {
        return (node != null) ? node.maxHigh : Integer.MIN_VALUE;
    }
}

public class Main {
    public static void main(String[] args) {
        IntervalTree intervalTree = new IntervalTree();
        intervalTree.insertInterval(1, 5);
        intervalTree.insertInterval(3, 7);
        intervalTree.insertInterval(6, 10);

        List<Interval> overlapping = intervalTree.findOverlappingIntervals(4, 8);
        for (Interval interval : overlapping) {
            System.out.println("Overlapping interval: [" + interval.low + ", " + interval.high + "]");
        }
    }
}
