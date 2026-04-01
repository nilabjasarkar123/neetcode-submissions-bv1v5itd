/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* reverse(ListNode *head) {
        if(head == NULL || head->next == NULL) return head;
        ListNode *dummy = reverse(head->next);
        head->next->next = head;
        head->next = NULL;
        return dummy;
    }
    void reorderList(ListNode* head) {
        // find middle
        ListNode *first = head;
        ListNode *fast = head, *slow = head;
        while(fast != NULL && fast->next != NULL) {
            fast = fast->next->next;
            slow = slow->next;
        }

        ListNode *second = reverse(slow);
        slow->next = NULL;
        while(first && second) {
            ListNode *firstN = (first->next!=NULL)?first->next:NULL,
                     *secondN = (second->next!=NULL)?second->next:NULL;
            if(first->next) first->next = second;
            if(second->next) second->next = firstN;
            first = firstN;
            second = secondN;
        }
    }
};
