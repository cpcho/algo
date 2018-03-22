#200. Number of Islands
/*Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally 
or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3*/

/*Just drown every island - one by one!!*/

private int x; // Width of the given grid
private int y; // Height of the given grid
private char[][] g; // The given grid, stored to reduce recursion memory usage

public int numIslands(char[][] grid) {
    
    // Store the given grid, this prevents having to make copies during recursion
    g = grid;
    int count = 0;
    
    // Dimension of the given graph
    y = g.length;
    if (y == 0) return 0;
    x = g[0].length;

    for (int i = 0; i < y; i++) { // Iterate over the entire given grid
    	for (int j = 0; j < x; j++) {
    		if (g[i][j] == '1') {
    			dfs(i, j);
    			count++;
    		}
    	}
    }
    return count;
}

void dfs(int i, int j) { // i: row index, j: column index

	// Check for invalid indices and sites that aren't land
	if (i < 0 || j < 0 || i >= y || j >= x || g[i][j] != '1') return;
	
	// Mark the site as visited
	g[i][j] = '0'; 

	// Check all adjacent sites
	dfs(grid, i + 1, j);
	dfs(grid, i - 1, j);
	dfs(grid, i, j + 1);
	dfs(grid, i, j - 1);
}

