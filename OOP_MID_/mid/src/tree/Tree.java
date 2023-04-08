package tree;

/** Binary trees with nodes labeled by integers */
public class Tree {
	private int root;
	private Tree left, right;

	/** Creates a new instance of Tree: a branch */
	public Tree(int root, Tree left, Tree right) {
		this.root = root;
		this.left = left;
		this.right = right;
	}

	/**
	 * Creates a new instance of Tree: a leaf (a special case
	 * of the above)
	 */
	public Tree(int root) {
		this.root = root;
		this.left = null;
		this.right = null;
	}

	/** Sample method: Mirror myself */
	public void mirror() {
		if (left != null) { // Left branch, please mirror yourself
			left.mirror(); // This works by delegation
		}
		if (right != null) { // Right branch, please mirror yourself
			right.mirror(); // This works by delegation
		}
		Tree originalLeft = left; // Swap the branches, mirror myself
		left = right;
		right = originalLeft;
	}

	/**
	 * Converts a tree to an expression-tree string representation
	 */
	@Override
	public String toString() {
		String sleft, sright;

		// Convert the left and right branches to strings,
		// delegating the task to them if they exist.
		if (left == null) {
			sleft = "empty";
		} else {
			sleft = left.toString(); // Please do your job, Mr. Left Subtree.
		}
		if (right == null) {
			sright = "empty";
		} else {
			sright = right.toString(); // Please do your job, Mrs. Right Subtree.
		}
		// Now I do my own job:
		String s = "branch(" + root + "," + sleft + "," + sright + ")";
		return s;
	}

	/**
	 * Converts a tree to an expression-tree string representation (advanced)
	 */
	public String toStringAdv() {
		return this.toStringFrom(0);
	}

	public String toStringFrom(int depth) {
		int step = 4; // Depth step (number of spaces printed)

		// Delegate task to Mr. Left Subtree, if necessary:
		String sleft;
		if (left != null) {
			sleft = left.toStringFrom(depth + step);
		} else {
			sleft = "";
		}
		// Delegate task to Mrs. Right Subtree, if necessary:
		String sright;
		if (right != null) {
			sright = right.toStringFrom(depth + step);
		} else {
			sright = "";
		}
		// My own task now:
		String s = sright + spaces(depth) + root + "\n" + sleft;
		return s;
	}

	private String spaces(int n) {
		String s = "";
		for (int i = 0; i < n; i++) {
			s = s + " ";
		}
		return s;
	}

	// 2
	public void triple() {
		/*
		 * 1. multiply each node with 3 --> root = root * 3
		 * 2. do recursive with left node and right node
		 */
		root = root * 3;
		if (left != null)
			left.triple();
		if (right != null)
			right.triple();
	}

	// 3
	public void printDepthFirst() {
		/*
		 * 1. print first the root
		 * 2. check left node first if exist do recursive with left node
		 * 3. after left node do check with right node id exist do recirsive with right
		 * node
		 */
		System.out.print(root + " ");
		if (left != null) {
			left.printDepthFirst();
		}
		if (right != null) {
			right.printDepthFirst();
		}
	}

	// 4
	public Tree createFreshCopy() {
		/*
		 * 1. make a temp tree to copy other tree
		 * 2. do resursive with left node and right node to save all node
		 * 3. return the temp node
		 */
		Tree tempNode = new Tree(this.root);
		if (this.left != null)
			tempNode.left = this.left.createFreshCopy();
		if (this.right != null)
			tempNode.right = this.right.createFreshCopy();
		return tempNode;
	}

	// 5
	public int saveDepthFirst(int a[], int whereToStart) {
		/*
		 * 1. set the input value as a root
		 * 2. if exist left node get a index of node save it in int whereToStart
		 * 3. after all left node , then check right node if exist get a index of node
		 * then save it in whereToStart
		 * 4. do recursive then return the value of whereToStart
		 */
		a[whereToStart] = root;
		if (left != null) {
			whereToStart = left.saveDepthFirst(a, whereToStart + 1);
		}
		if (right != null) {
			whereToStart = right.saveDepthFirst(a, whereToStart + 1);
		}
		return whereToStart;
	}

	// 6
	public Tree find(int n) {
		/*
		 * 1. check value of n with root
		 * 2. if n smaller then root do recursive with left node from
		 * 3. else if n biggest then root do recursive with right node
		 * 4. then check if n value same with root return this else return null
		 */
		if (root == n)
			return this;
		else if (root < n)
			return right.find(n);
		else if (root > n)
			return left.find(n);
		else
			return null;
	}

	// 7
	public Tree insert(int n) {
		/*
		 * 1. get the position of value int n to tree
		 * 2. with fuction same with fuction find()
		 * 3. but if the right or left node is null input n number into tree
		 * 4. then return this
		 */
		if (n > root) {
			if (right != null) {
				right.insert(n);
			} else {
				right = new Tree(n);
			}
		} else if (n < root) {
			if (left != null) {
				left.insert(n);
			} else {
				left = new Tree(n);
			}
		}
		return this;
	}
}