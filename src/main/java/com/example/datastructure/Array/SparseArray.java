package com.example.datastructure.Array;


/**
 * 稀疏数组的作用：当一个数组中大部分元素为0或者为同一个值的数组时，可以使用稀疏数组来保存该数组
 * 稀疏数组的处理方式： 1、记录数组一共有几行几列，有多少个不同的值  2、把具体不同的元素的行列及值记录到一个小规模的数组中，从而缩小规模
 *
 * 二维数组转稀疏数组思路：
 * 1、遍历原始的二维数组，得到有效的个数sum
 * 2、根据sum创建稀疏数组 sparseArr int[sum+1][3]
 * 3、将二维数组的有效数据存入到稀疏数组中
 *
 * 稀疏数组转原始二维数组思路
 * 1、先读取稀疏数组的第一行，根据第一行的数据
 * 2、创建原始的二维数组，在读取稀疏数组后几行，并赋给原始二维数组即可
 *
 */

public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组 12*12
        // 0表示没有值，其余的数字表示有值
        int[][] chessArr1 = new int[12][15];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[7][12] = 190;
        chessArr1[10][3] = -90;
        System.out.println("原始的二维数组===============");
        printArray(chessArr1);
        System.out.println("转换成稀疏数组=================>");
        int[][] sparseArray = convertSparseArray(chessArr1);
        printArray(sparseArray);
        System.out.println("转换成原始数组==============>");
        int[][] normalArray = convertNormal(sparseArray);
        printArray(normalArray);

    }

    private static void printArray(int[][] source){
        for (int[] row : source) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }

    //转化成稀疏数组
    private static int[][] convertSparseArray(int[][] source) {
        int sum = 0;
        int row = source.length;
        int col = source[0].length;
        for (int i = 0;i<row;i++) {
            for (int j = 0;j<col;j++) {
                //得到有效值的个数
                if (source[i][j] !=0) {
                    sum++;
                }
            }
        }
        //创建对应的稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        //给对应的稀疏数组赋原始的值,这是一个 row*col的数组，有几个有效值
        sparseArray[0][0] = row;
        sparseArray[0][1] = col;
        sparseArray[0][2] = sum;
        //遍历二维数组，将非0的值存放到sparseArr中
        int m = 1;
        for (int i = 0;i<row;i++) {
            for (int j = 0;j<col;j++) {
                //得到有效值的个数
                if (source[i][j] !=0) {
                    sparseArray[m][0] = i;
                    sparseArray[m][1] = j;
                    sparseArray[m][2] = source[i][j];
                    m++;
                }
            }
        }
        return sparseArray;
    }

    // 稀疏数组转换成原始数组
    private static int[][] convertNormal(int[][] sparseArray){
        int[][] normalArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        int sum = sparseArray[0][2];
        for (int i = 1; i <= sum; i++) {
            normalArray[sparseArray[i][0]][sparseArray[i][1]]= sparseArray[i][2];
        }

        return normalArray;
    }
}
