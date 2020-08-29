package InterViewPrep;

public class CountNumbersAfterSelf {
    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        int[] result = Calculate(nums);
        for (int item: result
             ) {
            System.out.println(item);
        }
    }

    private static int[] Calculate(int[] nums)
    {
        int[] result = new int[nums.length];
        result[result.length-1] = 0;
        Bst bst = new Bst(nums[nums.length-1]);

        for (int i = result.length-2; i >= 0 ; i--) {
            result[i] = bst.add(bst.root, nums[i]);
        }

        return result;
    }


    static class TreeNode
    {
        int count;
        TreeNode left, right;
        int val;

        public TreeNode(int val)
        {
            this.val = val;
            left = right = null;
            count = 1;
        }
    }

    static class Bst
    {
        public TreeNode root;

        public Bst(int value)
        {
            root = new TreeNode(value);
        }

        public int add(TreeNode root,int value)
        {
            if (root.val < value)
            {
                if (root.right == null)
                {
                    root.right = new TreeNode(value);
                    return root.count;
                }
                else
                {
                    return root.count + add(root.right, value);
                }
            }
            else
            {
                root.count++;
                if (root.left == null)
                {
                    root.left = new TreeNode(value);
                    return 0;
                }
                else
                {
                    return add(root.left, value);
                }
            }
        }
    }
}
