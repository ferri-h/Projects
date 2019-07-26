#include <stdlib.h>
#include <stdio.h>

int main(int argc, char** argv) {
  if (argc != 2) {
    return 0;
  } 

  FILE* fp = fopen(argv[1],"r"); // r reads file
  if (fp == NULL) 
    return 0;

  
  int arrsize;
  int num;

  fscanf(fp, "%d", &arrsize);
  // printf("%d\n", arrsize);

  int * temp = (int*)malloc(sizeof(int) * arrsize);
  int i;
  for (i = 0; i < arrsize; i++) {
    while(fscanf(fp,"%d", &num) != EOF) {
      temp[i] = num;
      break;
    }
    //  temp[i] = i;
  }

  int count = 0;

  int * rabeya = (int*) malloc(sizeof(int) *arrsize);
  //  int j;
  for(i = 0; i < arrsize; i++) { // separates odd
    if (temp[i] % 2 == 1 || temp[i] % 2 == -1) { // odd
      rabeya[count] = temp[i];
      count++;
    } 
  }

  int j;
  int help;

  for (i = 0; i < count -1; i++) { // ascendng
    for (j = 0; j < count - i -1; j++) {
      if(rabeya[j] > rabeya[j+1]) {
	help = rabeya[j];
	rabeya[j] = rabeya[j+1];
	rabeya[j+1] = help;
      }
    }
  }
  // quicksort(rabeya, 0, count-1);
  // try to use count here to arrange in ascending then decending
  int breakpoint = count;

  for(i = 0; i< arrsize; i++) { // separates evens
    if (temp[i] % 2 == 0 || temp[i] == 0) { // 0 bc neither even nor odd
      rabeya[count] = temp[i];
      count++;
    }
  }

  
  for (i = breakpoint; i < (arrsize); i++) { //descending
    for (j= i+1; j < arrsize; j++) {
      if (rabeya[i] < rabeya[j]) { // check for zero
	help = rabeya[i];
	rabeya[i] = rabeya[j];
	rabeya[j] = help;
	break;
      }
    }
  }


  // at this point we have separated even from odds
  // int j,k;


  for (i = 0; i < arrsize; i++) {
   printf("%d\t", rabeya[i]);
  }
  // int * rabeya = (int*)malloc(sizeof(int) * arrsize);


  

  // i want to create loop that orders array in ascendin to decending
  // while number is odd, count ++
  // after we find count, sort numbers up to count
  // then work on evens

  // printf("%d",count);
  printf("\n");

 
//  return rabeya;
 

  return 0;
}
