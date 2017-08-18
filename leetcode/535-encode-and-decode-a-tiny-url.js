// #535 Encode and Decode a Tiny URL
// https://leetcode.com/problems/encode-and-decode-tinyurl 

/**
 * Encodes a URL to a shortened URL.
 *
 * @param {string} longUrl
 * @return {string}
 */

const longMapper = []

function encode(longUrl) {
    longMapper.push(longUrl)
    return longMapper.length - 1
};

/**
 * Decodes a shortened URL to its original URL.
 *
 * @param {string} shortUrl
 * @return {string}
 */
function decode(shortUrl) {
    return longMapper[shortUrl]
};

/**
 * Your functions will be called as such:
 * decode(encode(url));
 */
