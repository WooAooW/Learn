#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <limits.h> 
#define  LENGTH 10
#define  true  1
#define  false  0

/*
 * Seclect Sort 
 * Core thing：Place the minimum value on the fisrt postion of the array 
 * at each  time 
 * Spacw complexity:O(n^2)
 * Time complexity：
 * */
void  SeclectSort(int list[], int length)
{
    int i, j;
    int minimum = list[0];
    int mini_index = 0;
    /*  the list[0] not need compare and move so the number
     *  of loop == n-1  */
    for(i = 0 ; i < length-1; i++)
    {
        mini_index = i;
        for(j = i+1; j < length; j++) /* compare to the rest of array that disordered*/
        {
            if(list[mini_index] > list[j]) /* find the minimum  value in the disordered */
                mini_index = j;
        }
        minimum = list[mini_index];
        list[mini_index] = list[i]; /* swap the minimum and list[i] */
        list[i] = minimum;
    }

}
/* create a  array in heap memrory
 * parameter : length is the sizeof array
 * return :  return the address of array 
 * */
int*  CreateList(int length)
{   
    int *list  = (int *)malloc(sizeof(int) *  length);
    srand(time(NULL)); /* create a random value */
    int i;
    for(i = 0; i < LENGTH; i++)    
        list[i] = rand()%50;/* get a <50 de  random value */
    return list;
}
/*  print a int array */
void list_for_each(int * list, int length)
{
    int i;
    for(i = 0; i < length; i++)
        printf("%d ", list[i]);
    printf(" \n");
}


int main()
{
    int *list = CreateList(LENGTH);
    list_for_each(list, LENGTH);
    SeclectSort(list, LENGTH);
    list_for_each(list, LENGTH);
}

