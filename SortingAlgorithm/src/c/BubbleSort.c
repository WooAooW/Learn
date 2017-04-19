#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#define  LENGTH 10
#define  true  1
#define  false  0

/*
 * Bubble Sort 
 * Core thing：Place the maximum value on the last postion of the array 
 * at each  time 
 * */
void  BubbleSort(int list[], int length)
{
    int i, j;
    int temp, flag;
    /*  the list[0] not need compare and move so the number
     *  of loop == n-1  */
    for(i = length - 1; i > 0; i--)
    {
        flag = true;
        for(j = 0; j < i; j++) /* compare to the rest of array that disordered*/
        {
            if(list[j] > list[j+1])
            {
                flag = false;
                temp = list[j];
                list[j] = list[j+1];
                list[j+1] = temp;
            }

        }

       if(flag) /* end  the sort method, if the array is already ordered */
           return;
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
    BubbleSort(list, LENGTH);
}

