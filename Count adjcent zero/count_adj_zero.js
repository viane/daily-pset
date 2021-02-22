// Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

// The distance between two adjacent cells is 1.



// Example 1:

// Input:
// [[0,0,0],
//  [0,1,0],
//  [0,0,0]]

// Output:
// [[0,0,0],
//  [0,1,0],
//  [0,0,0]]

// Example 2:

// Input:
// [[0,0,0],
//  [0,1,0],
//  [1,1,1]]

// Output:
// [[0,0,0],
//  [0,1,0],
//  [1,2,1]]

/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
var updateMatrix = function(matrix) {
    if(matrix == [[]]) return [[]]
    let count_matrix = new Array()
    let zero_coors = new Array()
    for(let i = 0; i<matrix.length; i++){
        for(let j = 0; j < matrix[0].length; j++){
            if(matrix[i][j] == 0){
                zero_coors.push({'i':i, 'j':j})
            }
        }
    }
    // console.log("Zeros coordiante sums: ", zero_coors);

    for(let i = 0; i<matrix.length; i++){
        let row_counts = []
        for(let j = 0; j < matrix[0].length; j++){
            if(matrix[i][j] == 0){
                row_counts.push(0)
                continue
            }
            // const current_coor = i + j
            const distance_to_zeros = zero_coors.map( zero_coor => {
                // console.log(Math.abs((i - zero_coor.i))) + Math.abs((j - zero_coor.j))
                return Math.abs((i - zero_coor.i)) + Math.abs((j - zero_coor.j))
            })
            // console.log('Distances from current element to all zeros: ', zero_coors);
            const min_dist_to_zero = Math.min(...distance_to_zeros)
            // console.log('Min distance to a zero: ', min_dist_to_zero);
            row_counts.push(min_dist_to_zero)
            // if(matrix[i][j]==1){
            //     return
            // }
        }
        count_matrix.push(row_counts)
    }
    console.log(count_matrix);
    return count_matrix
};

updateMatrix([[0,0,0],[0,1,0],[0,0,0]])
