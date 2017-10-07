// #272 Closest Binary Search Tree Value II
// https://leetcode.com/problems/closest-binary-search-tree-value-ii

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} target
 * @param {number} k
 * @return {number[]}
 */
var closestKValues = function(root, target, k) {
	const sortedList = traverse(root, [])
	let i = bsearch(sortedList, target) // left side of search
	let j = i + 1 // rightside of search
	if (i >= sortedList.length - 1) { i--; j--; }

	const closestValues = []

	while (closestValues.length < k) {
		if (i < 0) {
			closestValues.push(sortedList[j])
			j++
		}
		else if (j >= sortedList.length || Math.abs(target - sortedList[i]) < Math.abs(target - sortedList[j])) {
			closestValues.push(sortedList[i])
			i--
		} else {
			closestValues.push(sortedList[j])
			j++
		}
	}

	return closestValues
};

const traverse = (root, visited) => {
	if (!root) return visited

	traverse(root.left, visited)
	visited.push(root.val)
	traverse(root.right, visited)

	return visited
}

const bsearch = (list, target) => {
	const _bsearch = (start, end) => {
		const m = start + Math.floor((end - start) / 2)

		// next best thing if exhausted
		if (start < 0) return 0
		if (end > list.length) return list.length - 1
		if (start === end) return start

		// search again
		if (list[m] === target) return m
		else if (list[m] < target) return _bsearch(m + 1, end)
		else return _bsearch(start, m)
	}

	return _bsearch(0, list.length)
}
