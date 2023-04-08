package mytree;

// AVL Tree = Height-Balanced (HB) Tree

public class DAA2 extends DAA1 {

	// 4. isHeightBalanced() [10 points]
	public static boolean isHeightBalanced(MyTree t) {
		if (t.getEmpty()) {
			return true;
		} else {
			int height_right = MyTreeOps.height(t.getRight());
			int height_left = MyTreeOps.height(t.getLeft());

			if (Math.abs(height_left - height_right) <= 1) {
				return isHeightBalanced(t.getLeft()) && isHeightBalanced(t.getRight());
			} else {
				return false;
			}
		}
	}

	// 5. insertHB() [10 points]
	public static MyTree insertHB(int n, MyTree t) {
		// Write your codes in here
		if (t.getEmpty()) {
			return new MyTree(n, new MyTree(), new MyTree());
		} else if (n < t.getValue()) {
			return rebalanceForLeft(new MyTree(t.getValue(), insertHB(n, t.getLeft()), t.getRight()));
		} else if (n > t.getValue()) {
			return rebalanceForRight(new MyTree(t.getValue(), t.getLeft(), insertHB(n, t.getRight())));
		} else {
			return t;
		}
	}

	// rebalanceForLeft is called when the left subtree of t may have
	// grown taller by one notch.
	// If it is indeed taller than the right subtree by two notches,
	// return a height-balanced version of t using single or double rotations.
	// The subtrees of t are assumed to be already height-balanced and
	// no effort is made to rebalance them.
	//
	// Likewise, for the case of the right subtree -> rebalanceForRight
	// Both rebalanceForLeft & rebalanceForRight will be used by insertHB() and
	// deleteHB()
	// 6. rebalanceForLeft() [15 points]
	private static MyTree rebalanceForLeft(MyTree t) {
		if (MyTreeOps.height(t.getLeft()) <= (MyTreeOps.height(t.getRight()) + 1))
			return t;

		MyTree to_left = t.getLeft(), to_right = t.getRight();
		MyTree to_left_left = to_left.getLeft(), to_left_right = to_left.getRight();

		if (MyTreeOps.height(to_left_left) > MyTreeOps.height(to_right)) {
			return new MyTree(to_left.getValue(), to_left_left, new MyTree(t.getValue(), to_left_right, to_right));
		}

		return new MyTree(to_left_right.getValue(),
				new MyTree(to_left.getValue(), to_left.getLeft(), to_left_right.getLeft()),
				new MyTree(t.getValue(), to_left_right.getRight(), t.getRight()));
	}

	// 7. rebalanceForRight() [15 points]
	private static MyTree rebalanceForRight(MyTree t) {
		// Write your codes in here
		if (MyTreeOps.height(t.getRight()) <= (MyTreeOps.height(t.getLeft()) + 1))
			return t;

		MyTree to_left = t.getLeft(), to_right = t.getRight();
		MyTree to_right_left = to_right.getLeft(), to_right_right = to_right.getRight();

		if (MyTreeOps.height(to_right_right) > MyTreeOps.height(to_left)) {
			return new MyTree(to_right.getValue(), new MyTree(t.getValue(), to_left, to_right_left), to_right_right);
		}

		return new MyTree(to_right_left.getValue(), new MyTree(t.getValue(), t.getLeft(), to_right_left.getLeft()),
				new MyTree(to_right.getValue(), to_right_left.getRight(), to_right.getRight()));
		// Write your codes in here
	}

	// 8. deleteHB() [10 points]
	/**
	 * Deletes the value 'x' from the given tree, if it exists, and returns the new
	 * Tree.
	 *
	 * Otherwise, the original tree will be returned.
	 */
	public static MyTree deleteHB(MyTree t, int x) {
		if (t.getEmpty()) {
			return t;
		} else {
			int value = t.getValue();
			MyTree to_left = t.getLeft();
			MyTree to_right = t.getRight();

			if (x > value) {
				return rebalanceForLeft(new MyTree(t.getValue(), to_left, deleteHB(to_right, x)));
			} else if (x < value) {
				return rebalanceForRight(new MyTree(t.getValue(), deleteHB(to_left, x), to_right));
			} else {
				if (to_left.getEmpty()) {
					return to_right;
				} else if (to_right.getEmpty()) {
					return to_left;
				} else {
					int greks = max(to_left);
					return rebalanceForRight(new MyTree(greks, deleteHB(to_left, greks), to_right));
				}
			}
		}
	}

}