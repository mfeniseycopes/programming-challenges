// 380 - RandomizedSet
// https://leetcode.com/problems/insert-delete-getrandom-o1/

/**
* Initialize your data structure here.
*/
const RandomizedSet = function() {
  this.ord = 0
  this.hash = {}
  this.orderHash = {}
};

/**
* Inserts a value to the set. Returns true if the set did not already contain the specified element.
* @param {number} val
* @return {boolean}
*/
RandomizedSet.prototype.insert = function(val) {
  //debugger
  if (this.hash.hasOwnProperty(val)) {
    return false
  } else {
    this.hash[val] = this.ord
    this.orderHash[this.ord] = val
    this.ord++
    return true
  }
};

/**
* Removes a value from the set. Returns true if the set contained the specified element.
* @param {number} val
* @return {boolean}
*/
RandomizedSet.prototype.remove = function(val) {
  // debugger
  if (this.hash.hasOwnProperty(val)) {
    let removedOrd = this.hash[val]
    let lastInsertedVal = this.orderHash[this.ord - 1]

    if (val !== lastInsertedVal) {
      this.hash[lastInsertedVal] = removedOrd
      this.orderHash[removedOrd] = lastInsertedVal
    }

    this.ord--
    delete this.hash[val]
    delete this.orderHash[this.ord]

    return true
  } else {
    return false
  }
};

/**
* Get a random element from the set.
* @return {number}
*/
RandomizedSet.prototype.getRandom = function() {
  return this.orderHash[Math.floor(Math.random() * this.ord)]
};

/**
* Your RandomizedSet object will be instantiated and called as such:
* var obj = Object.create(RandomizedSet).createNew()
* var param_1 = obj.insert(val)
* var param_2 = obj.remove(val)
* var param_3 = obj.getRandom()
*/
