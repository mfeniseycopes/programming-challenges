// Find All Numbers Disappeared in an Array
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array

/*
Simply moving each number into its designated position, then rescanning
for missing elements gives us a O(n) time complexity and O(1) space complexity.

Interestingly, I did this with `forEach` and `reduce` initially, then, when using old-school `for` loops, saw a ~15% time reduction.
*/

/**
 * @param {number[]} nums
 * @return {number[]}
 */

function swap (arr, i, j) {
  if (arr[i] === arr[j]) return

  const tmp = arr[i]
  arr[i] = arr[j]
  arr[j] = tmp

  if (arr[i] != i + 1) swap(arr, i, arr[i] - 1)
}

function findDisappearedNumbers (nums) {
  for (let i = 0; i < nums.length; i++) {
    nums[i] !== i + 1 ? swap(nums, i, nums[i] - 1) : null
  }

  const acc = []
  for (let i = 0; i < nums.length; i++) {
    nums[i] !== i + 1 ? acc.push(i + 1) : null
  }
  return acc
};
