/* VAMSI AVINASH GUNJI 
Dr.Puya 
Data Structures */

#include<iostream>

using namespace std;
int main()
{ /*Where number is a variable that originally contains our integer,

Where mod is a variable that contains the last digit of number,

Where reverse is a variable representing the reverse of number. 
Remember to give only Positive numbers as input  */
int mod;/* integer mod*/
int rev;
int number;
/*It takes the number in Command in (Give only Positive Integers)
 */
cout<<"Enter a number in" <<endl;
cin>>number;


 while(number!=0)   /* The loop should terminate when number is zero Modding (%) the input int by 10 will extract off the rightmost digit. example: (1234 % 10) = 4.
Multiplying an integer by 10 will "push it left" exposing a zero to the right of that number, example: (5 * 10) = 50.
Dividing an integer by 10 will remove the rightmost digit. (Adding the integers together) 
*/
{
  mod=number%10; /* The modulo operator (%) returns the remainder of a divison */
  rev=rev*10 + mod; /* We can start building the reversed number now by appending mod onto the end of reverse. Remember that both of these variables are integers so we can not simply concatenate. We multiply reverse by 10 so that the ones column becomes the tens column, the tens column becomes the hundreds column, and so on. This also leaves us with a new ones column where we can add our mod which we determined
 */
  number=number/10; /* To remove the last digit  from number we simply divide it by 10. This works because we are performing integer division which rounds results down to the nearest integer  */
}
cout <<"Reverse = "<<rev;
 return 0;
 /* Reverse should return the number which you gave as input. */
 /* Termination Argument: Loop takes in number and goes through loop, when the number is zero, it starts to terminate immediately This mathematical solution saved us from traversing arrays or other such methods which would have been less efficient.
*/
 
}
