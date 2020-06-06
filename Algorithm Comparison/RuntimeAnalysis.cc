#include <iostream>
#include <vector>
#include <ctime>
using namespace std;


int algorithm1( const vector<int> & a )
{
    int maxSum = 0;

    for( int i = 0; i < a.size( ); ++i )
        for( int j = i; j < a.size( ); ++j )
        {
            int thisSum = 0;

            for( int k = i; k <= j; ++k )
                thisSum += a[ k ];

            if( thisSum > maxSum )
                maxSum   = thisSum;
        }

    return maxSum;
}



int algorithm2( const vector<int> & a )
{
    int maxSum = 0, thisSum = 0;

    for( int j = 0; j < a.size( ); ++j )
    {
        thisSum += a[ j ];

        if( thisSum > maxSum )
            maxSum = thisSum;
        else if( thisSum < 0 )
            thisSum = 0;
    }

    return maxSum;
}

/**
 * Simple test program.
 */
int main( )
{
  
   vector<int> a { 4, -3, 5, -2, -1, 2, 6,-2, 4, -3, 5, -2, -1, 2, 6, -2 };
   int answer;

    answer = algorithm1( a );
    cout << "The answer is " <<  answer  << endl;
    answer = algorithm2( a );
    cout << "The answer is " <<  answer  << endl;
    

     return 0;
}
