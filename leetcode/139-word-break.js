// #139 Word Break
// https://leetcode.com/problems/word-break

/**
* @param {string} s
* @param {string[]} wordDict
* @return {boolean}
*/
const wordBreak = (s, wordDict) => {
  const { min, max } = minMax(wordDict)
  const wordSet = new Set(wordDict)
  const memo = { 0: true }

  for (let j = 1; j <= s.length; j++) {
    for (let i = 0; i < j; i++) {
      if (memo[i] && wordSet.has(s.substring(i, j))) {
        memo[j] = true
        break;
      }
    }
  }

  return Boolean(memo[s.length])
};
