#include <stdlib.h>
#include <stdio.h>

int exponentiate (int x, int y) {
  int i;
  int help = 1;

  for (i = 0; i < y; i++) {
    help *= x;
  }

  return(help);
}

void evaluate(int * arr, int arrsize) {
  // given array, evaluate using 2^x
  // int maxPower = arrsize - 1;

  int i;
  int ret = 0;

  for (i = 0; i < arrsize; i++) {
    ret += arr[i]*(exponentiate(2,i));
  }

  printf("%d\n", ret);
}

//___________________________________________________________________________________________
int getArrSize(int num) {
  int temp = num;
  int arrsize = 0;

  while (temp != 0) {
    temp /= 2;
    arrsize++;
  }
  return arrsize;
}
//____________________________________________________________________________________________

  int* convert(int num, int arrsize) {

  int * arr = (int*)malloc(sizeof(int) * arrsize);
  int i;

  if (num == 1) {
    arr[0] = 1;
    return arr;
  }

  int temp = num; //5 
  int modder;

  for (i = 0; i < arrsize; i++) { // this is a loop to allocate array with binary numbers
    while (temp != 0) {
      modder = temp % 2;// add modder to aray
      temp /= 2;
      arr[i] = modder;
      break;
    }
  }

  for (i = 0; i < arrsize; i++) {
    // printf("%d",arr[i]);
  }

  //printf("\n");

  return arr;
  }

//___________________________________________________________________________________________

int main(int argc, char** argv) {
 
 if (argc != 2) {
    return 0;
 }
 FILE* fp = fopen(argv[1],"r");
 if (fp == NULL) {
   return 0;
  }

 int num;

 fscanf(fp, "%d", &num);

 int arrsize = getArrSize(num);
 int i;

 if (arrsize == 1){
   // return 0;
 }


 int * arr = convert(num,arrsize);
 

 for (i = arrsize -1; i >= 0; i--) {
   // printf("%d",arr[i]);
   // 10011010010100

   //0 0 1 0 1 0 0 1 0  1  1  0  0  1
   //1 2 3 4 5 6 7 8 9 10 11 12 13 14
 }

 char string[5];
 // char gets;
 int num1,num2;

 // printf("\n");
 while(fscanf(fp,"%4s \t %d \t %d",string, &num1,&num2) != EOF) {
   if (string[0] == 'g') { // gets, only use num1
     printf("%d\n",arr[num1]); // prints nth bit
     // what if nth bit doesnt exist



   // CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCOMP
   } else if (string[0] == 'c') { // comp, only use num1
     if (num1 > arrsize-1) { // n doesn't exist
       // printf("entered\n");
       int i;
       int count = 0;
       // int temp = arrsize;
       int * new = (int*)malloc(sizeof(int) * (num1+1));

       for (i = 0; i < arrsize; i++) {
	 new[i] = arr[i];
	 count++;
       }

       for (i = count; i < (num1+1); i++) {	 
	   new[i] = 0;	 
       }
       arr = new;
       arrsize = num1 +1;
     } 
   
     // printf("yeooo1 : %d\n",arr[num1]);
     if (arr[num1] == 1) {
	arr[num1] = 0;
     } else if (arr[num1] == 0) {
	arr[num1] = 1;
     }

     // printf("yeooo: %d\n",arr[num1]);
     evaluate(arr,arrsize);	  
   }
   // CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCOMP
 


   // SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
   else if (string[0] == 's') { // set n to v, use num1 and num2
     if(num1 > arrsize-1) {
       // printf("entered\n"); // so we must create new array to the left
       int i;
       int count = 0;
       int temp = arrsize;
       int * new = (int*)malloc(sizeof(int) * (num1+1));

       for(i = 0; i < arrsize; i++) {
	 new[i] = arr[i];
	 count++;
       }

       for (i = count; i < (num1+1); i++) {
	 if (i != num1) {
	   new[i] = 0;
	 } else { //num1 is reached
	   new[i] = num2;
	 }
       }
       arrsize = num1 + 1;
       evaluate(new,arrsize);
       arrsize = temp;
     } else { // bit exists
       arr[num1] = num2;
       evaluate(arr,arrsize);
     }
   
 // printf("String: %s\n Num1: %d\n Num2: %d\n",string,num1,num2);
   } // SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
 }
  return 0;
} 
