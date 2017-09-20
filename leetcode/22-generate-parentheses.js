// #20 Valid Parentheses
// https://leetcode.com/problems/generate-parentheses/
/**
 * @param {number} n
 * @return {string[]}
 */

const generateParenthesis = n => {
  if (n === 0) return []
  return generate('', n, n)
};

const generate = (paren, l, r, parens=[]) => {
  // invalid setup, abort
  if (l > r) return
  // use an open paren
  if (l) generate(paren + '(', l - 1, r, parens)
  // use a closed paren
  if (r) generate(paren + ')', l, r - 1, parens)
  // we are done, add to memoized accumulator
  if (!(l || r)) parens.push(paren)

  return parens
}
