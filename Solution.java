//3217. Delete Nodes From Linked List Present in Array

/*You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.

 

Example 1:

Input: nums = [1,2,3], head = [1,2,3,4,5]

Output: [4,5]

Explanation:



Remove the nodes with values 1, 2, and 3.

Example 2:

Input: nums = [1], head = [1,2,1,2,1,2]

Output: [2,2,2]

Explanation:



Remove the nodes with value 1.

Example 3:

Input: nums = [5], head = [1,2,3,4]

Output: [1,2,3,4]

Explanation:



No node has value 5.

 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
All elements in nums are unique.
The number of nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
The input is generated such that there is at least one node in the linked 
list that has a value not present in nums. */

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    
    ListNode() {
        this.val = 0;
        this.next = null;
    }
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode modifiedList(List<Integer> nums, ListNode head) {
        if (nums.size() == 0) return head;
        
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }
        
        ListNode temp = head;
        ListNode prev = null;
        
        while (temp != null) {
            if (mpp.getOrDefault(temp.val, 0) > 0) {
                if (temp == head) {
                    head = head.next;
                } else {
                    prev.next = temp.next;
                }
            } else {
                prev = temp;
            }
            temp = temp.next;
        }
        
        return head;
    }
    
    // Helper function to print the linked list
    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();
        
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        // Print the original list
        System.out.println("Original list:");
        solution.printList(head);
        
        // Create a list of integers to remove from the linked list
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(4);
        
        // Modify the linked list
        head = solution.modifiedList(nums, head);
        
        // Print the modified list
        System.out.println("Modified list:");
        solution.printList(head);
    }
}












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
/*class Solution {
public:
    ListNode* modifiedList(vector<int>& nums, ListNode* head) {
        if(nums.size()==0) return head;
        unordered_map<int,int> mpp;
        ListNode* temp = head;
        for(int i : nums){
            mpp[i]++;
        }
        ListNode* prev = head;
        while(temp!=NULL){
            if(mpp[temp->val]>0){
                if(temp == head){
                    head = head->next;
                }
                else{
                    prev->next = temp->next;
                }
            }
            else{
                prev = temp;
            }
            temp = temp->next;
        }
        return head;
    }
};*/