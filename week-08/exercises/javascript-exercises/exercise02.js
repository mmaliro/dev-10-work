// SUMMER CAMP
// Campers at summer camp can choose one of three afternoon activities:
// swimming, archery, or pottery.
// Swimmers must use the buddy system. If there's not an even number of swimmers,
// swimming is canceled and swimmers are reallocated to archery and pottery with
// the following rules:
// - add swimmers to the activity with the least participants until numbers are even
// - then distribute swimmers evenly, starting with pottery first.
// If there are an even number of swimmers, everyone gets their preferred activity.


/* Scenarios      | 01 | 02 | 03 | 04 | 05 | 06 |
-------------------------------------------------
starting swimmers |  9 |  6 |  5 | 11 | 99 |  3 |
starting archers  | 10 | 13 | 20 |  0 |  3 |  3 |
starting potters  | 12 | 21 |  5 | 11 |  7 |  3 |
final swimmers    |  0 |  6 |  0 |  0 |  0 |  0 |
final archers     | 15 | 13 | 20 | 11 | 54 |  4 |
final potters     | 16 | 21 | 10 | 11 | 55 |  5 |
*/

// Change these numbers to test each scenario.
let swimmers = 6;
let archers = 13;
let potters = 21;

// Write your distribution code here.

if (swimmers % 2 === 0) {
    // If there's an even number of swimmers, everyone gets their preferred activity.
    console.log("Everyone gets their preferred activity!");
    } else {
    // If there's an odd number of swimmers, we need to reallocate them.
    // First, we determine which activity has the least participants.
    let leastParticipants = Math.min(archers, potters);
    // Then we add swimmers to that activity until we have an even number of participants.
    if (leastParticipants === archers) {
    archers += Math.ceil(swimmers / 2);
    } else {
    potters += Math.ceil(swimmers / 2);
    }
    // We subtract the number of swimmers we added from the total number of swimmers.
    swimmers -= Math.floor(swimmers / 2) * 2;
    // Then we distribute the remaining swimmers evenly, starting with pottery first.
    while (swimmers > 0) {
    potters += 1;
    swimmers -= 1;
    if (swimmers > 0) {
    archers += 1;
    swimmers -= 1;
    }
    }
    }

// One set of code must work for all scenarios.

// Confirm results for each scenario.
console.log(`Swimmers: ${swimmers}`);
console.log(`Archers: ${archers}`);
console.log(`Potters: ${potters}`);