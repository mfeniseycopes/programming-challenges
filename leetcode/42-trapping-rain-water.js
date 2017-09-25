/**
* @param {number[]} heights
* @return {number}
*/
const trap = heights => {
  let sum = 0
  let max = 0
  let maxIdx = 0
  let runningSum = 0

  const agg = (el, i) => {
    if (el >= max) {
      sum += runningSum
      max = el
      maxIdx = i
      runningSum = 0
    } else {
      runningSum += (max - el)
    }
  }
  // forward accumulation
  heights.forEach(agg)

  // go backwards upto last max if last runningSum never closed
  const rhs = heights.slice(maxIdx).reverse()
  max = 0
  maxIdx = 0
  runningSum = 0
  rhs.forEach(agg)

  return sum
};
