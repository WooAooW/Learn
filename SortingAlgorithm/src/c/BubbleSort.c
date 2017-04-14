#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#define  LENGTH 10
#define  true  1
#define  false  0

/*
 * Bubble Sort 
 * 核心思想： 把权重最大的放到最后
 * */
void  BubbleSort(int list[], int length)
{
    int i, j;
    int temp, flag;
    for(i = length - 1; i > 0; i--)/* the number of circle */
    {
        flag = true;
        for(j = 0; j < i; j++) /* the number of compare */
        {
            if(list[j] > list[j+1])
            {
                flag = false;
                temp = list[j];
                list[j] = list[j+1];
                list[j+1] = temp;
            }

        }

       if(flag)
           return;
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
    BubbleSort(list, LENGTH);
    list_for_each(list, LENGTH);

}


