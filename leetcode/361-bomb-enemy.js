// #361 - Bomb Enemy
// https://leetcode.com/problems/bomb-enemy

/**
 * @param {character[][]} grid
 * @return {number}
 */
const maxKilledEnemies = grid => {
  const N = grid.length
  if (N === 0) return 0
  const M = grid[0].length

  const spaces = processGrid(grid, N, M)

  let max = 0
  spaces.forEach(pos => {
    let space = grid[pos[0]][pos[1]]
    let kills = space.row.kills + space.col.kills
    if (kills > max) {
      max = kills
    }
  })

  return max
}

const processGrid = (grid, N, M) => {

  const spaces = []

  let row
  for (let i = 0; i < N; i++) {
    row = { kills: 0 }
    for (let j = 0; j < M; j++) {
      // increment
      if (grid[i][j] === 'E') {
        row.kills++
      }
      // clear
      if (grid[i][j] === 'W') {
        row = { kills: 0 }
      }

      // collect space
      if (grid[i][j] === '0') {
        spaces.push([i, j])
      }

      grid[i][j] = {
        val: grid[i][j],
        row: row
      }
    }
  }

  let col
  for (let j = 0; j < M; j++) {
    col = { kills: 0 }
    for (let i = 0; i < N; i++) {
      // increment
      if (grid[i][j].val === 'E') {
        col.kills++
      }
      // clear
      if (grid[i][j].val === 'W') {
        col = { kills: 0 }
      }
      grid[i][j].col = col
    }
  }

  return spaces
}
