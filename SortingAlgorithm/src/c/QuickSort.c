
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#define  LENGTH 10
#define  true  1
#define  false  0

/*
 * Quick Sort 
 * Core thing： Recursive find the  suitable position 
 * Comment: implement by myself but is is too bad not clsscial
 * */
void  QuickSort(int list[], int left, int right)
{
    int i = left;
    int j = right;
    int temp = 0;
    int temp_swap = 0;
    temp = list[left];

    while( left < right)
    {

        /* <= handing the equal case */
        while(left <= right && temp >= list[left]) 
            left++;

        /* if the left is the largest value ,left will cross the right border*/
        if(left > j)          
            left =j;

        while(left <= right && temp <= list[right])
            right--;
        /* if the right is the largest value ,right will cross the blef torder */
         if(right +1 ==  left) 
             left = right;

        /* put the smaller than temp to left ,the biggger than to right */
        if(left < right)  
        {   
            temp_swap = list[right];
            list[right] = list[left];
            list[left] = temp_swap;
            left++;
            right--;
        }else if(left == right ){
            list[i] = list[left];
            list[left] = temp;
            QuickSort(list, i, left-1);
            QuickSort(list, left+1, j);
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
    list_for_each(list, LENGTH);
    QuickSort(list, 0, LENGTH -1);
    list_for_each(list, LENGTH);

}


