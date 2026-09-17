package com.shylaja.leetcode.arrays.prefixsum;

//1314. Matrix Block Sum -> 2D Prefix Sum Approach
/*
1. Create prefixsum[m+1][n+1].
2. Build the 2D prefix sum:prefix[i][j] =
3.     mat[i-1][j-1]
4.     + prefix[i-1][j]
5.     + prefix[i][j-1]
6.     - prefix[i-1][j-1]
7. For every cell (i, j), calculate its block boundaries:
    * r1 = max(0, i-k)
    * c1 = max(0, j-k)
    * r2 = min(m-1, i+k)
    * c2 = min(n-1, j+k)
8. Use the prefix sum formula to get the block sum:sum = prefix[r2][c2]
9.     - prefix[r1-1][c2]
10.     - prefix[r2][c1-1]
11.     + prefix[r1-1][c1-1]

*/
//Time: O(m × n)
//Space: O(m × n)

public class MatrixBlockSum {

    public static void main(String[] args) {

		int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int k = 1;

        int[][] result = matrixBlockSum(mat, k);

        // Print output
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
	}

    public static int[][] matrixBlockSum(int[][] mat, int k) {

        int m=mat.length;
        int n=mat[0].length;

        int[][] prefixsum=new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                prefixsum[i][j]=mat[i-1][j-1]
                +prefixsum[i-1][j]
                +prefixsum[i][j-1]
                -prefixsum[i-1][j-1];
            }
        }
        int[][] answer = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int r1=Math.max(0,i-k);
                int c1=Math.max(0,j-k);
                int r2=Math.min(m-1,i+k);
                int c2=Math.min(n-1,j+k);

                r1++;
                c1++;
                r2++;
                c2++;

                answer[i][j]=prefixsum[r2][c2]
                -prefixsum[r1-1][c2]
                -prefixsum[r2][c1-1]
                +prefixsum[r1-1][c1-1];
            }
        }
        return answer;
    }
}
