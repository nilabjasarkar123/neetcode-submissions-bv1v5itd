class TimeMap {
public:
    map<string, vector<pair<string, int>>> mp;
    TimeMap() {
        this->mp = mp;
    }
    
    void set(string key, string value, int timestamp) {
        mp[key].push_back({value, timestamp});
    }
    
    string get(string key, int timestamp) {
        
        auto& v = mp[key];
        int i = 0, j = v.size()-1;
        string ans = "";
        while(i <= j) {
            int mid = (i+j)>>1;

           if(v[mid].second > timestamp) {
                j = mid - 1;
            }
            else {
                ans = v[mid].first;
                i = mid + 1;
            }
        }
         return ans;
    }
   
};
