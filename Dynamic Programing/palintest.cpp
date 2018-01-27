#include<iostream>
#include<string>
#include<climits>
#include<vector>


using namespace std;

int palinCost(string &s,int l,int h,int i,int d,int r, vector<vector<int>> &dp){

         if(l+1==h)
            return min(d,min(i,r));
        if(l==h)
            return 0;
         if(dp[l][h]!=-1)
                return dp[l][r];
        if(s[l]==s[h])
            return dp[l][h]=palinCost(s,l+1,h-1,i,d,r,dp);


        return dp[l][h]=min( i+ palinCost(s,l+1,h,i,d,r,dp), min(d + palinCost(s,l,h-1,i,d,r,dp), r + palinCost(s,l+1,h-1,i,d,r,dp)));
}

int main(){

    int i,d,r;
    string s;
    cin>>i>>d>>r;
    cin>>s;
    int n= s.length();
    vector<vector<int>> dp(n, vector<int> (n,-1));
    cout<<palinCost(s,0,s.length()-1,i,d,r,dp);

return 0;
}
