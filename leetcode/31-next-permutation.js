/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */

const swap = (arr, i, j) => {
  let t = arr[j]
  arr[j] = arr[i]
  arr[i] = t
}

const reverse = (arr, k) => {
  let midpt = k + Math.floor((arr.length - k - 1) / 2)
  for (let i = 0; k + i <= midpt; i++) {
    swap(arr, k + i, arr.length - 1 - i)
  }
}


const nextPermutation = nums => {

  const _nextPermutation = start => {
    // cannot permute
    if (nums.length - start < 2) return false

    // permutation can be made in elements to right
    if (_nextPermutation(start + 1)) return true

    // permutation cannot be made to right, will need to move start element
    // nums are in decreasing order
    if (nums[start] > nums[start + 1]) return false

    // move next lowest to front
    else {
      let i = nums.length - 1
      while (nums[i] <= nums[start] && i > start) i--

      if (nums[start] === nums[i]) return false

      // swap with next lowest
      swap(nums, start, i)

      // reverse from start + 1 to end
      reverse(nums, start + 1)
      return true
    }
  }

  if (!_nextPermutation(0))
    reverse(nums, 0)
}
