import java.lang.*;
import java.io.*;
import java.util.*;

class Decryption 
{
  static String decryptWord(String inputWord)
  {
int len=inputWord.length();  //length of string
int mid = (inputWord.length()+1) / 2;
String s1=new String();
String s2=new String();
String firstswap=new String();
char[] chars=inputWord.toCharArray();

for (int i = 0;i < len; i++){
  if(chars[i]=='@')
  {
    chars[i]='A';
  }
  if(chars[i]=='=')
  {
    chars[i]='E';
  }
  if(chars[i]=='!')
  {
    chars[i]='I';
  }
  if(chars[i]=='?')
  {
    chars[i]='J';
  }
  if(chars[i]=='*')
  {
    chars[i]='O';
  }
  if(chars[i]=='#')
  {
    chars[i]='P';
  }
  if(chars[i]=='&')
  {
    chars[i]='R';
  }
  if(chars[i]=='$')
  {
    chars[i]='S';
  }
  if(chars[i]=='+')
  {
    chars[i]='T';
  }
  if(chars[i]=='^')
  {
    chars[i]='V';
  }
  if(chars[i]=='%')
  {
    chars[i]='X';
  }
}
//swap 3   
swap( chars, mid - 1, mid + 1 );
swap( chars, mid - 2, mid );

//swap 2
swap( chars, 0, chars.length - 2 );
swap( chars, 1, chars.length - 1 );

String s=new String(chars);

//swap 1
if(len%2!=0)
{
  s1=s.substring(0,mid-1);
  s2=s.substring(mid-1);
  firstswap=s2.concat(s1);
}
else
{
  s1=s.substring(0,mid);
  s2=s.substring(mid);
  firstswap=s2.concat(s1);
}
firstswap=firstswap.toLowerCase();


return firstswap; //returning the encrypted string
}
public static void swap( char[] chars, int l, int r ) 
{
  char tmp = chars[ l ];
  chars[ l ] = chars[ r ];
  chars[ r ] = tmp;
}

}

class Encryption
{ 
  static String encryptWord(String inputWord)
  {

inputWord=inputWord.toUpperCase(); //  Converting string to uppercase
int len=inputWord.length();  //length of string
final int mid = (inputWord.length()+1) / 2;

//Swap 1
String[] spstr = {inputWord.substring(0, mid),inputWord.substring(mid)};  //splitting the string into half
String firstSwap=spstr[1]+spstr[0];  //swapping the first half of string with the last half
char[] chars=firstSwap.toCharArray(); // converting the string into an array for swapping characters

// Swap 2
swap( chars, 0, chars.length - 2 );
swap( chars, 1, chars.length - 1 );

// Swap 3
swap( chars, mid - 1, mid + 1 );
swap( chars, mid - 2, mid );

    //running a character susbtitution 

for (int i = 0;i < len; i++){
  if(chars[i]=='A')
  {
    chars[i]='@';
  }
  if(chars[i]=='E')
  {
    chars[i]='=';
  }
  if(chars[i]=='I')
  {
    chars[i]='!';
  }
  if(chars[i]=='J')
  {
    chars[i]='?';
  }
  if(chars[i]=='O')
  {
    chars[i]='*';
  }
  if(chars[i]=='P')
  {
    chars[i]='#';
  }
  if(chars[i]=='R')
  {
    chars[i]='&';
  }
  if(chars[i]=='S')
  {
    chars[i]='$';
  }
  if(chars[i]=='T')
  {
    chars[i]='+';
  }
  if(chars[i]=='V')
  {
    chars[i]='^';
  }
  if(chars[i]=='X')
  {
    chars[i]='%';
  }
}
String str=new String(chars);

return str; //returning the encrypted string
}

public static void swap( char[] chars, int l, int r ) 
{
  char tmp = chars[ l ];
  chars[ l ] = chars[ r ];
  chars[ r ] = tmp;
  } //function to swap

  public static void main(String[] args)
  {  
    Decryption d1= new Decryption();
    Scanner s=new Scanner(System.in);
    String temp=s.nextLine();
    System.out.println(temp);
    System.out.println("The string before encrpytion - "+temp); 

    System.out.println(encryptWord(temp));
    String s1=encryptWord(temp);

    System.out.println("The string before Decryption is "+ s1);
    System.out.println(d1.decryptWord(s1));
  }
}
