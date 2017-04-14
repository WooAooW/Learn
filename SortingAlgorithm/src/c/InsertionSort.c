#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#define  LENGTH 10
#define  true  1
#define  false  0

/*
 * Insettion  Sort 
 * 核心思想： 找合适的位置
 * */
void  InsertionSort(int list[], int length)
{
    int i, j;
    int temp;
    for(i =  1; i < length; i++)/* the number of circle */
    {
        j = i;
        temp = list[i];
        while(j >= 1 && temp < list[j-1]) /* the number of compare */
            list[j] = list[--j];
        list[j] =  temp;
    }

}
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
    list_for_each(list, LENGTH);
    InsertionSort(list, LENGTH);
    list_for_each(list, LENGTH);

}


