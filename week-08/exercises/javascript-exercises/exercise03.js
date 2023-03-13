// SWITCH MOD DAY
// Given a positive day, assuming that day 1 is Monday, day 2 is Tuesday,
// ... day 9 is Tuesday (days "wrap"), day 21 is Sunday, etc.
// Use a switch statement to print the appropriate day of the week.
// You should be able to handle all positive integers.

/* Examples
1 -> "Monday"
2 -> "Tuesday"
3 -> "Wednesday"
4 -> "Thursday"
5 -> "Friday"
6 -> "Saturday"
7 -> "Sunday"
8 -> "Monday"
9 -> "Tuesday"
10 -> "Wednesday"
11 -> "Thursday"
12 -> "Friday"
13 -> "Saturday"
14 -> "Sunday"
15 -> "Monday"
16 -> "Tuesday"
etc...
*/

const day = 12;

// Write code here.

switch (day % 7) {
    case 0:
      console.log("Monday");
      break;
    case 1:
      console.log("Tuesday");
      break;
    case 2:
      console.log("Wednesday");
      break;
    case 3:
      console.log("Thursday");
      break;
    case 4:
      console.log("Friday");
      break;
    case 5:
      console.log("Saturday");
      break;
    case 6:
      console.log("Sunday");
      break;
  }
  