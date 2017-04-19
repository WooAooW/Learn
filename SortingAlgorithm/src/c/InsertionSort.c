#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#define  LENGTH 10
#define  true  1
#define  false  0

/*
 * Insettion  Sort 
 * Core thing： Move backward and insert the value into a smaller location
 * */
void  InsertionSort(int list[], int length)
{
    int i, j;
    int temp;
    /* the array[0] is ordered ,so  sort from index of 1
     * and n-1 is the number loop */
    for(i =  1; i < length; i++)
    {
        j = i;
        temp = list[i];
        while(j >= 1 && temp < list[j-1]) /* the number of compare */
            list[j] = list[--j];/* the bigger value was move backword */
        list[j] =  temp;
    }

}
/* create a  array in heap memrory
 * parameter : length is the sizeof array
 * return :  return the address of array
 * */
int*  CreateList(int length)
{   
    int *list  = (int *)malloc(sizeof(int) *  length);
    srand(time(NULL));
    int i;
    for(i = 0; i < LENGTH; i++)    
        list[i] = rand()%50;
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
    InsertionSort(list, LENGTH);
    list_for_each(list, LENGTH);

}


