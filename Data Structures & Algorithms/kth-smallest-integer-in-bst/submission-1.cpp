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
    int ans = 0;
    int helper(TreeNode* root, vector<int>& v, int &k) {
        if(root == NULL) return 0;
        
        helper(root->left, v, k);
        k--;
        if(k == 0) ans = root->val;
        helper(root->right, v, k);
        return 0;
    }
public:
    int kthSmallest(TreeNode* root, int k) {
        
        if(root == NULL) return 0;
        vector<int>v;
        helper(root, v, k);
        return ans;
    }
};
