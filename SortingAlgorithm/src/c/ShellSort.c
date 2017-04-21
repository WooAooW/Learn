#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#define  LENGTH 10
#define  true  1
#define  false  0

/*
 * Shell Sort 
 * Core thing：Use inset sort method by grop
 * Group：     The group be split by the step length
 * Step:       Step is the length/2^i(i = 1,2 ...n)
 * */
void  ShellSort(int list[], int length)
{
    int step; 
    int i, temp, j;
    for (step = length >> 1; step > 0; step>>=1) /* step/2 == step>>1 */
    {
        for (i = step; i < length; i++)/* using insert sort */
        {
            j = i ;
            temp = list[i];
            while(j >= step && temp < list[j - step])
            {
                list[j] = list[j - step];
                j = j - step;
            }
            list[j] = temp;
        }
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
//    int list[10] = {12, 10 , 8, 5, 4, 3 , 15, 17, 33, 55} ;
    list_for_each(list, LENGTH);
    ShellSort(list,  LENGTH);
    list_for_each(list, LENGTH);
    return 0;
}


