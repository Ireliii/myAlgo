package recursion;

/**
 * @author 86184
 * @date 2022-11-2022/11/1-13:54
 */
public class TheAmountOfIsland {
    public static int numIslands(char[][] grid){

        //更优解 判断完直接将1 置为 0

        /**
         * 遍历数组
         * 生成额外等大小空间
         * 判断当前位置是否为1
         *  若1    同时num+1   递归判断当前位置的周围是否为1
         *  若0  continue
         *  对应位置置为1 表示已判断
         */
        char[][] w = new char[grid.length][grid[0].length];
        int num = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                boolean one = isOne(grid, w, i, j);
                if(one)
                    num++;
            }
        }
        return num;
    }
    public static boolean isOne(char[][] grid,char[][] w,int x,int y){
        if(w[x][y] == 1){
            return false;
        }
        w[x][y] = 1;
        boolean isOne = false;
        if(grid[x][y] == '1'){
            isOne = true;
            //递归 下 和 右
            if(x != grid.length-1){
                isOne(grid,w,x+1,y);
            }
            if(y != grid[0].length -1){
                isOne(grid,w,x,y+1);
            }
            if(x != 0){
                isOne(grid,w,x-1,y);
            }
            if(y != 0){
                isOne(grid,w,x,y-1);
            }
        }
        return isOne;
    }

    public static void main(String[] args) {
        char[][] c = {
                {'1','1','1'},
                {'0',' ',' '},
                {'1','1','1'}
        };
        System.out.println(c.length);
        System.out.println(c[0].length);
        System.out.println(numIslands(c));
    }
}
