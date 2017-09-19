// # 17 Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

/**
 * @param {string} digits
 * @return {string[]}
 */

const mapping = {
  1: ['*'],
  2: ['a', 'b', 'c'],
  3: ['d', 'e', 'f'],
  4: ['g', 'h', 'i'],
  5: ['j', 'k', 'l'],
  6: ['m', 'n', 'o'],
  7: ['p', 'q', 'r', 's'],
  8: ['t', 'u', 'v'],
  9: ['w', 'x', 'y', 'z'],
  0: []
};

const crossDigit = (arr, digit) =>
  mapping[digit]
    .reduce(
      (acc, char) => 
        acc.concat(
          (arr.length ? arr : [''])
            .map(str => str + char)),
    []);

const letterCombinations = (digits) =>
  digits
    .split('')
    .reduce(crossDigit, []);
