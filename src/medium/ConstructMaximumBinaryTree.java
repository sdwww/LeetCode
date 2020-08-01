package medium;

import base.TreeNode;

/**
 * 654. 最大二叉树
 */
public class ConstructMaximumBinaryTree {

    public static void main(String[] args) {
        ConstructMaximumBinaryTree solution = new ConstructMaximumBinaryTree();
        int[] arr = {48, 259, 222, 129, 17, 245, 174, 68, 8, 261, 233, 112, 263, 41, 108, 209, 22, 35, 167, 133, 23, 201, 91, 190, 252, 182, 86, 15, 296, 103, 195, 207, 146, 275, 21, 204, 271, 248, 280, 66, 183, 28, 202, 78, 240, 92, 223, 264, 64, 163, 262, 25, 184, 242, 281, 288, 104, 158, 165, 67, 40, 272, 198, 273, 127, 290, 155, 197, 106, 226, 109, 81, 113, 119, 37, 168, 75, 214, 295, 237, 63, 192, 215, 251, 142, 218, 161, 80, 105, 20, 62, 100, 266, 39, 179, 83, 247, 269, 85, 234, 82, 118, 185, 277, 140, 122, 162, 128, 93, 139, 4, 216, 152, 285, 42, 102, 194, 175, 61, 210, 284, 14, 145, 299, 53, 213, 51, 0, 34, 79, 211, 1, 294, 94, 282, 125, 5, 249, 99, 173, 116, 220, 270, 45, 224, 144, 98, 177, 260, 46, 268, 230, 49, 107, 166, 77, 297, 178, 44, 231, 157, 159, 235, 131, 283, 120, 241, 6, 172, 123, 256, 19, 110, 150, 206, 33, 227, 170, 95, 31, 225, 130, 134, 257, 38, 30, 87, 254, 193, 3, 12, 236, 52, 186, 55, 180, 65, 72, 229, 154, 60, 115, 121, 219, 228, 76, 13, 238, 97, 217, 243, 27, 287, 88, 10, 169, 137, 244, 84, 73, 32, 286, 205, 156, 24, 151, 292, 160, 239, 50, 200, 70, 136, 138, 124, 189, 203, 191, 148, 153, 143, 276, 18, 221, 258, 278, 69, 57, 246, 2, 267, 176, 135, 16, 26, 187, 250, 181, 9, 11, 291, 255, 232, 265, 274, 149, 196, 212, 58, 89, 47, 117, 188, 132, 293, 54, 298, 171, 141, 208, 56, 147, 7, 101, 164, 114, 43, 199, 59, 111, 126, 74, 29, 279, 253, 71, 36, 289, 90, 96};
        TreeNode treeNode = solution.constructMaximumBinaryTree(arr);
        System.out.println(treeNode);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int maxIndex = findMaxIndex(nums, 0, nums.length - 1);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = search(nums, 0, maxIndex - 1);
        root.right = search(nums, maxIndex + 1, nums.length - 1);
        return root;
    }

    private TreeNode search(int[] nums, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            return null;
        }
        if (startIndex == endIndex) {
            return new TreeNode(nums[startIndex]);
        }
        int maxIndex = findMaxIndex(nums, startIndex, endIndex);
        TreeNode treeNode = new TreeNode(nums[maxIndex]);
        treeNode.left = search(nums, startIndex, maxIndex - 1);
        treeNode.right = search(nums, maxIndex + 1, endIndex);
        return treeNode;
    }

    private int findMaxIndex(int[] nums, int startIndex, int endIndex) {
        int maxIndex = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
