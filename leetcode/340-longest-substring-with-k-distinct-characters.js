// #340 Longest Substring with At Most K Distinct Characters
// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
const lengthOfLongestSubstringKDistinct = (str, k) => {
    
  if (k === 0) return 0
  if (k >= str.length) return str.length
    
  // tracking variables
  let head = 0
  let uniqs = {}
  let max = 0

  // iterate over the characters
  const chars = str.split('')
  
  chars
    .forEach((char, idx) => {
      
      // keep track of first/last positions of char
      if (uniqs.hasOwnProperty(char))
        uniqs[char].last = idx
      else 
        uniqs[char] = { first: idx, last: idx }
      
      // if not exceeded k, check for max
      if (Object.keys(uniqs).length <= k) {
        if (idx - head + 1 > max) 
            max = idx - head + 1        
      } 
      // exceeded k, need to find lowest element(s) to cull
      else {
        
        // find the character that ends furthest from current position
        let lowestEndIdx = idx - 1
        Object.keys(uniqs)
        .forEach(usedChar => {
          if (uniqs[usedChar].last < lowestEndIdx)
            lowestEndIdx = uniqs[usedChar].last
        })
        
        // for each character up to and including our desired cull
        // remove key if not included in new str
        for (let usedIdx = head; usedIdx <= lowestEndIdx; usedIdx++) {
          if (uniqs[chars[usedIdx]].last === usedIdx) {
            delete uniqs[chars[usedIdx]]
          }
        }
        
        // reset head to next start
        head = lowestEndIdx + 1
      }
    })
    
  return max
};
