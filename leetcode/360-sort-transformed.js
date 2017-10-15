// #360 Sort Transformed Array
// https://leetcode.com/problems/sort-transformed-array

/**
 * @param {number[]} nums
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @return {number[]}
 */
const sortTransformedArray = function(nums, a, b, c) {
  const N = nums.length
  const F = x => (a * (x ** 2)) + (b * x) + c

  nums = nums.map(F)

  let i = 1, j = N - 1
  while (i < N && nums[i - 1] <= nums[i]) i++
  while (j > 0 && nums[j - 1] <= nums[j]) j--

  // still sorted
  if (j < i) return nums

  // unsorted
  const left = nums.slice(0, i)
  const mid = nums.slice(i, j + 1)
  const right = nums.slice(j + 1, N)

  // elements in mid have switched, reverse to sort
  mid.reverse()

  return merge(left, merge(mid, right))
}

const merge = (a, b) => {
  const res = []

  while (a.length && b.length) {
    res.push(a[0] < b[0] ? a.shift() : b.shift())
  }

  return res.concat(a, b)
}
