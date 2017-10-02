/**
* @param {number} capacity
*/
var LRUCache = function(capacity) {

  this.capacity = capacity
  this.hash = {}

  this.head = { val: null, next: null, prev: null }
  this.tail = { val: null, next: null, prev: null }
  this.head.next = this.tail
  this.tail.prev = this.head

  this.count = 0
};

/**
* @param {number} key
* @return {number}
*/
LRUCache.prototype.get = function(key) {
  if (this.hash[key]) {
    let node = this.hash[key]

    // remove
    node.prev.next = node.next
    node.next.prev = node.prev

    // place after head
    node.prev = this.head
    node.next = this.head.next
    this.head.next.prev = node
    this.head.next = node

    return this.hash[key].val
  } else {
    return -1
  }
};

/**
* @param {number} key
* @param {number} value
* @return {void}
*/
LRUCache.prototype.put = function(key, value) {
  let node

  if (this.hash[key]) {
    node = this.hash[key]

    // update value
    node.val = value

    // remove
    node.prev.next = node.next
    node.next.prev = node.prev

  } else {
    if (this.count === this.capacity) {

      // remove pre-tail
      let removed = this.tail.prev
      removed.prev.next = removed.next
      removed.next.prev = removed.prev
      delete this.hash[removed.key]
      this.count--
    }

    // create new node
    node = { key: key, val: value, next: null, prev: null }
    this.hash[key] = node
    this.count++
  }

  // place after head
  node.prev = this.head
  node.next = this.head.next
  this.head.next.prev = node
  this.head.next = node
};

/**
* Your LRUCache object will be instantiated and called as such:
* var obj = Object.create(LRUCache).createNew(capacity)
* var param_1 = obj.get(key)
* obj.put(key,value)
*/
