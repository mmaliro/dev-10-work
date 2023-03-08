// LOOPS
// Execute the existing code.
// Note all output. Modified code output must match existing code output.
// Rewrite the loops as prescribed in numbered tasks.

// 1. Rewrite this `while` as a `for`.
// Output must be identical.
let message = "artichoke";
let result = "";
for (let i = message.length - 1; i >= 0; i--) {
result += message.charAt(i);
}
console.log(result);

// 2. Rewrite this `for` as a `while`.
let i = 13;
while (i < 22) {
console.log(i);
if (i % 3 === 0) {
i--;
}
i += 2;
}

// 3. Rewrite this `while` as a `do/while`.
let isDone = false;
let n = -5;
do {
    if (n > 0) {
    isDone = true;
    }
    n++;
    console.log(`n: ${n}, isDone: ${isDone}`);
    } while (!isDone && n < 3);