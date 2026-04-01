/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    void inoderTraversal(TreeNode* root, vector<int>& res) {
        if(root == NULL) {
            return;
        }
        inoderTraversal(root->left, res);
        res.push_back(root->val);
        inoderTraversal(root->right, res);
    }
    bool isSorted(vector<int> &nums) {
        for(int i = 1; i < nums.size(); i++) {
            if(nums[i] <= nums[i-1])return false;
        }
        return true;
    }
    bool isValidBST(TreeNode* root) {
        vector<int> inorder;
        inoderTraversal(root, inorder);
        return isSorted(inorder);
    }
};
