// #20 Valid Parentheses
// https://leetcode.com/problems/valid-parentheses

/*
Just using a stack to ensure each closing character can be paired with an 
opening character.
*/

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {

	const map = {
		')': '(',
		'}': '{',
		']': '[',
	}

	let stack = []

	for (let i = 0; i < s.length; i++) {
		const char = s.charAt(i)
		if (map.hasOwnProperty(char)) {
			if(stack.pop() !== map[char]) return false
		} else {
			stack.push(char)
		}
	}

	return stack.length === 0
};
