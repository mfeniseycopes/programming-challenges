// #231 - Power of Two
// https://leetcode.com/problems/power-of-two/

/*
Multiplication is computationally faster than using the modulus operator, so 
simply incrementing the power at each iteration seems better than dividing.
*/

/**
 * @param {number} n
 * @return {boolean}
 */
function isPowerOfTwo(n) {
	let pow = 1, i = 0;

	while (pow <= n) {
		if (pow === n) return true
		i++
		pow = pow * 2
	}

	return false
};
