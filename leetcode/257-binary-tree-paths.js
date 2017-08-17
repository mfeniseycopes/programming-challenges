// #257 Binary Tree Paths
// https://leetcode.com/problems/binary-tree-paths

/*
Pretty simple DFS binary tree traversal while keeping track of the path to each
node. I chose to memoize the paths to save space. If space was more of an issue
than time I would probably store a ref to the parent and recalculate the paths
at the end, rather than storing them at each node.

/**
* Definition for a binary tree node.
* function TreeNode(val) {
*     this.val = val;
*     this.left = this.right = null;
* }
*/
/**
* @param {TreeNode} root
* @return {string[]}
*/

function binaryTreePaths(root) {

    const paths = []

    if (!root) return paths

    function _binaryTreePaths(root) {
        const childless = !root.left && !root.right

        const pathToRoot = root.path ? root.path.concat(root.val) : [root.val]

        if (childless) {
            paths.push(pathToRoot)
            return
        }

        if (root.left) {
            root.left.path = pathToRoot
            _binaryTreePaths(root.left)
        }

        if (root.right) {
            root.right.path = pathToRoot
            _binaryTreePaths(root.right)
        }
    }


    _binaryTreePaths(root)

    return paths.map(path => path.join('->'))
}
