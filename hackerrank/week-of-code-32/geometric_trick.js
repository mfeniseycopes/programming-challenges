;; Geometric Trick
;;
;; https://www.hackerrank.com/contests/w32/challenges/geometric-trick

function geometricTrick(s){
  let triplets = new Set()

  for (let t = 1; Math.pow(t, 2) <= s.length; t++) {

    for (let z = t + 1; Math.pow(z, 2) <= s.length; z++) {

      let [_i, _j, _k] = [Math.pow(t, 2), t * z, Math.pow(z, 2)]

      for (let m = 1; m * Math.pow(z, 2) <= s.length; m++) {

        let [i, j, k] = [m * _i -  1, m * _j -  1, m * _k -  1]

        const others = [s[i], s[k]].sort().join('')

        if (s[j] === 'b' && others === 'ac') triplets.add([i, j, k].join(' '))
      }
    }
  }
  return triplets.size
}
