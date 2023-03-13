const assert = require("assert");
// MERGE AND REMOVE DUPLICATES
// Create a function named `mergeAndRemoveDuplicates`
// that accepts two arrays.
// Create a new array that contains elements from both
// arrays with duplicates removed. Duplicates should be removed if
// they occur in a single parameter array or if there's a duplicated element
// in each parameter.
// Return the result.

const arr1 = [1, 2, 3];
const arr2 = [2, 3, 4];
const result = mergeAndRemoveDuplicates(arr1, arr2);

function mergeAndRemoveDuplicates(arr1, arr2) {
    const set1 = new Set(arr1);
    const set2 = new Set(arr2);
    const combinedSet = new Set([...set1, ...set2]);
    const result = [...combinedSet].filter(x => {
      const count = arr1.filter(y => y === x).length + arr2.filter(y => y === x).length;
      return count > 1;
    });
    return result;
  }
  
  
  


// Execute this exercise.
// If you see the message "success!", all tests pass.

assert.deepStrictEqual(mergeAndRemoveDuplicates([1, 2], [2, 3]), [1, 2, 3]);
assert.deepStrictEqual(mergeAndRemoveDuplicates([1, 1, 2], [2, 2, 3]), [1, 2, 3]);
assert.deepStrictEqual(mergeAndRemoveDuplicates(["one", 2, true], [true, false, "two"]), ["one", 2, true, false, "two"]);
assert.deepStrictEqual(mergeAndRemoveDuplicates([], []), []);
assert.deepStrictEqual(mergeAndRemoveDuplicates(["red"], ["blue"]), ["red", "blue"]);
assert.deepStrictEqual(mergeAndRemoveDuplicates(["red", "green", "blue"], ["blue", "yellow"]), ["red", "green", "blue", "yellow"]);

console.log("success!");