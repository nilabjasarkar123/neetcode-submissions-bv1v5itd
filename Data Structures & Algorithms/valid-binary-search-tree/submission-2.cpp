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
    bool isValid(TreeNode* root, int mini, int maxi) {
        if(root == NULL) return true;
        if(root->val <= mini or root->val >= maxi) return false;
        int leftsubtree =  isValid(root->left, mini, root->val);
        int rightsubtree = isValid(root->right, root->val, maxi);
        return leftsubtree && rightsubtree;
    }
    bool isValidBST(TreeNode* root) {
        if(root == NULL) return true;
         return isValid(root, INT_MIN, INT_MAX);
        
    }
};
