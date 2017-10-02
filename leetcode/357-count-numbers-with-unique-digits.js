/**
 * @param {number} n
 * @return {number}
 */
const countNumbersWithUniqueDigits = n => {
  return _countNumbersWithUniqueDigits(n).reduce((sum, el) => sum + el, 0)
}

const _countNumbersWithUniqueDigits = n => {
  if (n === 0) return [1]
  if (n === 1) return [10]
  if (n === 2) return [10, 81]

  const recurs = _countNumbersWithUniqueDigits(n - 1)
  const last = recurs[recurs.length - 1] * (10 - n + 1)
  recurs.push(last)

  return recurs
}
