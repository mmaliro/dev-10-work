// CHALLENGE (OPTIONAL) : PATH FINDING
// Imagine the following string represents a 2D terrain.

const terrain = `
#############
#
#    ##
# @ #     X
############
`;

// `#` are obstacles
// `@` is an agent (hero, robot, unicorn, whatever you like).
// `X` is the goal (treasure, battery, cotton candy).

// Given a 2D terrain string, return a 2D terrain string that
// shows the path the agent traveled to get to the goal.
// `P` is a path.

/* For example, one path for the terrain above is:
#############
# PPPPPPP
# P  ## PPP
# P #     P
############
*/

// Diagonal moves are not allowed, only up, down, left, or right.

/* More examples:
----------------

@
            X

Solution:
----------------

PPPPPPPPPPPPP
            P


Example
----------------
    #    X
@   #
    ########
#
Solution:
----------------
    #    PP
PP  #     PPP
 P  ########P
#PPPPPPPPPPPP
Example
----------------
@#
#

           X
Solution:
----------------
No solution. Can't reach the goal.
*/

// Write a function that accepts a terrain string and 
// returns a solved path terrain string.
// You'll likely want more than one function.

function findPath(terrain) {
    // Convert terrain string to 2D array of characters
    const grid = terrain.trim().split('\n').map(row => row.split(''));
    
    // Find starting position of agent
    let startX, startY;
    for (let y = 0; y < grid.length; y++) {
      for (let x = 0; x < grid[y].length; x++) {
        if (grid[y][x] === '@') {
          startX = x;
          startY = y;
          break;
        }
      }
    }
    
    // Breadth-First Search to find shortest path
    const queue = [{x: startX, y: startY, path: []}];
    const visited = new Set();
    while (queue.length > 0) {
      const {x, y, path} = queue.shift();
      if (grid[y][x] === 'X') {
        // Found goal, mark path with 'P' and return grid as string
        path.forEach(({x, y}) => grid[y][x] = 'P');
        return grid.map(row => row.join('')).join('\n');
      }
      if (visited.has(`${x},${y}`)) continue;
      visited.add(`${x},${y}`);
      if (x > 0 && grid[y][x-1] !== '#') {
        queue.push({x: x-1, y, path: [...path, {x, y}]});
      }
      if (x < grid[y].length-1 && grid[y][x+1] !== '#') {
        queue.push({x: x+1, y, path: [...path, {x, y}]});
      }
      if (y > 0 && grid[y-1][x] !== '#') {
        queue.push({x, y: y-1, path: [...path, {x, y}]});
      }
      if (y < grid.length-1 && grid[y+1][x] !== '#') {
        queue.push({x, y: y+1, path: [...path, {x, y}]});
      }
    }
    
    // Goal not found
    return null;
  }

  console.log(findPath(terrain));
/* Output:
#############
#PPPPPPPP
#P  ##PPP
#P #    P
############
*/
