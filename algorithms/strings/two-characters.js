// Two Characters
// https://www.hackerrank.com/challenges/two-characters

process.stdin.resume();
process.stdin.setEncoding('ascii');

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
  input_stdin += data;
});

process.stdin.on('end', function () {
  input_stdin_array = input_stdin.split("\n");
  main();    
});

function readLine() {
  return input_stdin_array[input_currentline++];
}

/////////////// ignore above this line ////////////////////

function maxWithOnly(charArr, allowedChars) {
  
  const filtered = charArr
    .filter(el => allowedChars.has(el))
  
  return filtered
    .some((el, i, arr) => el === arr[i - 1]) ? 0 : filtered.length
}

function maxLen(n, s) {
  
  const charArr = s.split('')
  
  const chars = new Set(
    charArr
      .reduce((acc, el, i, arr) => {
        if (el !== acc[acc.length - 1]) acc.push(el)
        return acc
      }, []))
  
  let max = 0
  
  chars.forEach((x, i) => {
    
    chars.forEach((y, j) => {
      if (j <= i) return
      
      const length = maxWithOnly(charArr, new Set([x, y]))
      if (length > max) max = length
    })
  })
  
  return max
}

function main() {
  const n = parseInt(readLine());
  const s = readLine();
  const result = maxLen(n, s);
  console.log(result);
}

