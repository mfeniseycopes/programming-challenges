/**
 * @param {string} S
 * @param {number} K
 * @return {string}
 */
const licenseKeyFormatting = (S, K) => {
  const chars = S.split('')
    .filter(c => c !== '-')
    .map(c => c.toUpperCase())

  if (K === 0) return chars.join('')

  let offset = chars.length % K || K
  const final = [chars.slice(0, offset).join('')]

  for (let i = 0; i + offset < chars.length; i += K)
    final.push(chars.slice(i + offset, i + offset + K).join(''))

  return final.join('-')
}
