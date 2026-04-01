class Solution {
public:
    bool compare(int a[], int b[]) {
        for(int i = 0; i < 26; i++){
            
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
    bool checkInclusion(string s1, string s2) {
        if(s1.size() > s2.size()) return false;
        int count1[26] = {0}, count2[26] = {0};

        for(auto s : s1) count1[s-'a']++;

        int i = 0, j = 0, countLen = s1.size();
      //  lecaabee
    
        while(j < countLen) {
            count2[s2[j]-'a']++;
            j++;
        }
        while(j < s2.size()) {
            if(compare(count1, count2)){
                return true;
            }
            count2[s2[i]-'a']--;
            count2[s2[j]-'a']++;
            i++;
            j++;
        }
        if(compare(count1, count2)){
                return true;
        }
        return false;
    }
};

/*
abc
acb
bac
bca
cab
cba
i = 0 , j = 0
0123456
lecabee
  i
    j

countLen = 3->2   ->1->0 
a-1
b-1
c-1
------
l-0 
e-0
c-1
a-1
b-1
lecaabee
    i
         j
countLen = 3->2->1
a--1
b-1
c-1

aaabccaaab
  i
  j

*/