// #66 Plus One
// https://leetcode.com/problems/plus-one

/**
* @param {number[]} digits
* @return {number[]}
*/

function plusOne(digits) {

  for (let i = digits.length - 1; i > -1; i--) {
    if (digits[i] !== 9) {
      digits[i]++
      return digits
    }

    digits[i] = 0
  }

  digits.unshift(1)

  return digits
};
