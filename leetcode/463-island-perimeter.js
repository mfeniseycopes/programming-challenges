// #463 - Island Perimeter
// https://leetcode.com/problems/island-perimeter

/*
Not a very exciting problem or solution, just aggregating the perimeter based
on whether each square has watery neighbors. I did manage to do it all in single
method chain, which is pretty slick.
*/

/**
 * @param {number[][]} grid
 * @return {number}
 */
var islandPerimeter = grid =>

  grid.reduce(
    (outerAcc, row, r) =>
      outerAcc + row.reduce(
        (innerAcc, square, c) =>
          innerAcc + (square ?
            ( ( ( !r || !grid[r - 1][c] ) ? 1 : 0) +
              ( ( (r === grid.length - 1) || !grid[r + 1][c] ) ? 1 : 0) +
              ( ( !c || !grid[r][c - 1] ) ? 1 : 0) +
              ( ( (c === row.length - 1) || !grid[r][c + 1] ) ? 1 : 0) ) : 0)
        , 0), 0);
