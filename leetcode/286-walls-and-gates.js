// # 286 Walls and Gates
// https://leetcode.com/problems/walls-and-gates

/**
 * @param {number[][]} rooms
 * @return {void} Do not return anything, modify rooms in-place instead.
 */
const wallsAndGates = rooms => {
  const N = rooms.length
  if (N === 0) return
  const M = rooms[0].length
  if (M === 0) return

  const exploreQueue = getGates(rooms)

  let sq, val, i, j
  while (exploreQueue.length > 0) {
    sq = exploreQueue.shift()
    i = sq.i
    j = sq.j
    val = rooms[i][j]

    // look up
    if (i > 0 && rooms[i - 1][j] > val + 1) {
      rooms[i - 1][j] = val + 1
      exploreQueue.push({i: i - 1, j: j})
    }
    // look down
    if (i < N - 1 && rooms[i + 1][j] > val + 1) {
      rooms[i + 1][j] = val + 1
      exploreQueue.push({i: i + 1, j: j})
    }
    // look left
    if (j > 0 && rooms[i][j - 1] > val + 1) {
      rooms[i][j - 1] = val + 1
      exploreQueue.push({i: i, j: j - 1})
    }
    // look right
    if (j < M - 1 && rooms[i][j + 1] > val + 1) {
      rooms[i][j + 1] = val + 1
      exploreQueue.push({i: i, j: j + 1})
    }
  }
}

const getGates = rooms => {
  const gates = []

  for (let i = 0; i < rooms.length; i++) {
    for (let j = 0; j < rooms[i].length; j++) {
      if (rooms[i][j] === 0) {
          gates.push({i: i, j: j})
      }
    }
  }

  return gates
}
