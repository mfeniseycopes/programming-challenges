// #345 Reverse Vowels of a String
// https://leetcode.com/problems/reverse-vowels-of-a-string/

/*
The key here is just maintaining two pointers starting at the start and end of
the string, swapping vowels as they converge.

/**
* @param {string} s
* @return {string}
*/
function reverseVowels(s) {
  chars = s.split('')

  let i = 0; j = chars.length - 1;
  vowels = new Set(['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']);

  while (i < j) {
    const left = vowels.has(chars[i])
    const right = vowels.has(chars[j])

    if (left && right) {
      let tmp = chars[j]
      chars[j] = chars[i]
      chars[i] = tmp
      i++
      j--
    } else {
      left ? j-- : i++
    }
  }

  return chars.join('')
};
