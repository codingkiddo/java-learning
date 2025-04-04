package com.example.ds;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

import static java.lang.String.format;

public class TreeNode {
	
	private int value;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TreeNode treeNode = (TreeNode) o;
		return value == treeNode.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	public void insert(int value) {
		insert(this, value);
	}

	private void insert(TreeNode currentNode, final int value) {
		if (currentNode.left == null && value < currentNode.value) {
			currentNode.left = new TreeNode(value);
			return;
		}

		if (currentNode.right == null && value > currentNode.value) {
			currentNode.right = new TreeNode(value);
			return;
		}

		if (value > currentNode.value) {
			insert(currentNode.right, value);
		}

		if (value < currentNode.value) {
			insert(currentNode.left, value);
		}
	}

	public TreeNode parent(int target) throws NoSuchElementException {
		return parent(this, new TreeNode(target));
	}

	private TreeNode parent(TreeNode current, TreeNode target) throws NoSuchElementException {
		if (target.equals(current) || current == null) {
			throw new NoSuchElementException(format("No parent node found for 'target.value=%s' "
					+ "The target is not in the tree or the target is the topmost root node.", target.value));
		}

		if (target.equals(current.left) || target.equals(current.right)) {
			return current;
		}

		return parent(target.value < current.value ? current.left : current.right, target);
	}

	public TreeNode iterativeParent(int target) {
		return iterativeParent(this, new TreeNode(target));
	}

	private TreeNode iterativeParent(TreeNode current, TreeNode target) {
		Deque<TreeNode> parentCandidates = new LinkedList<>();

		String notFoundMessage = format("No parent node found for 'target.value=%s' "
				+ "The target is not in the tree or the target is the topmost root node.", target.value);

		if (target.equals(current)) {
			throw new NoSuchElementException(notFoundMessage);
		}

		while (current != null || !parentCandidates.isEmpty()) {

			while (current != null) {
				parentCandidates.addFirst(current);
				current = current.left;
			}

			current = parentCandidates.pollFirst();

			if (target.equals(current.left) || target.equals(current.right)) {
				return current;
			}

			current = current.right;
		}

		throw new NoSuchElementException(notFoundMessage);
	}
}