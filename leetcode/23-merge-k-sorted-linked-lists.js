/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */

const swap = (arr, i, j) => {
  const t = arr[i]
  arr[i] = arr[j]
  arr[j] = t
}

const parentIndex = i => Math.ceil(i / 2) - 1
const leftIndex = i => 2 * i + 1
const rightIndex = i => 2 * (i + 1)

const buildMinHeap = arr => {
  for (let i = arr.length - 1; i > -1; i--) {
    minHeapify(arr, i)
  }
}

const minHeapify = (arr, i) => {
  const left = leftIndex(i)
  const right = rightIndex(i)

  let min
  if (!arr[left]) return
  else if (!arr[right]) min = left
  else min = arr[left].val < arr[right].val ? left : right

  if (arr[min].val < arr[i].val) {
    swap(arr, i, min)
    minHeapify(arr, min)
  }
}

const extractMin = arr => {

  if (arr.length > 1) {
    // get the min
    const min = arr[0]

    // move last el to top of tree
    arr[0] = arr.pop()

    // heapify from root
    minHeapify(arr, 0)
  // min was last element
  } else {
    return arr.pop()
  }
}

const insert = (arr, el) => {
  arr.push(el)
  let child = arr.length - 1
  let parent = parentIndex(child)

  while (parent > -1) {
    if (arr[child].val < arr[parent].val) {
      // swap parent and child to keep invariant
      swap(arr, child, parent)
      // next iteration will be one level up
      child = parent
      parent = parentIndex(child)
    } else {
      // we are done
      break
    }
  }
}

const mergeKLists = lists => {
  const merged = new ListNode(null)
  let tail = merged

  lists = lists.filter(list => list !== null)

  buildMinHeap(lists)
  let min

  while (lists.length > 0) {
    // get the min
    min = extractMin(lists)

    // put in merged
    tail.next = min
    tail = tail.next

    // insert remaining linked list
    if (min.next) {
      insert(lists, min.next)
    }
  }

  return merged.next
}
