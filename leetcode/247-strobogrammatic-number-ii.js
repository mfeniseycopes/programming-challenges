// #247 Strobogrammatic Number II
// https://leetcode.com/problems/strobogrammatic-number-ii
/**
 * @param {number} n
 * @return {string[]}
 */
const findStrobogrammatic = n => {
	return _findStrobogrammatic(n)
		.filter(num => num.length === 1 ? true : num.charAt(0) !== '0')
};

const pairs = [
	['0', '0'],
	['1', '1'],
	['6', '9'],
	['8', '8'],
	['9', '6']
]

const _findStrobogrammatic = n => {
	if (n === 0) return ['']
	if (n === 1) return ['0', '1', '8']

	const strobos = []
	_findStrobogrammatic(n - 2)
		.forEach(smallerStrobo => {
			pairs.forEach(pair => {
				strobos.push(pair[0] + smallerStrobo + pair[1])
			})
		})

	return strobos
};
