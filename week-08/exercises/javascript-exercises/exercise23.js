// ITEM BETWEEN ARRAYS
// Create a function that accepts an array, any other value, and an array.
// Return a new array that includes all elements from the first array, the value, then
// all the elements from the last array parameter.
// Hint: spread syntax is useful here.

/* Examples
[1, 2], "a", [true]                   => [1, 2, "a", true]
[], 87, [9]                           => [87, 9]
[14, 15], 0, []                       => [14, 15, 0]
["red", "blue"], "orange", ["yellow"] => ["red", "blue", "orange", "yellow"]
["red"], ["orange"], ["yellow"]       => ["red", ["orange"], "yellow"]
*/


function concatArrays(arr1, value, arr2) {
    return [...arr1, value, ...arr2];
  }
  
// Confirm your result by debugging or printing to the console.

console.log(concatArrays([1, 2], "a", [true])); // [1, 2, "a", true]
console.log(concatArrays([], 87, [9])); // [87, 9]
console.log(concatArrays([14, 15], 0, [])); // [14, 15, 0]
console.log(concatArrays(["red", "blue"], "orange", ["yellow"])); // ["red", "blue", "orange", "yellow"]
console.log(concatArrays(["red"], ["orange"], ["yellow"])); // ["red", ["orange"], "yellow"]
