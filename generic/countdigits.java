class Solution {
public:
    int countDigit(int n) {
        int count =0;
        while(n>0){
            if(n%10 != 0)
            count++;
            n=n/10;
        }
          return count ;
    }

};
//I had to count the number of non zero digits in a number