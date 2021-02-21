// Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

const grid = [["1","1","1"],["0","1","0"],["1","1","1"]]

/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    let island_count = 0
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            if(grid[i][j] == '1'){

                mark_island(grid, i, j)
                // console.log(grid);

                island_count++
                // return
            }
        }
    }
    return island_count
};

const mark_island = (grid, i, j) =>{
    grid[i][j] = '0'

    if(i-1 >= 0 && grid[i-1][j] == '1'){
        mark_island(grid,i-1,j)
    }

    if(j-1 >= 0 && grid[i][j-1] == '1'){
        mark_island(grid,i,j-1)
    }

    if(j+1 < grid[i].length && grid[i][j+1] == '1'){
        mark_island(grid,i,j+1)
    }

    if(i+1 < grid.length && grid[i+1][j] == '1'){
        mark_island(grid,i+1,j)
    }


}

console.log(numIslands(grid))
