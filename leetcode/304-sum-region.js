// #304 Range Sum Query 2D - Immutable
// https://leetcode.com/problems/range-sum-query-2d-immutable

/**
* @param {number[][]} matrix
*/
var NumMatrix = function(matrix) {
  this.matrix = matrix
  this.regionSums = {}
};

/**
* @param {number} row1
* @param {number} col1
* @param {number} row2
* @param {number} col2
* @return {number}
*/
NumMatrix.prototype.sumRegion = function(row1, col1, row2, col2) {
  const key = [row1, col1, row2, col2].join(',')
  if (this.regionSums.hasOwnProperty(key)) {
    return this.regionSums[key]
  }

  let left, right, top, bottom
  if (row1 === row2 && col1 === col2) {
    this.regionSums[key] = this.matrix[row1][col1]

  } else if (row1 === row2) {
    left = this.sumRegion(row1, col1, row2, col1)
    right = this.sumRegion(row1, col1 + 1, row2, col2)
    this.regionSums[key] = left + right

  } else if (col1 === col2) {
    top = this.sumRegion(row1, col1, row1, col2)
    bottom = this.sumRegion(row1 + 1, col1, row2, col2)
    this.regionSums[key] = top + bottom

  } else {
    if (row2 - row1 < col2 - col1) {
      left = this.sumRegion(row1, col1, row2, col1)
      right = this.sumRegion(row1, col1 + 1, row2, col2)
      this.regionSums[key] = left + right

    } else {
      top = this.sumRegion(row1, col1, row1, col2)
      bottom = this.sumRegion(row1 + 1, col1, row2, col2)
      this.regionSums[key] = top + bottom

    }
  }

  return this.regionSums[key]
};

/**
* Your NumMatrix object will be instantiated and called as such:
* var obj = Object.create(NumMatrix).createNew(matrix)
* var param_1 = obj.sumRegion(row1,col1,row2,col2)
*/

n = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]])
console.log(n.sumRegion(2,1,4,3))
console.log(n.sumRegion(1,1,2,2))
console.log(n.sumRegion(1,2,2,4))
