// #397 Integer Replacement
// https://leetcode.com/problems/integer-replacement

/**
* @param {number} n
* @return {number}
*/
const integerReplacement = n => {
  // done!
  if (n === 1) {
    return 0;
  }

  // dividing shrinks faster than subtraction
  if (n % 2 === 0) {
    return 1 + integerReplacement(n / 2);
  }

  let up = n + 1
  let down = n - 1
  // try to get to a division step quickly
  if (down === 2 || ((down / 2) % 2 === 0)) {
    return 1 + integerReplacement(down);
  } else if ((up / 2) % 2 === 0) {
    return 1 + integerReplacement(up);
  } else {
    return 1 + integerReplacement(down);
  }
}
