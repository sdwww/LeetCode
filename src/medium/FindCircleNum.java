package medium;

/**
 * 547. 省份数量
 */
public class FindCircleNum {

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        FindCircleNum findCircleNum = new FindCircleNum();
        int circleNum = findCircleNum.findCircleNum(nums);
        System.out.println(circleNum);
    }

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int length = isConnected.length;
        boolean[] visited = new boolean[length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int index, int[][] isConnected, boolean[] visited) {
        // 找到和index连接的，如果没有被访问过，dfs
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[i][index] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, isConnected, visited);
            }
        }
    }
}
